package com.indexing.service;

import com.indexing.store.InvertedIndex;
import com.indexing.store.Tuple;

import java.util.ArrayList;
import java.util.List;

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
}
