package io.cscode.algorithms.arrays;

import io.cscode.base.UnitTestBase;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestThreeSum extends UnitTestBase {

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    ThreeSum threeSum;

    @Test
    public void test3Sum_Using_2Sum() {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum.threeSum_Using_2Sum(input);
        List<List<Integer>> expected = Arrays.asList(List.of(-1, 0, 1), List.of(-1,-1,2));
        assertEquals(expected, result);
    }

    @Test
    public void test3Sum_Using_Sorting_And_2Sum() {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum.threeSum_Using_Sorting_And_2Sum(input);
        List<List<Integer>> expected = Arrays.asList(List.of(-1,-1,2), List.of(-1, 0, 1));
        assertEquals(expected, result);
    }
}
