package co.appsazan.mystore.fragment;

import android.app.TabActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import co.appsazan.mystore.R;
import co.appsazan.mystore.adapter.CategoryAdapter;
import co.appsazan.mystore.adapter.ViewPagerAdapter;
import co.appsazan.mystore.utils.IdGenerator;

/**
 * Created by Ali on 10/16/2016.
 */
public class BestAppFragment extends Fragment {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private String[] viewPagerTitles=new String[3];

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        viewPagerTitles[0]=getString(R.string.will_instal);
        viewPagerTitles[1]=getString(R.string.installed);
        viewPagerTitles[2]=getString(R.string.all_app);
        View view =inflater.inflate(R.layout.fragment_bestapp,container,false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpagerBestApp);
        tabLayout = (TabLayout) view.findViewById(R.id.tabsBestApp);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onPause() {
        super.onPause();

    }

    private void setupViewPager(ViewPager viewPager) {
         adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
       /* adapter.addFragment(new WillInstallBestAppFragment(), getString(R.string.will_instal));
        adapter.addFragment(new InstalledBestAppFragment(), getString(R.string.installed));
        adapter.addFragment(new AllBestAppFragment(), getString(R.string.all_app));*/
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setCurrentItem(2);

    }

/*
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }


        public void addFragment(Fragment fragment, String title) {
           Log.i("-----1", ""+mFragmentList.size());
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }


        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            Log.i("-----2", ""+mFragmentList.size());
            return mFragmentList.size();
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }


    }*/

    class ViewPagerAdapter extends PagerAdapter
    {
        RelativeLayout willInstalledBestAppLayout=null;
        RelativeLayout installedBestAppLayout=null;
        RelativeLayout allBestAppLayout=null;
        WillInstallBestAppFragment willInstallBestAppFragment=new WillInstallBestAppFragment();
        InstalledBestAppFragment installedBestAppFragment=new InstalledBestAppFragment();
        AllBestAppFragment allBestAppFragment=new AllBestAppFragment();
        FragmentManager fragmentManager=null;
        FragmentTransaction fragmentTransaction=null;


        private ViewPagerAdapter()
        {
            willInstalledBestAppLayout=new RelativeLayout(getActivity().getApplicationContext());
            willInstalledBestAppLayout.setId(IdGenerator.getId("willInstalledBestAppLayout"));
            willInstalledBestAppLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

            installedBestAppLayout=new RelativeLayout(getActivity().getApplicationContext());
            installedBestAppLayout.setId(IdGenerator.getId("installedBestAppLayout"));
            installedBestAppLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

            allBestAppLayout=new RelativeLayout(getActivity().getApplicationContext());
            allBestAppLayout.setId(IdGenerator.getId("allBestAppLayout"));
            allBestAppLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));



        }
        public ViewPagerAdapter(FragmentManager manager)
        {
            this();
            this.fragmentManager=manager;

        }

        @Override
        public int getCount() {
            return 3;
        }

        public CharSequence getPageTitle(int position) {
            return viewPagerTitles[position];
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (View)object==view;
        }
        @Deprecated
        public Object instantiateItem(View container, int position)
        {
            fragmentTransaction=fragmentManager.beginTransaction();
            if(position==0)
            {
               fragmentTransaction.add(willInstalledBestAppLayout.getId(),willInstallBestAppFragment);
                fragmentTransaction.commit();
                ((ViewPager)container).addView(willInstalledBestAppLayout,0);
                return willInstalledBestAppLayout;
            }
            else if(position==1)
            {
                fragmentTransaction.add(installedBestAppLayout.getId(),installedBestAppFragment);
                fragmentTransaction.commit();
                ((ViewPager)container).addView(installedBestAppLayout,0);
                return installedBestAppLayout;
            }
            else if(position==2)
            {

                fragmentTransaction.add(allBestAppLayout.getId(),allBestAppFragment);
                fragmentTransaction.commit();
                ((ViewPager)container).addView(allBestAppLayout,0);
                return allBestAppLayout;
            }

            return  null;
        }
        @Deprecated
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager)container).removeView((View)object);
        }

    }

}
