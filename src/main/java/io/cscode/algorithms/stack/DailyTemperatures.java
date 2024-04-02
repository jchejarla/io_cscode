package io.cscode.algorithms.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                result[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}
