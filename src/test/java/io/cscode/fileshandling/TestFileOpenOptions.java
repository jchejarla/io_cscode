package io.cscode.fileshandling;

import io.cscode.base.UnitTestBase;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestFileOpenOptions extends UnitTestBase {

    private static final String CONTENT =  "Hello, it's a great day today!";

    private static final String PATH_TO_FILE = "/Users/jc/Documents/cscode-files/sample.txt";

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    FileOpenOptions fileOpenOptions;

    @Test
    public void testRead() throws Exception {
        // for unit tests running lets make sure file has only the expected text.
        // just in case if the original text has been appended by other methods.
        Files.deleteIfExists(Path.of(PATH_TO_FILE));
        Files.createFile(Path.of(PATH_TO_FILE));

        fileOpenOptions.write(PATH_TO_FILE, CONTENT);

        String text = fileOpenOptions.read(PATH_TO_FILE);
        System.out.println(text);
        assertEquals(CONTENT, text);
    }

    @Test (expected = FileAlreadyExistsException.class)
    public void testCreateNew() throws Exception {
        fileOpenOptions.createNew(PATH_TO_FILE, CONTENT);
    }

    @Test
    public void testCreate() throws Exception {
        fileOpenOptions.create(PATH_TO_FILE, CONTENT);
        assertTrue(Files.exists(Path.of(PATH_TO_FILE)));
        assertEquals(CONTENT, Files.readString(Path.of(PATH_TO_FILE)));
    }

    @Test
    public void testWrite() throws Exception {
        fileOpenOptions.write(PATH_TO_FILE, CONTENT);
        assertTrue(Files.exists(Path.of(PATH_TO_FILE)));
    }

    @Test
    public void textAppend() throws Exception {
        fileOpenOptions.write(PATH_TO_FILE, CONTENT);
        fileOpenOptions.append(PATH_TO_FILE, CONTENT);
        assertEquals(CONTENT+CONTENT, Files.readString(Path.of(PATH_TO_FILE)));
    }

    @Test
    public void testTruncateExisting() throws Exception {
        fileOpenOptions.write(PATH_TO_FILE, CONTENT);
        fileOpenOptions.truncateExisting(PATH_TO_FILE, CONTENT);
        assertEquals(CONTENT, Files.readString(Path.of(PATH_TO_FILE)));
    }

    @Test
    public void testSparse() throws Exception {
        Files.deleteIfExists(Path.of(PATH_TO_FILE));
        fileOpenOptions.sparse(PATH_TO_FILE, CONTENT);
        assertTrue(Files.exists(Path.of(PATH_TO_FILE)));
        Files.deleteIfExists(Path.of(PATH_TO_FILE));
    }

    @Test
    public void testWriteInSync() throws Exception {
        fileOpenOptions.writeInSync(PATH_TO_FILE, CONTENT);
        assertTrue(Files.exists(Path.of(PATH_TO_FILE)));
    }

    @Test
    public void testWriteInDataSync() throws Exception {
        fileOpenOptions.writeInDataSync(PATH_TO_FILE, CONTENT);
        assertTrue(Files.exists(Path.of(PATH_TO_FILE)));
    }

    @Test
    public void testCheckDirWithNoFollowLinks() throws Exception {
        boolean result = fileOpenOptions.checkDirWithNoFollowLinks("/Users/jc/Documents/cscode-files");
        assertTrue(result);
    }
}
