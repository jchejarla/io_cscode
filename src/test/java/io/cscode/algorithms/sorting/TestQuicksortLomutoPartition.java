package io.cscode.algorithms.sorting;

import io.cscode.base.UnitTestBase;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class TestQuicksortLomutoPartition extends UnitTestBase {

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    QuicksortLomutoPartition quicksortLomutoPartition;

    @Test
    public void testQuickSort() {
        int[] input = {3, 2, 1, 9, 8, 5, 6};
        quicksortLomutoPartition.sortArray(input);
        assertTrue(Arrays.equals(new int[]{1,2,3,5,6,8,9}, input));
    }

    @Test
    public void testQuickSortWhenInputIsNull() {
        int[] input = null;
        quicksortLomutoPartition.sortArray(input);
        assertTrue(Arrays.equals(null, input));
    }

    @Test
    public void testQuickSortWhenInputIsEmpty() {
        int[] input = {};
        quicksortLomutoPartition.sortArray(input);
        assertTrue(0 == input.length);
    }
}
