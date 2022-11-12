package com.example.loggerapp.content;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class ActivityContent {

    /**
     * An array of log type items.
     */
    public static final List<ActivityItem> ITEMS = new ArrayList<ActivityItem>();

    static {
        // Add Activity items.
        ITEMS.add(new ActivityItem("Football: 30m"));
        ITEMS.add(new ActivityItem("Football: 60m"));
        ITEMS.add(new ActivityItem("Football: 90m"));
        ITEMS.add(new ActivityItem("Football: 120m"));
        ITEMS.add(new ActivityItem("Gym: 30m"));
        ITEMS.add(new ActivityItem("Gym: 60m"));
        ITEMS.add(new ActivityItem("Gym: 90m"));
        ITEMS.add(new ActivityItem("Gym: 120m"));
        ITEMS.add(new ActivityItem("Running: 15m"));
        ITEMS.add(new ActivityItem("Running: 30m"));
        ITEMS.add(new ActivityItem("Running: 60m"));
        ITEMS.add(new ActivityItem("Running: 90m"));
        ITEMS.add(new ActivityItem("Running: 120m"));

        Collections.sort(ITEMS, (symptomTypeItem, t1) -> symptomTypeItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class ActivityItem {
        public final String content;

        public ActivityItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}