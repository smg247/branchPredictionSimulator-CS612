package com.stephengoeddel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BranchPredictor {

    private List<ProgramCounter> programCounters;
    private BranchHistory branchHistory;
    private BranchDestination branchDestination;
    private BranchOdds branchOdds;

    private int numberOfPCs;
    private int numberOfCycles;
    private final int keyLength;

    private int numberOfCorrectPredictions;

    public BranchPredictor(int numberOfPCs, int numberOfCycles, int keyLength, BranchOdds branchOdds) {
        this.numberOfPCs = numberOfPCs;
        this.numberOfCycles = numberOfCycles;
        this.keyLength = keyLength;
        this.branchOdds = branchOdds;

        programCounters = new ArrayList<ProgramCounter>();
        branchHistory = new BranchHistory();
        branchDestination = new BranchDestination();
    }

    public void runSimulation() {
        Random random = new Random();
        for (int i = 0; i < numberOfCycles; i++) {
            System.out.println("============ New PC ============");
            int pcIndex = random.nextInt(numberOfPCs);
            ProgramCounter programCounter = programCounters.get(pcIndex);
            System.out.println(programCounter);

            String key = getKeyFromPC(programCounter);
            String history = BranchHistory.findBranchHistoryForKey(key, branchHistory);
            System.out.println("Key: " + key);
            System.out.println(BranchHistory.formatBranchHistoryForPrinting(history));

            boolean predictedToBranch = BranchHistory.predictedToBranch(history);
            if (predictedToBranch) {
                System.out.println("Branch presumptively taken");
                String destination = BranchDestination.findDestinationForKey(key, branchDestination);
                System.out.println(BranchDestination.formatBranchDestinationForPrinting(destination));
            } else {
                System.out.println("Branch presumptively NOT taken");
            }

            boolean takeBranch = branchOdds.shouldTakeBranch();
            if (takeBranch) {
                System.out.println("Branch Taken");

                if (predictedToBranch) {
                    System.out.println("Good prediction!");
                    numberOfCorrectPredictions++;
                } else {
                    System.out.println("failed to branch mistakenly - penalty incurred");
                }
            } else {
                System.out.println("Branch Not Taken");
                if (predictedToBranch) {
                    System.out.println("Branched mistakenly - penalty incurred");
                } else {
                    numberOfCorrectPredictions++;
                    System.out.println("Correctly decided not to branch!");
                }
            }

            String newHistoryValue = BranchHistory.calculateNewHistoryValue(history, takeBranch);
            branchHistory.updateHistory(key, newHistoryValue);
            System.out.println("New Branch History: " + newHistoryValue);

        }

        System.out.println("Total correct predictions " + numberOfCorrectPredictions + "/" + numberOfCycles);
    }

    public void seed() {
        for (int i = 0; i < numberOfPCs; i++) {
            String binaryString = generateRandomPC();
            ProgramCounter programCounter = new ProgramCounter(binaryString);
            programCounters.add(programCounter);

            String key = getKeyFromPC(programCounter);
            branchDestination.updateDestination(key, generateRandomPC());
            branchHistory.updateHistory(key, generateRandomHistory());
        }
    }

    private String getKeyFromPC(ProgramCounter programCounter) {
        String pc = programCounter.getPc();
        if (pc.length() < keyLength) {
            throw new IllegalStateException("ProgramCounter: " + programCounter + " is too short, minimum of: " + keyLength + " required.");
        }
        return pc.substring(pc.length() - keyLength);
    }

    private String generateRandomPC() {
        Random random = new Random();
        int randomInt = random.nextInt(100000000) + 100;
        return Integer.toBinaryString(randomInt);
    }

    private String generateRandomHistory() {
        Random random = new Random();
        int randomInt = random.nextInt(4);
        String history = Integer.toBinaryString(randomInt);
        return BranchHistory.makeHistoryTwoBitsLong(history);
    }
}
