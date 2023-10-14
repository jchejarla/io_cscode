package io.cscode.algorithms.dp;

public class PalindromicSubstrings {

    static int expandAroundCenter(String s) {
        int total = 0;
        for (int i=0; i<s.length(); i++) {
            int oddLengthPalindromes = expandAroundCenterHelper(s, i, i);
            int evenLengthPalindromes = expandAroundCenterHelper(s, i, i+1);
            total += oddLengthPalindromes + evenLengthPalindromes;
        }
        return total;
    }

    static int expandAroundCenterHelper(String s, int l, int r) {
        int total = 0;
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
            total++;
            l--;
            r++;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("########### expand around center #############");
        System.out.println(expandAroundCenter("babad"));
        System.out.println(expandAroundCenter("cbbd"));
        System.out.println(expandAroundCenter("a"));
        System.out.println(expandAroundCenter("ab"));
        System.out.println(expandAroundCenter("bb"));
    }
}
