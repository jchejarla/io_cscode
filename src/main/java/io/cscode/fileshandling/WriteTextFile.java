package io.cscode.fileshandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriteTextFile {

    private static final String PATH_TO_FILE ="/Users/jc/Documents/cscode-files/sample.txt";

    public void writeToFileUsingFiles(String text, String fullyQualifiedPath) throws IOException {
        Files.writeString(Path.of(fullyQualifiedPath), text);
    }

    public void appendToFileUsingFiles(String text, String fullyQualifiedPath) throws IOException {
        Files.writeString(Path.of(fullyQualifiedPath), text, StandardOpenOption.APPEND);
    }

    public void writeToFileUsingFileWriter(String text, String fullyQualifiedPath) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fullyQualifiedPath)) {
            fileWriter.write(text);
        }
    }

    public void appendToFileUsingFileWriter(String text, String fullyQualifiedPath) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fullyQualifiedPath, true)) {
            fileWriter.write(text);
        }
    }

    public void writeToFileUsingBufferedWriter(String text, String fullyQualifiedPath) throws IOException {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fullyQualifiedPath))) {
            bufferedWriter.write(text);
        }
    }

    public void writeToFileUsingBufferedWriterIncreasedBuffer(String text, String fullyQualifiedPath) throws IOException {
        // using buffer character array of size 2048 - i.e. 4KB ( each char is of 2 bytes)
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fullyQualifiedPath), 2048)) {
            bufferedWriter.write(text);
        }
    }

}
