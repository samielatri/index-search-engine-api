/* package */
package com.indexing.application;

/* On-Demand Imports */

/* Specific Imports */
import java.net.InetAddress;

/**
 * Created bu PacLab
 * User: PacLab
 * Date: 2021
 *
 * Interface hasIpAddress
 */
interface hasIpAddress {
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
