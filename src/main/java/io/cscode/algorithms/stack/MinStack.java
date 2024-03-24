package io.cscode.algorithms.stack;

import java.util.Stack;

public class MinStack {
    final Stack<Integer> stack;
    final Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(minStack.isEmpty() ? val: Integer.min(val, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack1 = new MinStack();
        minStack1.push(-2);
        minStack1.push(0);
        minStack1.push(-3);
        System.out.println("Min : "+minStack1.getMin());
        minStack1.pop();
        System.out.println("Top : "+minStack1.top());
        System.out.println("Min : "+minStack1.getMin());

    }
}
