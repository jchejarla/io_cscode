package io.cscode.algorithms.arrays;

import io.cscode.base.UnitTestBase;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class TestKthLargestElement extends UnitTestBase {

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    KthLargestElement kthLargestElement;

    @Test
    public void testFindKthLargestUsingSorting() {
        int[] input_1 = {3, 2, 1, 5, 6, 4};
        int k_1 = 2;
        int kthLargest_1 = kthLargestElement.findKthLargestUsingSorting(input_1, k_1);
        assertEquals(5 , kthLargest_1);

        int[] input_2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k_2 = 4;
        int kthLargest_2 = kthLargestElement.findKthLargestUsingSorting(input_2, k_2);
        assertEquals(4 , kthLargest_2);
    }

    @Test
    public void testFindKthLargestUsingMinHeap() {
        int[] input_1 = {3, 2, 1, 5, 6, 4};
        int k_1 = 2;
        int kthLargest_1 = kthLargestElement.findKthLargestUsingMinHeap(input_1, k_1);
        assertEquals(5 , kthLargest_1);

        int[] input_2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k_2 = 4;
        int kthLargest_2 = kthLargestElement.findKthLargestUsingMinHeap(input_2, k_2);
        assertEquals(4 , kthLargest_2);
    }

    @Test
    public void testFindKthLargestQuickSelect() {
        int[] input = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int kthLargest = kthLargestElement.kthLargestUsingQuickSelect(input, k);
        assertEquals(5 , kthLargest);

        input = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        kthLargest = kthLargestElement.kthLargestUsingQuickSelect(input, k);
        assertEquals(4 , kthLargest);

        input = new int[]{3, 2, 1, 9, 8, 5, 6};
        k = 2;
        kthLargest = kthLargestElement.kthLargestUsingQuickSelect(input, k);
        assertEquals(8 , kthLargest);
    }
}
