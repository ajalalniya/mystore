package co.appsazan.mystore.createView;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.StringReader;
import java.util.List;

import co.appsazan.mystore.Config;
import co.appsazan.mystore.R;
import co.appsazan.mystore.adapter.CollactionAdapter;
import co.appsazan.mystore.adapter.HorizentalAdapter;
import co.appsazan.mystore.model.to.AppListStruct;
import co.appsazan.mystore.model.to.MyCollection;
import co.appsazan.mystore.myview.MyTextView;
import co.appsazan.mystore.myview.MyTextViewBold;
import co.appsazan.mystore.utils.IdGenerator;
import co.appsazan.mystore.utils.JsonToArray;

/**
 * Created by Ali on 9/6/2016.
 */
public class AddViews {
    public static LinearLayout lm;
   // private LinearLayout lm;
private View view;
    public AddViews(View view,LinearLayout linearLayout) {

        lm = linearLayout;
        this.view=view;
    }

    public void initialise() {


        // ConfigStruct list = new Gson().fromJson(json, ConfigStruct.class);

        for (String myview : Config.appStruct) {
            int i = 0;
            String[] str = myview.split(":");
            if (str[0].trim().equals("MyAppList")) {
                i++;
                addAppList(str[1].trim(), str[2].trim(), str[3].trim(), i);

            } else if (str[0].trim().equals("MyBanner")) {
                i++;
                addBanner(str[1].trim(), i);

            } else if (str[0].trim().equals("MyCollection")) {
                i++;
                addCollection(str[1].trim(), str[2].trim(), i);

            }
            else if(str[0].trim().equals("VeryBestApps")){

                i++;
                addVeryBestApps(str[1].trim(),  i);

            }

        }
    }

    public void addAppList(String title, String url, String urlmore, int i) {

        LayoutInflater layoutInflater = (LayoutInflater)
                Config.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        lm.addView(layoutInflater.inflate(R.layout.custom1, null), 0);

        String json = null;
        json = new JsonToArray().initDataSet(Config.context.getResources().openRawResource(R.raw.sample_bestlist));
    /*    List<AppListStruct> mylist = new ArrayList<AppListStruct>();
        List arrayList = new Gson().fromJson(json, ArrayList.class);
        for (Object o : arrayList) {
            AppListStruct appListStruct = new Gson().fromJson(o.toString(), AppListStruct.class);
            mylist.add(appListStruct);
        }*/


        ((MyTextViewBold) view.findViewById(R.id.txtTitleAppList)).setId(IdGenerator.getId("txtTitleAppList" + i));
        MyTextViewBold txtTitle = (MyTextViewBold) view.findViewById(IdGenerator.getId("txtTitleAppList" + i));
        txtTitle.setText(title);

        List<AppListStruct> mylist = new Gson().fromJson(new StringReader(json), new TypeToken<List<AppListStruct>>() {
        }.getType());


        ((RecyclerView) view.findViewById(R.id.rycAppList)).setId(IdGenerator.getId("rycAppList" + i));
        RecyclerView rycAppList = (RecyclerView) view.findViewById(IdGenerator.getId("rycAppList" + i));

        HorizentalAdapter horizontalAdapter = new HorizentalAdapter(mylist);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(Config.context, LinearLayoutManager.HORIZONTAL, true);
        rycAppList.setLayoutManager(horizontalLayoutManagaer);
        rycAppList.setAdapter(horizontalAdapter);
        //  ((TextView) SelectViews.activity.findViewById(100)).setText("salam");
    }

    public void addBanner(String url, int i) {

        LayoutInflater layoutInflater = (LayoutInflater)
                Config.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        lm.addView(layoutInflater.inflate(R.layout.custom2, null), 0);

    }

    public void addCollection(String title, String url, int i) {


        LayoutInflater layoutInflater = (LayoutInflater)
                Config.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        lm.addView(layoutInflater.inflate(R.layout.custom3, null), 0);


        ((MyTextViewBold) view.findViewById(R.id.txtTitleCollaction)).setId(IdGenerator.getId("txtTitleCollaction" + i));
        MyTextViewBold txtTitle = (MyTextViewBold)  view.findViewById(IdGenerator.getId("txtTitleCollaction" + i));
        txtTitle.setText(title);

        String json = "";
        json = new JsonToArray().initDataSet(Config.context.getResources().openRawResource(R.raw.sample_collaction));
        List<MyCollection> mylist = new Gson().fromJson(new StringReader(json), new TypeToken<List<MyCollection>>() {
        }.getType());


        ((RecyclerView) view.findViewById(R.id.rycCollaction)).setId(IdGenerator.getId("rycCollaction" + i));
        RecyclerView rycCollaction = (RecyclerView) view.findViewById(IdGenerator.getId("rycCollaction" + i));

        CollactionAdapter horizontalAdapter = new CollactionAdapter(mylist);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(Config.context, LinearLayoutManager.HORIZONTAL, true);
        rycCollaction.setLayoutManager(horizontalLayoutManagaer);
        rycCollaction.setAdapter(horizontalAdapter);


    }


    public void addVeryBestApps(String url, int i){

        LayoutInflater layoutInflater = (LayoutInflater)
                Config.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        lm.addView(layoutInflater.inflate(R.layout.custom4, null), 0);



        String json = "";
        json = new JsonToArray().initDataSet(Config.context.getResources().openRawResource(R.raw.sample_collaction));
        List<MyCollection> mylist = new Gson().fromJson(new StringReader(json), new TypeToken<List<MyCollection>>() {
        }.getType());


        ((RecyclerView) view.findViewById(R.id.rycVeryBestApps)).setId(IdGenerator.getId("rycVeryBestApps" + i));
        RecyclerView rycCollaction = (RecyclerView) view.findViewById(IdGenerator.getId("rycVeryBestApps" + i));

        CollactionAdapter horizontalAdapter = new CollactionAdapter(mylist);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(Config.context, LinearLayoutManager.HORIZONTAL, true);
        rycCollaction.setLayoutManager(horizontalLayoutManagaer);
        rycCollaction.setAdapter(horizontalAdapter);



    }

}
