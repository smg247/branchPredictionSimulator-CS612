package com.stephengoeddel;

public class BranchDestination {
    private final String key;
    private final String pcIfTaken;

    public BranchDestination(String key, String pcIfTaken) {
        this.key = key;
        this.pcIfTaken = pcIfTaken;
    }

    public String getKey() {
        return key;
    }

    public String getPcIfTaken() {
        return pcIfTaken;
    }

    @Override
    public String toString() {
        return "Branch Destination: " + key + "-->" + pcIfTaken;
    }
}
