package com.indexing.util;

/* On-Demand imports */
import java.io.*;

/* Specific imports */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created bu PacLab
 * User: PacLab
 * Date: 2021
 *
 * Component to handle JSON conversion within Jax-RS framework,
 * implements MessageBodyWriter<Object> and MessageBodyReader<Object>.
 */
@Provider
public class GsonProvider
        implements MessageBodyWriter<Object>, MessageBodyReader<Object> {

    /* data members */

    private final Gson gson = new GsonBuilder().serializeNulls().create(); // gson object

    /**
     * return true if isWriteable, false if not.
     *
     * @param type Class<?>
     * @param genericType Type
     * @param annotations Annotation[]
     * @param mediaType MediaType
     * @return boolean true if isWriteable, false if not.
     */
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    /**
     * Return size if determinable, -1 if not
     *
     * @param o Object
     * @param type Class<?>
     * @param genericType Type
     * @param annotations Annotation[]
     * @param mediaType MediaType
     * @return long
     */
    @Override
    public long getSize(Object o, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    /**
     * @param o Object
     * @param type Class<?>
     * @param genericType Type
     * @param annotations Annotation[]
     * @param mediaType MediaType
     * @param httpHeaders MultivaluedMap<String, Object>
     * @param entityStream OutputStream
     * @throws IOException input output exception
     * @throws WebApplicationException web application exception
     */
    @Override
    public void writeTo(Object o, Class<?> type, Type genericType,
                        Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders,
                        OutputStream entityStream)
            throws IOException, WebApplicationException {
        try (OutputStreamWriter writer = new OutputStreamWriter(entityStream)) {
            String json = gson.toJson(o);
            writer.write(json);
            writer.flush();
        }
    }

    /**
     * return true if isReadable, false if not.
     * @param type Class<?>
     * @param genericType Type
     * @param annotations Annotation[]
     * @param mediaType MediaType
     * @return boolean true if isReadable, false if not.
     */
    @Override
    public boolean isReadable(Class<?> type, Type genericType,
                              Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    /**
     * @param type Class<Object>
     * @param genericType Type
     * @param annotations Annotation[]
     * @param mediaType MediaType
     * @param httpHeaders MultivaluedMap<String, String>
     * @param entityStream InputStream
     * @return Object
     * @throws IOException input output exception
     * @throws WebApplicationException webapp exception
     */
    @Override
    public Object readFrom(Class<Object> type, Type genericType,
                           Annotation[] annotations, MediaType mediaType,
                           MultivaluedMap<String, String> httpHeaders,
                           InputStream entityStream)
            throws IOException, WebApplicationException {
        try (InputStreamReader streamReader = new InputStreamReader(entityStream)) {
            return gson.fromJson(streamReader, genericType);
        }
    }
}
