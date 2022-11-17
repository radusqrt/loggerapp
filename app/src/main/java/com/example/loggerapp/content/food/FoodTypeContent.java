package com.example.loggerapp.content.food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class FoodTypeContent {

    /**
     * An array of log type items.
     */
    public static final List<FoodTypeItem> ITEMS = new ArrayList<FoodTypeItem>();

    static {
        // Add LogType items.
        ITEMS.add(new FoodTypeItem("Meat"));
        ITEMS.add(new FoodTypeItem("Dairy"));
        ITEMS.add(new FoodTypeItem("Fruits"));
        ITEMS.add(new FoodTypeItem("Vegetables"));
        ITEMS.add(new FoodTypeItem("Grains"));
        ITEMS.add(new FoodTypeItem("Specific meals"));
        ITEMS.add(new FoodTypeItem("Drinks"));

        Collections.sort(ITEMS, (FoodTypeItem, t1) -> FoodTypeItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class FoodTypeItem {
        public final String content;

        public FoodTypeItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}