package io.cscode.algorithms.slidingwindow;

public class MinimumNumberOfFlipsToMakeTheBinaryStringAlternate {

    static int minFlips(String s) {
        //111000 - if we apply type-1 operation, i.e. remove character from beginning and add it at end.
        //to apply for all characters, that means until we get the same string back, 111000 -> 111000
        // In this approach, we will take the whole string as if we apply type-1 on every character 111000111000
        // then apply sliding window with length as 6 and see how many type-2 operations are required to get one of the possible
        // alternate string, one starts with 1 and another starts with 0.

        int n= s.length();
        s = s+ s;
        StringBuilder alternate1= new StringBuilder();
        StringBuilder alternate2= new StringBuilder();
        // First let's construct the two possible alternate strings
        for(int i=0; i<s.length(); i++) {
            if(i%2==0){
                alternate1.append("0");
                alternate2.append("1");
            } else {
                alternate1.append("1");
                alternate2.append("0");
            }
        }

        // now apply sliding window
        int left = 0;
        int right=0;
        int diff1 =0;
        int diff2 =0;
        int ans = s.length();//we are going to find min, so setting it to max possible
        while(right < s.length()) {
            if(s.charAt(right) != alternate1.charAt(right)){
                diff1++;
            }
            if(s.charAt(right) != alternate2.charAt(right)) {
                diff2++;
            }

            if(right - left +1 >n) {
                if(s.charAt(left) != alternate1.charAt(left)) {
                    diff1--;
                }
                if(s.charAt(left) != alternate2.charAt(left)) {
                    diff2--;
                }
                left++;
            }
            //update ans, only if the window size is n, that is because, we want to know how many
            // flips needed to alternate the string with original size.
            if(right - left +1  == n) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minFlips("01001001101"));
        System.out.println(minFlips("111000"));
        System.out.println(minFlips("010"));
        System.out.println(minFlips("1110"));
    }
}
