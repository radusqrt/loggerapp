package com.example.loggerapp.content;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class SymptomBodyLocationContent {

    /**
     * An array of log type items.
     */
    public static final List<SymptomBodyLocationItem> ITEMS = new ArrayList<SymptomBodyLocationItem>();

    static {
        // Add LogType items.
        ITEMS.add(new SymptomBodyLocationItem("Pain"));

        Collections.sort(ITEMS, (SymptomBodyLocationItem, t1) -> SymptomBodyLocationItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class SymptomBodyLocationItem {
        public final String content;

        public SymptomBodyLocationItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}