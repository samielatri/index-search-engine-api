package com.indexing.util.system;

public class SystemMemory
        implements AccessesMemoryStatus {

    public long getMaxMemory() {
        return runtime.maxMemory();
    }

    public long getUsedMemory() {
        return getMaxMemory() - getFreeMemory();
    }

    public long getTotalMemory() {
        return runtime.totalMemory();
    }

    public long getFreeMemory() {
        return runtime.freeMemory();
    }

}
