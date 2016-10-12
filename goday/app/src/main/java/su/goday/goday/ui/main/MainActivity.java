package su.goday.goday.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import su.goday.goday.R;
import su.goday.goday.ui.wheel.WheelActivity;
import su.goday.goday.ui.profile.UserProfileActivity;
import su.goday.goday.ui.support.AboutActivity;
import su.goday.goday.ui.support.HelpActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private ImageView profileButton;
    private Intent intent;
    private boolean uved = false;
    private boolean synk = false;
    private boolean close = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        profileButton = (ImageView) toolbar.findViewById(R.id.profile_click);
        profileButton.setOnClickListener(this);

        ImageView saveButton = (ImageView) toolbar.findViewById(R.id.save_click);
        saveButton.setVisibility(View.GONE);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        makeSlide();
    }

    public void makeSlide() {
        for (int i = 0; i < 10; i++) {
            MainContextFragment tm = new MainContextFragment();
            viewPagerAdapter.addFragment(tm);
        }
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.life_wheel) {
            intent = new Intent(this, WheelActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Обработка нажатия в области навигационного меню
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Отклики по нав бару
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            //профиль
            intent = new Intent(this, UserProfileActivity.class);
            startActivity(intent);
            close = true;
        } else if (id == R.id.nav_share) {
            //пригласить друзей
            final Intent intent1 = new Intent(Intent.ACTION_SEND);
            intent1.setType("text/plain");
            String message = "Я нашел удобное приложения, помогающее достигать поставленных целей! " +
                    "Можешь попробовать, установив его по ссылке: https://play.google.com/store/apps/details?id=" + getPackageName();
            intent1.putExtra(Intent.EXTRA_TEXT, message);
            try {
                startActivity(Intent.createChooser(intent1, "Пригласить друга"));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getApplicationContext(), "Ошибочка", Toast.LENGTH_SHORT).show();
            }
            close = true;
        } else if (id == R.id.nav_uved) {
            //уведомления
            if (uved)
                item.setIcon(R.drawable.ic_uved_off);
            else
                item.setIcon(R.drawable.ic_uved_on);
            uved = !uved;
            close = false;
        } else if (id == R.id.nav_synk) {
            //синхронизация
            if (synk)
                item.setIcon(R.drawable.ic_synk_off);
            else
                item.setIcon(R.drawable.ic_synk_on);
            synk = !synk;
            close = false;
        } else if (id == R.id.nav_help) {
            //помощь
            intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
            close = true;
        } else if (id == R.id.nav_star) {
            //оставить отзыв
            final Uri uri = Uri.parse("market://details?id=" + getPackageName());
            final Intent rateAppIntent = new Intent(Intent.ACTION_VIEW, uri);

            if (getPackageManager().queryIntentActivities(rateAppIntent, 0).size() > 0) {
                startActivity(rateAppIntent);
            }
            close = true;
        } else if (id == R.id.nav_error) {
            //сообщить об оштбке
            close = true;
        } else if (id == R.id.nav_info) {
            intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            //о приложении
            close = true;
        } else if (id == R.id.nav_monday) {
            //понедельник
            close = true;
        } else if (id == R.id.nav_sanday) {
            //воскресенье
            close = true;
        }
        if (close) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }

    // Обработка нажатия на всем активити
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profile_click:
                intent = new Intent(this, UserProfileActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}