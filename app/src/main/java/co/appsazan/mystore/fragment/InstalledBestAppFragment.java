package co.appsazan.mystore.fragment;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.StringReader;
import java.util.List;

import co.appsazan.mystore.Config;
import co.appsazan.mystore.R;
import co.appsazan.mystore.adapter.BestAppAdapter;
import co.appsazan.mystore.model.to.MyBestApp;
import co.appsazan.mystore.utils.JsonToArray;

/**
 * Created by Ali on 10/16/2016.
 */
public class InstalledBestAppFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_installed_best_app, container, false);


        String json;
        json = new JsonToArray().initDataSet(Config.context.getResources().openRawResource(R.raw.sample_bestapp));
        List<MyBestApp> mylist = new Gson().fromJson(new StringReader(json), new TypeToken<List<MyBestApp>>() {
        }.getType());


        RecyclerView rycBestApp = (RecyclerView) view.findViewById(R.id.rycInstalledBestApp);

        BestAppAdapter allBestAppAdapter = new BestAppAdapter(mylist);
        RecyclerView.LayoutManager linearLayoutManager
                = new GridLayoutManager(getActivity(),3);
        rycBestApp.setLayoutManager(linearLayoutManager);



        rycBestApp.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(10), true));
        rycBestApp.setItemAnimator(new DefaultItemAnimator());

        rycBestApp.setAdapter(allBestAppAdapter);
        return view;
    }
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}