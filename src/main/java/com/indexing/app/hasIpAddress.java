/* package */
package com.indexing.app;

/* On-Demand Imports */

/* Specific Imports */
import java.net.InetAddress;

/**
 * Created bu PacLab
 * User: PacLab
 * Date: 2021
 *
 * Interface hasIpAddress
 **/
public interface hasIpAddress {

    int NUMBER_OF_NODES = 3;
    int NUMBER_OF_UTIL_CLASSES = 3;

    /**
     * @return String host IP address
     * @throws Exception UnknownHostException if host is unknown
     */
    static String getIp() throws Exception {
        System.out.println("- DEV : B hasIpAddress:getIp()");
        InetAddress inetAddress = InetAddress.getLocalHost();
        String hostAddress = inetAddress.getHostAddress();
        System.out.println("- IP Address: " + hostAddress);
        System.out.println("- DEV : E hasIpAddress:getIp()");
        return hostAddress;
    }
}
