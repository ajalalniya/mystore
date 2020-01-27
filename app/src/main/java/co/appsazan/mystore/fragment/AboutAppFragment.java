package co.appsazan.mystore.fragment;

import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import co.appsazan.mystore.Config;
import co.appsazan.mystore.R;
import co.appsazan.mystore.adapter.ScreenShotAdapter;
import co.appsazan.mystore.adapter.WishListAdapter;
import co.appsazan.mystore.model.to.AppDetailStruct;
import co.appsazan.mystore.model.to.MyWishList;
import co.appsazan.mystore.myview.MyTextView;
import co.appsazan.mystore.myview.MyTextViewShape;
import co.appsazan.mystore.utils.JsonToArray;

/**
 * Created by Ali on 11/29/2016.
 */
public class AboutAppFragment extends Fragment {

    private ScreenShotAdapter horizontaldetailAdapter;
    private RecyclerView horizontal_recycler_view;
    public static AppDetailStruct appDetailStruct;
    public MyTextView txtDetailSize;
    public MyTextView txtDetailPrise;
    public MyTextView txtDetailVersion;
    public MyTextView txtDetailDescription;
    public RelativeLayout lastVertionLayer1;
    public RelativeLayout lastVertionLayer2;
    public RelativeLayout lastVertionLayerArea1;
    public RelativeLayout lastVertionLayerArea2;
    public MyTextViewShape arrow1;
    public MyTextViewShape arrow2;
    public RelativeLayout part_screen;
public ScrollView scrollPage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_app, container, false);


/*part_screen = (RelativeLayout) view.findViewById(R.id.part_screen);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = (displaymetrics.heightPixels)/4;

        part_screen.getLayoutParams().height=height;
        part_screen.requestLayout();*/
        txtDetailSize = (MyTextView) view.findViewById(R.id.txtDetailSize);
        txtDetailPrise = (MyTextView) view.findViewById(R.id.txtDetailPrise);
        txtDetailVersion = (MyTextView) view.findViewById(R.id.txtDetailVersion);
        txtDetailDescription = (MyTextView) view.findViewById(R.id.txtDetailDescription);
        scrollPage=(ScrollView) view.findViewById(R.id.scrollpage2);
        String json = null;
        try {
            json = new JsonToArray().initDataSet(getResources().openRawResource(R.raw.sample_detail));
        } catch (Exception e) {
            e.printStackTrace();
        }


        lastVertionLayer1 = (RelativeLayout) view.findViewById(R.id.lastVertionLayer1);
        lastVertionLayer2 = (RelativeLayout) view.findViewById(R.id.lastVertionLayer2);
        lastVertionLayerArea1 = (RelativeLayout) view.findViewById(R.id.dropDown1);
        lastVertionLayerArea2 = (RelativeLayout) view.findViewById(R.id.dropDown2);
        arrow1 = (MyTextViewShape) view.findViewById(R.id.arrow1);
        arrow2 = (MyTextViewShape) view.findViewById(R.id.arrow2);
        appDetailStruct = new Gson().fromJson(json, AppDetailStruct.class);
        txtDetailSize.setText(appDetailStruct.size);
//        txtDetailPrise.setText(appDetailStruct.price);
        txtDetailVersion.setText(appDetailStruct.version);
        txtDetailDescription.setText(appDetailStruct.description);
        List<Integer> myWidth = new ArrayList<Integer>();
        List<Integer> myHeight = new ArrayList<Integer>();
        lastVertionLayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastVertionLayerArea1.getVisibility() == View.GONE) {
                    lastVertionLayerArea1.setVisibility(View.VISIBLE);
                    arrow1.setText(getResources().getString(R.string.fa_angle_up));

                } else {
                    lastVertionLayerArea1.setVisibility(View.GONE);
                    arrow1.setText(getResources().getString(R.string.fa_angle_down));
                }
            }
        });
        lastVertionLayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastVertionLayerArea2.getVisibility() == View.GONE) {
                    lastVertionLayerArea2.setVisibility(View.VISIBLE);
                    arrow2.setText(getResources().getString(R.string.fa_angle_up));
                    scrollPage.fullScroll(ScrollView.FOCUS_DOWN);


                } else {
                    lastVertionLayerArea2.setVisibility(View.GONE);
                    arrow2.setText(getResources().getString(R.string.fa_angle_down));
                }
            }
        });
        horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.screenshotimg);
        horizontaldetailAdapter = new ScreenShotAdapter(appDetailStruct.screen);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
        horizontal_recycler_view.setAdapter(horizontaldetailAdapter);


        return view;
    }
}
