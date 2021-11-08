package io.cscode.fileshandling;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ProcessingLargeFiles {

    private static final String PATH_TO_FILE = "/Users/jc/Documents/cscode-files/sample_dataset.csv";


    public void loadFileIntoMemory(String fullyQualifiedPath) throws IOException {
        List<String> allLines = Files.readAllLines(Path.of(fullyQualifiedPath));
        allLines.forEach(System.out::println);
    }

    public void processFileUsingStreams(String fullyQualifiedPath) throws IOException {
        System.out.println("File size : "+ Files.size(Path.of(fullyQualifiedPath))/1024/1024 + "MB");
        Runtime runtime = Runtime.getRuntime();
        System.out.println("BEFORE ---- Total memory : "+ (runtime.maxMemory() / 1024/ 1024) + "MB , free memory : "+ (runtime.freeMemory()/ 1024/ 1024) + "MB");

        long start = System.currentTimeMillis();
        try (InputStream inputStream = new FileInputStream(fullyQualifiedPath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {
                Stream<String> lines = bufferedReader.lines();
                lines.forEach(System.out::println);
        }
        long end = System.currentTimeMillis();

        System.out.println("AFTER ---- Total memory : "+ (runtime.maxMemory() / 1024/ 1024) + "MB , free memory : "+ (runtime.freeMemory()/ 1024/ 1024) + "MB");
        System.out.println("Total processing time (ms): "+(end - start));
    }

    public void processFileUsingBufferedStreams(String fullyQualifiedPath) throws IOException {
        System.out.println("File size : "+ Files.size(Path.of(fullyQualifiedPath))/1024/1024 + "MB");
        Runtime runtime = Runtime.getRuntime();
        System.out.println("BEFORE ---- Total memory : "+ (runtime.maxMemory() / 1024/ 1024) + "MB , free memory : "+ (runtime.freeMemory()/ 1024/ 1024) + "MB");

        long start = System.currentTimeMillis();
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fullyQualifiedPath));
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {
                Stream<String> lines = bufferedReader.lines();
                lines.forEach(System.out::println);
        }
        long end = System.currentTimeMillis();

        System.out.println("AFTER ---- Total memory : "+ (runtime.maxMemory() / 1024/ 1024) + "MB , free memory : "+ (runtime.freeMemory()/ 1024/ 1024) + "MB");
        System.out.println("Total processing time (ms) : "+(end - start));
    }


    public void processFileUsingScanner(String fullyQualifiedPath) throws IOException {
        System.out.println("File size : "+ Files.size(Path.of(fullyQualifiedPath))/1024/1024 + "MB");
        Runtime runtime = Runtime.getRuntime();
        System.out.println("BEFORE ---- Total memory : "+ (runtime.maxMemory() / 1024/ 1024) + "MB , free memory : "+ (runtime.freeMemory()/ 1024/ 1024) + "MB");

        long start = System.currentTimeMillis();
        try(Scanner scanner = new Scanner(new FileInputStream(fullyQualifiedPath))) {
            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("AFTER ---- Total memory : "+ (runtime.maxMemory() / 1024/ 1024) + "MB , free memory : "+ (runtime.freeMemory()/ 1024/ 1024) + "MB");
        System.out.println("Total processing time (ms) : "+(end - start));

    }

    public void processFileUsingFileStreamFileChannel(String fullyQualifiedPath) throws IOException {
        System.out.println("File size : "+ Files.size(Path.of(fullyQualifiedPath))/1024/1024 + "MB");
        Runtime runtime = Runtime.getRuntime();
        System.out.println("BEFORE ---- Total memory : "+ (runtime.maxMemory() / 1024/ 1024) + "MB , free memory : "+ (runtime.freeMemory()/ 1024/ 1024) + "MB");

        long start = System.currentTimeMillis();
        try (FileInputStream fileInputStream = new FileInputStream(fullyQualifiedPath)) {
            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(8 * 1024);
            while(fileChannel.read(byteBuffer) != -1) {
                String str = new String(byteBuffer.array());
                System.out.println(str);
                byteBuffer.clear();
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("AFTER ---- Total memory : "+ (runtime.maxMemory() / 1024/ 1024) + "MB , free memory : "+ (runtime.freeMemory()/ 1024/ 1024) + "MB");
        System.out.println("Total processing time (ms) : "+(end - start));
    }

    public void processFileUsingRandomAccessFileChannel(String fullyQualifiedPath) throws IOException {
        System.out.println("File size : "+ Files.size(Path.of(fullyQualifiedPath))/1024/1024 + "MB");
        Runtime runtime = Runtime.getRuntime();
        System.out.println("BEFORE ---- Total memory : "+ (runtime.maxMemory() / 1024/ 1024) + "MB , free memory : "+ (runtime.freeMemory()/ 1024/ 1024) + "MB");

        long start = System.currentTimeMillis();
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fullyQualifiedPath, "r")) {
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(8 * 1024);
            while(fileChannel.read(byteBuffer) != -1) {
                String str = new String(byteBuffer.array());
                System.out.println(str);
                byteBuffer.clear();
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("AFTER ---- Total memory : "+ (runtime.maxMemory() / 1024/ 1024) + "MB , free memory : "+ (runtime.freeMemory()/ 1024/ 1024) + "MB");
        System.out.println("Total processing time (ms) : "+(end - start));
    }


    public static void main(String[] args) {
        try {
            //new ProcessingLargeFiles().processFileUsingStreams(PATH_TO_FILE);
            //new ProcessingLargeFiles().processFileUsingBufferedStreams(PATH_TO_FILE);
            //new ProcessingLargeFiles().processFileUsingScanner(PATH_TO_FILE);
            //new ProcessingLargeFiles().processFileUsingFileChannel(PATH_TO_FILE);
            //new ProcessingLargeFiles().processFileUsingFileStreamFileChannel(PATH_TO_FILE);
            //new ProcessingLargeFiles().processFileUsingRandomAccessFileChannel(PATH_TO_FILE);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
