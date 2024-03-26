package io.cscode.algorithms.stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemovingStarsFromString {

    static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if('*' == c){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(removeStars("cs**cod*e"));
        System.out.println(removeStars("erase*****"));
    }
}
