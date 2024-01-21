package io.cscode.algorithms.slidingwindow;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

    static int characterReplacement(String s, int k) {

        HashMap<Character, Integer> count = new HashMap<>();
        int left = 0;
        int right = 0;
        int longestCount= 0;
        int result = 0;
        while(right < s.length()) {
            char current = s.charAt(right);
            int newCount = count.merge(current, 1, Integer::sum); // add count as 1 if not exists, otherwise sum it up to existing count.
            longestCount = Math.max(longestCount, newCount);

              /*
                Key logic is here, Since we can perform K number of replacements,
                our window size is right-left, check if there are 'K' other elements
                other than the character which appeared the highest number of times.
                For example, ABBBBBBCDEF, K=2, when we are at C, our window size is 8,
                and the character that appeared higher number of times is 'B', within this window, we have two other characters A and C.
                so the longest substring with K replacements at this window will be BBBBBBBBDEF.
             */

            if((right - left +1) - longestCount > k) {
                count.merge(current, -1, Integer::sum);
                left++;
            }
            result = Math.max(result, (right - left +1));
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
