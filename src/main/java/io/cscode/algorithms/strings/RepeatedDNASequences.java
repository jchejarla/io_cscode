package io.cscode.algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {

    static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> seen = new HashMap<>();
        int i =0;
        while(i <s.length()-9) {
            String substring = s.substring(i, i+10);
            int timesSeen = seen.merge(substring, 1, Integer::sum);
            if(timesSeen == 2) {
                result.add(substring);
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
