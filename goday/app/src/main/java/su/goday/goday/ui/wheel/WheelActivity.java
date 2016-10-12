package su.goday.goday.ui.wheel;

import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import su.goday.goday.R;


public class WheelActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    private TextView skText0;
    private TextView skText1;
    private TextView skText2;
    private TextView skText3;
    private TextView skText4;
    private TextView skText5;
    private TextView skText6;
    private TextView skText7;
    private SeekBar sk0;
    private SeekBar sk1;
    private SeekBar sk2;
    private SeekBar sk3;
    private SeekBar sk4;
    private SeekBar sk5;
    private SeekBar sk6;
    private SeekBar sk7;
    private Button ready;
    private WheelView wheelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whell);

        viewSetting();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        ImageView backPressButton = (ImageView) toolbar.findViewById(R.id.profile_click);
        backPressButton.setImageDrawable(getResources().getDrawable(R.mipmap.arrow_white));
        backPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_text);
        textView.setText("Колесо жизни");

        ImageView saveButton = (ImageView) toolbar.findViewById(R.id.save_click);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.start_layout1);
        wheelView = new WheelView(linearLayout.getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.addView(wheelView, layoutParams);

        //передаю контект в view для оброботки нажатия i
        wheelView.setContext(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()) {
            case R.id.seek0:
                wheelView.changeUgle(i, 0);
                skText0.setText(i + "%");
                break;
            case R.id.seek1:
                wheelView.changeUgle(i, 1);
                skText1.setText(i + "%");
                break;
            case R.id.seek2:
                wheelView.changeUgle(i, 2);
                skText2.setText(i + "%");
                break;
            case R.id.seek3:
                wheelView.changeUgle(i, 3);
                skText3.setText(i + "%");
                break;
            case R.id.seek4:
                wheelView.changeUgle(i, 4);
                skText4.setText(i + "%");
                break;
            case R.id.seek5:
                wheelView.changeUgle(i, 5);
                skText5.setText(i + "%");
                break;
            case R.id.seek6:
                wheelView.changeUgle(i, 6);
                skText6.setText(i + "%");
                break;
            case R.id.seek7:
                wheelView.changeUgle(i, 7);
                skText7.setText(i + "%");
                break;
            default:
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void viewSetting() {
        skText0 = (TextView) findViewById(R.id.seek0Text);
        skText1 = (TextView) findViewById(R.id.seek1Text);
        skText2 = (TextView) findViewById(R.id.seek2Text);
        skText3 = (TextView) findViewById(R.id.seek3Text);
        skText4 = (TextView) findViewById(R.id.seek4Text);
        skText5 = (TextView) findViewById(R.id.seek5Text);
        skText6 = (TextView) findViewById(R.id.seek6Text);
        skText7 = (TextView) findViewById(R.id.seek7Text);

        sk0 = (SeekBar) findViewById(R.id.seek0);
        sk1 = (SeekBar) findViewById(R.id.seek1);
        sk2 = (SeekBar) findViewById(R.id.seek2);
        sk3 = (SeekBar) findViewById(R.id.seek3);
        sk4 = (SeekBar) findViewById(R.id.seek4);
        sk5 = (SeekBar) findViewById(R.id.seek5);
        sk6 = (SeekBar) findViewById(R.id.seek6);
        sk7 = (SeekBar) findViewById(R.id.seek7);

        sk0.getProgressDrawable().setColorFilter(getResources().getColor(R.color.circle_first_color), PorterDuff.Mode.SRC_IN);
        sk1.getProgressDrawable().setColorFilter(getResources().getColor(R.color.circle_second_color), PorterDuff.Mode.SRC_IN);
        sk2.getProgressDrawable().setColorFilter(getResources().getColor(R.color.circle_third_color), PorterDuff.Mode.SRC_IN);
        sk3.getProgressDrawable().setColorFilter(getResources().getColor(R.color.circle_forth_color), PorterDuff.Mode.SRC_IN);
        sk4.getProgressDrawable().setColorFilter(getResources().getColor(R.color.circle_fifth_color), PorterDuff.Mode.SRC_IN);
        sk5.getProgressDrawable().setColorFilter(getResources().getColor(R.color.circle_sixth_color), PorterDuff.Mode.SRC_IN);
        sk6.getProgressDrawable().setColorFilter(getResources().getColor(R.color.circle_seventh_color), PorterDuff.Mode.SRC_IN);
        sk7.getProgressDrawable().setColorFilter(getResources().getColor(R.color.circle_eight_color), PorterDuff.Mode.SRC_IN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            sk0.getThumb().setColorFilter(getResources().getColor(R.color.circle_first_color), PorterDuff.Mode.SRC_IN);
            sk1.getThumb().setColorFilter(getResources().getColor(R.color.circle_second_color), PorterDuff.Mode.SRC_IN);
            sk2.getThumb().setColorFilter(getResources().getColor(R.color.circle_third_color), PorterDuff.Mode.SRC_IN);
            sk3.getThumb().setColorFilter(getResources().getColor(R.color.circle_forth_color), PorterDuff.Mode.SRC_IN);
            sk4.getThumb().setColorFilter(getResources().getColor(R.color.circle_fifth_color), PorterDuff.Mode.SRC_IN);
            sk5.getThumb().setColorFilter(getResources().getColor(R.color.circle_sixth_color), PorterDuff.Mode.SRC_IN);
            sk6.getThumb().setColorFilter(getResources().getColor(R.color.circle_seventh_color), PorterDuff.Mode.SRC_IN);
            sk7.getThumb().setColorFilter(getResources().getColor(R.color.circle_eight_color), PorterDuff.Mode.SRC_IN);
        }

        ready = (Button) findViewById(R.id.ready_button);
        ready.setOnClickListener(this);
        sk0.setOnSeekBarChangeListener(this);
        sk1.setOnSeekBarChangeListener(this);
        sk2.setOnSeekBarChangeListener(this);
        sk3.setOnSeekBarChangeListener(this);
        sk4.setOnSeekBarChangeListener(this);
        sk5.setOnSeekBarChangeListener(this);
        sk6.setOnSeekBarChangeListener(this);
        sk7.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ready_button:
                finish();
                break;
            default:
                break;
        }
    }
}
