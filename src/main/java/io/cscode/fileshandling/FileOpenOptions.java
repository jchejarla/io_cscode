package io.cscode.fileshandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileOpenOptions {

    public String read(String fileFullyQualifiedPath) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(Path.of(fileFullyQualifiedPath), StandardOpenOption.READ));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    public void createNew(String fileFullyQualifiedPath, String text) throws IOException {
        Files.writeString(Path.of(fileFullyQualifiedPath),text, StandardOpenOption.CREATE_NEW);
    }

    public void create(String fileFullyQualifiedPath, String text) throws IOException {
        Files.writeString(Path.of(fileFullyQualifiedPath),text, StandardOpenOption.CREATE);
    }

    public void write(String fileFullyQualifiedPath, String text) throws IOException {
        Files.writeString(Path.of(fileFullyQualifiedPath),text, StandardOpenOption.WRITE);
    }

    public void append(String fileFullyQualifiedPath, String text) throws IOException {
        Files.writeString(Path.of(fileFullyQualifiedPath),text, StandardOpenOption.APPEND);
    }

    public void truncateExisting(String fileFullyQualifiedPath, String text) throws IOException {
        Files.writeString(Path.of(fileFullyQualifiedPath),text, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void sparse(String fileFullyQualifiedPath, String text) throws IOException {
        Files.writeString(Path.of(fileFullyQualifiedPath),text, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE, StandardOpenOption.SPARSE);
    }

    public void writeInSync(String fileFullyQualifiedPath, String text) throws IOException {
        Files.writeString(Path.of(fileFullyQualifiedPath), text, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.SYNC);
    }

    public void writeInDataSync(String fileFullyQualifiedPath, String text) throws IOException {
        Files.writeString(Path.of(fileFullyQualifiedPath), text, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.DSYNC);
    }

    public boolean checkDirWithNoFollowLinks(String dir)  {
        return Files.isDirectory(Path.of(dir), LinkOption.NOFOLLOW_LINKS);
    }
}
