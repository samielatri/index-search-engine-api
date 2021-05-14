package com.indexing.store.Document;

import java.io.Serializable;

public class DocumentCollection
        implements Serializable, InvertedIndex<DocumentCollection, Integer>{

    public DocumentCollection() {

    }

    /**
     * add document to collection of document from id and documentCollection
     * @param documentCollection DocumentCollection document that represent data to store
     * @param VendorID Integer id of the document
     */
    public void addToCollection(DocumentCollection documentCollection, Integer VendorID){

    }

    /**
     * add String data to collection
     * @param data String
     */
    public void addToCollection(String data){

    }
}
