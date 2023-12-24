package io.cscode.algorithms.arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSet {

    LinkedList<Integer>[] set = new LinkedList[10000]; // This can be changed as needed to spread numbers across

    public MyHashSet() { // to avoid NPEs later, initializing with empty LinkedLists
      for(int i=0;i< set.length; i++) {
          set[i] = new LinkedList<>();
      }
    }

    public void add(int key) {
        if(!contains(key)) {
            int hashKey = key % set.length;
            set[hashKey].add(key);
        }
    }

    public void remove(int key) {
        int hashKey = key % set.length;
        set[hashKey].remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int hashKey = key % set.length;
        return set[hashKey].contains(key);
    }


    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(Arrays.toString(myHashSet.set));
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(Arrays.toString(myHashSet.set));
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(Arrays.toString(myHashSet.set));
        System.out.println(myHashSet.contains(2));
    }
}
