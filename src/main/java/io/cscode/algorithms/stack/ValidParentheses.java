package io.cscode.algorithms.stack;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    static boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();
        Map<Character, Character> closeToOpenMap = Map.of(')', '(', ']','[','}','{');

        for(char c : s.toCharArray()) {
            if(closeToOpenMap.containsKey(c)) {
                if(!chars.isEmpty() && closeToOpenMap.get(c).equals(chars.peek())) {
                    chars.pop();
                } else {
                    return false;
                }
            } else {
                chars.push(c);
            }
        }
        return chars.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid(")("));
        System.out.println(isValid("(]"));
        System.out.println(isValid(")"));
    }
}
