package io.cscode.algorithms.slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithKUniqueChars {

    static int longestWithKUnique(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int left=0;
        int right=0;
        int longest = -1;
        while(right < s.length()) {
            char current = s.charAt(right);
            count.merge(current, 1, Integer::sum);
            if(count.size() == k) {
                longest = Math.max(longest, right - left +1);
            }
            while(count.size()>k) {
                char leftChar = s.charAt(left);
                int newCount = count.merge(leftChar, -1, Integer::sum);
                if(newCount == 0){
                    count.remove(leftChar);
                }
                left++;
            }
            right++;
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestWithKUnique("aabacbebebe", 3));
        System.out.println(longestWithKUnique("aaaa", 2));

    }
}
