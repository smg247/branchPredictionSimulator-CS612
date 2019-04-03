package com.stephengoeddel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BranchPredictor {
    private List<ProgramCounter> programCounters;
    private BranchHistory branchHistory;
    private List<BranchDestination> branchDestinations;

    private int numberOfPCs;
    private int numberOfCycles;

    public BranchPredictor(int numberOfPCs, int numberOfCycles) {
        this.numberOfPCs = numberOfPCs;
        this.numberOfCycles = numberOfCycles;

        programCounters = new ArrayList<ProgramCounter>();
        branchHistory = new BranchHistory();
        branchDestinations = new ArrayList<BranchDestination>();
    }

    public void runSimulation() {
        Random random = new Random();
        for (int i = 0; i < numberOfCycles; i++) {
            System.out.println("============ New PC ============");
            int pcIndex = random.nextInt(numberOfPCs);
            ProgramCounter programCounter = programCounters.get(pcIndex);
            System.out.println(programCounter);

            String key = Util.getKeyFromPC(programCounter);
            String history = Util.findBranchHistoryForPC(programCounter, branchHistory);
            System.out.println("Key: " + key);
            System.out.println(Util.formatBranchHistoryForPrinting(history));

            boolean takeBranch = Util.shouldTakeBranch(50); //TODO: this is a coin flip for now, but should be configurable
            if (takeBranch) {
                System.out.println("Branch Taken");
                //TODO: find the destination and print it out
            } else {
                System.out.println("Branch Not Taken");
            }
            //TODO: update the branch history for this branch to reflect what just happened


        }
    }

    public void seed() {
        for (int i = 0; i < numberOfPCs; i++) {
            String binaryString = Util.generateRandomPC();
            ProgramCounter programCounter = new ProgramCounter(binaryString);
            programCounters.add(programCounter);

            String key = Util.getKeyFromPC(programCounter);
            BranchDestination branchDestination = new BranchDestination(key, Util.generateRandomPC());
            branchDestinations.add(branchDestination);

            branchHistory.updateHistory(key, Util.generateRandomHistory());
        }
    }
}
