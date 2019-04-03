package com.stephengoeddel;

import java.util.HashMap;
import java.util.Map;

public class BranchHistory {
    private Map<String, String> historyMap;

    public BranchHistory() {
        historyMap = historyMap = new HashMap<String, String>();
    }

    public void updateHistory(String key, String history) {
        historyMap.put(key, history);
    }

    public String getHistoryForKey(String key) {
        return historyMap.get(key);
    }
}
