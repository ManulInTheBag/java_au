package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final List<String> linkTitles;
    private final List<String> codeBlocks;
    private final String marker;
    private static final String MD_MARKER = "<!-----solution----->";

    public static Solution parseFile(List<String> oldFileContent, FileType fileType, String fileName) {
        String marker = "";
        if (fileType == FileType.MARKDOWN) {
            marker = MD_MARKER;
        }

        if (oldFileContent.size() == 0) {
            oldFileContent.add(marker);
        }

        int index = oldFileContent.indexOf(marker);
        List<String> linkTitles = new ArrayList();
        List<String> codeBlocks = new ArrayList();
        if (index == 0) {
            return new Solution(linkTitles, codeBlocks, marker);
        } else {
            linkTitles = new ArrayList(oldFileContent.subList(0, index));
            codeBlocks = new ArrayList(oldFileContent.subList(index + 1, oldFileContent.size()));
            return new Solution(linkTitles, codeBlocks, marker);
        }
    }

    public void add(ItemEntity file) {
        this.linkTitles.add(file.getFormattedLinkTitle());
        this.codeBlocks.add(file.getFormattedSubTitle());
        this.codeBlocks.add(file.getFormattedLink());
        this.codeBlocks.add(file.getFormattedCodeBlock());
    }

    public String toString() {
        String linkTitlesString = String.join("\n", this.linkTitles);
        String codeBlocksString = String.join("\n", this.codeBlocks);
        return linkTitlesString + "\n" + this.marker + "\n" + codeBlocksString;
    }

    private Solution(List<String> linkTitles, List<String> codeBlocks, String comment) {
        this.linkTitles = linkTitles;
        this.codeBlocks = codeBlocks;
        this.marker = comment;
    }
}
