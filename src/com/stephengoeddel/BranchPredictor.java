package com.stephengoeddel;

import java.util.ArrayList;
import java.util.List;

public class BranchPredictor {
    List<ProgramCounter> programCounters;
    List<BranchHistoryEntry> branchHistories;
    List<BranchDestination> branchDestinations;

    public BranchPredictor() {
        programCounters = new ArrayList<ProgramCounter>();
        branchHistories = new ArrayList<BranchHistoryEntry>();
        branchDestinations = new ArrayList<BranchDestination>();
    }

    public void seed(int numberOfPCs) {
        for (int i = 0; i < numberOfPCs; i++) {
            String binaryString = Util.generateRandomPC();
            ProgramCounter programCounter = new ProgramCounter(binaryString);
            programCounters.add(programCounter);

            String key = Util.getKeyFromProgramCounter(programCounter);
            BranchDestination branchDestination = new BranchDestination(key, Util.generateRandomPC());
            branchDestinations.add(branchDestination);

            BranchHistoryEntry branchHistoryEntry = new BranchHistoryEntry(key, Util.generateRandomHistory());
            branchHistories.add(branchHistoryEntry);
        }
    }
}
