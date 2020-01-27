package co.appsazan.mystore.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.StringReader;
import java.util.List;

import co.appsazan.mystore.Config;
import co.appsazan.mystore.R;
import co.appsazan.mystore.adapter.MyAppAdapter;
import co.appsazan.mystore.model.to.MyApp;
import co.appsazan.mystore.utils.JsonToArray;

/**
 * Created by Ali on 10/16/2016.
 */
public class InstalledMyAppFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_installed_my_app, container, false);






        String json;
        json = new JsonToArray().initDataSet(Config.context.getResources().openRawResource(R.raw.sample_myapp));
        List<MyApp> mylist = new Gson().fromJson(new StringReader(json), new TypeToken<List<MyApp>>() {
        }.getType());


  RecyclerView rycMyApp = (RecyclerView) view.findViewById(R.id.rycInstalledMyApp);

        MyAppAdapter myAppAdapter = new MyAppAdapter(mylist);
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(getActivity());
        rycMyApp.setLayoutManager(linearLayoutManager);
        rycMyApp.setAdapter(myAppAdapter);

        return view;
    }
}
