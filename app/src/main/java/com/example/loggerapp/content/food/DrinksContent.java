package com.example.loggerapp.content.food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class DrinksContent {

    /**
     * An array of log type items.
     */
    public static final List<DrinksItem> ITEMS = new ArrayList<DrinksItem>();
    public static final Map<String, String> DRINK_TYPE = new HashMap<>();

    static {
        // Add LogType items.
        ITEMS.add(new DrinksItem("Coffee"));
        ITEMS.add(new DrinksItem("Cappuccino"));
        ITEMS.add(new DrinksItem("Espresso"));
        ITEMS.add(new DrinksItem("Green Tea"));
        ITEMS.add(new DrinksItem("Black Tea"));
        ITEMS.add(new DrinksItem("Other tea"));
        ITEMS.add(new DrinksItem("Coca-cola"));
        ITEMS.add(new DrinksItem("Beer"));
        ITEMS.add(new DrinksItem("Gin"));
        ITEMS.add(new DrinksItem("Vodka"));
        ITEMS.add(new DrinksItem("Other alcoholic drink"));
        ITEMS.add(new DrinksItem("Other caffeinated drink"));
        ITEMS.add(new DrinksItem("Other soda"));
        ITEMS.add(new DrinksItem("Other"));

        Collections.sort(ITEMS, (DrinksItem, t1) -> DrinksItem.content.compareTo(t1.content));

        DRINK_TYPE.put("Coffee", "Coffee");
        DRINK_TYPE.put("Cappuccino", "Coffee");
        DRINK_TYPE.put("Espresso", "Coffee");
        DRINK_TYPE.put("Other caffeinated drink", "Coffee");
        DRINK_TYPE.put("Green Tea", "Tea");
        DRINK_TYPE.put("Black Tea", "Tea");
        DRINK_TYPE.put("Other Tea", "Tea");
        DRINK_TYPE.put("Coca cola", "Soda");
        DRINK_TYPE.put("Other soda", "Soda");
        DRINK_TYPE.put("Beer", "Alcohol");
        DRINK_TYPE.put("Gin", "Alcohol");
        DRINK_TYPE.put("Vodka", "Alcohol");
        DRINK_TYPE.put("Other alcoholic drink", "Alcohol");
        DRINK_TYPE.put("Other", "Other");
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class DrinksItem {
        public final String content;

        public DrinksItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}