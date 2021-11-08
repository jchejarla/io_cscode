package io.cscode.fileshandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ReadTextFile {

    public String readFileUsingFilesClass(String fullyQualifiedPath) {
        try {
            StringBuilder sb = new StringBuilder();
            Stream<String> stream = Files.lines(Path.of(fullyQualifiedPath));
            stream.forEach(line -> sb.append(line));
            return sb.toString();
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

    public String readFileUsingFileReader(String fullyQualifiedPath) {
        try(FileReader fileReader = new FileReader(fullyQualifiedPath)) {
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

    public String readFileUsingBufferedReader(String fullyQualifiedPath) {
        try(BufferedReader br = Files.newBufferedReader(Path.of(fullyQualifiedPath))){
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
