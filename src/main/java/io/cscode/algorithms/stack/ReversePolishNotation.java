package io.cscode.algorithms.stack;

import java.util.Stack;

public class ReversePolishNotation {

    static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens) {
            if("+".equals(token)) {
                int x1 = stack.pop();
                int x2 = stack.pop();
                stack.push(x2+x1);
            } else if("-".equals(token)) {
                int x1 = stack.pop();
                int x2 = stack.pop();
                stack.push(x2-x1);
            } else if("*".equals(token)) {
                int x1 = stack.pop();
                int x2 = stack.pop();
                stack.push(x2*x1);
            } else if("/".equals(token)) {
                int x1 = stack.pop();
                int x2 = stack.pop();
                stack.push(x2/x1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
