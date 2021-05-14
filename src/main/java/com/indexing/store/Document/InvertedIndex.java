package com.indexing.store.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InvertedIndex<T1, T2> {
    Map<Integer, List<DocumentLine>> liste = new HashMap<>();

    /**
     * add document to collection of document
     * @param document T1 document that represent data to store
     * @param id T2 id of the document
     */
    void addToCollection(T1 document, T2 id);

    void addToCollection(String data);

}
