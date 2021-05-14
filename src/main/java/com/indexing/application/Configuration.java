/* package */
package com.indexing.application;

/* On-Demand Imports */

/* Specific Imports */

/**
 * Created bu PacLab
 * User: PacLab
 * Date: 2021
 *
 * final class Configuration
 */
final class Configuration {
    /* Data members */
    private static final int NUMBER_OF_NODES = 3;  // number of nodes
    private static final int NUMBER_OF_UTIL_CLASSES = 3; // number of utility classes

    /* Constructors */

    /**
     * default constructor
     */
    private Configuration() {

    }

    /**
     * @return int
     */
    static int getNumberOfNodes() {
        return NUMBER_OF_NODES;
    }

    /**
     * @return int
     */
    static int getNumberOfUtilClasses() {
        return NUMBER_OF_UTIL_CLASSES;
    }

    @Override
    public String toString() {
        return "Configuration : {\n" +
                "NUMBER_OF_NODES = " + NUMBER_OF_NODES +
                "\nNUMBER_OF_UTIL_CLASSES = " + NUMBER_OF_UTIL_CLASSES +
                "\n}";
    }

    /* Methods */
}
