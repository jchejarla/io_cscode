package io.cscode.algorithms.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStringWithDistinctCharacters {

    static int longestSubStringWith_K_Distinct_Characters(String input, int k) {

        int i=0;
        int j=0;

        int maxLength = -1;

        int[] count = new int[256];
        while(j<input.length()) {

            char currentChar = input.charAt(j);

            if(count[currentChar] ==0) {
                // if this character is not repeated
                count[currentChar] = count[currentChar]+1;
                j++;
                maxLength = Math.max(maxLength, (j-i));
            } else {
                // if the current character is already seen, we need to move the window. i.e. move i to its new position
                count[currentChar] = count[currentChar]-1;
                i++;
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        String input  = "aabacbebe";
        System.out.println(longestSubStringWith_K_Distinct_Characters(input, 3));
    }

}
