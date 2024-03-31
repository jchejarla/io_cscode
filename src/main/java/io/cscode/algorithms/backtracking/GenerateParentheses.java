package io.cscode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GenerateParentheses {

    static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, 0, 0, new Stack<>(), res);
        return res;
    }

    static void helper(int n, int openN, int closeN, Stack<Character> stack, List<String> result) {
        if(openN == closeN && openN == n) {
            result.add(stack.stream().map(String::valueOf).collect(Collectors.joining()));
            return;
        }

        if(openN < n) {
            stack.push('(');
            helper(n, openN+1, closeN, stack, result);
            stack.pop();
        }

        if(closeN<openN) {
            stack.push(')');
            helper(n, openN, closeN+1, stack, result);
            stack.pop();
        }

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
