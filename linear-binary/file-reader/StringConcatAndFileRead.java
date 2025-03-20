import java.io.*;
import java.nio.charset.StandardCharsets;

public class StringConcatAndFileRead {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";
        String filePath = "largefile.txt";

        StringBuilder stringBuilder = new StringBuilder();
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;

        StringBuffer stringBuffer = new StringBuffer();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;

        System.out.println("Time taken by StringBuilder: " + stringBuilderTime + " nanoseconds");
        System.out.println("Time taken by StringBuffer: " + stringBufferTime + " nanoseconds");

        int wordCount = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            long fileStartTime = System.nanoTime();
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            long fileEndTime = System.nanoTime();
            System.out.println("Total words in file: " + wordCount);
            System.out.println("Time taken to read file: " + (fileEndTime - fileStartTime) + " nanoseconds");
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found at path " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
