package io.cscode.algorithms.linkedlist;

import java.util.Stack;

public class ReverseSinglyLinkedList {


    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node reverse(Node head){
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        Node current = head;
        Node next = null;
        while ((next = current.next) != null) {
            stack.add(next);
            current = next;
        }

        Node temp = new Node(0);
        Node reversed = temp;
        while(!stack.isEmpty()) {
            Node removed = stack.pop();
            System.out.println(removed.data);
            reversed.next = removed;
            reversed = reversed.next;
        }
        return temp.next;
    }

    static Node reverseList(Node head)
    {
        // Stack to store elements of list
        Stack<Node > stk = new Stack<Node> ();

        // Push the elements of list to stack
        Node ptr = head;
        while (ptr.next != null)
        {
            stk.push(ptr);
            ptr = ptr.next;
        }

        // Pop from stack and replace
        // current nodes value'
        ptr = new Node(0);
        head = ptr;
        while (!stk.isEmpty())
        {
            ptr.next = stk.peek();
            ptr = ptr.next;
            stk.pop();
        }
        ptr.next = null;

        return head;
    }

    public static void main(String[] args) {
        Node ll = new Node(1);
        ll.next = new Node(2);
        ll.next.next = new Node(3);
        ll.next.next.next = new Node(4);
        Node reversed  = reverseList(ll);
        System.out.println();
    }
}
