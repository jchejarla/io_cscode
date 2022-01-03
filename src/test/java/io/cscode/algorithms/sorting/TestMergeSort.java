package io.cscode.algorithms.sorting;

import io.cscode.base.UnitTestBase;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class TestMergeSort extends UnitTestBase {

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    MergeSort mergeSort;

    @Test
    public void testMergeSort() {
        int[] input = {3, 2, 1, 9, 8, 5, 6};
        mergeSort.sort(input);
        assertTrue(Arrays.equals(new int[]{1,2,3,5,6,8,9}, input));
    }
    @Test
    public void testMergeSortWithDuplicateElements() {
        int[] input = {3,3,2,1,2,9,8,4,6,22,11,5};
        mergeSort.sort(input);
        assertTrue(Arrays.equals(new int[]{1, 2, 2, 3, 3, 4, 5, 6, 8, 9, 11, 22}, input));
    }

    @Test
    public void testMergeSortWhenInputIsNull() {
        int[] input = null;
        mergeSort.sort(input);
        assertTrue(Arrays.equals(null, input));
    }

    @Test
    public void testMergeSortWhenInputIsEmpty() {
        int[] input = {};
        mergeSort.sort(input);
        assertTrue(0 == input.length);
    }
}
