package io.cscode.collections.map.examples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DeleteEntriesFromMap {

    public static void removeEntryUsingKey() {
        Map<String, String> map = new HashMap<>(Map.of("Item 1","Tomatoes", "Item 2","Oranges"));
        System.out.println("BEFORE , map size : "+map.size() + " , entries " + map);
        map.remove("Item 1");
        System.out.println("AFTER , map size : "+map.size() + " , entries " + map);
    }

    public static void removeEntryUsingIterator() {
        Map<String, String> map = new HashMap<>(Map.of("Item 1","Tomatoes", "Item 2","Oranges"));
        System.out.println("BEFORE , map size : "+map.size() + " , entries " + map);
        Iterator<Map.Entry<String, String>> ite  = map.entrySet().iterator();
        while(ite.hasNext()) {
            if("Item 1".equals(ite.next().getKey())) {
                ite.remove();
            }
        }
        System.out.println("AFTER , map size : "+map.size() + " , entries " + map);
    }

    public static void removeEntryUsingKeyAndValue() {
        Map<String, String> map = new HashMap<>(Map.of("Item 1","Tomatoes", "Item 2","Oranges"));
        System.out.println("BEFORE , map size : "+map.size() + " , entries " + map);
        map.remove("Item 1", "Tomatoes");
        System.out.println("AFTER , map size : "+map.size() + " , entries " + map);
    }

    public static void removeUsingRemoveIfOnEntrySet() {
        Map<String, String> map = new HashMap<>(Map.of("Item 1","Tomatoes", "Item 2","Oranges"));
        System.out.println("BEFORE , map size : "+map.size() + " , entries " + map);
        map.entrySet().removeIf(entry-> "Item 1".equals(entry.getKey()));
        System.out.println("AFTER , map size : "+map.size() + " , entries " + map);
    }

    public static void removeUsingRemoveIfOnKeySet() {
        Map<String, String> map = new HashMap<>(Map.of("Item 1","Tomatoes", "Item 2","Oranges"));
        System.out.println("BEFORE , map size : "+map.size() + " , entries " + map);
        map.keySet().removeIf(entry-> "Item 1".equals(entry));
        System.out.println("AFTER , map size : "+map.size() + " , entries " + map);
    }

    public static void removeUsingRemoveIfOnValues() {
        Map<String, String> map = new HashMap<>(Map.of("Item 1","Tomatoes", "Item 2","Oranges"));
        System.out.println("BEFORE , map size : "+map.size() + " , entries " + map);
        map.values().removeIf(val-> "Tomatoes".equals(val));
        System.out.println("AFTER , map size : "+map.size() + " , entries " + map);
    }

    public static void main(String[] args) {
        //removeEntryUsingKey();
        //removeEntryUsingIterator();
        //removeEntryUsingKeyAndValue();
        //removeUsingRemoveIfOnEntrySet();
        //removeUsingRemoveIfOnKeySet();
        removeUsingRemoveIfOnValues();
    }
}
