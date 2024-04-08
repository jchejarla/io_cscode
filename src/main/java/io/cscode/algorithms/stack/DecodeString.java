package io.cscode.algorithms.stack;

import java.util.Stack;

public class DecodeString {

    static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if( c != ']') {
                stack.push(String.valueOf(c));
            } else {
                String current ="";
                while (!"[".equals(stack.peek())) {
                    current = stack.pop() + current;
                }
                stack.pop(); // pop the '['

                // now we need to get the K number before that
                String k = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek().toCharArray()[0])) {
                    k = stack.pop() + k;
                }
                String decoded = current.repeat(Integer.parseInt(k));
                stack.push(decoded);
            }
        }
        return String.join("", stack);
    }

    public static void main(String[] args) {
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
