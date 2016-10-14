package su.goday.goday.ui.support;

import android.view.View;

/**
 * Created by Гога on 13.10.2016.
 */
public class UISuppurt {
    public static void goneViews(View... views) {
        for (int i = 0; i < views.length; i++) {
            views[i].setVisibility(View.GONE);
        }
    }
}
