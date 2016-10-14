package su.goday.goday.ui.profile;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import su.goday.goday.R;
import su.goday.goday.support.ImageManager;
import su.goday.goday.ui.support.UISuppurt;
import su.goday.goday.user.User;

public class UserProfileActivity extends Activity {
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        ImageView backPressButton = (ImageView) toolbar.findViewById(R.id.back_press);

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

        user = User.getInstance();
        EditText username = (EditText) findViewById(R.id.enter_username);
        TextView email = (TextView) findViewById(R.id.enter_email);
        TextView password = (TextView) findViewById(R.id.enter_password);

        username.setText(user.getUsername());
        email.setText(user.getEmail());
        password.setText(user.getPassword());

        ImageView profileImage = (ImageView) findViewById(R.id.profile_image);
        new ImageManager().fetchImage(user.getAvatar(), profileImage);

        UISuppurt.goneViews(toolbar.findViewById(R.id.profile_click));
    }
}
