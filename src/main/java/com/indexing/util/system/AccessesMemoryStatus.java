package com.indexing.util.system;

public interface AccessesMemoryStatus {

        Runtime runtime = Runtime.getRuntime();

        long getMaxMemory();

        long getUsedMemory();

        long getTotalMemory();

        long getFreeMemory();

}
