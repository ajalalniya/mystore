package co.appsazan.mystore.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import co.appsazan.mystore.R;
import co.appsazan.mystore.adapter.ViewPagerAdapter;
import co.appsazan.mystore.utils.IdGenerator;

/**
 * Created by Ali on 10/16/2016.
 */
public class MyAppFragment extends Fragment {
    private String[] viewPagerTitles=new String[3];
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


}

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        viewPagerTitles[0]=getString(R.string.will_instal);
        viewPagerTitles[1]=getString(R.string.installed);
        viewPagerTitles[2]=getString(R.string.all_app);
        View view = inflater.inflate(R.layout.fragment_my_app, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpagerMyApp);
        tabLayout = (TabLayout) view.findViewById(R.id.tabsMyApp);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
         adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        /*adapter.addFragment(new WillInstallMyAppFragment(), getString(R.string.will_instal));
        adapter.addFragment(new InstalledMyAppFragment(), getString(R.string.installed));
        adapter.addFragment(new AllMyAppFragment(), getString(R.string.all_app));*/

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setCurrentItem(2);
    }


   /* class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }


        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }


        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }


    }*/

    class ViewPagerAdapter extends PagerAdapter
    {
        RelativeLayout willInstallMyAppLayout=null;
        RelativeLayout installedMyAppLayout=null;
        RelativeLayout allMyAppLayout=null;
        WillInstallMyAppFragment willInstallMyAppFragment=new WillInstallMyAppFragment();
        InstalledMyAppFragment installedMyAppFragment=new InstalledMyAppFragment();
        AllMyAppFragment allMyAppFragment=new AllMyAppFragment();
        FragmentManager fragmentManager=null;
        FragmentTransaction fragmentTransaction=null;


        private ViewPagerAdapter()
        {
            willInstallMyAppLayout=new RelativeLayout(getActivity().getApplicationContext());
            willInstallMyAppLayout.setId(IdGenerator.getId("willInstallMyAppLayout"));
            willInstallMyAppLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

            installedMyAppLayout=new RelativeLayout(getActivity().getApplicationContext());
            installedMyAppLayout.setId(IdGenerator.getId("installedMyAppLayout"));
            installedMyAppLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

            allMyAppLayout=new RelativeLayout(getActivity().getApplicationContext());
            allMyAppLayout.setId(IdGenerator.getId("allMyAppLayout"));
            allMyAppLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

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
                fragmentTransaction.add(willInstallMyAppLayout.getId(),willInstallMyAppFragment);
                fragmentTransaction.commit();
                ((ViewPager)container).addView(willInstallMyAppLayout,0);
                return willInstallMyAppLayout;
            }
            else if(position==1)
            {
                fragmentTransaction.add(installedMyAppLayout.getId(),installedMyAppFragment);
                fragmentTransaction.commit();
                ((ViewPager)container).addView(installedMyAppLayout,0);
                return installedMyAppLayout;
            }
            else if(position==2)
            {
                fragmentTransaction.add(allMyAppLayout.getId(),allMyAppFragment);
                fragmentTransaction.commit();
                ((ViewPager)container).addView(allMyAppLayout,0);
                return allMyAppLayout;
            }

            return  null;
        }
        @Deprecated
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager)container).removeView((View)object);
        }

    }



    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
