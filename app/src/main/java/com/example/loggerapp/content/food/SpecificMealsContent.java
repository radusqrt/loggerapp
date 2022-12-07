package com.example.loggerapp.content.food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class SpecificMealsContent {

    /**
     * An array of log type items.
     */
    public static final List<SpecificMealsItem> ITEMS = new ArrayList<SpecificMealsItem>();

    static {
        // Add LogType items.
        ITEMS.add(new SpecificMealsItem("Chickpea Coconut Curry"));

        Collections.sort(ITEMS, (SpecificMealsItem, t1) -> SpecificMealsItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class SpecificMealsItem {
        public final String content;

        public SpecificMealsItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}