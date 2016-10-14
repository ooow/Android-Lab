package su.goday.goday.ui.login;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.AccountPicker;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiModel;
import com.vk.sdk.api.model.VKList;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

import su.goday.goday.API.GoDayRequestAPI;
import su.goday.goday.R;
import su.goday.goday.ui.main.MainActivity;
import su.goday.goday.user.User;

public class RegistActivity extends Activity {
    private Button loginButton;
    private Button regButton;
    private ImageButton vkButton;
    private ImageButton googleButton;
    private ImageButton fbLogginButton;
    private EditText name;
    private EditText email;
    private EditText password;
    private CallbackManager callbackManager;
    private boolean regStatus;
    private User user;


    private final static String G_PLUS_SCOPE = "oauth2:https://www.googleapis.com/auth/plus.me";
    private final static String USERINFO_SCOPE = "https://www.googleapis.com/auth/userinfo.profile";
    private final static String EMAIL_SCOPE = "https://www.googleapis.com/auth/userinfo.email";
    private final static String SCOPES = G_PLUS_SCOPE + " " + USERINFO_SCOPE + " " + EMAIL_SCOPE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Facebook Авторизация     ----------------------------------------------------------------
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        AccessToken accessToken = loginResult.getAccessToken();
                        Profile profile = Profile.getCurrentProfile();
                        if (profile != null) {
                            final JSONObject body = new JSONObject();
                            try {
                                body.put("name", profile.getName());
                                body.put("identifier_fb", profile.getId());
                                body.put("device_type", "android");
                                body.put("token", "");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            registNewUser(body);

                            Intent intent1 = new Intent(RegistActivity.this, MainActivity.class);
                            user = User.getInstance();
                            user.setUsername(profile.getFirstName() + " " + profile.getLastName());
                            user.setEmail(profile.getId());
                            /*intent1.putExtra("type", "vk");
                            intent1.putExtra("first_name", profile.getFirstName());
                            intent1.putExtra("last_name", profile.getLastName());
                            intent1.putExtra("id", profile.getId());*/
                            startActivity(intent1);
                        }
                    }

