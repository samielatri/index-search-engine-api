package com.indexing.store;

import java.util.*;

/**
 * Created bu PacLab
 * User: PacLab
 */

public class InvertedIndex {

    public static final List<String> stopwords = Arrays.asList("a", "able", "about",
            "across", "after", "all", "almost", "also", "am", "among", "an",
            "and", "any", "are", "as", "at", "be", "because", "been", "but",
            "by", "can", "cannot", "could", "dear", "did", "do", "does",
            "either", "else", "ever", "every", "for", "from", "get", "got",
            "had", "has", "have", "he", "her", "hers", "him", "his", "how",
            "however", "i", "if", "in", "into", "is", "it", "its", "just",
            "least", "let", "like", "likely", "may", "me", "might", "most",
            "must", "my", "neither", "no", "nor", "not", "of", "off", "often",
            "on", "only", "or", "other", "our", "own", "rather", "said", "say",
            "says", "she", "should", "since", "so", "some", "than", "that",
            "the", "their", "them", "then", "there", "these", "they", "this",
            "tis", "to", "too", "twas", "us", "wants", "was", "we", "were",
            "what", "when", "where", "which", "while", "who", "whom", "why",
            "will", "with", "would", "yet", "you", "your");

    private static final Map<String, Map<String, List<Tuple>>> index = new HashMap<>();
    public static final List<String> files = new ArrayList<>();


    public static Map<String, List<Tuple>> getTable(String tableName) {
        return index.get(tableName);
    }

    public static List<Tuple> getWordMetadata(String tableName, String word) {
        Map<String, List<Tuple>> table = getTable(tableName);
        if( table == null || table.get(word) == null) {
            return new ArrayList<>();
        }
        return table.get(word);
    }

    public static void clear() {
        index.clear();
    }

    public static void createTable(String tableName) {
        index.put(tableName, new HashMap<>());
    }

    public static Map<String, List<Tuple>> getMergedInvertedIndexForTables(String[] tables) {
        if (tables.length == 1) {
            return getTable(tables[0]);
        } else {
            Map<String, List<Tuple>> finalTable = new HashMap<>();
            for (String tableName : tables) {
                Map<String, List<Tuple>> table = getTable(tableName.trim());
                if(table == null) {
                    throw new IllegalArgumentException("Table " + tableName + " does not exist, please consider indexing a file with the same name before the search operation                      ");
                }
                // Adding all the words from table to finalTable except if it already exists, then we just add the tuples
                // to the corresponding word metadata
                table.forEach((key, value) -> finalTable.merge(key, value, (existingMetas, newMetas) -> {
                    existingMetas.addAll(newMetas);
                    return existingMetas;
                }));
            }
            return finalTable;
        }
    }
}
