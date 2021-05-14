/* package */
package com.indexing.server.application;

/* On-Demand Imports */

/* Specific Imports */
import com.indexing.server.IsHost;
import com.indexing.server.cluster.FirstNode;
import com.indexing.server.cluster.SecondNode;
import com.indexing.server.cluster.ThirdNode;
import com.indexing.server.HasIpAddress;
import com.indexing.exception.RuntimeExceptionMapper;
import com.indexing.util.GsonProvider;
import com.indexing.util.parser.CSVParser;

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
        implements IsHost {

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
        sets.add(new FirstNode());
        sets.add(new SecondNode());
        sets.add(new ThirdNode());
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
        sets.add(GsonProvider.class);
        sets.add(CSVParser.class);
        return sets;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        try {
            return "App" + HasIpAddress.getIp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "App without known host address";
    }
}
