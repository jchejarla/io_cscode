package io.cscode.algorithms.strings;

import java.util.AbstractMap;
import java.util.Map;

public class IntegerToRoman {

    static final String[] romanOrder = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    static final int[] intOrder = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for(int i= intOrder.length-1; i>=0; i--){
            int div = num / intOrder[i];
            if(div>0) {
                sb.append(romanOrder[i].repeat(div));
                num = num % intOrder[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
    }
}
