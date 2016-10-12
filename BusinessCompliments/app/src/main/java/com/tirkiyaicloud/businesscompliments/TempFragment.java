package com.tirkiyaicloud.businesscompliments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TempFragment extends Fragment {
    private TextView textView;
    private String mainTitle;
    private int in;
    private int all;
    private boolean starred = false;
    private ImageButton share;
    private SharedPreferences sPref;


    public TempFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_temp, container, false);


        Toolbar toolbar = (Toolbar) view.findViewById(R.id.my_toolbar1);
        toolbar.setBackgroundColor(getResources().getColor(R.color.color4));
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.go_back_white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_text);
        toolbarTitle.setText("ПРИМЕРЫ");
        RelativeLayout layout = (RelativeLayout) toolbar.findViewById(R.id.layout_tool);
        ImageButton ib = (ImageButton) layout.findViewById(R.id.image_button_tool);
        ib.setBackgroundColor(toolbar.getDrawingCacheBackgroundColor());

        TextView title = (TextView) view.findViewById(R.id.big_text_title2);
        title.setText(mainTitle);

        TextView tx = (TextView) view.findViewById(R.id.fragment_text);
        tx.setText(textView.getText());
        TextSize textSize = TextSize.getInstance();
        tx.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.getTextSize());
        TextView counted = (TextView) view.findViewById(R.id.counted);
        String numer = "" + in + "/" + all;
        counted.setText(numer);
        ImageButton fab1 = (ImageButton) view.findViewById(R.id.fab);
        if (starred) {
            fab1.setImageDrawable(getResources().getDrawable(R.mipmap.on_star));
        } else {
            fab1.setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
        }

        ImageButton fab = (ImageButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       ImageButton fab1 = (ImageButton) view.findViewById(R.id.fab);
                                       StarItems starItems = StarItems.getInstance();
                                       if (!starItems.isStar(textView)) {
                                           Snackbar.make(view, "Добавлено в избранные", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                                           fab1.setImageDrawable(getResources().getDrawable(R.mipmap.on_star));
                                           starItems.setItem(mainTitle, textView);
                                           starred = !starred;
                                       } else {
                                           Snackbar.make(view, "Удаленно из избранных", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                                           fab1.setImageDrawable(getResources().getDrawable(R.mipmap.in_star));
                                           starItems.deleteItem(textView);
                                           starred = !starred;
                                       }
                                   }
                               }
        );

        share = (ImageButton) view.findViewById(R.id.image_button_tool);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                String message = "Я нашел хороший пример в приложении \"Деловой Комплимент\": \n" + String.valueOf(textView.getText());
                String textToSend = message;
                intent1.putExtra(Intent.EXTRA_TEXT, textToSend);
                try {
                    startActivity(Intent.createChooser(intent1, "Поделиться примером"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity().getApplicationContext(), "Ошибочка", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public int getIn() {

        return in;
    }

    public String getMainTitle() {
        return mainTitle;
    }
}
