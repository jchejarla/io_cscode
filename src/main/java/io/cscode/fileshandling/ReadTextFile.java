package io.cscode.fileshandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ReadTextFile {

    private static final String PATH_TO_FILE = "/Users/jc/Documents/cscode-files/sample.txt";

    public String readFileUsingFilesClass() {
        try {
            StringBuilder sb = new StringBuilder();
            Stream<String> stream = Files.lines(Path.of(PATH_TO_FILE));
            stream.forEach(line -> sb.append(line));
            return sb.toString();
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

    public String readFileUsingFileReader() {
        try(FileReader fileReader = new FileReader(PATH_TO_FILE)) {
            StringBuilder sb = new StringBuilder();
            char[] text = new char[1024];
            int count;
            while((count = fileReader.read(text)) != -1) {
                sb.append(text, 0, count);
            }
            return sb.toString();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String readFileUsingBufferedReader() {
        try(BufferedReader br = Files.newBufferedReader(Path.of(PATH_TO_FILE))){
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
