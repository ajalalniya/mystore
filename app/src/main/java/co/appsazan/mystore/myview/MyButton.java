package co.appsazan.mystore.myview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import co.appsazan.mystore.Config;

/**
 * Created by Ali on 9/19/2016.
 */
public class MyButton extends Button{


    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);


        setTypeface(Config.typeface);
    }
}
