package main.java;

import java.util.ArrayList;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws Exception {
        String txtFile = "src/test/sourceFile.txt";
        String oldFile = "src/test/converted.md";
        ArrayList<String> txtFileContent = Utils.readData(txtFile);
        ArrayList<String> oldFileContent = Utils.readData(oldFile);
        String[] oldFileName = oldFile.split("\\.");
        Solution oldSolutionFile = Solution.parseFile(oldFileContent, FileType.MARKDOWN, oldFileName[0]);
        ItemEntity entity = Utils.parseNewFileContent(txtFileContent, FileType.MARKDOWN);
        entity.formatFile();
        oldSolutionFile.add(entity);
        Utils.writeData(oldFile, oldSolutionFile.toString());
    }
}