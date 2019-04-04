package com.stephengoeddel;

import java.util.Random;

public enum BranchOdds {
    NEVER(0, true),
    RARELY(25, true),
    COIN_FLIP(50, true),
    MOSTLY(75, true),
    ALWAYS(100, true),
    RANDOM(-1, false);

    private final int oddsOutOf100;
    private final boolean predefinedOdds;

    BranchOdds(int oddsOutOf100, boolean predefinedOdds) {
        this.oddsOutOf100 = oddsOutOf100;
        this.predefinedOdds = predefinedOdds;
    }

    public boolean shouldTakeBranch() {
        int odds;
        Random random = new Random();
        if (predefinedOdds) {
            odds = oddsOutOf100;
        } else {
            odds =  random.nextInt(101);
        }

        int randomInt = random.nextInt(101);
        return randomInt <= odds;
    }
}
