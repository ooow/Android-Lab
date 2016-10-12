package com.tirkiyaicloud.businesscompliments;

/**
 * Created by Гога on 12.07.2016.
 */
public class TextSize {
    private int TextSize;
    private static TextSize ourInstance = new TextSize();

    public static TextSize getInstance() {
        return ourInstance;
    }

    private TextSize() {
    }

    public int getTextSize() {
        return TextSize;
    }

    public void setTextSize(int textSize) {
        TextSize = textSize;
    }
}
