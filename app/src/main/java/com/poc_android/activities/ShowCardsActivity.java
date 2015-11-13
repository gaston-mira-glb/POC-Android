package com.poc_android.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.poc_android.R;

import java.util.ArrayList;

public class ShowCardsActivity extends FragmentActivity {

    private static final int NUM_PAGES = 5;
    private ViewPager mViewPager;
    private MyPagerAdapter mPagerAdapter;
    private TextView mCreditCardText;
    private ArrayList<Integer> mListCc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cards);
        mListCc = new ArrayList<>();
        mListCc.add(123213123);
        mListCc.add(154687789);
        mListCc.add(325487987);
        mListCc.add(489545665);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mCreditCardText = (TextView) findViewById(R.id.credt_card_number_text);
        String msg = "Esta es la tarjeta " + mListCc.get(0);
        mCreditCardText.setText(msg);
        mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), mListCc);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                String msg = "Esta es la tarjeta " + mListCc.get(position);
                mCreditCardText.setText(msg);
                //mPagerAdapter.getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public class MyPagerAdapter extends FragmentStatePagerAdapter {

        private ArrayList<Integer> listCc;

        public MyPagerAdapter(android.support.v4.app.FragmentManager fm, ArrayList<Integer> list) {
            super(fm);
            listCc = list;
        }

        @Override
        public Fragment getItem(int pos) {
            return CreditCardFragment.create(listCc.get(pos));
        }

        @Override
        public int getCount() {
            return listCc.size();
        }
    }

}
