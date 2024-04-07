package io.cscode.algorithms.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.stream.Stream;

public class CarFleet {

    static int carFleetUsingSorting(int target, int[] position, int[] speed) {
        int[][] positionAndSpeedPair = new int[position.length][2];
        for(int i=0; i<position.length; i++) { // position and speed are same length arrays
            positionAndSpeedPair[i][0] = position[i];
            positionAndSpeedPair[i][1] = speed[i];
        }
        // sort based on position, reverse order since we want to sort based on highest position to the lowest position
        Arrays.sort(positionAndSpeedPair, Comparator.comparing(o -> o[0], Comparator.reverseOrder()));
        Stack<Double> stack = new Stack<>();
        Stream.of(positionAndSpeedPair).forEach(pair-> {
            // compute the time it takes to reach destination
            // distance to destination from current position / speed
            double timeToReach = (double)(target - pair[0]) / pair[1];
            if(stack.isEmpty() || timeToReach > stack.peek()) {
                stack.push(timeToReach);
            }
        });
        return stack.size();
    }


    static int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[target]; // position[i] < target, so length n is good enough
        for(int i=0; i<position.length; i++) {
            time[position[i]] = (double)(target - position[i])/ speed[i];
        }
        int result = 0;
        double prev = 0.0;
        for(int i=time.length-1; i>=0; i--) {
            double current = time[i];
            if(current > prev) {
                prev = current;
                result++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(carFleetUsingSorting(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
        System.out.println(carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));

    }
}
