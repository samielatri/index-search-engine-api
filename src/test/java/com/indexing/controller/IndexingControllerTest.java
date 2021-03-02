package com.indexing.controller;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.io.File;

import static org.junit.Assert.assertNotNull;

public class IndexingControllerTest extends JerseyTest {

    private static final String FILE_PATH = System.getProperty("user.dir") + "/dummy-data.csv";

    @Override
    protected Application configure() {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(IndexController.class);
        resourceConfig.register(SearchController.class);
        resourceConfig.register(MultiPartFeature.class);
        return resourceConfig;
    }

    @Override
    protected void configureClient(ClientConfig config) {
        config.register(MultiPartFeature.class);
    }

    @Test
    public void testIndexFile() {
        FileDataBodyPart filePart = new FileDataBodyPart("file", new File(FILE_PATH));
        filePart.setContentDisposition(
                FormDataContentDisposition.name("file").fileName(FILE_PATH).build());
        filePart.setMediaType(MediaType.valueOf("audio/mpeg"));

        MultiPart multiPart = new FormDataMultiPart()
                .bodyPart(filePart);

        final String response = target("index")
                .request()
                .post(Entity.entity(multiPart, MediaType.MULTIPART_FORM_DATA), String.class);

        assertNotNull(response);
    }


}
