package io.cscode.algorithms.strings;

public class IsSubsequence {

    /* Using two pointers approach */
    static boolean usingTwoPointers(String s, String t) {
        if(s.length() > t.length()) {
            return false;
        }

        int i = 0;
        int j =0;
        while(i<s.length() && j<t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        System.out.println("############### Using two pointers approach ######################");
        System.out.println(usingTwoPointers("abc", "ahbgdc"));
        System.out.println(usingTwoPointers("axc", "ahbgdc"));
        System.out.println(usingTwoPointers("axc", "ahbgdcx"));

    }
}
