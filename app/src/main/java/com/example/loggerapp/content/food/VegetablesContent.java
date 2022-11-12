package com.example.loggerapp.content.food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class VegetablesContent {

    /**
     * An array of log type items.
     */
    public static final List<VegetablesItem> ITEMS = new ArrayList<VegetablesItem>();

    static {
        // Add LogType items.
        ITEMS.add(new VegetablesItem("Artichoke"));
        ITEMS.add(new VegetablesItem("Asparagus"));
        ITEMS.add(new VegetablesItem("Eggplant"));
        ITEMS.add(new VegetablesItem("Avocado"));
        ITEMS.add(new VegetablesItem("Beetroot"));
        ITEMS.add(new VegetablesItem("Broccoli"));
        ITEMS.add(new VegetablesItem("Brussels Sprout"));
        ITEMS.add(new VegetablesItem("Cabbage"));
        ITEMS.add(new VegetablesItem("Carrot"));
        ITEMS.add(new VegetablesItem("Cauliflower"));
        ITEMS.add(new VegetablesItem("Celeriac"));
        ITEMS.add(new VegetablesItem("Celery"));
        ITEMS.add(new VegetablesItem("Corn"));
        ITEMS.add(new VegetablesItem("Cucumber"));
        ITEMS.add(new VegetablesItem("Garlic"));
        ITEMS.add(new VegetablesItem("Kale"));
        ITEMS.add(new VegetablesItem("Leek"));
        ITEMS.add(new VegetablesItem("Lettuce"));
        ITEMS.add(new VegetablesItem("Mushroom"));
        ITEMS.add(new VegetablesItem("Okra"));
        ITEMS.add(new VegetablesItem("Onion"));
        ITEMS.add(new VegetablesItem("Green onion"));
        ITEMS.add(new VegetablesItem("Parsnip"));
        ITEMS.add(new VegetablesItem("Pea"));
        ITEMS.add(new VegetablesItem("Bell pepper"));
        ITEMS.add(new VegetablesItem("Potato"));
        ITEMS.add(new VegetablesItem("Pumpkin"));
        ITEMS.add(new VegetablesItem("Radish"));
        ITEMS.add(new VegetablesItem("Spinach"));
        ITEMS.add(new VegetablesItem("Tomato"));
        ITEMS.add(new VegetablesItem("Sweet potato"));
        ITEMS.add(new VegetablesItem("Zucchini"));

        Collections.sort(ITEMS, (VegetablesItem, t1) -> VegetablesItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class VegetablesItem {
        public final String content;

        public VegetablesItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}