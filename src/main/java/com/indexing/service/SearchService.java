package com.indexing.service;

import com.indexing.exception.InvalidQueryExcepiton;
import com.indexing.store.InvertedIndex;
import com.indexing.store.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchService {


    public List<String> search(List<String> words) {
        List<String> matchingFiles = new ArrayList<>();
        for (String _word : words) {
            String word = _word.toLowerCase();
            List<Metadata> idx = InvertedIndex.index.get(word);
            if (idx != null) {
                for (Metadata t : idx) {
                    matchingFiles.add(InvertedIndex.files.get(t.getFileNumber()));
                }
            }
        }
        return matchingFiles;
    }

    public JSONArray search(String query) throws InvalidQueryExcepiton {
        // Json array to hold the result
        JSONArray jsonArray = new JSONArray();
        if (!QueryParser.validateQuery(query)) {
            throw new InvalidQueryExcepiton("Invalid query syntax");
        }
        String[] columns = QueryParser.extractQueryColumns(query);
        if (QueryParser.isWhereQuery(query)) {
            Map<String, String> conditions = QueryParser.extractQueryWhereConditions(query);
            // This is supposed to hold the metadata values of where the conditions have been met
            List<Metadata> matchingMetadata = new ArrayList<>();
            // For now we only support single condition in the where clause, so this will iterate only once
            for (String key : conditions.keySet()) {
                if (!InvertedIndex.index.containsKey(conditions.get(key))) {
                    // Once condition is broken
                    return jsonArray;
                }
                // Metadata of the where value
                List<Metadata> metadata = InvertedIndex.index.get(conditions.get(key));
                // We're only interested in the values that actually correspond to the column specified in the where AKA key
                matchingMetadata.addAll(metadata.stream().filter(tuple -> key.equalsIgnoreCase(tuple.getColumn())).collect(Collectors.toList()));
            }


            // Fetching the values of the columns specified in the SELECT clause
            if (columns.length == 1 && columns[0].trim().equalsIgnoreCase("*")) {
                // load all columns
            } else {
                List<Integer> validLines = matchingMetadata.stream().map(Metadata::getLineNumber).collect(Collectors.toList());
                List<Integer> validFiles = matchingMetadata.stream().map(Metadata::getFileNumber).collect(Collectors.toList());

                // Each line is supposed to represent an entry that respects the where conditions
                for (int line : validLines) {
                    JSONObject item = new JSONObject();
                    for (String key : InvertedIndex.index.keySet()) {
                        InvertedIndex.index.get(key).stream().filter(metadata -> isValidEntry(columns, line, validFiles, metadata))
                                .forEach(metadata -> {
                                    item.put(metadata.getColumn(), key);
                                });
                    }
                    jsonArray.put(item);
                }

            }
        }
        return jsonArray;
    }


    private boolean isValidEntry(String[] columns, int line, List<Integer> validFiles, Metadata metadata) {
        return line == metadata.getLineNumber() &&
                validFiles.contains(metadata.getFileNumber()) &&
                Arrays.stream(columns).filter(column -> column.trim().equalsIgnoreCase(metadata.getColumn())).findFirst().isPresent();
    }

}