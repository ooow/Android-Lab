package su.goday.goday.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import su.goday.goday.API.GoDayRequestAPI;
import su.goday.goday.R;
import su.goday.goday.ui.main.MainActivity;

public class LoginActivity extends Activity {
    private Button regButton;
    private Button logButton;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logButton = (Button) findViewById(R.id.loginButton);
        regButton = (Button) findViewById(R.id.regButton);


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent);
            }
        });

        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logButton.setText("...");
                logButton.setEnabled(false);
                logIn();
            }
        });
    }

    public void onBackPressed() {
        finish();
    }

    public void logIn() {
        final String url = "http://admin.goday.su/index.php/api/rest/login";
        final EditText email = (EditText) findViewById(R.id.enterEmail);
        final EditText password = (EditText) findViewById(R.id.enterPassword);

        String validate = RegistActivity.validateEmail(email.getText().toString());

        if ("ok".equals(validate)) {
            final JSONObject body = new JSONObject();
            try {
                body.put("login", email.getText().toString());
                body.put("password", password.getText().toString());

                final Handler myHandler = new Handler();
                Thread myThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final String status = GoDayRequestAPI.SingIn(url, body);
                        myHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                switch (status) {
                                    case "User found...":
                                        Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                                        intent1.putExtra("type", "email");
                                        intent1.putExtra("login", email.getText().toString());
                                        intent1.putExtra("password", password.getText().toString());
                                        startActivity(intent1);
                                        logButton.setText("Войти");
                                        logButton.setEnabled(true);
                                        break;
                                    case "User not found...":
                                        showStatus("Неверный логин или пароль");
                                        logButton.setText("Войти");
                                        logButton.setEnabled(true);
                                        break;
                                    default:
                                        showStatus("Проблема с интернет соединением");
                                        logButton.setText("Войти");
                                        logButton.setEnabled(true);
                                        break;
                                }
                            }
                        });
                    }
                });
                myThread.setDaemon(true);
                myThread.start();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            showStatus(validate);
            logButton.setText("Войти");
            logButton.setEnabled(true);
        }
    }

    public void showStatus(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }
}
