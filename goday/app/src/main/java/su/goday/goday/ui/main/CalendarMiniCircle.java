package su.goday.goday.ui.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TableRow;

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
        //p.setColor(getResources().getColor(color));
        p.setColor(Color.GREEN);

        float xr = 360 / 5;

        int w = getWidth();
        int h = getHeight();

        int centerx = w / 2, centery = h / 2, radius = h / 2;
        if (h > w) radius = w / 2;


        int sx1 = w / 2 - h / 2;
        if (sx1 < 0) sx1 = 0;
        int sy1 = h / 2 - w / 2;
        if (sy1 < 0) sy1 = 0;
        int sx2 = w / 2 + h / 2;
        if (sx2 > w) sx2 = w;
        int sy2 = h / 2 + w / 2;
        if (sy2 > h) sy2 = h;

        rect.set(sx1, sy1, sx2, sy2);
        canvas.drawArc(rect, 270, xr * partOf, true, p);

        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.BLACK);
        p.setStrokeWidth(2);
        canvas.drawCircle(centerx, centery, radius, p);
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
