package io.cscode.algorithms.arrays;

import java.util.HashSet;

public class UniqueEmailAddresses {

    static int filterUniqueEmailAddressesUsingHashing(String[] emails) {
        HashSet<String> unique = new HashSet<>();
        for(String email: emails) {
            StringBuilder sb = new StringBuilder(email.length());
            int i=0;
            while(i<email.length()) {
                char c = email.charAt(i);
                if(c == '+' || c == '@') {
                    int index = email.indexOf('@', i);
                    sb.append(email.substring(index));
                    break;
                }
                if(c != '.'){
                    sb.append(c);
                }
                i++;
            }
            unique.add(sb.toString());

        }
        return unique.size();
    }

    public static void main(String[] args) {
        System.out.println(filterUniqueEmailAddressesUsingHashing(new String[]{"cscodeio@test.com", "cscode.io@test.com", "cscode@cscode.io"}));
    }
}
