package com.indexing.server;

import com.indexing.util.datastructure.Pair;

import java.util.ArrayList;
import java.util.List;

public interface ClusterInitializer
        extends HasIpAddress {

    static List<Pair<String, String>> cluster = new ArrayList<Pair<String,String>>();;

}
