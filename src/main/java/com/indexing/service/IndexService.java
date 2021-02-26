package com.indexing.service;

import com.indexing.store.InvertedIndex;
import com.indexing.store.Tuple;
import org.glassfish.jersey.media.multipart.ContentDisposition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Created bu PacLab
 * User: sami
 * */

public class IndexService {

    public long indexFile(InputStream inputStream, ContentDisposition contentDisposition) throws IOException {
        String name = null;
        if(contentDisposition !=null) {
            name = contentDisposition.getFileName();
        } else {
            name = "file_" + LocalDateTime.now();
        }
        System.out.println("Indexing file : " + name);
        long startTime = System.currentTimeMillis();
        int fileno = InvertedIndex.files.indexOf(name);
        if (fileno == -1) {
            InvertedIndex.files.add(name);
            fileno = InvertedIndex.files.size() - 1;
        }

        int pos = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        for (String line = reader.readLine(); line != null; line = reader
                .readLine()) {
            System.out.println("Indexing line : " + line);
            for (String _word : line.split("\\W+")) {
                String word = _word.toLowerCase();
                pos++;
                if (InvertedIndex.stopwords.contains(word))
                    continue;
                List<Tuple> idx = InvertedIndex.index.get(word);
                // TODO: computeIfAbsent method
                if (idx == null) {
                    idx = new LinkedList<>();
                    InvertedIndex.index.put(word, idx);
                }
                idx.add(new Tuple(fileno, pos));
            }
        }
        return System.currentTimeMillis() - startTime;
    }

}