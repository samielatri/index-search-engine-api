package com.indexing.store;

import java.util.Objects;

/**
 * Created bu PacLab
 * User: PacLab
 */

public class Tuple {
    private int fileNumber;
    private int lineNumber;
    private String column;

    public Tuple(int fileNumber, int lineNumber, String column) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return fileNumber == tuple.fileNumber && lineNumber == tuple.lineNumber && column.equals(tuple.getColumn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileNumber, lineNumber);
    }
}