package com.tirkiyaicloud.businesscompliments;


import android.annotation.TargetApi;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.tirkiyaicloud.businesscompliments.fragments.FragmentInfo;
import com.tirkiyaicloud.businesscompliments.fragments.FragmentMain;
import com.tirkiyaicloud.businesscompliments.fragments.FragmentSetting;
import com.tirkiyaicloud.businesscompliments.fragments.FragmentStar;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentMain fragmentMain;
    FragmentStar fragmentStar;
    FragmentSetting fragmentSetting;
    FragmentInfo fragmentInfo;
    SharedPreferences sPref;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextSize textSize = TextSize.getInstance();
        textSize.setTextSize(20);

        toolbar.setBackgroundColor(getResources().getColor(R.color.color8));
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setTextColor(getResources().getColor(R.color.colorWhite));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        fragmentMain = new FragmentMain();
        fragmentStar = new FragmentStar();
        fragmentSetting = new FragmentSetting();
        fragmentInfo = new FragmentInfo();
        FragmentTransaction ftrans = getFragmentManager().beginTransaction();
        ftrans.replace(R.id.container, fragmentMain);
        ftrans.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        FragmentTransaction ftrans = getFragmentManager().beginTransaction();

        if (id == R.id.nav_main) {
            ftrans.replace(R.id.container, fragmentMain);
        } else if (id == R.id.nav_star) {
            ftrans.replace(R.id.container, fragmentStar);
        } else if (id == R.id.nav_setting) {
            ftrans.replace(R.id.container, fragmentSetting);
        } else if (id == R.id.nav_info) {
            ftrans.replace(R.id.container, fragmentInfo);
        } else if (id == R.id.nav_five) {
            final Uri uri = Uri.parse("market://details?id=" + "delovoy_kompliment");
            final Intent rateAppIntent = new Intent(Intent.ACTION_VIEW, uri);

            if (getPackageManager().queryIntentActivities(rateAppIntent, 0).size() > 0) {
                startActivity(rateAppIntent);
            } else {
            }
        }
        ftrans.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
