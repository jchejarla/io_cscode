package io.cscode.algorithms.strings;

public class LengthOfLastWord {

    static int traceFromRightSide(String s) {

        int length = 0;
        for(int i=s.length() -1; i>=0 ; i--) {
            if(s.charAt(i) != ' '){
                length++;
            }

            if(s.charAt(i) == ' ' && length != 0) {
                return length;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        System.out.println("############### Trace from right side approach ######################");
        System.out.println(traceFromRightSide("Hello World"));
        System.out.println(traceFromRightSide(" fly me to the moon "));
        System.out.println(traceFromRightSide("hello     "));
        System.out.println(traceFromRightSide("       hello"));

    }
}
