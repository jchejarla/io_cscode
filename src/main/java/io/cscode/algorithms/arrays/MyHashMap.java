package io.cscode.algorithms.arrays;

import java.util.LinkedList;

public class MyHashMap {

    LinkedList<Entry>[] map = new LinkedList[10000];

    static class Entry {
        int key;
        int value;
        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        for(int i=0; i<map.length; i++) {
            map[i] = new LinkedList<>();
        }
    }

    // If key exists, update the value, otherwise add a new entry
    public void put(int key, int value) {
        int hashIndex = key % map.length;
        LinkedList<Entry> list = map[hashIndex];
        for(Entry entry: list) {
            if(entry.key == key) {
                entry.value = value;
                return;
            }
        }
        list.add(new Entry(key, value));
    }

    public int get(int key) {
        int hashIndex = key % map.length;
        LinkedList<Entry> list = map[hashIndex];
        for(Entry entry: list) {
            if(entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hashIndex = key % map.length;
        LinkedList<Entry> list = map[hashIndex];
        for(Entry entry: list) {
            if (entry.key == key) {
                list.remove(entry);
                return;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}
