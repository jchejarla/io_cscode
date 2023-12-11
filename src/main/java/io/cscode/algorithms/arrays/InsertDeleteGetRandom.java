package io.cscode.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class InsertDeleteGetRandom {

    final HashMap<Integer, Integer> numberToIndex;
    final List<Integer> numbers;
    final Random randomGen;

    public InsertDeleteGetRandom() {
        numberToIndex = new HashMap<>();
        numbers = new ArrayList<>();
        randomGen = new Random();
    }

    public boolean insert(int val) {
        if(numberToIndex.containsKey(val)) {
            return false;
        }
        numberToIndex.put(val, numbers.size());
        numbers.add(val);
        return true;
    }

    public boolean remove(int val) {

        if(!numberToIndex.containsKey(val)) {
            return false;
        }
        int index = numberToIndex.get(val);
        int lastIndex = numbers.size()-1;
        if(index != lastIndex) { // re-arrange numbers
            // update the index for last element of list in the map
            // replace the element that we are going tot delete with the last element in the List
            int lastElement = numbers.get(lastIndex);
            numbers.set(index, lastElement);
            numberToIndex.put(lastElement, index);
        }
        numbers.remove(lastIndex);
        numberToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int random = randomGen.nextInt(numbers.size());
        return numbers.get(random);
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom insertDeleteGetRandom = new InsertDeleteGetRandom();

        System.out.println(insertDeleteGetRandom.insert(1));
        System.out.println(insertDeleteGetRandom.remove(2));
        System.out.println(insertDeleteGetRandom.insert(2));
        System.out.println(insertDeleteGetRandom.getRandom());
        System.out.println(insertDeleteGetRandom.remove(1));
        System.out.println(insertDeleteGetRandom.insert(2));
        System.out.println(insertDeleteGetRandom.getRandom());


        insertDeleteGetRandom = new InsertDeleteGetRandom();
        System.out.println(insertDeleteGetRandom.remove(0));
        System.out.println(insertDeleteGetRandom.remove(0));
        System.out.println(insertDeleteGetRandom.insert(0));
        System.out.println(insertDeleteGetRandom.getRandom());
        System.out.println(insertDeleteGetRandom.remove(0));
        System.out.println(insertDeleteGetRandom.insert(0));
        System.out.println(insertDeleteGetRandom.getRandom());


    }
}
