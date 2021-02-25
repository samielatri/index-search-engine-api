package com.indexing;

import com.indexing.service.IndexService;
import com.indexing.service.SearchService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Application {
    public static final String FILE_PATH = "../../../../samples/yellow_tripdata_2020-02.csv";

    private static IndexService indexService = new IndexService();
    private static SearchService searchService = new SearchService();

    public static void main(String[] args) throws IOException {
        String[] files = {FILE_PATH};
        try {
            for (int i = 0; i < files.length; i++) {
                indexService.indexFile(new FileInputStream(files[0]),
                        null);
            }
            searchService.search(Arrays.asList("koko"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}