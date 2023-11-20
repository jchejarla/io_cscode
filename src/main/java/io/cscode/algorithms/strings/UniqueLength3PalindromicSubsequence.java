package io.cscode.algorithms.strings;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueLength3PalindromicSubsequence {

    static int countPalindromicSubsequence(String s) {

        // First count each letter occurrence and its count
        HashMap<Character, Integer> right = new HashMap<>();
        for(char c: s.toCharArray()) {
            right.merge(c, 1, Integer::sum);
        }

        HashSet<Character> left = new HashSet<>();
        HashSet<String> uniquePalindromes = new HashSet<>();

        // now loop through every character of string and check if left and right side characters are same
        for(char c: s.toCharArray()) {
            int newCount = right.merge(c, -1, Integer::sum);
            if(newCount == 0) {
                right.remove(c);
            }

            for(Character leftChar: left) {
                if(right.containsKey(leftChar)) {
                    // this is a palindrome
                    uniquePalindromes.add(String.valueOf(c) +leftChar);// just adding 2 letters,
                                                                        // as left and right letters will be same
                                                                        // in 3 letters palindromes
                }
            }
            left.add(c);
        }

        return uniquePalindromes.size();
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
        System.out.println(countPalindromicSubsequence("adc"));

    }
}
