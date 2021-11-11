package io.cscode.algorithms.arrays;

import io.cscode.base.UnitTestBase;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestTwoSum extends UnitTestBase {

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    TwoSum twoSum;

    @Test
    public void testTwoSum() {
        int[] input = {3, 2, 4};
        int target =6;
        int[] output = twoSum.twoSum(input, target);
        assertTrue(Arrays.equals(new int[]{1,2}, output));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTwoSumInvalidInput() {
        twoSum.twoSum(null, 1);
    }
}
