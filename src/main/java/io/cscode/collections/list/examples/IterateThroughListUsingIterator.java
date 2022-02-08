package io.cscode.collections.list.examples;

import java.util.Iterator;
import java.util.List;

public class IterateThroughListUsingIterator {

    public static void iterateUsingIterator() {
        List<String> groceries = List.of("Tomatoes", "Potato", "Eggplant","Broccoli", "Squash");
        //iterator works based on a pointer hasNext() will tell whether it reached end of List or not
        // and next() will fetch the element and move pointer to next element if there is any

        System.out.println("###### iterator in while loop #####");
        Iterator<String> ite = groceries.iterator();
        while(ite.hasNext()) {
            System.out.println("inside while loop : "+ ite.next());
        }

        // same above logic can be implemented using while loop as well.
        System.out.println("###### iterator in for loop #####");
        for(Iterator<String> it = groceries.iterator(); it.hasNext();) {
            System.out.println("inside for loop : "+ it.next());
        }

    }

    public static void main(String[] args) {
        iterateUsingIterator();
    }
}
