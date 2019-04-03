package com.stephengoeddel;

public class ProgramCounter {
    private final String pc;

    public ProgramCounter(String pc) {
        this.pc = pc;
    }

    public String getPc() {
        return pc;
    }

    @Override
    public String toString() {
        return "Program Counter: " + pc;
    }
}
