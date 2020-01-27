package co.appsazan.mystore.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import co.appsazan.mystore.Config;

/**
 * Created by Ali on 9/17/2016.
 */
public class MyTextViewBold extends TextView {
    public MyTextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Config.typefaceBold);
    }
}
