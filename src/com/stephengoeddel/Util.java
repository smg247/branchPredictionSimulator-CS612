package com.stephengoeddel;

import java.util.Random;

public class Util {
    private static int KEY_LENGTH = 8;

    public static String getKeyFromPC(ProgramCounter programCounter) {
        String pc = programCounter.getPc();
        if (pc.length() < KEY_LENGTH) {
            throw new IllegalStateException("ProgramCounter: " + programCounter + " is too short, minimum of: " + KEY_LENGTH + " required.");
        }
        return pc.substring(pc.length() - KEY_LENGTH);
    }

    public static String generateRandomPC() {
        Random random = new Random();
        int randomInt = random.nextInt(100000000) + 100;
        return Integer.toBinaryString(randomInt);
    }

    public static String generateRandomHistory() {
        Random random = new Random();
        int randomInt = random.nextInt(4);
        String history = Integer.toBinaryString(randomInt);
        if (history.length() < 2) {
            history = "0" + history;
        }

        return history;
    }

    /**
     * @param odds     odds that branch should be taken out of 100
     * @return if the branch should be taken
     */
    public static boolean shouldTakeBranch(int odds) {
        if (odds < 0) {
            throw new IllegalStateException("Odds " + odds +  " less than 0");
        } else if (odds > 100) {
            throw new IllegalStateException("Odds " + odds +  " greater than 100");
        }

        Random random = new Random();
        int randomInt = random.nextInt(101);
        return randomInt <= odds;
    }

    public static String findBranchHistoryForPC(ProgramCounter programCounter, BranchHistory branchHistory) {
        String key = getKeyFromPC(programCounter);
        String history = branchHistory.getHistoryForKey(key);
        if (history == null) {
            throw new IllegalStateException("Branch History not found for key: " + key);
        }

        return history;
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
}
