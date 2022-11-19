package com.example.loggerapp.content.food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class FruitsContent {

    /**
     * An array of log type items.
     */
    public static final List<FruitsItem> ITEMS = new ArrayList<FruitsItem>();

    static {
        // Add LogType items.
        ITEMS.add(new FruitsItem("Apple"));
        ITEMS.add(new FruitsItem("Banana"));
        ITEMS.add(new FruitsItem("Kiwi"));
        ITEMS.add(new FruitsItem("Pineapple"));
        ITEMS.add(new FruitsItem("Watermelon"));
        ITEMS.add(new FruitsItem("Blueberry"));
        ITEMS.add(new FruitsItem("Raspberry"));
        ITEMS.add(new FruitsItem("Pear"));


        Collections.sort(ITEMS, (FruitsItem, t1) -> FruitsItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class FruitsItem {
        public final String content;

        public FruitsItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}