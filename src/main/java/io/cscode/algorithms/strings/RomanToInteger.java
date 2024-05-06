package io.cscode.algorithms.strings;

import java.util.Map;

public class RomanToInteger {
    static final Map<Character, Integer> roman = Map.of('I',1,
            'V', 5,
            'X',10,
            'L',50,
            'C',100,
            'D',500,
            'M',1000);

    static int romanToInt(String s) {
        int result =0;
        for (int i=0; i<s.length(); i++) {
            int current = roman.get(s.charAt(i));
            if(i+1 < s.length() && current < roman.get(s.charAt(i+1))) {
                // if there is next character, check if current is lesser than next one
                result -= current;
            } else {
                result += current;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
