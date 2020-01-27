package co.appsazan.mystore.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import co.appsazan.mystore.Config;
import co.appsazan.mystore.R;
import co.appsazan.mystore.adapter.ScreenShotAdapter;
import co.appsazan.mystore.fragment.AboutAppFragment;
import co.appsazan.mystore.fragment.CommentsAppFragment;
import co.appsazan.mystore.fragment.RelatedAppFragment;
import co.appsazan.mystore.model.to.AppDetailStruct;
import co.appsazan.mystore.myview.MyButton;
import co.appsazan.mystore.myview.MyTextView;
import co.appsazan.mystore.myview.MyTextViewShape;
import co.appsazan.mystore.utils.JsonToArray;
import co.appsazan.mystore.utils.UiHelper;

/**
 * Created by Ali on 9/19/2016.
 */
public class SecondActivity extends AppCompatActivity {

    public RatingBar rtbStar;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public class Ui extends UiHelper {

        public ImageView imgDetailImage;
        public MyTextView txtDetailTitle;

        public MyTextView txtDetailDesc;
        public MyButton btnDetailDownload;
        public MyTextViewShape txtWishShape;

        public Ui(View view, Bundle savedInstanceState) {
            parseUi(view);

            if (savedInstanceState == null) {
                Bundle extras = getIntent().getExtras();


                txtWishShape.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (txtWishShape.getText().toString().equals(getResources().getString(R.string.bookmark_io))) {

                            txtWishShape.setText(getResources().getString(R.string.bookmark));

                        } else {


                            txtWishShape.setText(getResources().getString(R.string.bookmark_io));
                        }


                    }
                });



                if (extras == null) {

                    txtDetailTitle.setText("");
                    txtDetailDesc.setText("");
                    imgDetailImage = null;

                    Log.i("----b", "here");

                } else {
                    txtDetailTitle.setText(extras.getString("appName"));
                    txtDetailDesc.setText(extras.getString("appDesc"));
                    Picasso.with(Config.context).load(extras.getString("appImg")).into(imgDetailImage);
                    Log.i("----b", "here2 " + extras.getString("appName"));
                }
            } else {
                txtDetailTitle.setText((String) savedInstanceState.getSerializable("appName"));
                txtDetailDesc.setText((String) savedInstanceState.getSerializable("appDesc"));
                Picasso.with(Config.context).load((String) savedInstanceState.getSerializable("appImg")).into(imgDetailImage);
                Log.i("----b", "here3 " + (String) savedInstanceState.getSerializable("appName"));
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Ui ui = new Ui(getWindow().getDecorView(), savedInstanceState);

  /*      rtbStar = (RatingBar) findViewById(R.id.rtbStar);
        rtbStar.setRating(AboutAppFragment.appDetailStruct.star);*/


        viewPager = (ViewPager) findViewById(R.id.viewpagerSecondPage);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabsSecondPage);
        tabLayout.setupWithViewPager(viewPager);


     /*   btndownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(AppDetailStruct.link); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });*/

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RelatedAppFragment(), "مرتبط");
        adapter.addFragment(new CommentsAppFragment(), "نظرات");
        adapter.addFragment(new AboutAppFragment(), "درباره");
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(2);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
