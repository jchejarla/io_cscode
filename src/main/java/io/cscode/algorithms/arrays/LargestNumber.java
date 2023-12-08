package io.cscode.algorithms.arrays;

import java.util.stream.IntStream;

public class LargestNumber {

    static String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        IntStream.of(nums).boxed().sorted((num1, num2)->{
            String compare1 = num1+""+num2;
            String compare2 = num2+""+num1;
            return compare2.compareTo(compare1);
        }).forEach(sb::append);
        if(sb.charAt(0) == '0') {
            return "0";
        }
        return  sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(largestNumber(new int[]{0, 0}));

    }
}
