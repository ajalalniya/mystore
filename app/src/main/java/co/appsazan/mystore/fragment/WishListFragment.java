package co.appsazan.mystore.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import co.appsazan.mystore.R;
import co.appsazan.mystore.utils.IdGenerator;

/**
 * Created by Ali on 10/16/2016.
 */
public class WishListFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private String[] viewPagerTitles=new String[3];


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        viewPagerTitles[0]=getString(R.string.news);
        viewPagerTitles[1]=getString(R.string.free);
        viewPagerTitles[2]=getString(R.string.all_app);
        View view =inflater.inflate(R.layout.fragment_wish_list,container,false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpagerWishList);
        tabLayout = (TabLayout) view.findViewById(R.id.tabsWishList);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        return view;
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

    class ViewPagerAdapter extends PagerAdapter
    {
        RelativeLayout newsWishListLayout=null;
        RelativeLayout freeWishListLayout=null;
        RelativeLayout allWishListLayout=null;
        NewsWishListFragment newsWishListFragment=new NewsWishListFragment();
        FreeWishListFragment freeWishListFragment=new FreeWishListFragment();
        AllWishListFragment allWishListFragment=new AllWishListFragment();
        FragmentManager fragmentManager=null;
        FragmentTransaction fragmentTransaction=null;


        private ViewPagerAdapter()
        {
            newsWishListLayout=new RelativeLayout(getActivity().getApplicationContext());
            newsWishListLayout.setId(IdGenerator.getId("newsWishListLayout"));
            newsWishListLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

            freeWishListLayout=new RelativeLayout(getActivity().getApplicationContext());
            freeWishListLayout.setId(IdGenerator.getId("freeWishListLayout"));
            freeWishListLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

            allWishListLayout=new RelativeLayout(getActivity().getApplicationContext());
            allWishListLayout.setId(IdGenerator.getId("allWishListLayout"));
            allWishListLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));



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
                fragmentTransaction.add(newsWishListLayout.getId(),newsWishListFragment);
                fragmentTransaction.commit();
                ((ViewPager)container).addView(newsWishListLayout,0);
                return newsWishListLayout;
            }
            else if(position==1)
            {
                fragmentTransaction.add(freeWishListLayout.getId(),freeWishListFragment);
                fragmentTransaction.commit();
                ((ViewPager)container).addView(freeWishListLayout,0);
                return freeWishListLayout;
            }
            else if(position==2)
            {

                fragmentTransaction.add(allWishListLayout.getId(),allWishListFragment);
                fragmentTransaction.commit();
                ((ViewPager)container).addView(allWishListLayout,0);
                return allWishListLayout;
            }

            return  null;
        }
        @Deprecated
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager)container).removeView((View)object);
        }

    }
}
