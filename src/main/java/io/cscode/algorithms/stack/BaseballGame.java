package io.cscode.algorithms.stack;

import java.util.Stack;

public class BaseballGame {

    static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String op: operations) {
            if("+".equals(op)) {
                // record a new score, sum of two previous scores
                if(stack.size()>=2) {
                    int x1 = stack.pop();
                    int x2 = stack.peek();
                    int newRecord = x1+x2;
                    stack.push(x1);
                    stack.push(newRecord);
                }
            } else if ("D".equals(op)) {
                // record a new score, that is double of previous element
                if(stack.size()>=1) {
                    stack.push(stack.peek() *2);
                }
            } else if ("C".equals(op)) {
                //invalidate previous
                if(stack.size()>=1) {
                    stack.pop();
                }
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        int total = 0;
        for(Integer num: stack) {
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
        System.out.println(calPoints(new String[]{"1","C"}));
    }
}
