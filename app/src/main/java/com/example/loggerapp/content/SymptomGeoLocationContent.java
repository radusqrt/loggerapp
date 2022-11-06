package com.example.loggerapp.content;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class SymptomGeoLocationContent {

    /**
     * An array of log type items.
     */
    public static final List<SymptomGeoLocationItem> ITEMS = new ArrayList<SymptomGeoLocationItem>();

    static {
        // Add LogType items.
        ITEMS.add(new SymptomGeoLocationItem("Home"));
        ITEMS.add(new SymptomGeoLocationItem("Work"));
        ITEMS.add(new SymptomGeoLocationItem("Walk"));
        ITEMS.add(new SymptomGeoLocationItem("Commute"));
        ITEMS.add(new SymptomGeoLocationItem("Sport"));

        Collections.sort(ITEMS, (SymptomGeoLocationItem, t1) -> SymptomGeoLocationItem.content.compareTo(t1.content));
        ITEMS.add(0, new SymptomGeoLocationItem("N/A"));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class SymptomGeoLocationItem {
        public final String content;

        public SymptomGeoLocationItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}