package com.stephengoeddel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BranchPredictor {
    List<ProgramCounter> programCounters;
    List<BranchHistoryEntry> branchHistories;

    public BranchPredictor() {
        programCounters = new ArrayList<ProgramCounter>();
        branchHistories = new ArrayList<BranchHistoryEntry>();
    }

    public void seed() {

    }
}
