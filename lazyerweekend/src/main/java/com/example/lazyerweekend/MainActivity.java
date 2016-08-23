package com.example.lazyerweekend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.lazyerweekend.Collection.CollectionFragment;
import com.example.lazyerweekend.Lanmiaozhuli.AssistFragment;
import com.example.lazyerweekend.LazyerWeekend.LazyerFragment;
import com.example.lazyerweekend.Search.SearchFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面，控制4个Fragment的滑动
 */
public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private List<Fragment> fragments = new ArrayList<>();
    private LazyerFragment mLazyerFragment;
    private SearchFragment mSearchFragment;
    private AssistFragment mAssistFragment;
    private CollectionFragment mCollectionFragment;
    private RadioGroup mRadioGroup;
    private ViewPager mViewPager;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        initFragment();
        loadDatas();
        initView();
    }

    //初始化获得Fragment对象
    private void initFragment() {
        mLazyerFragment = LazyerFragment.newInstance();
        mSearchFragment = SearchFragment.newInstance();
        mAssistFragment = AssistFragment.newInstance();
        mCollectionFragment = CollectionFragment.newInstance();
    }

    //初始化数据，这里就是4个Fragment
    private void loadDatas() {
        fragments.add(mLazyerFragment);
        fragments.add(mSearchFragment);
        fragments.add(mAssistFragment);
        fragments.add(mCollectionFragment);
    }

    //初始化视图
    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.main_bottom_radio_group);
        mViewPager = (ViewPager) findViewById(R.id.main_fragment_view_pager);
        //选择默认显示的Fragment
        mRadioGroup.check(R.id.main_bottom_lazyer_rb);
        //RadioGroup的监听，监听选择
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.main_bottom_lazyer_rb:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.main_bottom_search_rb:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.main_bottom_assist_rb:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.main_bottom_collection_rb:
                        mViewPager.setCurrentItem(3);
                        break;
                }
            }
        });
        //创建适配器对象、并与ViewPager绑定
        mAdapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        //设置初始选定项,默认为第一项
        mViewPager.setCurrentItem(0);
        //给ViewPager添加监听,使滑动时RadioButton一起动
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRadioGroup.check(R.id.main_bottom_lazyer_rb);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.main_bottom_search_rb);
                        break;
                    case 2:
                        mRadioGroup.check(R.id.main_bottom_assist_rb);
                        break;
                    case 3:
                        mRadioGroup.check(R.id.main_bottom_collection_rb);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    //创建适配器
    class MyAdapter extends FragmentStatePagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments == null ? 0 : fragments.size();
        }
    }
}
