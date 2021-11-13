package main.java;

public enum FileType {
    MARKDOWN("md");

    public final String type;

    private FileType(String type) {
        this.type = type;
    }
}
