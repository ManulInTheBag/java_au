package main.java;

import java.util.List;

public class MarkdownEntity implements ItemEntity {
    private final String link;
    private final String title;
    private final List<String> codeBlock;
    private String formattedLinkTitle;
    private String formattedSubTitle;
    private String formattedLink;
    private List<String> formattedCodeBlock;

    MarkdownEntity(String link, String title, List<String> codeBlock) {
        this.link = link;
        this.title = title;
        this.codeBlock = codeBlock;
    }

    public String getFormattedLinkTitle() {
        return this.formattedLinkTitle;
    }

    public String getFormattedSubTitle() {
        return this.formattedSubTitle;
    }

    public String getFormattedLink() {
        return this.formattedLink;
    }

    public String getFormattedCodeBlock() {
        return Utils.toString(this.formattedCodeBlock);
    }

    public void formatFile() {
        this.formattedLinkTitle = "+ [" + this.title + "](#" + this.title.toLowerCase().replaceAll(" ", "-") + ")";
        this.formattedSubTitle = "##" + this.title;
        this.formattedLink = this.link;
        this.formattedCodeBlock = this.codeBlock;
        this.formattedCodeBlock.add(0, "```java");
        this.formattedCodeBlock.add("```");
    }
}