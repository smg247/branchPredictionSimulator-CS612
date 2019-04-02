package com.stephengoeddel;

public class ProgramCounter {
    private final int pc;
    private final int pcIfTaken;

    public ProgramCounter(int pc, int pcIfTaken) {
        this.pc = pc;
        this.pcIfTaken = pcIfTaken;
    }

    public int getPc() {
        return pc;
    }

    public int getPcIfTaken() {
        return pcIfTaken;
    }
}
