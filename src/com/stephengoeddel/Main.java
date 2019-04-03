package com.stephengoeddel;

public class Main {

    public static void main(String[] args) {
        BranchPredictor branchPredictor = new BranchPredictor(100, 100);
        branchPredictor.seed();
        branchPredictor.runSimulation();
        System.out.println("test");
    }
}
