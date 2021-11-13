import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static ArrayList<String> readData(String filePath) throws IOException {
        File file = new File(filePath);
        ArrayList<String> collectedData = new ArrayList<>();
        if (!file.exists()) {
            return collectedData;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                collectedData.add(line);
            }
        }

        return collectedData;
    }

    public static void writeData(String path, String changedSource) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(changedSource);
        }
    }

    public static ItemEntity parseNewFileContent(List<String> sourceFile, FileType type) throws Exception {
        String link = sourceFile.get(0);
        String title = sourceFile.get(1);
        List<String> codeBlock = sourceFile.subList(2, sourceFile.size());
        if (type == FileType.MARKDOWN) {
            return new MarkdownEntity(link, title, codeBlock);
        }
        throw new Exception("Unknown type");
    }

    public static String toString(List<String> array) {
        return String.join("\n", array);
    }
}