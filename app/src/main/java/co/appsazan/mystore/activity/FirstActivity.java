package co.appsazan.mystore.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import co.appsazan.mystore.Config;
import co.appsazan.mystore.R;
import co.appsazan.mystore.createView.AddViews;
import co.appsazan.mystore.createView.SelectViews;
import co.appsazan.mystore.fragment.AllMyAppFragment;
import co.appsazan.mystore.fragment.BestAppFragment;
import co.appsazan.mystore.fragment.CategoryFragment;
import co.appsazan.mystore.fragment.HomeFragment;
import co.appsazan.mystore.fragment.MyAppFragment;
import co.appsazan.mystore.fragment.WishListFragment;
import co.appsazan.mystore.utils.JsonToArray;

/**
 * Created by Ali on 9/5/2016.
 */
public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout tabWishList, tabCategory, tabHome, tabBestApp, tabMyApp;
    private ImageView imgTabWishList, imgTabCategory, imgTabHome, imgTabBestApp, imgTabMyApp;
    private Fragment currentFragment;
    private FragmentManager fm;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Config.configStruct.getTheme().equals("MyThemeGame"))
            setTheme(R.style.MyThemeGame);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabWishList = (LinearLayout) findViewById(R.id.tabWishList);
        tabCategory = (LinearLayout) findViewById(R.id.tabCategory);
        tabHome = (LinearLayout) findViewById(R.id.tabHome);
        tabBestApp = (LinearLayout) findViewById(R.id.tabBestApp);
        tabMyApp = (LinearLayout) findViewById(R.id.tabMyApp);
        imgTabWishList = (ImageView) findViewById(R.id.imgTabWishList);
        imgTabCategory = (ImageView) findViewById(R.id.imgTabCategory);
        imgTabHome = (ImageView) findViewById(R.id.imgTabHome);
        imgTabBestApp = (ImageView) findViewById(R.id.imgTabBestApp);
        imgTabMyApp = (ImageView) findViewById(R.id.imgTabMyApp);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_content);


        if (fragment == null) {
            FragmentTransaction ft = fm.beginTransaction();
            currentFragment = new HomeFragment();
            ft.add(R.id.fragment_content, currentFragment);
            imgTabHome.setImageResource(R.drawable.home_selected);
            ft.commit();
        }
        tabWishList.setOnClickListener(this);
        tabCategory.setOnClickListener(this);
        tabHome.setOnClickListener(this);
        tabBestApp.setOnClickListener(this);
        tabMyApp.setOnClickListener(this);
        Config.MyActivity = this;
        //   new AddViews(this).initialise();

    }

    @Override
    public void onClick(View view) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch (view.getId()) {
            case R.id.tabWishList:
                currentFragment = new WishListFragment();
                ft.replace(R.id.fragment_content, currentFragment);
                disSelected();
                // imgTabWishList.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
                imgTabWishList.setImageResource(R.drawable.wishlist_selected);
                break;
            case R.id.tabCategory:
                currentFragment = new CategoryFragment();
                ft.replace(R.id.fragment_content, currentFragment);
                disSelected();
                imgTabCategory.setImageResource(R.drawable.categories_selected);
                break;
            case R.id.tabHome:
                currentFragment = new HomeFragment();
                ft.replace(R.id.fragment_content, currentFragment);
                disSelected();
                imgTabHome.setImageResource(R.drawable.home_selected);
                break;
            case R.id.tabBestApp:
                currentFragment = new BestAppFragment();
                ft.replace(R.id.fragment_content, currentFragment);
                disSelected();
                imgTabBestApp.setImageResource(R.drawable.topcharts_selected);
                break;
            case R.id.tabMyApp:

                currentFragment = new MyAppFragment();
                ft.replace(R.id.fragment_content, currentFragment);
                disSelected();
                imgTabMyApp.setImageResource(R.drawable.mygames_selected);
                break;
        }

        ft.commit();


    }

    private void disSelected() {

        imgTabWishList.setImageResource(R.drawable.wishlist);
        imgTabCategory.setImageResource(R.drawable.categories);
        imgTabHome.setImageResource(R.drawable.home);
        imgTabBestApp.setImageResource(R.drawable.topcharts);
        imgTabMyApp.setImageResource(R.drawable.mygames);

    }
}
