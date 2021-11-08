package io.cscode.fileshandling;

import io.cscode.base.UnitTestBase;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class TestReadTextFile extends UnitTestBase {

    private static final String PATH_TO_FILE = "/Users/jc/Documents/cscode-files/sample.txt";

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    ReadTextFile readTextFile;

    @Test
    public void testReadFileUsingFilesClass() {
        String text = readTextFile.readFileUsingFilesClass(PATH_TO_FILE);
        assertEquals("Hello, it's a great day today!",text);
    }

    @Test
    public void testReadFileUsingFileReader() {
        String text = readTextFile.readFileUsingFileReader(PATH_TO_FILE);
        assertEquals("Hello, it's a great day today!",text);
    }

    @Test
    public void testReadFileUsingBufferedReader() {
        String text = readTextFile.readFileUsingBufferedReader(PATH_TO_FILE);
        assertEquals("Hello, it's a great day today!",text);
    }
}
