package io.cscode.algorithms.sorting;

import io.cscode.base.UnitTestBase;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class TestQuicksortHoarePartition extends UnitTestBase {

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    QuicksortHoarePartition quicksortHoarePartition;

    @Test
    public void testQuickSort() {
        int[] input = {3, 2, 1, 9, 8, 5, 6};
        quicksortHoarePartition.sortArray(input);
        assertTrue(Arrays.equals(new int[]{1,2,3,5,6,8,9}, input));
    }

    @Test
    public void testQuickSortWithDuplicateElements() {
        int[] input = {3,3,2,1,2,9,8,4,6,22,11,5};
        quicksortHoarePartition.sortArray(input);
        assertTrue(Arrays.equals(new int[]{1, 2, 2, 3, 3, 4, 5, 6, 8, 9, 11, 22}, input));
    }

    @Test
    public void testQuickSortWhenInputIsNull() {
        int[] input = null;
        quicksortHoarePartition.sortArray(input);
        assertTrue(Arrays.equals(null, input));
    }

    @Test
    public void testQuickSortWhenInputIsEmpty() {
        int[] input = {};
        quicksortHoarePartition.sortArray(input);
        assertTrue(0 == input.length);
    }
}
