package io.cscode.fileshandling;

import io.cscode.base.UnitTestBase;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestWriteTextFile extends UnitTestBase {

    private static final String PATH_TO_FILE = "/Users/jc/Documents/cscode-files/sample.txt";

    private static final String CONTENT =  "Hello, it's a great day today!";

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    WriteTextFile writeTextFile;

    @Test
    public void testWriteToFileUsingFiles () throws Exception {
        writeTextFile.writeToFileUsingFiles(CONTENT, PATH_TO_FILE);
        assertTrue(Files.exists(Path.of(PATH_TO_FILE)));
        assertEquals(CONTENT, Files.readAllLines(Path.of(PATH_TO_FILE)).get(0));
    }

    @Test
    public void testAppendToFileUsingFiles () throws Exception {
        writeTextFile.writeToFileUsingFiles(CONTENT, PATH_TO_FILE);
        writeTextFile.appendToFileUsingFiles(CONTENT, PATH_TO_FILE);
        assertTrue(Files.exists(Path.of(PATH_TO_FILE)));
        assertEquals(CONTENT+CONTENT, Files.readAllLines(Path.of(PATH_TO_FILE)).get(0));
    }

    @Test
    public void testWriteToFileUsingFileWriter() throws Exception {
        writeTextFile.writeToFileUsingFileWriter(CONTENT, PATH_TO_FILE);
        assertTrue(Files.exists(Path.of(PATH_TO_FILE)));
        assertEquals(CONTENT, Files.readAllLines(Path.of(PATH_TO_FILE)).get(0));
    }

    @Test
    public void testAppendToFileUsingFileWriter() throws Exception {
        writeTextFile.writeToFileUsingFileWriter(CONTENT, PATH_TO_FILE);
        writeTextFile.appendToFileUsingFileWriter(CONTENT, PATH_TO_FILE);
        assertTrue(Files.exists(Path.of(PATH_TO_FILE)));
        assertEquals(CONTENT+CONTENT, Files.readAllLines(Path.of(PATH_TO_FILE)).get(0));
    }

    @Test
    public void testWriteToFileUsingBufferedWriter() throws Exception {
        writeTextFile.writeToFileUsingBufferedWriter(CONTENT, PATH_TO_FILE);
        assertTrue(Files.exists(Path.of(PATH_TO_FILE)));
        assertEquals(CONTENT, Files.readAllLines(Path.of(PATH_TO_FILE)).get(0));
    }

    @Test
    public void testWriteToFileUsingBufferedWriterIncreasedBuffer() throws Exception {
        writeTextFile.writeToFileUsingBufferedWriterIncreasedBuffer(CONTENT, PATH_TO_FILE);
        assertTrue(Files.exists(Path.of(PATH_TO_FILE)));
        assertEquals(CONTENT, Files.readAllLines(Path.of(PATH_TO_FILE)).get(0));
    }
}
