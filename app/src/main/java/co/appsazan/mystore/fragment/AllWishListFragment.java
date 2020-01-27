package co.appsazan.mystore.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.StringReader;
import java.util.List;

import co.appsazan.mystore.Config;
import co.appsazan.mystore.R;
import co.appsazan.mystore.adapter.MyAppAdapter;
import co.appsazan.mystore.adapter.WishListAdapter;
import co.appsazan.mystore.model.to.MyBestApp;
import co.appsazan.mystore.model.to.MyWishList;
import co.appsazan.mystore.utils.IdGenerator;
import co.appsazan.mystore.utils.JsonToArray;

/**
 * Created by Ali on 10/16/2016.
 */
public class AllWishListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_wish_list, container, false);



        String json;
        json = new JsonToArray().initDataSet(Config.context.getResources().openRawResource(R.raw.sample_wishlist));
        List<MyWishList> mylist = new Gson().fromJson(new StringReader(json), new TypeToken<List<MyWishList>>() {
        }.getType());



        RecyclerView rycWishList = (RecyclerView) view.findViewById(R.id.rycAllWishList);



        WishListAdapter myAppAdapter = new WishListAdapter(mylist);
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(getActivity());
        rycWishList.setLayoutManager(linearLayoutManager);
        rycWishList.setAdapter(myAppAdapter);
        return view;
    }
}
