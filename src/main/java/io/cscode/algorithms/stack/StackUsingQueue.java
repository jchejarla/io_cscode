package io.cscode.algorithms.stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingQueue {

    final Deque<Integer> queue;

    public StackUsingQueue() {
         queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.push(x);
    }

    public int pop() {
        for(int i=0; i<queue.size()-1; i++) {
            queue.push(queue.pop());
        }
        return queue.pop();
    }

    public int top() {
        for(int i=0; i<queue.size()-1; i++) {
            queue.push(queue.pop());
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stackUsingQueue = new StackUsingQueue();
        stackUsingQueue.push(3);
        stackUsingQueue.push(2);
        stackUsingQueue.push(1);
        System.out.println("top : " + stackUsingQueue.top());
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.pop());
        System.out.println(stackUsingQueue.empty());
    }
}
