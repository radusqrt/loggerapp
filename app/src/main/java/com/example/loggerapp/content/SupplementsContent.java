package com.example.loggerapp.content;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class SupplementsContent {

    /**
     * An array of log type items.
     */
    public static final List<SupplementsItem> ITEMS = new ArrayList<SupplementsItem>();

    static {
        // Add Supplements items.
        ITEMS.add(new SupplementsItem("Athletic Greens"));
        ITEMS.add(new SupplementsItem("Magnesiocard"));

        Collections.sort(ITEMS, (symptomTypeItem, t1) -> symptomTypeItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class SupplementsItem {
        public final String content;

        public SupplementsItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}