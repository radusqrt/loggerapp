package com.example.loggerapp.content.symptom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for providing log type content for user interfaces.
 */
public class SymptomTypeContent {

    /**
     * An array of log type items.
     */
    public static final List<SymptomTypeItem> ITEMS = new ArrayList<SymptomTypeItem>();

    static {
        // Add LogType items.
        ITEMS.add(new SymptomTypeItem("Pain"));
        ITEMS.add(new SymptomTypeItem("Focus impairment"));
        ITEMS.add(new SymptomTypeItem("Imbalance, falling, dropping"));
        ITEMS.add(new SymptomTypeItem("Shortness of breath"));
        ITEMS.add(new SymptomTypeItem("Flatulence"));
        ITEMS.add(new SymptomTypeItem("Arrhythmia"));
        ITEMS.add(new SymptomTypeItem("Muscle spasm"));
        ITEMS.add(new SymptomTypeItem("Panic attack"));
        ITEMS.add(new SymptomTypeItem("Weakness"));
        ITEMS.add(new SymptomTypeItem("Tremors"));
        ITEMS.add(new SymptomTypeItem("Blood in stool"));
        ITEMS.add(new SymptomTypeItem("Presyncope"));
        ITEMS.add(new SymptomTypeItem("Tiredness"));
        ITEMS.add(new SymptomTypeItem("Numbness"));
        ITEMS.add(new SymptomTypeItem("Dryness"));

        Collections.sort(ITEMS, (symptomTypeItem, t1) -> symptomTypeItem.content.compareTo(t1.content));
    }

    /**
     * A log type item representing a piece of log type content.
     */
    public static class SymptomTypeItem {
        public final String content;

        public SymptomTypeItem(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}