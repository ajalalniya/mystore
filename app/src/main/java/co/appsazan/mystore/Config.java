package co.appsazan.mystore;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;

import com.google.gson.Gson;


import co.appsazan.mystore.model.to.ConfigStruct;
import co.appsazan.mystore.utils.JsonToArray;
import co.appsazan.mystore.utils.ReverseArray;

/**
 * Created by Ali on 9/6/2016.
 */
public class Config extends Application {

    public static Resources resources;
    public static String packageName;
    public static String mUrl;
    public static Context context;
    public static ConfigStruct configStruct;
    public static String[] appStruct;
    public static Typeface typeface;
    public static Typeface typefaceShape;
    public static Typeface typefaceBold;
    public static String theme;
public static Activity MyActivity;
    @Override
    public void onCreate() {
        super.onCreate();
        resources = getResources();
        packageName = getPackageName();
        context = getApplicationContext();
        typeface = Typeface.createFromAsset(context.getAssets(), "fonts/MyFont.ttf");
        typefaceShape = Typeface.createFromAsset(context.getAssets(), "fonts/fontshape.ttf");
        typefaceBold = Typeface.createFromAsset(context.getAssets(), "fonts/MyFontBold.ttf");


/** get data from server **/
        String json = new JsonToArray().initDataSet(getResources().openRawResource(R.raw.sample_data));
        configStruct = new Gson().fromJson(json, ConfigStruct.class);
        appStruct = configStruct.getStruct().split(",");
        ReverseArray myArray = new ReverseArray(appStruct);


/** get data from server **/




        appStruct = myArray.reverseArray();
        theme = configStruct.getTheme();






    }


}
