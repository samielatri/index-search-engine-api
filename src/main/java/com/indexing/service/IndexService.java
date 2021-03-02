package com.indexing.service;

import com.indexing.store.InvertedIndex;
import com.indexing.store.Metadata;
import org.glassfish.jersey.media.multipart.ContentDisposition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created bu PacLab
 * User: sami
 */

public class IndexService {

    public void indexFile(InputStream inputStream, ContentDisposition contentDisposition) throws IOException {
        String name;
        final List<String> columns = new ArrayList<>();
        if (contentDisposition != null) {
            name = contentDisposition.getFileName();
        } else {
            name = "file_" + LocalDateTime.now();
        }
        // long startTime = System.currentTimeMillis();
        int fileNumber = InvertedIndex.files.indexOf(name);
        if (fileNumber == -1) {
            InvertedIndex.files.add(name);
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
                    if (word.isBlank() || InvertedIndex.stopwords.contains(word))
                        continue;
                    List<Metadata> idx = InvertedIndex.index.computeIfAbsent(word, k -> new LinkedList<>());
                    idx.add(new Metadata(fileNumber, lineNumber, columns.get(columnNumber).trim()));
                    /*
                        if (idx == null) {
                            idx = new LinkedList<>();
                            InvertedIndex.index.put(word, idx);
                        }
                     */
                    columnNumber++;
                }
            }

            lineNumber++;
        }
        // return System.currentTimeMillis() - startTime;
    }

}