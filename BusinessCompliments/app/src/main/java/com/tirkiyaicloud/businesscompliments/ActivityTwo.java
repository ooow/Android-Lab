package com.tirkiyaicloud.businesscompliments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    Toolbar toolbar;
    LinearLayout layouts[];
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        intent = getIntent();
        this.setTitle(intent.getStringExtra("title"));

        int type = intent.getIntExtra("type", 0);
        switch (type) {
            case 1:
                makeTypeOne();
                break;
            case 2:
                makeTypeTwo();
                break;
            default:
                break;
        }
    }

    private void makeTypeOne() {
        setContentView(R.layout.content_activity_two);
        LinearLayout lt = (LinearLayout) findViewById(R.id.lOne);
        toolbar = (Toolbar) lt.findViewById(R.id.my_toolbar);
        toolbarSetting();
        TextView tx = (TextView) toolbar.findViewById(R.id.toolbar_text);
        tx.setText(R.string.app_name);
        TextView textView = (TextView) findViewById(R.id.titleText);
        TextView bigText = (TextView) findViewById(R.id.bigText);
        textView.setText(intent.getStringExtra("title1"));
        int tom = intent.getIntExtra("tom", 0);
        ImageView imageView = (ImageView) findViewById(R.id.imageForTitle);
        TextSize textSize = TextSize.getInstance();
        bigText.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.getTextSize());
        switch (tom) {
            case 1:
                toolbar.setBackgroundColor(getResources().getColor(R.color.color7));
                imageView.setImageDrawable(getResources().getDrawable(R.mipmap.title1));
                bigText.setText(R.string.text_image1);
                break;
            case 2:
                toolbar.setBackgroundColor(getResources().getColor(R.color.color6));
                imageView.setImageDrawable(getResources().getDrawable(R.mipmap.title2));
                bigText.setText(R.string.text_image2);
                break;
            case 5:
                toolbar.setBackgroundColor(getResources().getColor(R.color.color5));
                imageView.setImageDrawable(getResources().getDrawable(R.mipmap.title3));
                bigText.setText(R.string.text_image3);
                break;
            default:
                break;
        }
    }

    private void makeTypeTwo() {
        setContentView(R.layout.activity_two_content_two);
        LinearLayout ml = (LinearLayout) findViewById(R.id.lTwo);
        toolbar = (Toolbar) ml.findViewById(R.id.my_toolbar);
        TextView tx = (TextView) toolbar.findViewById(R.id.toolbar_text);
        tx.setText(intent.getStringExtra("title"));
        toolbarSetting();
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.layoutActivityTwo);
        layouts = new LinearLayout[10];
        layouts[0] = (LinearLayout) findViewById(R.id.layout1);
        layouts[1] = (LinearLayout) findViewById(R.id.layout2);
        layouts[2] = (LinearLayout) findViewById(R.id.layout3);
        layouts[3] = (LinearLayout) findViewById(R.id.layout4);
        layouts[4] = (LinearLayout) findViewById(R.id.layout5);
        layouts[5] = (LinearLayout) findViewById(R.id.layout6);
        layouts[6] = (LinearLayout) findViewById(R.id.layout7);
        layouts[7] = (LinearLayout) findViewById(R.id.layout8);
        layouts[8] = (LinearLayout) findViewById(R.id.layout9);
        layouts[9] = (LinearLayout) findViewById(R.id.layout10);
        for (int i = 0; i < layouts.length; i++) {
            layouts[i].setOnClickListener(this);
        }
        textView1 = (TextView) layouts[0].findViewById(R.id.textV1);
        textView2 = (TextView) layouts[1].findViewById(R.id.textV2);
        textView3 = (TextView) layouts[2].findViewById(R.id.textV3);
        textView4 = (TextView) layouts[3].findViewById(R.id.textV4);
        textView5 = (TextView) layouts[4].findViewById(R.id.textV5);
        textView6 = (TextView) layouts[5].findViewById(R.id.textV6);
        textView7 = (TextView) layouts[6].findViewById(R.id.textV7);
        textView8 = (TextView) layouts[7].findViewById(R.id.textV8);
        textView9 = (TextView) layouts[8].findViewById(R.id.textV9);
        textView10 = (TextView) layouts[9].findViewById(R.id.textV10);
        ImageView imageView1 = (ImageView) layouts[0].findViewById(R.id.imageV1);
        ImageView imageView2 = (ImageView) layouts[1].findViewById(R.id.imageV2);
        ImageView imageView3 = (ImageView) layouts[2].findViewById(R.id.imageV3);
        ImageView imageView4 = (ImageView) layouts[3].findViewById(R.id.imageV4);
        ImageView imageView5 = (ImageView) layouts[4].findViewById(R.id.imageV5);
        ImageView imageView6 = (ImageView) layouts[5].findViewById(R.id.imageV6);
        ImageView imageView7 = (ImageView) layouts[6].findViewById(R.id.imageV7);
        ImageView imageView8 = (ImageView) layouts[7].findViewById(R.id.imageV8);
        ImageView imageView9 = (ImageView) layouts[8].findViewById(R.id.imageV9);
        ImageView imageView10 = (ImageView) layouts[9].findViewById(R.id.imageV10);
        View view1 = mainLayout.findViewById(R.id.view1);
        View view2 = mainLayout.findViewById(R.id.view2);
        View view3 = mainLayout.findViewById(R.id.view3);
        View view4 = mainLayout.findViewById(R.id.view4);
        view1.setVisibility(View.GONE);
        view2.setVisibility(View.GONE);
        view3.setVisibility(View.GONE);
        view4.setVisibility(View.GONE);
        layouts[6].setVisibility(View.GONE);
        layouts[7].setVisibility(View.GONE);
        layouts[8].setVisibility(View.GONE);
        layouts[9].setVisibility(View.GONE);
        int tom = intent.getIntExtra("tom", 0);
        switch (tom) {
            case 3:
                toolbar.setBackgroundColor(getResources().getColor(R.color.color1));
                textView1.setText(R.string.top8text1);
                textView2.setText(R.string.top8text2);
                textView3.setText(R.string.top8text3);
                textView4.setText(R.string.top8text4);
                textView5.setText(R.string.top8text5);
                textView6.setText(R.string.top8text6);
                textView7.setText(R.string.top8text7);
                textView8.setText(R.string.top8text8);
                imageView1.setImageDrawable(getResources().getDrawable(R.mipmap.top8number1));
                imageView2.setImageDrawable(getResources().getDrawable(R.mipmap.top8number2));
                imageView3.setImageDrawable(getResources().getDrawable(R.mipmap.top8number3));
                imageView4.setImageDrawable(getResources().getDrawable(R.mipmap.top8number4));
                imageView5.setImageDrawable(getResources().getDrawable(R.mipmap.top8number5));
                imageView6.setImageDrawable(getResources().getDrawable(R.mipmap.top8number6));
                imageView7.setImageDrawable(getResources().getDrawable(R.mipmap.top8number7));
                imageView8.setImageDrawable(getResources().getDrawable(R.mipmap.top8number8));
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.VISIBLE);
                layouts[6].setVisibility(View.VISIBLE);
                layouts[7].setVisibility(View.VISIBLE);
                break;
            case 4:
                toolbar.setBackgroundColor(getResources().getColor(R.color.color3));
                textView1.setText(R.string.fact8text1);
                textView2.setText(R.string.fact8text2);
                textView3.setText(R.string.fact8text3);
                textView4.setText(R.string.fact8text4);
                textView5.setText(R.string.fact8text5);
                textView6.setText(R.string.fact8text6);
                imageView1.setImageDrawable(getResources().getDrawable(R.mipmap.form1));
                imageView2.setImageDrawable(getResources().getDrawable(R.mipmap.form2));
                imageView3.setImageDrawable(getResources().getDrawable(R.mipmap.form3));
                imageView4.setImageDrawable(getResources().getDrawable(R.mipmap.form4));
                imageView5.setImageDrawable(getResources().getDrawable(R.mipmap.form5));
                imageView6.setImageDrawable(getResources().getDrawable(R.mipmap.form6));
                break;
            case 6:
                toolbar.setBackgroundColor(getResources().getColor(R.color.color4));
                textView1.setText(R.string.pr8text1);
                textView2.setText(R.string.pr8text2);
                textView3.setText(R.string.pr8text3);
                textView4.setText(R.string.pr8text4);
                textView5.setText(R.string.pr8text5);
                textView6.setText(R.string.pr8text6);
                textView7.setText(R.string.pr8text7);
                textView8.setText(R.string.pr8text8);
                textView9.setText(R.string.pr8text9);
                textView10.setText(R.string.pr8text10);
                imageView1.setImageDrawable(getResources().getDrawable(R.mipmap.prim1));
                imageView2.setImageDrawable(getResources().getDrawable(R.mipmap.prim2));
                imageView3.setImageDrawable(getResources().getDrawable(R.mipmap.prim3));
                imageView4.setImageDrawable(getResources().getDrawable(R.mipmap.prim4));
                imageView5.setImageDrawable(getResources().getDrawable(R.mipmap.prim5));
                imageView6.setImageDrawable(getResources().getDrawable(R.mipmap.prim6));
                imageView7.setImageDrawable(getResources().getDrawable(R.mipmap.prim7));
                imageView8.setImageDrawable(getResources().getDrawable(R.mipmap.prim8));
                imageView9.setImageDrawable(getResources().getDrawable(R.mipmap.prim9));
                imageView10.setImageDrawable(getResources().getDrawable(R.mipmap.prim10));
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.VISIBLE);
                view3.setVisibility(View.VISIBLE);
                view4.setVisibility(View.VISIBLE);
                layouts[6].setVisibility(View.VISIBLE);
                layouts[7].setVisibility(View.VISIBLE);
                layouts[8].setVisibility(View.VISIBLE);
                layouts[9].setVisibility(View.VISIBLE);
                break;
            case 7:
                toolbar.setBackgroundColor(getResources().getColor(R.color.color2));
                textView1.setText(R.string.up8text1);
                textView2.setText(R.string.up8text2);
                textView3.setText(R.string.up8text3);
                textView4.setText(R.string.up8text4);
                textView5.setText(R.string.up8text5);
                textView6.setText(R.string.up8text6);
                imageView1.setImageDrawable(getResources().getDrawable(R.mipmap.up0));
                imageView2.setImageDrawable(getResources().getDrawable(R.mipmap.up1));
                imageView3.setImageDrawable(getResources().getDrawable(R.mipmap.up2));
                imageView4.setImageDrawable(getResources().getDrawable(R.mipmap.up3));
                imageView5.setImageDrawable(getResources().getDrawable(R.mipmap.up4));
                imageView6.setImageDrawable(getResources().getDrawable(R.mipmap.up5));
                break;
            default:
                break;
        }
    }

    public void toolbarSetting() {
        TextView tx = (TextView) toolbar.findViewById(R.id.toolbar_text);
        tx.setTextColor(getResources().getColor(R.color.colorWhite));
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.go_back_white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, TextActivity.class);
        TextView tx = (TextView) toolbar.findViewById(R.id.toolbar_text);
        String st = (String) tx.getText();
        intent.putExtra("main_title", st);
        int type = 0;
        if ("ТОП-8 ошибок".equals(st))
            type = 1;
        else if ("ФОРМУЛЫ".equals(st))
            type = 2;
        else if ("УПРАЖНЕНИЯ".equals(st))
            type = 3;
        else if ("ПРИМЕРЫ".equals(st))
            type = 4;
        switch (view.getId()) {
            case R.id.layout1:
                intent.putExtra("title", textView1.getText());
                intent.putExtra("type", type);
                intent.putExtra("tom", 1);
                startActivity(intent);
                break;
            case R.id.layout2:
                intent.putExtra("title", textView2.getText());
                intent.putExtra("type", type);
                intent.putExtra("tom", 2);
                startActivity(intent);
                break;
            case R.id.layout3:
                intent.putExtra("title", textView3.getText());
                intent.putExtra("type", type);
                intent.putExtra("tom", 3);
                startActivity(intent);
                break;
            case R.id.layout4:
                intent.putExtra("title", textView4.getText());
                intent.putExtra("type", type);
                intent.putExtra("tom", 4);
                startActivity(intent);
                break;
            case R.id.layout5:
                intent.putExtra("title", textView5.getText());
                intent.putExtra("type", type);
                intent.putExtra("tom", 5);
                startActivity(intent);
                break;
            case R.id.layout6:
                intent.putExtra("title", textView6.getText());
                intent.putExtra("type", type);
                intent.putExtra("tom", 6);
                startActivity(intent);
                break;
            case R.id.layout7:
                intent.putExtra("title", textView7.getText());
                intent.putExtra("type", type);
                intent.putExtra("tom", 7);
                startActivity(intent);
                break;
            case R.id.layout8:
                intent.putExtra("title", textView8.getText());
                intent.putExtra("type", type);
                intent.putExtra("tom", 8);
                startActivity(intent);
                break;
            case R.id.layout9:
                intent.putExtra("title", textView9.getText());
                intent.putExtra("type", type);
                intent.putExtra("tom", 9);
                startActivity(intent);
                break;
            case R.id.layout10:
                intent.putExtra("title", textView10.getText());
                intent.putExtra("type", type);
                intent.putExtra("tom", 10);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
