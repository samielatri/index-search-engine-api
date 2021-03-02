package com.parsing.dbms.service.business;

import com.parsing.dbms.service.util.TransformCsvToJson;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created bu PacLab
 * User: sami
 * Date: 2/9/2021
 * Time: 2:38 PM
 * Package: dbms.service.business
 * <p>
 * Class name: Document
 * Class description : A Document is a collection of non structured data.
 */
public class Document { // Column
    // attributes
    // TODO: implement Document logic
    private static int numberOfDocuments = Integer.MIN_VALUE;
    ArrayList<String> dataArrayList;
    private int documentId; // unique identifier for id

    // constructors

    /**
     * @param stringData
     */
    public Document(String... stringData) {
        documentId = numberOfDocuments++;
        dataArrayList = new ArrayList<>();
        Collections.addAll(dataArrayList, stringData);
        /*
            for(String data : stringData) {
                dataArrayList.add(data);
            } // foreach block end
         */
    } // Document constructor end

    // methods

    /**
     * @param args
     */
    public static void main(String[] args) {
        // printDataArrayList();
        // Csv file's path to test
        String testPath = "samples/yellow_tripdata_2009-01.csv";
        // readCsvUsingBufferedReader test
        System.out.println("Calling readCsvUsingBufferedReader :");
        Document document = TransformCsvToJson.readCsvUsingBufferedReader(testPath);
        if (document == null) {
            System.out.println("Problem occurred during reading");
        } else {
            document.printDataArrayList();
            System.out.println("No problems were occurred during reading");
        } // if-else block end
    } // main end

    // accessors

    // main

    /**
     *
     */
    public void printDataArrayList() {
        int dataIdentifier = -1;
        for (String data : dataArrayList) {
            System.out.println(++dataIdentifier + " : " + data + "\n");
        } // foreach block end
    } // printDataArrayList end
} // Document class end
