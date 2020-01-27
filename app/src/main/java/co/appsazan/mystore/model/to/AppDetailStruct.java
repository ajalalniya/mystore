package co.appsazan.mystore.model.to;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ali on 9/19/2016.
 */
public class AppDetailStruct {

    @SerializedName("star")
    public float star;
@SerializedName("screen")
    public List<String> screen =new ArrayList<String>();
    @SerializedName("size")
    public  String size;
    @SerializedName("price")
    public  String price;
    @SerializedName("version")
    public  String version;
    @SerializedName("description")
    public  String description;
}
