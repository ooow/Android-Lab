package su.goday.goday.user;

import android.widget.ImageView;

/**
 * Created by Гога on 12.10.2016.
 */
public class User {
    private String username;
    private String email;
    private String password;
    private String avatar;

    private static User ourInstance = new User();


    public static User getInstance() {
        return ourInstance;

    }

    private User() {
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
