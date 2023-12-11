package io.cscode.algorithms.strings;

import java.util.HashSet;

public class CheckIfStringContainsAllBinaryCodesOfSizeK {

    static boolean hasAllCodes(String s, int k) {
        int expectedTotal  = 1 <<k; // equivalent to Math.pow(2, k)
        HashSet<String> uniqueBinaryCodes = new HashSet<>();
        for(int i=0; i<s.length()-(k-1); i++) {
            String kLengthBinary = s.substring(i, i+k);
            uniqueBinaryCodes.add(kLengthBinary);
            if(uniqueBinaryCodes.size() == expectedTotal){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasAllCodes("00110110", 2));
        System.out.println(hasAllCodes("00110", 2));
    }
}
