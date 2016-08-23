package com.example.lazyerweekend.LazyerWeekend;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lazyerweekend.R;

/**
 * Created by my on 2016/8/23.
 */
public class LazyerFragment extends Fragment{

    private Context mContext;

    public static LazyerFragment newInstance(){
        LazyerFragment lazyerFragment = new LazyerFragment();
        return lazyerFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        return view;
    }
}
