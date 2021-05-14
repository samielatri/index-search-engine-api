package com.indexing.service;

import com.indexing.store.InvertedIndex;
import org.glassfish.jersey.media.multipart.ContentDisposition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created bu PacLab
 * User: PacLab
 */

public class IndexService {

    public long indexFile(InputStream inputStream, ContentDisposition contentDisposition) throws IOException {
        String tableName;
        final List<String> columns = new ArrayList<>();
        if (contentDisposition != null) {
            tableName = contentDisposition.getFileName().trim();
            if(tableName.contains(".")) {
                tableName = tableName.substring(0, tableName.lastIndexOf("."));
            }
        } else {
            tableName = "file_" + LocalDateTime.now();
        }
        // Creating the table (empty for now)
        InvertedIndex.createTable(tableName);
        long startTime = System.currentTimeMillis();
        int fileNumber = InvertedIndex.files.indexOf(tableName);
        if (fileNumber == -1) {
            InvertedIndex.files.add(tableName);
            fileNumber = InvertedIndex.files.size() - 1;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        int lineNumber = 0;

        // Lines
        for (String line = reader.readLine(); line != null; line = reader
                .readLine()) {

            int columnNumber = 0;

            // Columns
            for (String _word : line.split(",")) {
                String word = _word.toLowerCase();
                if (lineNumber == 0) {
                    columns.add(word);
                } else {
                    /*
                    if (word.isBlank() || InvertedIndex.stopwords.contains(word))
                        continue;
                    List<Tuple> idx = InvertedIndex.getWordMetadata(tableName, word);
                    if (idx != null && idx.size() == 0) {
                        // Filling the previously created table
                        InvertedIndex.getTable(tableName).put(word, idx);
                    }
                    idx.add(new Tuple(fileNumber, lineNumber, columns.get(columnNumber).trim()));
                    columnNumber++;
                    */
                }
            }

            lineNumber++;
        }
        return System.currentTimeMillis() - startTime;
    }

}