package io.cscode.algorithms.slidingwindow;

import java.util.HashMap;

public class FruitsIntoBasket {

    static int totalFruit(int[] fruits) {
        int left = 0;
        int right =0;
        int maxFruits = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        while(right < fruits.length) {
            count.merge(fruits[right], 1, Integer::sum);
            // when map size more than 2
            // that means we are going out of bounds as we only have two baskets
            while(count.size() >2) {
                int newVal = count.merge(fruits[left], -1, Integer::sum);
                if(newVal ==0) {
                    count.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right -left+1);
            right++;
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 1, 2, 3}));
        System.out.println(totalFruit(new int[]{1, 2, 1}));
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));

    }
}
