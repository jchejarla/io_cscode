package io.cscode.algorithms.strings;

public class LongestCommonPrefix {

    static String checkCharsVertically(String[] strs) {
        int longest = 0;
        String prefix = strs[0];
        for(int i=0; i<prefix.length(); i++) {
            for(int j=1; j<strs.length; j++) {
                if(i == strs[j].length() || prefix.charAt(i) != strs[j].charAt(i)) {
                    return prefix.substring(0, longest);
                }
            }
            longest++;
        }

        return prefix.substring(0, longest);
    }


    public static void main(String[] args) {
        System.out.println(checkCharsVertically(new String[] {"flower","flow","flight"}));
        System.out.println(checkCharsVertically(new String[] {"dog","racecar","car"}));
        System.out.println(checkCharsVertically(new String[] {"abcd"}));
        System.out.println(checkCharsVertically(new String[] {"cir","car"}));


    }
}
