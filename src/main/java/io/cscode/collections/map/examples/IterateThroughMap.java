package io.cscode.collections.map.examples;

import java.util.Iterator;
import java.util.Map;

public class IterateThroughMap {

    public static void iterateUsingForEachLoop() {
        Map<String, String> map = Map.of("Item 1","Tomatoes", "Item 2","Oranges");
        map.forEach((key, value)->System.out.println("Key : "+ key + " , Value : "+value));
    }

    public static void iterateViaEntrySetIterator() {
        Map<String, String> map = Map.of("Item 1","Tomatoes", "Item 2","Oranges");
        Iterator<Map.Entry<String, String>> ite = map.entrySet().iterator();
        while(ite.hasNext()) {
            Map.Entry<String, String> entry  = ite.next();
            System.out.println("Key : "+ entry.getKey() + " , Value : "+entry.getValue());
        }
    }

    public static void iterateViaEntrySetEnhancedForLoop() {
        Map<String, String> map = Map.of("Item 1","Tomatoes", "Item 2","Oranges");
        for(Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println("Key : "+ entry.getKey() + " , Value : "+entry.getValue());
        }
    }

    public static void main(String[] args) {
        //iterateUsingForEachLoop();
        //iterateViaEntrySetIterator();
        //iterateViaEntrySetEnhancedForLoop();
    }
}
