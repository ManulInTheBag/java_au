package main.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public Utils() {
    }

    public static ArrayList<String> readData(String filePath) throws IOException {
        File file = new File(filePath);
        ArrayList<String> collectedData = new ArrayList();
        if (!file.exists()) {
            return collectedData;
        } else {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            try {
                while((line = br.readLine()) != null) {
                    collectedData.add(line);
                }
            } catch (Throwable var7) {
                try {
                    br.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }

                throw var7;
            }

            br.close();
            return collectedData;
        }
    }

    public static void writeData(String path, String changedSource) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));

        try {
            writer.write(changedSource);
        } catch (Throwable var6) {
            try {
                writer.close();
            } catch (Throwable var5) {
                var6.addSuppressed(var5);
            }

            throw var6;
        }

        writer.close();
    }

    public static ItemEntity parseNewFileContent(List<String> sourceFile, FileType type) throws Exception {
        String link = (String)sourceFile.get(0);
        String title = (String)sourceFile.get(1);
        List<String> codeBlock = sourceFile.subList(2, sourceFile.size());
        if (type == FileType.MARKDOWN) {
            return new MarkdownEntity(link, title, codeBlock);
        } else {
            throw new Exception("Unknown type");
        }
    }

    public static String toString(List<String> array) {
        return String.join("\n", array);
    }
}