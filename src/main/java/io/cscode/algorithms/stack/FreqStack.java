package io.cscode.algorithms.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FreqStack {
    final Map<Integer, Stack<Integer>> frequencyToElementsList;
    final Map<Integer, Integer> frequencyOfElements;
    int maxFrequency =0;

    public FreqStack() {
        frequencyToElementsList = new HashMap<>();
        frequencyOfElements = new HashMap<>();
    }

    public void push(int val) {
        int freq = frequencyOfElements.merge(val, 1, Integer::sum);
        if(freq>maxFrequency)  {
            maxFrequency = freq;
            frequencyToElementsList.put(freq, new Stack<>());
        }
        frequencyToElementsList.get(freq).push(val);
    }

    public int pop() {
        Stack<Integer> stack = frequencyToElementsList.get(maxFrequency);
        int result = stack.pop();
        frequencyOfElements.merge(result, -1, Integer::sum);
        if(stack.isEmpty()) { // there are no other elements with the same frequency
            maxFrequency--;
        }
        return result;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(7);
        freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}
