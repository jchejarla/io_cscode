package io.cscode.algorithms.arrays;

import java.util.HashSet;

public class NamingACompany {

    static long distinctNames(String[] ideas) {

        HashSet<String>[] set = new HashSet[26];
        for(String idea: ideas) {
            int index = idea.charAt(0) - 'a';
            if(set[index] == null) {
                set[index] = new HashSet<>();
            }
            set[index].add(idea.substring(1));
        }

        long result = 0;
        for(int i=0; i<set.length; i++) {
            HashSet<String> ideasASet = set[i];
            if(ideasASet == null) {
                continue;
            }
            for(int j=i; j<set.length; j++) {
                HashSet<String> ideasBSet = set[j];
                if(ideasBSet == null) {
                    continue;
                }
                int existInBoth = 0; // suffix words that exits in both sets
                for(String ideasB: ideasBSet) {
                    if(ideasASet.contains(ideasB)) {
                        existInBoth++;
                    }
                }

                result += (ideasBSet.size() - existInBoth) * (ideasASet.size() - existInBoth) * 2L;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(distinctNames(new String[]{"coffee","donuts","time","toffee"}));
        System.out.println(distinctNames(new String[]{"lack","back"}));

    }
}
