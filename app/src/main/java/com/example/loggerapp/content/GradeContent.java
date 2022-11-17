package com.example.loggerapp.content;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class GradeContent {

    /**
     * An array of log type items.
     */
    public static final List<GradeItem> ITEMS = new ArrayList<GradeItem>();

    static {
        // Add LogType items.
        ITEMS.add(new GradeItem("1"));
        ITEMS.add(new GradeItem("2"));
        ITEMS.add(new GradeItem("3"));
        ITEMS.add(new GradeItem("4"));
        ITEMS.add(new GradeItem("5"));
        ITEMS.add(new GradeItem("6"));
        ITEMS.add(new GradeItem("7"));
        ITEMS.add(new GradeItem("8"));
        ITEMS.add(new GradeItem("9"));
        ITEMS.add(new GradeItem("10"));

        Collections.sort(ITEMS, (GradeItem, t1) -> GradeItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class GradeItem {
        public final String content;

        public GradeItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}