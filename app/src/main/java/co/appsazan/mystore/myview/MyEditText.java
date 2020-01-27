package co.appsazan.mystore.myview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import co.appsazan.mystore.Config;

/**
 * Created by Ali on 9/17/2016.
 */
public class MyEditText extends EditText {
    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Config.typeface);
    }
}