package com.stephengoeddel;

import java.util.HashMap;
import java.util.Map;

public class BranchDestination {
    private Map<String, String> destinationMap;

    public BranchDestination() {
        destinationMap = new HashMap<String, String>();
    }

    public static String findDestinationForKey(String key, BranchDestination branchDestination) {
        String destination = branchDestination.getDestinationForKey(key);
        if (destination == null) {
            throw new IllegalStateException("Branch Destination not found for key: " + key);
        }

        return destination;
    }

    public static String formatBranchDestinationForPrinting(String branchDestination) {
        return "Branching to PC: " + branchDestination;
    }

    public void updateDestination(String key, String history) {
        destinationMap.put(key, history);
    }

    public String getDestinationForKey(String key) {
        return destinationMap.get(key);
    }
}
