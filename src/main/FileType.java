package main;

import java.util.Objects;

public enum FileType {
    MARKDOWN("md");

    public final String type;
    FileType(String type) {
        this.type = type;
    }
}