package io.cscode.algorithms.strings;

import io.cscode.base.UnitTestBase;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestIsStringHasUniqueCharacters extends UnitTestBase {

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    IsStringHasUniqueCharacters isStringHasUniqueCharacters;

    @Test
    public void testIsStringHasUniqueCharsUsingSorting() {
        boolean result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingSorting("hello");
        assertFalse(result);
        result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingSorting(null);
        assertFalse(result);
        result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingSorting("");
        assertTrue(result);
        result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingSorting("i");
        assertTrue(result);
        result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingSorting("square");
        assertTrue(result);
    }

    @Test
    public void testIsStringHasUniqueCharsUsingSoring() {
        boolean result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingSet("hello");
        assertFalse(result);
        result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingSet(null);
        assertFalse(result);
        result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingSet("");
        assertTrue(result);
        result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingSet("i");
        assertTrue(result);
        result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingSet("square");
        assertTrue(result);
    }

    @Test
    public void testIsStringHasUniqueCharsUsingTempArray() {
        boolean result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingTempArray("hello");
        assertFalse(result);
        result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingTempArray(null);
        assertFalse(result);
        result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingTempArray("");
        assertTrue(result);
        result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingTempArray("i");
        assertTrue(result);
        result = isStringHasUniqueCharacters.isStringHasUniqueCharsUsingTempArray("square");
        assertTrue(result);
    }
}
