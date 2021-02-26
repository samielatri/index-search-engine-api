package com.indexing.service;

import com.indexing.exception.InvalidQueryExcepiton;
import com.indexing.store.InvertedIndex;
import com.indexing.store.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created bu PacLab
 * User: sami
 * */

public class SearchService {

    public List<String> search(List<String> words) {
        List<String> matchingFiles = new ArrayList<>();
        for (String _word : words) {
            String word = _word.toLowerCase();
            List<Tuple> idx = InvertedIndex.index.get(word);
            if (idx != null) {
                for (Tuple t : idx) {
                    matchingFiles.add(InvertedIndex.files.get(t.getFileno()));
                }
            }
        }
        return matchingFiles;
    }

    // TODO: add exception to signature
    public List<String> search(String query) throws InvalidQueryExcepiton {
        if (!QueryParser.validateQuery(query)) {
            throw new InvalidQueryExcepiton("Invalid query");
        }
        String[] columns = QueryParser.extractQueryColumns(query);
        // TODO select data based on the columns provided in the query
        if (QueryParser.isWhereQuery(query)) {
            Map<String, String> conditions = QueryParser.extractQueryWhereConditions(query);
            // TODO use the conditions to filter the data
        }
        return null;
    }
}
