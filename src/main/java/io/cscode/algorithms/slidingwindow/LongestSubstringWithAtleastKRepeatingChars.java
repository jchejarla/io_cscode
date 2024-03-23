package io.cscode.algorithms.slidingwindow;

public class LongestSubstringWithAtleastKRepeatingChars {

    static int longestWithAtleasetKRepeating(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    static int helper(String s, int left, int right, int k) {
        if(right - left <k) {
            return 0;
        }

        int[] charsFrequency = new int[26];
        for(int i=left; i<right; i++) {
            charsFrequency[s.charAt(i)-'a']++;
        }

        boolean isValid = true;
        int start =0;
        int result =0;
        for( int i=left; i<right; i++) {
            if(charsFrequency[s.charAt(i)-'a'] <k) {
                result = Math.max(result, helper(s, left, i, k));
                isValid = false;
                start = i+1; // move to next position
            }
        }
        return isValid ? right - left : Math.max(result, helper(s, start, right, k));
    }

    public static void main(String[] args) {
        System.out.println(longestWithAtleasetKRepeating("aaabb", 3));
    }
}
