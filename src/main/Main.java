import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        String txtFile = "src/test/java/testFile.txt";
        String oldFile = "src/test/java/testSourceFile.md";
        ArrayList<String> txtFileContent = Utils.readData(txtFile);
        ArrayList<String> oldFileContent = Utils.readData(oldFile);
        String[] oldFileName = oldFile.split("\\.");
        Solution oldSolutionFile = Solution.parseFile(oldFileContent, FileType.MARKDOWN, oldFileName[0]); // TODO if new one created make a header?
        ItemEntity entity = Utils.parseNewFileContent(txtFileContent, FileType.MARKDOWN);
        entity.formatFile();
        oldSolutionFile.add(entity);
        Utils.writeData(oldFile, oldSolutionFile.toString());
    }

}