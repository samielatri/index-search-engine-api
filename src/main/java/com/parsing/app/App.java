package com.parsing.app;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created bu PacLab
 * User: sami
 * Date: 2/10/2021
 * Time: 3:41 PM
 * Package: controller
 */


@ApplicationPath("")
public class App extends Application {

    public Set<Object> getSingletons() {
        Set<Object> sets = new HashSet<>(1);
        //sets.add(new TestEndpoint());
        return sets;
    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> sets = new HashSet<>(1);
        //sets.add(GsonProvider.class);
        //sets.add(RuntimeExceptionMapper.class);
        return sets;
    }
}