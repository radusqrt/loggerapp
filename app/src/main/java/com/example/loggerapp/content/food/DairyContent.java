package com.example.loggerapp.content.food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class DairyContent {

    /**
     * An array of log type items.
     */
    public static final List<DairyItem> ITEMS = new ArrayList<DairyItem>();

    static {
        // Add LogType items.
        ITEMS.add(new DairyItem("Ayran"));
        ITEMS.add(new DairyItem("Yogurt"));
        ITEMS.add(new DairyItem("Butter"));
        ITEMS.add(new DairyItem("Cheese"));
        ITEMS.add(new DairyItem("Cream"));
        ITEMS.add(new DairyItem("Milk"));
        ITEMS.add(new DairyItem("Gelato"));
        ITEMS.add(new DairyItem("Kefir"));
        ITEMS.add(new DairyItem("Eggs"));

        Collections.sort(ITEMS, (DairyItem, t1) -> DairyItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class DairyItem {
        public final String content;

        public DairyItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}