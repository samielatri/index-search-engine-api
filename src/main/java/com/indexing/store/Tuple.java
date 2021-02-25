package com.indexing.store;

public class Tuple {
    private int fileno;
    private int position;

    public Tuple(int fileno, int position) {
        this.fileno = fileno;
        this.position = position;
    }

    public int getFileno() {
        return fileno;
    }

    public void setFileno(int fileno) {
        this.fileno = fileno;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}