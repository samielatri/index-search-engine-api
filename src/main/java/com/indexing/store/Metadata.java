package com.indexing.store;

public class Metadata {
    private int fileNumber;
    private int lineNumber;
    private String column;

    public Metadata(int fileNumber, int lineNumber, String column) {
        this.fileNumber = fileNumber;
        this.lineNumber = lineNumber;
        this.column = column;
    }

    public int getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(int fileNumber) {
        this.fileNumber = fileNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
}