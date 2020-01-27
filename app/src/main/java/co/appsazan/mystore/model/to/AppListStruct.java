package co.appsazan.mystore.model.to;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Ali on 9/17/2016.
 */
public class AppListStruct {
    @SerializedName("appname")
    public String appname;
    @SerializedName("desc")
    public String desc;
    @SerializedName("imgurl")
    public String imgurl;
    @SerializedName("url")
    public String url;


}
