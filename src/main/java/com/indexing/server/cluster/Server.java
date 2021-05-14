package com.indexing.server.cluster;

import com.indexing.server.HasIpAddress;

public class Server
        implements HasIpAddress {
    protected static String ip;

    static {
        try {
            ip = HasIpAddress.getIp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
