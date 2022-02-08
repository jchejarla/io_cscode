package io.cscode.collections.list.examples;

import java.util.List;

public class IterateThroughListUsingSimpleForLoop {

    public static void iterateUsingEnhancedForLoop() {

        List<String> groceries = List.of("Tomatoes", "Potato", "Eggplant","Broccoli", "Squash");

        System.out.println("##### enhanced for loop #####");
        for(String item: groceries) {
            System.out.println("inside enhanced for loop : "+ item);
        }

        System.out.println("##### regular for loop #####");
        for(int i=0; i<groceries.size(); i++) {
            System.out.println("inside regular for loop : "+ groceries.get(i));
        }
    }

    public static void main(String[] args) {
        iterateUsingEnhancedForLoop();
    }
}
