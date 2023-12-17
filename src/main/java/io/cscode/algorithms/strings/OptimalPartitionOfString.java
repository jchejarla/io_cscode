package io.cscode.algorithms.strings;

import java.util.HashSet;

public class OptimalPartitionOfString {

    static int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int result = 1;
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                result++;
                set.clear();
            }
            set.add(c);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(partitionString("abacaba"));
    }
}
