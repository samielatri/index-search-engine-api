/* package */
package com.indexing.application;

/* On-Demand Imports */

/* Specific Imports */
import com.indexing.exception.RuntimeExceptionMapper;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

/**
 * Created bu PacLab
 * User: PacLab
 * Date: 2021
 *
 * App extends Application implements hasIpAddress
 */
@ApplicationPath("")
public class App
        extends Application
        implements hasIpAddress {

    /* Constructors */

    /**
     * default constructor
     */
    public App() {
    }

    /* Methods */

    /**
     * getSingletons return set of nodes.
     * @return Set<Object> set of nodes
     */
    @Override
    public Set<Object> getSingletons() {
        Set<Object> sets = new HashSet<>(Configuration.getNumberOfNodes());
        return sets;
    }

    /**
     * getClasses return set of util classes used.
     * @return Set<Class<?>> set of util classes
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> sets = new HashSet<>(Configuration.getNumberOfUtilClasses());
        sets.add(RuntimeExceptionMapper.class);
        return sets;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        try {
            return "App" + hasIpAddress.getIp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "App without known host address";
    }
}
