package co.appsazan.mystore.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import co.appsazan.mystore.Config;
import co.appsazan.mystore.R;
import co.appsazan.mystore.adapter.CategoryAdapter;
import co.appsazan.mystore.adapter.CollactionAdapter;
import co.appsazan.mystore.createView.AddViews;
import co.appsazan.mystore.model.to.MyCategory;
import co.appsazan.mystore.utils.IdGenerator;

/**
 * Created by Ali on 10/16/2016.
 */
public class CategoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);


        RecyclerView rycCategory = (RecyclerView) view.findViewById(R.id.rycCategory);

        CategoryAdapter categoryAdapter = new CategoryAdapter(fillCategory());
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(getActivity());
        rycCategory.setLayoutManager(linearLayoutManager);
        rycCategory.setAdapter(categoryAdapter);
        rycCategory.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), rycCategory, new ClickListener() {


            @Override
            public void onClick(View view, int position) {
               /* drawerListener.onDrawerItemSelected(view, position);
                mDrawerLayout.closeDrawer(containerView);*/
            }

            @Override
            public void onLongClick(View view, int position) {

            }

        }));

        return view;
    }

    private List<MyCategory> fillCategory() {
        String[] titles = new String[16];
        int[] icon = new int[16];

        titles = getActivity().getResources().getStringArray(R.array.categories_item);
        icon[0] = R.drawable.amuzeshi;
        icon[1] = R.drawable.strategy;
        icon[2] = R.drawable.takhteyi;
        icon[3] = R.drawable.sargarmi;
        icon[4] = R.drawable.khanevadegi;
        icon[5] = R.drawable.danestaniha;
        icon[6] = R.drawable.reghabati;
        icon[7] = R.drawable.shabihsazi;
        icon[8] = R.drawable.kalamat;
        icon[9] = R.drawable.majarajuyi;
        icon[10] = R.drawable.moamayi;
        icon[11] = R.drawable.mosabeghevasorat;
        icon[12] = R.drawable.naghshafarini;
        icon[13] = R.drawable.music;
        icon[14] = R.drawable.hayajaani;
        icon[15] = R.drawable.varzeshi;


        ArrayList<MyCategory> arrayMycategory = new ArrayList<>();

        for (int i = 0; i <= 15; i++) {
            MyCategory mycategory = new MyCategory();
            mycategory.setImage(icon[i]);
            mycategory.setTitle(titles[i]);
            arrayMycategory.add(mycategory);
        }
        return arrayMycategory;
    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