                    @Override
                    public void onCancel() {
                        showStatus("Произошла ошибка, попробуйте снова");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        showStatus("Проблема с интернет соединением");
                    }
                });
        setContentView(R.layout.activity_regist);

        fbLogginButton = (ImageButton) findViewById(R.id.loginButton1);
        fbLogginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logInWithReadPermissions(RegistActivity.this, Arrays.asList("public_profile", "email"));
            }
        });

        // Facebook Авторизация     ----------------------------------------------------------------

        // Email Авторизация     -------------------------------------------------------------------
        regButton = (Button) findViewById(R.id.regButton);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = (EditText) findViewById(R.id.enterName);
                email = (EditText) findViewById(R.id.enterEmail);
                password = (EditText) findViewById(R.id.enterPassword);

                String validate = validateFields(name.getText().toString(), email.getText().toString(), password.getText().toString());

                if ("ok".equals(validate)) {
                    final JSONObject body = new JSONObject();
                    try {
                        body.put("name", name.getText().toString());
                        body.put("login", email.getText().toString());
                        body.put("password", password.getText().toString());
                        body.put("device_type", "android");
                        body.put("token", "");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    registNewUser(body);
                } else showStatus(validate);
            }
        });
        // Email Авторизация     -------------------------------------------------------------------

        // Vkontakte Авторизация     ---------------------------------------------------------------
        vkButton = (ImageButton) findViewById(R.id.loginVkButton);
        vkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] scope = new String[]{VKScope.OFFLINE, VKScope.PHOTOS, VKScope.EMAIL};
                VKSdk.login(RegistActivity.this, scope);
            }
        });
        // Vkontakte Авторизация     ---------------------------------------------------------------

        // Google+ Авторизация     ---------------------------------------------------------------
        googleButton = (ImageButton) findViewById(R.id.loginGPlusButton);
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AccountPicker.newChooseAccountIntent(null, null, new String[]{"com.google"},
                        false, null, null, null, null);
                startActivityForResult(intent, 123);

            }
        });
        // Google+ Авторизация     ---------------------------------------------------------------

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void registNewUser(final JSONObject body) {
        final String url = "http://admin.goday.su/index.php/api/rest/user";
        final Handler myHandler = new Handler();
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final String status = GoDayRequestAPI.RegistrationNewUser(url, body);
                myHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        switch (status) {
                            case "New user was registered by login and password...":
                                Intent intent1 = new Intent(RegistActivity.this, MainActivity.class);
                                user = User.getInstance();
                                user.setUsername(name.getText().toString());
                                user.setEmail(email.getText().toString());
                                user.setPassword(password.getText().toString());
                                startActivity(intent1);
                                showStatus("Регистрация прошла успешна");
                                break;
                            case "User with this email alrady registered...":
                                showStatus("Пользователь с таким email уже зарегистрирован");
                                break;
                            case "User found by VK...":
                                break;
                            case "User found by FB...":
                                break;
                            case "User found by GOOGLE...":
                                regStatus = true;
                                break;
                            case "New user was registered by VK...":
                                break;
                            case "New user was registered by FB...":
                                break;
                            case "New user was registered by GOOGLE...":
                                regStatus = true;
                                break;
                            case "Server Offline":
                                showStatus("Проблема с интернет соединением");
                                regStatus = false;
                                break;
                            default:
                                showStatus("Произошла ошибка, попробуйте снова");
                                regStatus = false;
                                break;
                        }
                    }
                });
            }
        });
        myThread.setDaemon(true);
        myThread.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                VKRequest request = VKApi.users().get(VKParameters.from(VKApiConst.FIELDS, "photo_200", "first_name", "id"));
                request.executeWithListener(new VKRequest.VKRequestListener() {
                    @Override
                    public void onComplete(VKResponse response) {
                        super.onComplete(response);
                        VKList list = (VKList) response.parsedModel;
                        try {
                            if (list.size() > 0) {
                                VKApiModel vm = list.get(0);
                                JSONObject js = vm.fields;
                                String first_name = js.getString("first_name");
                                String last_name = js.getString("last_name");
                                String id = js.getString("id");
                                String photo_200 = js.getString("photo_200");

                                final JSONObject body = new JSONObject();
                                try {
                                    body.put("name", first_name + " " + last_name);
                                    body.put("identifier_vk", id);
                                    body.put("device_type", "android");
                                    body.put("token", "");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                registNewUser(body);

                                Intent intent1 = new Intent(RegistActivity.this, MainActivity.class);
                                user = User.getInstance();
                                user.setUsername(first_name + " " + last_name);
                                user.setEmail(id);
                                user.setAvatar(photo_200);

                                /*intent1.putExtra("type", "vk");
                                intent1.putExtra("first_name", first_name);
                                intent1.putExtra("last_name", last_name);
                                intent1.putExtra("id", id);
                                intent1.putExtra("photo_50", photo_50);*/
                                startActivity(intent1);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            @Override
            public void onError(VKError error) {
                showStatus("Произошла ошибка, попробуйте снова");
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
        if (requestCode == 123 && resultCode == RESULT_OK) {
            final String accountName = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
            AsyncTask<Void, Void, String> getToken = new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... params) {
                    try {
                        return GoogleAuthUtil.getToken(RegistActivity.this, accountName, SCOPES);
                    } catch (UserRecoverableAuthException userAuthEx) {
                        startActivityForResult(userAuthEx.getIntent(), 123);
                    } catch (IOException e) {
                        System.out.println("-===============================================EPTA112112121");
                        e.printStackTrace();
                        return "error";
                    } catch (GoogleAuthException fatalAuthEx) {
                        showStatus("Произошла ошибка, попробуйте снова");
                        System.out.println("---------------------------------------------------------WOOOOOPPPSS22222");
                        System.out.println("Fatal Authorization Exception" + fatalAuthEx.getLocalizedMessage());
                        System.out.println("---------------------------------------------------------WOOOOOPPPSS22222");
                        return "error";
                    }
                    return "error";
                }

                @Override
                protected void onPostExecute(String token) {
                    if ("error".equals(token))
                        showStatus("Проблема с интернет соединением");
                    else {
                        final JSONObject body = new JSONObject();
                        try {
                            body.put("name", "google+");
                            body.put("identifier_google", token);
                            body.put("device_type", "android");
                            body.put("token", "");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        registNewUser(body);

                        if (regStatus) {
                            Intent intent1 = new Intent(RegistActivity.this, MainActivity.class);
                            user = User.getInstance();
                            user.setUsername("Google +");
                            user.setEmail(token);
                            /*intent1.putExtra("type", "vk");
                            intent1.putExtra("first_name", "Google");
                            intent1.putExtra("last_name", "+");
                            intent1.putExtra("id", token);*/
                            startActivity(intent1);
                        }
                    }
                }

            };
            getToken.execute(null, null, null);
        }
    }

    public void showStatus(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
    }

    public String validateFields(String name, String email, String password) {
        if (name.length() < 1)
            return "Слишком короткое имя";
        if (password.length() < 6)
            return "Пароль слишком короткий";
        return validateEmail(email);
    }

    public static String validateEmail(String email) {
        if (email.length() < 5)
            return "Введите корректный email";
        else if (!email.contains("@") || !email.contains("."))
            return "Введите корректный email";
        else if (email.charAt(0) == '@' || email.charAt(0) == '.' ||
                email.charAt(email.length() - 1) == '@' || email.charAt(email.length() - 1) == '.')
            return "Введите корректный email";
        else if (email.indexOf("@") > email.lastIndexOf("."))
            return "Введите корректный email";
        else if (email.indexOf("@") != email.lastIndexOf("@"))
            return "Введите корректный email";
        else if (email.indexOf("@") + 1 == email.indexOf("."))
            return "Введите корректный email";
        else return "ok";
    }
}
