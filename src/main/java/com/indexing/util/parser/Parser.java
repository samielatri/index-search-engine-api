package com.indexing.util.parser;

public interface Parser<T1, T2> {
    int i = 0;

    String fileName = System.getProperty("user.dir") + "/" + Configuration.sampleFolder + "/" + Configuration.fileToLoadName;

    /**
     * Parse a line of file and store it in T1 instance.
     * @param line String line of file
     * @return T1 storage object
     */
    T1 parseLine(String line);

    /**
     * Parse a entire file and store it in T2 instance.
     * @param fileName String name of the file we parse
     * @return T2 storage object
     */
    T2 parseFile(String fileName);

}
