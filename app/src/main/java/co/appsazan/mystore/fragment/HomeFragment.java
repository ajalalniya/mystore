package co.appsazan.mystore.fragment;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import co.appsazan.mystore.R;
import co.appsazan.mystore.createView.AddViews;

/**
 * Created by Ali on 10/15/2016.
 */
public class HomeFragment extends Fragment {



   public HomeFragment(){};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);

        LinearLayout lm =(LinearLayout) view.findViewById(R.id.main_layout);

        new AddViews(view,lm).initialise();

        return view;
    }
}
