package com.stephengoeddel;

public class Main {

    public static void main(String[] args) {
        BranchPredictor branchPredictor = new BranchPredictor(10, 1000, 4, BranchOdds.COIN_FLIP);
        branchPredictor.seed();
        branchPredictor.runSimulation();
    }
}
