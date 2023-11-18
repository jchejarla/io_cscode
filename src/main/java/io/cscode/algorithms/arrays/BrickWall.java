package io.cscode.algorithms.arrays;

import java.util.HashMap;
import java.util.List;

public class BrickWall {

    static int bruteForceApproach(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // first get the width
        int width = 0;
        List<Integer> first_row = wall.get(0);
        for(int brick : first_row) {
            width += brick;
        }

        if(width == 1) {
            return wall.size();
        }

        for(List<Integer> row: wall) {
            int brickUnits=1;
            int currentWidth =row.get(0);
            int i=1;
            while(brickUnits < width){

                if(currentWidth > brickUnits) {
                    map.merge(brickUnits, 1, Integer::sum);
                } else {
                    map.merge(brickUnits, 0, Integer::sum);
                    currentWidth += row.get(i);
                    i++;
                }

                brickUnits++;
            }

        }

        // get the minimum cut point, min value from HashMap
        int min = Integer.MAX_VALUE;
        for(Integer val: map.values()) {
            if(val < min) {
                min = val;
            }
        }
        return min;
    }

    static int countGapsAndFindMaxGaps(List<List<Integer>> wall) {
        final HashMap<Integer, Integer> gaps = new HashMap<>();

        for(List<Integer> row: wall) {
            int currentBrickPosition = 0;
            // we will be ignoring the last brick, because we cannot include edge positions per problem statement
            for(int i=0; i<row.size()-1; i++) {
                currentBrickPosition += row.get(i);
                gaps.merge(currentBrickPosition, 1, Integer::sum);
            }
        }

        int maxGaps = 0;
        for(Integer gap : gaps.values()) {
            if(gap>maxGaps) {
                maxGaps = gap;
            }
        }
        return wall.size() - maxGaps;
    }

    public static void main(String[] args) {
        List<List<Integer>> wall_1 = List.of(
                                            List.of(1,2,2,1),
                                            List.of(3,1,2),
                                            List.of(1,3,2),
                                            List.of(2,4),
                                            List.of(3,1,2),
                                            List.of(1,3,1,1)
                                        );
        List<List<Integer>> wall_2 =  List.of(
                                                List.of(1),
                                                List.of(1),
                                                List.of(1)
                                        );
        System.out.println("############### Brute force approach######################");
        System.out.println(bruteForceApproach(wall_1));
        System.out.println(bruteForceApproach(wall_2));

        System.out.println("############### Count gaps, find max gaps (efficient approach) ######################");
        System.out.println(countGapsAndFindMaxGaps(wall_1));
        System.out.println(countGapsAndFindMaxGaps(wall_2));

    }

}
