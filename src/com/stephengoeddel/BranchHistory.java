package com.stephengoeddel;

import java.util.HashMap;
import java.util.Map;

public class BranchHistory {
    private Map<String, String> historyMap;

    public BranchHistory() {
        historyMap = historyMap = new HashMap<String, String>();
    }

    public static String findBranchHistoryForKey(String key, BranchHistory branchHistory) {
        String history = branchHistory.getHistoryForKey(key);
        if (history == null) {
            throw new IllegalStateException("Branch History not found for key: " + key);
        }

        return history;
    }

    public static boolean predictedToBranch(String history) {
        return "11".equals(history) || "10".equals(history);
    }

    public static String formatBranchHistoryForPrinting(String history) {
        String printableHistory = "Branch History: " + history + " --> ";
        if ("00".equals(history)) {
            printableHistory += "Strong Not Taken";
        } else if ("01".equals(history)) {
            printableHistory += "Weak Not Taken";
        } else if ("10".equals(history)) {
            printableHistory += "Weak Taken";
        } else if ("11".equals(history)) {
            printableHistory += "Strong Taken";
        } else {
            throw new IllegalStateException("Branch History not within bounds: " + history);
        }

        return printableHistory;
    }

    public static String calculateNewHistoryValue(String currentHistory, boolean branchTaken) {
        int historyInt = Integer.parseInt(currentHistory, 2);

        if (branchTaken) {
            if (historyInt < 3) {
                historyInt++;
            }
        } else {
            if (historyInt > 0) {
                historyInt--;
            }
        }

        return makeHistoryTwoBitsLong(Integer.toBinaryString(historyInt));
    }

    public static String makeHistoryTwoBitsLong(String history) {
        if (history.length() < 2) {
            return "0" + history;
        }

        return history;
    }

    public void updateHistory(String key, String history) {
        historyMap.put(key, history);
    }

    public String getHistoryForKey(String key) {
        return historyMap.get(key);
    }
}
