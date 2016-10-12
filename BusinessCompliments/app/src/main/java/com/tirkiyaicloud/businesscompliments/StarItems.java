package com.tirkiyaicloud.businesscompliments;

import android.util.Pair;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Гога on 12.07.2016.
 */
public class StarItems {
    ArrayList<Pair<String, TextView>> starItems = new ArrayList<>();

    private static StarItems ourInstance = new StarItems();

    public static StarItems getInstance() {
        return ourInstance;
    }

    private StarItems() {
    }

    public void setItem(String st, TextView tx) {
        if (!isStar(tx))
            starItems.add(new Pair<String, TextView>(st, tx));
    }

    public void deleteItem(TextView tx) {
        for (int i = 0; i < starItems.size(); i++) {
            if (starItems.get(i).second.getText().equals(tx.getText()))
                starItems.remove(i);
        }
    }

    public ArrayList<Pair<String, TextView>> getStarItems() {
        return starItems;
    }

    public boolean isStar(TextView tx) {
        for (int i = 0; i < starItems.size(); i++) {
            if (starItems.get(i).second.getText().equals(tx.getText()))
                return true;
        }
        return false;
    }
}
