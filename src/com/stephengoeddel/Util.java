package com.stephengoeddel;

import java.util.Random;

public class Util {
    private static int KEY_LENGTH = 8;

    public static String getKeyFromProgramCounter(ProgramCounter programCounter) {
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
}
