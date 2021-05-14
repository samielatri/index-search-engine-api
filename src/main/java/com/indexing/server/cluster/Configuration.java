package com.indexing.server.cluster;

import com.indexing.util.datastructure.Pair;

final class Configuration {
    // 192.168.0.0 – 192.168.255.255
    private static final Pair<String, String> master = new Pair<String, String>("master", "192.168.75.1");
    private static final Pair<String, String> slave = new Pair<String, String>("slave", "192.168.75.2");
}
