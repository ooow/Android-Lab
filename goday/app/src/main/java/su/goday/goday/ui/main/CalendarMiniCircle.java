package su.goday.goday.ui.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import su.goday.goday.R;

/**
 * Created by Гога on 11.10.2016.
 */
public class CalendarMiniCircle extends View {
    private int partOf = 0;
    private int color = R.color.progressbar_foreground_color;

    public CalendarMiniCircle(Context context) {
        super(context);
    }

    public CalendarMiniCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CalendarMiniCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setDither(true);
        RectF rect = new RectF();
    /*    p.setColor(getResources().getColor(color));*/
        p.setColor(getResources().getColor(R.color.progressbar_foreground_color));

        float xr = 360 / 5;

        int x = 50, y = 50;
        rect.set(15, 15, 85, 85);
        canvas.drawArc(rect, 270, xr * partOf, true, p);

        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(2);
        canvas.drawCircle(x, y, 36, p);
    }

    public void setPartOf() {
        if (partOf < 5)
            partOf++;
        else partOf = 0;
        invalidate();
    }

    public void setColor(int color) {
        this.color = color;
        partOf = 5;
        invalidate();
    }

    public void setBackground(Drawable background) {

    }

    public int getPartOf() {
        return partOf;
    }
}
