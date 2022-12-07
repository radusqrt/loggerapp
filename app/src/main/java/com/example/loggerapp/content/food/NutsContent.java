package com.example.loggerapp.content.food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class NutsContent {

    /**
     * An array of log type items.
     */
    public static final List<NutsItem> ITEMS = new ArrayList<NutsItem>();

    static {
        // Add LogType items.
        ITEMS.add(new NutsItem("Cashews"));
        ITEMS.add(new NutsItem("Pistachios"));
        ITEMS.add(new NutsItem("Almonds"));
        ITEMS.add(new NutsItem("Pecans"));
        ITEMS.add(new NutsItem("Walnuts"));
        ITEMS.add(new NutsItem("Peanuts"));
        ITEMS.add(new NutsItem("Hazelnuts"));
        ITEMS.add(new NutsItem("Chestnuts"));
        ITEMS.add(new NutsItem("Pine nuts"));

        Collections.sort(ITEMS, (NutsItem, t1) -> NutsItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class NutsItem {
        public final String content;

        public NutsItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}