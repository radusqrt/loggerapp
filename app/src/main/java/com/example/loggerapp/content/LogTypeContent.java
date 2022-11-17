package com.example.loggerapp.content;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class LogTypeContent {

    /**
     * An array of log type items.
     */
    public static final List<LogTypeItem> ITEMS = new ArrayList<LogTypeItem>();

    static {
        // Add LogType items.
        ITEMS.add(new LogTypeItem("Symptom"));
        ITEMS.add(new LogTypeItem("Food"));
        ITEMS.add(new LogTypeItem("Supplements or drugs"));
        ITEMS.add(new LogTypeItem("Activity"));
        ITEMS.add(new LogTypeItem("Grade"));

        Collections.sort(ITEMS, (symptomTypeItem, t1) -> symptomTypeItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class LogTypeItem {
        public final String content;

        public LogTypeItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}