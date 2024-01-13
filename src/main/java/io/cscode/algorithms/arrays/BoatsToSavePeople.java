package io.cscode.algorithms.arrays;

import java.util.Arrays;

public class BoatsToSavePeople {

    static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int result = 0;
        int l = 0;
        int r = people.length - 1;
        while (l <= r) {
            int remain = limit - people[r--];
            result += 1;
            if (remain >= people[l]) {
                l++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3, 4, 1, 2}, 4));
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }
}
