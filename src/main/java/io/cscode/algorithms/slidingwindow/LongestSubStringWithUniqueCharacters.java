package io.cscode.algorithms.slidingwindow;

import java.util.HashMap;

public class LongestSubStringWithUniqueCharacters {


    static int longestSubStringWith_K_Unique_Characters_2(String input, int k) {
        if(input == null || k>input.length()) {
            return -1;
        }
        int i=0;
        int j=0;

        int maxLength = -1;
        int[] countN = new int[256];
        int uniqueCharsSeenSoFar = 0;

        while(j<input.length()) {
            char currentChar = input.charAt(j);
            if(countN[currentChar] ==0) { // meaning that this is the first occurrence of that character
                uniqueCharsSeenSoFar++;
            }

            countN[currentChar] = countN[currentChar] + 1;

            while(uniqueCharsSeenSoFar >k) {
                // move the window from ith position
                char slideStartCharacter = input.charAt(i);
                int newVal = countN[slideStartCharacter] = countN[slideStartCharacter]-1;
                i++;
                if(newVal ==0) {
                    uniqueCharsSeenSoFar--;
                }
            }

            if(uniqueCharsSeenSoFar == k) {
                maxLength = Math.max(maxLength, (j-i) +1); // +1 because of array index starts from 0
            }
            j++;
        }
        return maxLength;
    }

    static int longestSubStringWith_K_Unique_Characters(String input, int k) {
        if(input == null || k>input.length()) {
            return -1;
        }
        int i=0;
        int j=0;

        int maxLength = -1;
        HashMap<Character, Integer> count = new HashMap<>();
        while(j<input.length()) {
            count.merge(input.charAt(j), 1, Integer::sum);

            while(count.size() >k) {
                // move the window from ith position
                char slideStartCharacter = input.charAt(i);
                int newVal = count.merge(slideStartCharacter, -1, Integer::sum);
                i++;
                if(newVal ==0) {
                    count.remove(slideStartCharacter);
                }
            }

            if(count.size() == k) {
                maxLength = Math.max(maxLength, (j-i) +1); // +1 because of array index starts from 0
            }
            j++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String input  = "aabacbebe";
        System.out.println(longestSubStringWith_K_Unique_Characters(input, 3));
        System.out.println(longestSubStringWith_K_Unique_Characters_2(input, 3));
    }
}
