import java.util.List;
import java.util.ArrayList;

public class Solution {

    public static Solution parseFile(List<String> oldFileContent, FileType fileType, String fileName) {
        String comment = "";
        if (fileType == FileType.MARKDOWN){
            comment = MD_COMMENT;
        }
        if (oldFileContent.size() == 0){
            oldFileContent.add(comment);
        }
        int index = oldFileContent.indexOf(comment);
        List<String> linkTitles = new ArrayList<>();
        List<String> codeBlocks = new ArrayList<>();
        if (index == 0){
            return new Solution(linkTitles, codeBlocks, comment);
        }
        linkTitles = new ArrayList<>(oldFileContent.subList(0, index));
        codeBlocks = new ArrayList<>(oldFileContent.subList(index + 1, oldFileContent.size()));
        return new Solution(linkTitles, codeBlocks, comment);
    }

    public void add(ItemEntity file) {
        this.linkTitles.add(file.getFormattedLinkTitle());
        this.codeBlocks.add(file.getFormattedSubTitle());
        this.codeBlocks.add(file.getFormattedLink());
        this.codeBlocks.add(file.getFormattedCodeBlock());
    }

    public String toString(){
        String linkTitlesString = String.join("\n", this.linkTitles);
        String codeBlocksString = String.join("\n", this.codeBlocks);
        return linkTitlesString + "\n" + this.comment + "\n" + codeBlocksString;
    }

    private Solution(List<String> linkTitles, List<String> codeBlocks, String comment){
        this.linkTitles = linkTitles;
        this.codeBlocks = codeBlocks;
        this.comment = comment;
    }

    private final List<String> linkTitles;
    private final List<String> codeBlocks;
    private final String comment;

    private static final String MD_COMMENT = "<!-----solution----->";
}