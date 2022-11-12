package com.example.loggerapp.content.food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class GrainsContent {

    /**
     * An array of log type items.
     */
    public static final List<GrainsItem> ITEMS = new ArrayList<GrainsItem>();

    static {
        // Add LogType items.
        ITEMS.add(new GrainsItem("Bulgur"));
        ITEMS.add(new GrainsItem("Corn"));
        ITEMS.add(new GrainsItem("Oats"));
        ITEMS.add(new GrainsItem("Quinoa"));
        ITEMS.add(new GrainsItem("Rice"));
        ITEMS.add(new GrainsItem("Spelt"));
        ITEMS.add(new GrainsItem("Wheat"));
        ITEMS.add(new GrainsItem("Wild rice"));

        Collections.sort(ITEMS, (GrainsItem, t1) -> GrainsItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class GrainsItem {
        public final String content;

        public GrainsItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}