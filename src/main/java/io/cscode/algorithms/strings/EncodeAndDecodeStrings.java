package io.cscode.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
           sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    static List<String> decode(String str) {
        // write your code here
        List<String> list = new ArrayList<>();
        int currentIndex = 0;
        while(currentIndex < str.length()) {
            int separatorPos = str.indexOf("#", currentIndex);
            String actualStrLength = str.substring(currentIndex, separatorPos);
            int length = Integer.parseInt(actualStrLength);
            String actualStr = str.substring(separatorPos+1, separatorPos+length+1);
            currentIndex = separatorPos+actualStr.length()+1;
            list.add(actualStr);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> s1 = List.of("cs","code","love","you");
        String encodedS1 = encode(s1);
        System.out.println("Encoded string of "+s1+" is : "+encodedS1);
        System.out.println("Decoded string of "+s1+" is : "+decode(encodedS1));

        List<String> s2 = List.of("#cs#","#code#","#love#","#you#");
        String encodedS2 = encode(s2);
        System.out.println("Encoded string of "+s2+" is : "+encodedS2);
        System.out.println("Decoded string of "+s2+" is : "+decode(encodedS2));
    }
}
