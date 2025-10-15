package com.elevenappstudio.getdailydiamondguide.DiamondApp;

import com.elevenappstudio.getdailydiamondguide.R;

import android.content.Intent;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.elevenappstudio.getdailydiamondguide.DiamondApp.ExtraClass.AdsClass;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.Fragment.FirstFragment;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.Fragment.FourthFragment;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.Fragment.SecondFragment;
import com.elevenappstudio.getdailydiamondguide.DiamondApp.Fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class OnBoarding_Activity extends AppCompatActivity {

    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_on_boarding);

        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        ImageView lnr_dots = (ImageView) findViewById(R.id.lnr_dots);
        ImageView iv_swipe_start = (ImageView) findViewById(R.id.iv_swipe_start);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager(), 1);

        viewPagerAdapter.addFragment(new FirstFragment(), "1");
        viewPagerAdapter.addFragment(new SecondFragment(), "2");
        viewPagerAdapter.addFragment(new ThirdFragment(), "3");
        viewPagerAdapter.addFragment(new FourthFragment(), "4");

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pos = position;
                if (position == 0) {
                    lnr_dots.setImageResource(R.drawable.iv_dot_1);
                    iv_swipe_start.setVisibility(View.GONE);
                    lnr_dots.setVisibility(View.VISIBLE);
                } else if (position == 1) {
                    lnr_dots.setImageResource(R.drawable.iv_dot_2);
                    iv_swipe_start.setVisibility(View.GONE);
                    lnr_dots.setVisibility(View.VISIBLE);
                } else if (position == 2) {
                    lnr_dots.setImageResource(R.drawable.iv_dot_3);
                    iv_swipe_start.setVisibility(View.GONE);
                    lnr_dots.setVisibility(View.VISIBLE);
                } else if (position == 3) {
                    iv_swipe_start.setVisibility(View.VISIBLE);
                    lnr_dots.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewpager.setAdapter(viewPagerAdapter);
        viewpager.setCurrentItem(0);

        iv_swipe_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pos == 3) {
                    //intent
                    AdsClass.Show_Interstitial_Ads(OnBoarding_Activity.this, new AdsClass.AdsClick() {
                        @Override
                        public void AdsDismiss(boolean b) {
                            Intent intent = new Intent(OnBoarding_Activity.this, Earn_Diamonds_Activity.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    pos++;
                    viewpager.setCurrentItem(pos);
                }
            }
        });
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList();
        private final List<String> mFragmentTitleList = new ArrayList();

        ViewPagerAdapter(FragmentManager fragmentManager, int i) {
            super(fragmentManager, i);
        }

        public Fragment getItem(int i) {
            return this.mFragmentList.get(i);
        }

        public int getCount() {
            return this.mFragmentList.size();
        }


        public void addFragment(Fragment fragment, String str) {
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(str);
        }

        public CharSequence getPageTitle(int i) {
            return this.mFragmentTitleList.get(i);
        }
    }
}