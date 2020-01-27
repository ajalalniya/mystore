package co.appsazan.mystore.createView;

import android.widget.LinearLayout;

/**
 * Created by Ali on 9/10/2016.
 */
public class ViewProperties {

    public LinearLayout.LayoutParams setlayoutParams(int with, int hight) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                with, hight);
        return params;
    }

}
