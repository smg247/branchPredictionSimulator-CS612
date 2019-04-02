package com.stephengoeddel;

public class BranchHistoryEntry {
    private final int key;
    private int history;

    public BranchHistoryEntry(int key, int history) {
        this.key = key;
        this.history = history;
    }

    public int getKey() {
        return key;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }
}
