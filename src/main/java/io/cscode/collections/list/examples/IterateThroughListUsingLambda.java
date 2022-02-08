package io.cscode.collections.list.examples;

import java.util.List;

public class IterateThroughListUsingLambda {

    public static void iterateThroughListUsingLambda() {
        List<String> groceries = List.of("Tomatoes", "Potato", "Eggplant","Broccoli", "Squash");

        //pass a Java method as consumer function that takes List type as input.
        //in below line, we are passing System.out.println that takes String as argument
        System.out.println("##### simple forEach loop #####");
        groceries.forEach(System.out::println);

        //You can pass your own method as well
        System.out.println("\n##### passing my own method to forEach #####");
        groceries.forEach(new IterateThroughListUsingLambda()::print);

        //You can implement a Lambda function inline implementation and pass as argument as well.
        System.out.println("\n##### inline forEach consumer function #####");
        groceries.forEach(item -> {
            System.out.println("inside inline function  : " +item);
        });

    }

    public void print(String item) {
        System.out.println("logging item in my own method  : " +item);
    }


    public static void main(String[] args) {
       iterateThroughListUsingLambda();
    }
}
