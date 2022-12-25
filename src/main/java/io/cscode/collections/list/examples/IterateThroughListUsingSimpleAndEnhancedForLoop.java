package io.cscode.collections.list.examples;

import java.util.List;

public class IterateThroughListUsingSimpleAndEnhancedForLoop {

    public static void iterateUsingRegularForLoop() {
        List<String> groceries = List.of("Tomatoes", "Potato", "Eggplant","Broccoli", "Squash");
        for(int i=0; i<groceries.size(); i++) { // regular for loop
            System.out.println("#Item : "+ groceries.get(i));
        }
    }


    public static void iterateUsingEnhancedForLoop() {
        List<String> groceries = List.of("Tomatoes", "Potato", "Eggplant", "Broccoli", "Squash");
        for (String item : groceries) { // enhanced for loop syntax
            System.out.println("#Item : " + item);
        }
    }

    public static void iterateUsingWhileLoop(){
        List<String> groceries = List.of("Tomatoes", "Potato", "Eggplant", "Broccoli", "Squash");
        int counter =0;
        while(counter<groceries.size()) {
            System.out.println("#Item : " + groceries.get(counter++));
        }
    }

    public static void main(String[] args) {
       // iterateUsingRegularForLoop();
        //iterateUsingEnhancedForLoop();
        iterateUsingWhileLoop();
    }
}
