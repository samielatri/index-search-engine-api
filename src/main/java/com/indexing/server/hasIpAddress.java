/* package */
package com.indexing.server;

/* On-Demand Imports */

/* Specific Imports */
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created bu PacLab
 * User: PacLab
 * Date: 2021
 *
 * Interface hasIpAddress
 */
public interface hasIpAddress {
    /**
     * @return String host IP address
     * @throws Exception UnknownHostException if host is unknown
     */
    static String getIp() throws Exception {
        String ip = "";
        try {
            System.out.println("- DEV : B hasIpAddress:getIp()");
            ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println("- IP Address: " + ip);
            System.out.println("- DEV : E hasIpAddress:getIp()");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }
}
