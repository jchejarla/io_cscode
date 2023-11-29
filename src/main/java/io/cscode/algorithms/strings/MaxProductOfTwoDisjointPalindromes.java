package io.cscode.algorithms.strings;

public class MaxProductOfTwoDisjointPalindromes {

    /* Brute force approach using depth-first-search*/
    static int maxProductUsingBruteForceApproach1_DFS(String s) {
        return dfs(s, 0, "", "");
    }

    static int dfs(String s, int i, String s1, String s2) {
        if(i>= s.length()) {
            if(isPalindrome(s1) && isPalindrome(s2)) {
                return s1.length() * s2.length();
            }
            return 0;
        }

        int left = dfs(s, i+1, s1+s.charAt(i), s2);
        int right = dfs(s, i+1, s1, s2+s.charAt(i));
        int center = dfs(s, i+1, s1, s2);
        return Math.max(center, Math.max(left, right));
    }

    /* Brute force approach using Bit masking*/
    static int maxProductUsingBruteForceApproach2_BitMasking(String s) {
        int mask = 1 <<s.length(); // all possible subsequences  2 power n
        int[] cache = new int[mask];
        for (int i=1; i<mask ;i++) { // we are starting with i = 1 because bit-masking with all zeros doesn't represent
                                      // any subsequence
            String subSequence = "";
            for(int j=0; j<s.length(); j++) {
                if( (i & (1 << j)) > 0) { // whether to include current character from j with  mask being i
                    subSequence += s.charAt(j);
                }
            }

            // now check subsequence reads same from both directions, for e.g. stats
            if(isPalindrome(subSequence)) {
                cache[i] = subSequence.length();
            }
        }
        // since we have stored all possible palindromes and their length stored in dp array
        // now, find disjoint ones and max product among them
        int maxProduct = 0;
        for(int i=0; i<cache.length; i++) {
            for(int j=0; j<cache.length; j++) {
                if((i &j) ==0) { // disjoint indexes
                    maxProduct = Math.max(maxProduct, cache[i] * cache[j]);
                }
            }
        }
        return maxProduct;
    }

    static boolean isPalindrome(String input) {
        for(int i=0; i< input.length()/2; i++) {
            if(input.charAt(i) != input.charAt(input.length()-1 -i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("############### Brute-force using DFS ######################");
        int maxProduct = maxProductUsingBruteForceApproach1_DFS("codingisfun");
        System.out.println(maxProduct);

        System.out.println("############### Brute-force using BitMasking ######################");
        maxProduct = maxProductUsingBruteForceApproach2_BitMasking("codingisfun");
        System.out.println(maxProduct);
    }

}
