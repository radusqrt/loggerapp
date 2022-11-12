package com.example.loggerapp.content.food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class MeatContent {

    /**
     * An array of log type items.
     */
    public static final List<MeatItem> ITEMS = new ArrayList<MeatItem>();

    static {
        // Add LogType items.
        ITEMS.add(new MeatItem("Chicken"));
        ITEMS.add(new MeatItem("Beef"));
        ITEMS.add(new MeatItem("Turkey"));
        ITEMS.add(new MeatItem("Lamb"));
        ITEMS.add(new MeatItem("Goat"));
        ITEMS.add(new MeatItem("Pork"));
        ITEMS.add(new MeatItem("Duck"));
        ITEMS.add(new MeatItem("Veal"));
        ITEMS.add(new MeatItem("Wild boar"));

        Collections.sort(ITEMS, (MeatItem, t1) -> MeatItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class MeatItem {
        public final String content;

        public MeatItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}