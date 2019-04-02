package com.stephengoeddel;

public class BranchHistoryEntry {
    private final String key;
    private String history;

    public BranchHistoryEntry(String key, String history) {
        this.key = key;
        this.history = history;
    }

    public String getKey() {
        return key;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
