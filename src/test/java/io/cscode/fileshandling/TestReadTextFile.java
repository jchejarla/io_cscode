package io.cscode.fileshandling;

import io.cscode.base.UnitTestBase;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;

public class TestReadTextFile extends UnitTestBase {

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    ReadTextFile readTextFile;

    @Test
    public void testReadFileUsingFilesClass() {
        String text = readTextFile.readFileUsingFilesClass();
        assertEquals("Hello, it's a great day today!",text);
    }

    @Test
    public void testReadFileUsingFileReader() {
        String text = readTextFile.readFileUsingFileReader();
        assertEquals("Hello, it's a great day today!",text);
    }

    @Test
    public void testReadFileUsingBufferedReader() {
        String text = readTextFile.readFileUsingBufferedReader();
        assertEquals("Hello, it's a great day today!",text);
    }
}
