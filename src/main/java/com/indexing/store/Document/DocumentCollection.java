package com.indexing.store.Document;

import com.indexing.util.datastructure.OptimizedArrayList;
import com.indexing.util.parser.Parser;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.indexing.store.Document.Configuration.*;

public class DocumentCollection
        implements Serializable, InvertedIndex<DocumentLine, Integer> {

    public static Map<Integer, List<DocumentLine>> mapper;

    static {
        mapper = new HashMap<Integer, List<DocumentLine>>();
    }

    /**
     * Default constructor
     */
    public DocumentCollection() {

    }

    /**
     * Constructor that takes a mapper to initialize the static mapper
     * @param mapper Map<Integer, List<DocumentLine>>
     */
    public DocumentCollection(Map<Integer, List<DocumentLine>> mapper) {
        DocumentCollection.mapper = mapper;
    }

    /**
     * add document to collection of document from id and documentCollection
     * @param documentLine DocumentLine line that represent data to store
     * @param documentLineId Integer id of the documentLine, e.g: VendorID
     */
    public void addToCollection(DocumentLine documentLine, Integer documentLineId) {
        try {
            boolean documentLineIndexed = mapper.get(documentLineId).add(documentLine);
            if (! documentLineIndexed) {
                mapper.put(documentLineId, new LinkedList<DocumentLine>());
                mapper.get(documentLineId).add(documentLine);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * add String data to collection by adding to the mapper using the CsvParser
     * @param data String that represents the line of data, need to be in csv format
     */
    public void addToCollection(String data) {
        // TODO: new DocumentLine.... is a function in CSVParser
        String[] dataArray = Parser.parseData(data, ",");
        addToCollection( new DocumentLine(
                dataArray[TPEP_PICKUP_DATETIME],
                dataArray[TPEP_DROPOFF_DATETIME],
                Short.parseShort(dataArray[PASSENGER_COUNT]),
                Float.parseFloat(dataArray[TRIP_DISTANCE]),
                Float.parseFloat(dataArray[PICKUP_LONGITUDE]),
                Float.parseFloat(dataArray[PICKUP_LATITUDE]),
                Short.parseShort(dataArray[RATECODEID]),
                dataArray[STORE_AND_FWD_FLAG],
                Float.parseFloat(dataArray[DROPOFF_LONGITUDE]),
                Float.parseFloat(dataArray[DROPOFF_LATITUDE]),
                Short.parseShort(dataArray[PAYEMENT_TYPE]),
                Float.parseFloat(dataArray[FARE_AMOUNT]),
                Float.parseFloat(dataArray[EXTRA]),
                Float.parseFloat(dataArray[MTA_TAX]),
                Float.parseFloat(dataArray[TIP_AMOUNT]),
                Float.parseFloat(dataArray[TOLLS_AMOUNT]),
                Float.parseFloat(dataArray[IMPROVEMENT_SURCHARGE]),
                Float.parseFloat(dataArray[TOTAL_AMOUNT])
        ), Integer.parseInt(dataArray[VENDOR_ID]) );
    }

    /**
     * return size of DocumentCollection, size of DocumentCollection is
     * the number of indexed documentLines
     * @return int size of DocumentCollection
     */
    public static int getSize(){
        int size = 0;
        for ( int id : DocumentCollection.mapper.keySet() ) {
            size += DocumentCollection.mapper.get(id).size();
        }
        return size;
    }
}
