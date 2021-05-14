package com.indexing.util.parser;

import com.indexing.store.Document.DocumentCollection;
import com.indexing.store.Document.DocumentLine;

public class CSVParser
        implements Parser<DocumentLine, DocumentCollection> {

    public DocumentLine parseLine(String line) {
        return new DocumentLine();
    }

    public DocumentCollection parseFile(String fileName) {
        return new DocumentCollection();
    }

}
