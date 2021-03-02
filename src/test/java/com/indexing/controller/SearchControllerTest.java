package com.indexing.controller;

import com.indexing.store.InvertedIndex;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Created bu PacLab
 * User: sami
 */

public class SearchControllerTest extends JerseyTest {

    private static final String FILE_PATH;

    static {
        FILE_PATH = System.getProperty("user.dir") + "/dummy-data.csv";
    }

    public SearchControllerTest() {
    }

    @Override
    protected Application configure() {
        ResourceConfig resourceConfig = new ResourceConfig();

        resourceConfig.register(SearchController.class);
        resourceConfig.register(IndexController.class);
        resourceConfig.register(MultiPartFeature.class);

        return resourceConfig;
    }

    @Override
    protected void configureClient(ClientConfig config) {
        config.register(MultiPartFeature.class);
    }

    @Before
    public void before() {
        InvertedIndex.index.clear();
    }

    @Test
    public void testSearchQuery() {

        // Indexing the file
        FileDataBodyPart filePart = new FileDataBodyPart("file", new File(FILE_PATH));
        filePart.setContentDisposition(
                FormDataContentDisposition.name("file")
                        .fileName(FILE_PATH)
                        .build()
        );

        filePart.setMediaType(MediaType.valueOf("audio/mpeg"));

        MultiPart multiPart = new FormDataMultiPart()
                .bodyPart(filePart);

        target("index")
                .request()
                .post(
                        Entity.entity(
                                multiPart,
                                MediaType.MULTIPART_FORM_DATA
                        ),
                        String.class
                );

        // Performing the search operation

        // query 1
        final String query1 = (
                "SELECT tolls_amount,improvement_surcharge,total_amount,congestion_surcharge "
                        + "FROM DOES_NOT_MATTER_YET "
                        + "WHERE total_amount = value1"
        );

        final String response1 = (
                target("search")
                        .request()
                        .post(
                                Entity.text(query1),
                                String.class
                        )
        );

        JSONArray array1 = new JSONArray(response1);

        assertEquals(
                2,
                array1.length()
        );

        // query 2
        final String query2 = (
                "SELECT tolls_amount, improvement_surcharge,total_amount,congestion_surcharge "
                        + "FROM DOES_NOT_MATTER_YET"
                        + "WHERE total_amount = value3"
        );

        final String response2 = (
                target("search")
                        .request()
                        .post(
                                Entity.text(query2),
                                String.class
                        )
        );

        JSONArray array2 = new JSONArray(response2);

        assertEquals(
                1,
                array2.length()
        );
    }


}