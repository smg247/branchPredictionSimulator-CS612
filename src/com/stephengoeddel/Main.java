package com.stephengoeddel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to the Branch Prediction Simulation using a 2-bit counter!");
        Scanner in = new Scanner(System.in);

        System.out.println("Firstly, would you like to watch as the simulation runs (1), or just skip to the results (2)?: ");
        int dramaticMode = in.nextInt();
        while (dramaticMode < 1 || dramaticMode > 2) {
            System.out.println("Enter 1 or 2");
            dramaticMode = in.nextInt();
        }

        System.out.println("Choose the total number of program counters (representing potential branches) in the program (1 - 1000): ");
        int numberOfPCs = in.nextInt();
        while (numberOfPCs <= 0 || numberOfPCs > 1000) {
            System.out.println("Invalid PC number, try again");
            numberOfPCs = in.nextInt();
        }

        System.out.println("Choose the total number cycles to simulate (representing total branch decisions) in the program (1 - 10000): ");
        int numberOfCycles = in.nextInt();
        while (numberOfCycles <= 0 || numberOfCycles > 10000) {
            System.out.println("Invalid cycle number, try again");
            numberOfCycles = in.nextInt();
        }

        System.out.println("Choose the length of the key for the BTB and BHB (2-8): ");
        int keyLength = in.nextInt();
        while (keyLength <= 1 || keyLength > 8) {
            System.out.println("Invalid key length, try again");
            keyLength = in.nextInt();
        }

        System.out.println("Finally, choose the odds that any given branch will actually be taken: ");
        for (BranchOdds value : BranchOdds.values()) {
            System.out.println(value.ordinal() + " - " + value.name());
        }

        int branchOddsChoice = in.nextInt();
        while (branchOddsChoice < 0 || branchOddsChoice > BranchOdds.values().length - 1) {
            System.out.println("Invalid branch odds, try again");
            branchOddsChoice = in.nextInt();
        }

        BranchPredictor branchPredictor = new BranchPredictor(numberOfPCs, numberOfCycles, keyLength, BranchOdds.values()[branchOddsChoice], dramaticMode == 1);
        branchPredictor.seed();
        branchPredictor.runSimulation();
    }
}
