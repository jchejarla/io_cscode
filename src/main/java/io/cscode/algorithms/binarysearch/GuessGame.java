package io.cscode.algorithms.binarysearch;

import java.util.Random;

public class GuessGame {

    int pick=-1;

    public void init(int n) {
        Random random = new Random(1);
        pick = random.nextInt(n);
        System.out.println("Random Pick : "+pick);
    }

    protected int guess(int guess) {
        if(guess == pick) {
            return 0;
        } else if(guess >pick) {
            return -1;
        } else {
            return 1;
        }
    }
}
