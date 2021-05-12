package com.indexing.service;

import com.indexing.exception.InvalidQueryException;
import com.indexing.model.QueryType;
import com.indexing.store.InvertedIndex;
import com.indexing.store.Tuple;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created bu PacLab
 * User: PacLab
 */

public class SearchService {


    public List<String> search(List<String> words, String[] tables) {
        Map<String, List<Tuple>> index = InvertedIndex.getMergedInvertedIndexForTables(tables);
        List<String> matchingFiles = new ArrayList<>();
        for (String _word : words) {
            String word = _word.toLowerCase();
            List<Tuple> idx = index.get(word);
            if (idx != null) {
                for (Tuple t : idx) {
                    matchingFiles.add(InvertedIndex.files.get(t.getFileNumber()));
                }
            }
        }
        return matchingFiles;
    }

    public JSONArray search(String query) throws InvalidQueryException {
        // Json array to hold the result
        JSONArray jsonArray = new JSONArray();
        if (!QueryParser.validateQuery(query)) {
            throw new InvalidQueryException("Invalid query syntax");
        }
        String[] columns = QueryParser.extractQueryColumns(query);
        String[] tables = QueryParser.extractQueryTables(query);
        Map<String, List<Tuple>> index = InvertedIndex.getMergedInvertedIndexForTables(tables);
        if (QueryParser.isWhereQuery(query)) {
            // Determines where we have AND, OR or MIXED query type
            QueryType queryType = QueryParser.queryType(query);
            Map<String, String> conditions = QueryParser.extractQueryWhereConditions(query, queryType);
            // This is supposed to hold the metadata values of where the conditions have been met
            Set<Tuple> validTuples = new HashSet<>();
            for (String key : conditions.keySet()) {
                if (!index.containsKey(conditions.get(key))) {
                    // Once condition is broken
                    return jsonArray;
                }
                // Metadata of the where value
                Set<Tuple> result = index.get(conditions.get(key)).stream().filter(tuple -> key.equalsIgnoreCase(tuple.getColumn())).collect(Collectors.toSet());
                if (queryType == QueryType.AND) {
                    validTuples = result;
                } else if (queryType == QueryType.OR) {
                    validTuples.addAll(result);
                }
            }

            // Fetching the values of the columns specified in the SELECT clause
            if (columns.length == 1 && columns[0].trim().equalsIgnoreCase("*")) {
                // load all columns
            } else {
                List<Integer> validLines = validTuples.stream().map(Tuple::getLineNumber).distinct().collect(Collectors.toList());
                List<Integer> validFiles = validTuples.stream().map(Tuple::getFileNumber).distinct().collect(Collectors.toList());
                // Each line is supposed to represent an entry that respects the where conditions
                for (int line : validLines) {
                    JSONObject item = new JSONObject();
                    for (String key : index.keySet()) {
                        index.get(key).stream().filter(tuple -> isValidEntry(columns, line, validFiles, tuple))
                                .forEach(tuple -> {
                                    item.put(tuple.getColumn(), key);
                                });
                    }
                    jsonArray.put(item);
                }
            }
        } else {
            //TODO load all
        }
        return jsonArray;
    }


    private boolean isValidEntry(String[] columns, int line, List<Integer> validFiles, Tuple tuple) {
        return line == tuple.getLineNumber() &&
                validFiles.contains(tuple.getFileNumber()) &&
                Arrays.stream(columns).filter(column -> column.trim().equalsIgnoreCase(tuple.getColumn())).findFirst().isPresent();
    }

}
