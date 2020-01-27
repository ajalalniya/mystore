package co.appsazan.mystore.createView;

import com.google.gson.Gson;

import co.appsazan.mystore.model.to.ConfigStruct;

/**
 * Created by Ali on 9/5/2016.
 */
public class SelectViews {

    public SelectViews() {

    }

    public void initialise(String json) {

        ConfigStruct data = new Gson().fromJson(json, ConfigStruct.class);
       /* ArrayList arrayList = new Gson().fromJson(json, ArrayList.class);
        ConfigStruct data = null;
        for (Object o : arrayList) {
            data = new Gson().fromJson(o.toString(), ConfigStruct.class);
            Log.i("----", "my " + o.toString() + " str:  " + data.getTest1());
        }*/
       /* for (String x : data.getTest1().split(",")) {

            try {

                Class JVM_OBJECT = Class.forName("co.appsazan.mystore.createView.AddViews");
                Method method = JVM_OBJECT.getDeclaredMethod(x);
                method.invoke(JVM_OBJECT);
            } catch (Exception e) {
                e.printStackTrace();
                Log.i("----x", x);
            }
        }*/
    }

}