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
        ITEMS.add(new SymptomBodyLocationItem("Head"));
        ITEMS.add(new SymptomBodyLocationItem("Eyes"));
        ITEMS.add(new SymptomBodyLocationItem("Neck"));
        ITEMS.add(new SymptomBodyLocationItem("Chest"));
        ITEMS.add(new SymptomBodyLocationItem("Arm-Left"));
        ITEMS.add(new SymptomBodyLocationItem("Arm-Right"));
        ITEMS.add(new SymptomBodyLocationItem("Intestine"));
        ITEMS.add(new SymptomBodyLocationItem("Leg-Left"));
        ITEMS.add(new SymptomBodyLocationItem("Leg-Right"));

        Collections.sort(ITEMS, (SymptomBodyLocationItem, t1) -> SymptomBodyLocationItem.content.compareTo(t1.content));
        ITEMS.add(0, new SymptomBodyLocationItem("N/A"));
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