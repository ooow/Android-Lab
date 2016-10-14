package su.goday.goday.ui.support;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import su.goday.goday.R;

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        ImageView backPressButton = (ImageView) toolbar.findViewById(R.id.back_press);

        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_text);
        textView.setText("О приложении");

        backPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        UISuppurt.goneViews(toolbar.findViewById(R.id.save_click), toolbar.findViewById(R.id.profile_click));
    }
}
