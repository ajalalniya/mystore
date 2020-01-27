package co.appsazan.mystore.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.appsazan.mystore.R;

/**
 * Created by Ali on 11/29/2016.
 */
public class CommentsAppFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test, container, false);
        return view;
    }
}
