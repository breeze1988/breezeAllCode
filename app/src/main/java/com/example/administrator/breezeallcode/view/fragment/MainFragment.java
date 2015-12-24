package com.example.administrator.breezeallcode.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.breezeallcode.R;
import com.example.administrator.breezeallcode.constant.Constant;
import com.example.administrator.breezeallcode.view.adapter.MainAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/12/24.
 */
public class MainFragment extends android.support.v4.app.Fragment {
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    public static MainFragment newMainFragement() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        String[] classifyDatas = null;
        String flag = getArguments().getString(Constant.KEY_TITLE);
        MainAdapter adapter = null;
        /*主界面*/
        if ("main".equals(flag)) {
            classifyDatas = getActivity().getResources().getStringArray(R.array.classify);
            adapter = new MainAdapter(getActivity(), classifyDatas, 0);
        }
        /*一级界面*/
        else {
            if ("View".equals(flag)) {
                classifyDatas = getActivity().getResources().getStringArray(R.array.classify_view);
            } else if ("四大组件".equals(flag)) {

            } else if ("图片加载处理".equals(flag)) {

            } else if ("网络通信".equals(flag)) {

            } else if ("动画".equals(flag)) {

            } else if ("内存泄露".equals(flag)) {

            }
            adapter = new MainAdapter(getActivity(), classifyDatas, 1);
        }

        /*二级界面*/
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
