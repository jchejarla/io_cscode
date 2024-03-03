package io.cscode.algorithms.slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubstring {

    static String minWindow(String s, String t) {
        //first take t characters and their count into a HashMap
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char c: t.toCharArray()) {
            tMap.merge(c, 1, Integer::sum);
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        int left = 0;
        int right =0;

        int requiredCount = tMap.size();
        int haveCount = 0;

        int[] ansIndices = new int[]{0,0};
        int minLength = Integer.MAX_VALUE; // setting it to a maximum value since we want to find min

        while(right < s.length()) {
            char c = s.charAt(right);
            int sCharCount = sMap.merge(c, 1, Integer::sum);
            int tCharCount =tMap.getOrDefault(c, 0);
            if(sCharCount == tCharCount){
                haveCount++;
            }
            while(haveCount == requiredCount) {
                if(right-left+1 <minLength) {
                    minLength = right-left+1;
                    ansIndices[0] = left;
                    ansIndices[1] = right;
                }
                char leftChar = s.charAt(left++);
                sCharCount = sMap.merge(leftChar, -1, Integer::sum);
                if(tMap.containsKey(leftChar) && sCharCount < tMap.get(leftChar)) {
                    haveCount--;
                }
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(ansIndices[0], ansIndices[1]+1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
