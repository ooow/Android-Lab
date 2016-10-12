package su.goday.goday.ui.wheel;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;

import su.goday.goday.R;
import su.goday.goday.ui.dialog.InfoDialogFragm;

/**
 * Created by Гога on 14.09.2016.
 */
public class WheelView extends View {
    private Paint p;
    private Rect rect;
    private float minSize;
    private float maxSize;
    private Section[] sections = new Section[8];
    private int[] colors;
    private int[] procents;
    private float centerX = 0;
    private float centerY = 0;
    private FragmentActivity myContext;

    public WheelView(Context context) {
        super(context);
        rect = new Rect();
        p = new Paint();
        p.setAntiAlias(true);
        p.setDither(true);
        for (int i = 0; i < sections.length; i++) {
            sections[i] = new Section();
        }
        procents = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        colors = new int[]{
                getResources().getColor(R.color.circle_first_color),
                getResources().getColor(R.color.circle_second_color),
                getResources().getColor(R.color.circle_third_color),
                getResources().getColor(R.color.circle_forth_color),
                getResources().getColor(R.color.circle_fifth_color),
                getResources().getColor(R.color.circle_sixth_color),
                getResources().getColor(R.color.circle_seventh_color),
                getResources().getColor(R.color.circle_eight_color),
                getResources().getColor(R.color.round_color_center_circle),
                getResources().getColor(R.color.round_color_center_circle_second),
                getResources().getColor(R.color.round_color_center_circle_text)};
    }

    // Изменение объема закраски секций
    public void changeUgle(int i, int sectionNumber) {
        sections[sectionNumber].setSize(minSize + (i * (maxSize - minSize) / 100));
        procents[sectionNumber] = i;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        p.setColor(colors[8]);
        p.setStrokeWidth(2);

        int startX = 0;
        int startY = getHeight() / 2 - getWidth() / 2;
        int endX = getWidth();
        int endY = getHeight() / 2 + getWidth() / 2;
        rect.set(startX, startY, endX, endY);
        maxSize = getRadius(canvas);
        int sectionSize = Math.round(maxSize / 14);
        minSize = (int) maxSize - (10 * sectionSize);

        centerX = rect.centerX();
        centerY = rect.centerY();

        canvas.drawCircle(centerX, centerY, maxSize, p);

        drawSections(canvas);
        drawCircles(canvas, maxSize, sectionSize);
        drawStar(canvas, startX, startY, endX, endY);
        drawTwoCircles(canvas, sectionSize);
        drawI(canvas);
        drawTextInMiniCircles(canvas);
    }

    // Отрисовка маленьких кругов с текстом внутри
    public void drawTextInMiniCircles(Canvas canvas) {
        float cx = getWidth() / 2f;
        float cy = getHeight() / 2f;
        float circleRadius = maxSize;
        int colorNum = 5;
        for (int i = 0; i < 360; i += 45) {
            float angle = (float) (i * Math.PI / 180f) - 75;

            float startX1 = (float) (cx + circleRadius * Math.sin(angle));
            float startY1 = (float) (cy - circleRadius * Math.cos(angle));

            if (colorNum == 7)
                colorNum = 0;
            else
                colorNum++;
            p.setColor(colors[colorNum]);
            canvas.drawCircle(startX1, startY1, 31, p);

            p.setColor(Color.WHITE);
            canvas.drawCircle(startX1, startY1, 30, p);

            p.setTextAlign(Paint.Align.CENTER);
            p.setTextSize(25);
            p.setColor(colors[colorNum]);
            canvas.drawText(String.valueOf(procents[colorNum]), startX1, startY1 + 10, p);
        }
    }


    // Отрисовка 2-х центральных кругов
    public void drawTwoCircles(Canvas canvas, int sectionSize) {
        p.setColor(colors[9]);
        canvas.drawCircle(centerX, centerY, maxSize - (10 * sectionSize), p);
        p.setColor(colors[8]);
        canvas.drawCircle(centerX, centerY, maxSize - (12 * sectionSize), p);
    }

    // Надпись I в цетре круга
    public void drawI(Canvas canvas) {
        p.setTextSize(60);
        p.setTextAlign(Paint.Align.CENTER);
        p.setColor(colors[10]);
        canvas.drawText("i", centerX, centerY + 20, p);
    }

    // Отрисовка заполнения секций
    public void drawSections(Canvas canvas) {
        int arcStart = 0;
        int arcGradus = 45;

        for (int i = 0; i < sections.length; i++) {
            float sizeSec = sections[i].getSize();
            sections[i].setAllCon(arcStart, arcGradus, centerX - sizeSec, centerY - sizeSec, centerX + sizeSec, centerY + sizeSec);
            arcStart += 45;
        }

        for (int i = 0; i < sections.length; i++) {
            p.setColor(colors[i]);
            canvas.drawArc(sections[i].getRect(), sections[i].getArcStart(), sections[i].getArcGradus(), true, p);
        }
    }

    // Отрисовка делений на круги
    public void drawCircles(Canvas canvas, float maxSize, int sectionSize) {
        p.setStyle(Paint.Style.STROKE);
        for (int i = 0; i < 10; i++) {
            p.setColor(Color.WHITE);
            canvas.drawCircle(centerX, centerY, maxSize - (i * sectionSize), p);
        }
        p.setStyle(Paint.Style.FILL);
    }

    // Отрисовка делений на секции (звезда)
    public void drawStar(Canvas canvas, int startX, int startY, int endX, int endY) {
        canvas.drawLine(startX, startY, endX, endY, p);
        canvas.drawLine(endX, startY, startX, endY, p);
        canvas.drawLine(centerX, startY, centerX, endY, p);
        canvas.drawLine(startX, centerY, endX, centerY, p);
    }

    public float getRadius(Canvas canvas) {
        float width = canvas.getWidth();
        float height = canvas.getHeight();
        float minSize = width > height ? height : width;
        return minSize / 2;
    }

    // Класс секции
    public class Section {
        private int arcStart;
        private int arcGradus;
        private RectF rect;
        private float size = 0;

        public void setAllCon(int arcStart, int arcGradus, float left, float top, float right, float button) {
            this.arcStart = arcStart;
            this.arcGradus = arcGradus;
            rect = new RectF(left, top, right, button);
        }

        public RectF getRect() {
            return rect;
        }

        public int getArcStart() {
            return arcStart;
        }

        public int getArcGradus() {
            return arcGradus;
        }

        public float getSize() {
            return size;
        }

        public void setSize(float size) {
            this.size = size;
        }
    }

    public void setContext(Activity activity) {
        myContext = (FragmentActivity) activity;
    }

    // Обработка нажатия на i
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                final float x = ev.getX();
                final float y = ev.getY();
                if (x >= centerX - 50 && y >= centerY - 50 && x <= centerX + 50 && y <= centerY + 50) {
                    new InfoDialogFragm().setText(myContext.getString(R.string.information_wheel_i)).
                            show(myContext.getSupportFragmentManager(), null);
                }
                break;
        }
        return true;
    }
}