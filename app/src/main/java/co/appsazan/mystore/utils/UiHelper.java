package co.appsazan.mystore.utils;

import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;

import co.appsazan.mystore.Config;

/**
 * Created by Ali on 9/6/2016.
 */
public class UiHelper {


        public void parseUi(View view) {
            Field[] fields = getClass().getFields();
            for (Field field: fields) {


                int id = Config.resources.getIdentifier(field.getName(), "id", Config.packageName);
           //     Log.i("----a",field.getName()+"-->"+id);
                try {
                    field.set(this, field.getType().cast(view.findViewById(id)));
                }
                catch (IllegalArgumentException e) {
                    Log.i("LOG", "Error Illegal Exception");
                }
                catch (IllegalAccessException e) {
                    Log.i("LOG", "Error Access Exception");
                }
                catch (Exception e) {
                    Log.e("LOG", "Error on setting field: " + field.getName() + " with type " + field.getType().getCanonicalName());
                }
            }

    }


}
