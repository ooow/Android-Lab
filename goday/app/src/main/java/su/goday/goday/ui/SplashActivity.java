package su.goday.goday.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.facebook.login.widget.LoginButton;

import su.goday.goday.R;
import su.goday.goday.ui.login.LoginActivity;
import su.goday.goday.ui.main.MainActivity;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, 2 * 1000);
    }
}
