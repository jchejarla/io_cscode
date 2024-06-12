package io.cscode.algorithms.binarysearch;

public class GuessNumberHigherLower extends GuessGame {

    public GuessNumberHigherLower(int n) {
        init(n);
    }

    public int guessNumber(int n) {

        int left = 1;
        int right = n;
        while(left<=right) {
            int mid = left + (right - left) /2;
            int guess = guess(mid);
            if(guess == 0) {
                return mid;
            } else if(guess == -1) {
                right = mid-1;
            } else {
                left = mid+1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new GuessNumberHigherLower(10).guessNumber(10));
    }
}
