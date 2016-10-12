package su.goday.goday.ui.profile;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import su.goday.goday.R;

public class UserProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        ImageView backPressButton = (ImageView) toolbar.findViewById(R.id.profile_click);
        backPressButton.setImageDrawable(getResources().getDrawable(R.mipmap.arrow_white));

        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_text);
        textView.setText("Настройки профиля");

        backPressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ImageView saveButton = (ImageView) toolbar.findViewById(R.id.save_click);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
