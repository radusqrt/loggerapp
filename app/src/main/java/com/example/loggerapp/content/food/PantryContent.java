package com.example.loggerapp.content.food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class PantryContent {

    /**
     * An array of log type items.
     */
    public static final List<PantryItem> ITEMS = new ArrayList<PantryItem>();

    static {
        // Add LogType items.
        ITEMS.add(new PantryItem("Dark Chocolate"));
        ITEMS.add(new PantryItem("Honey"));
        ITEMS.add(new PantryItem("Peanut"));
        ITEMS.add(new PantryItem("Peanut butter"));
        ITEMS.add(new PantryItem("Chestnut"));
        ITEMS.add(new PantryItem("Walnut"));
        ITEMS.add(new PantryItem("Cashew"));
        ITEMS.add(new PantryItem("Cashew butter"));

        Collections.sort(ITEMS, (PantryItem, t1) -> PantryItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class PantryItem {
        public final String content;

        public PantryItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}