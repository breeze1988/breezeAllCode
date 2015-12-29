package com.example.administrator.breezeallcode.view.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.breezeallcode.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/12/25.
 */
public class ViewClassifyActivity extends BaseActivity {
    @Bind(R.id.view_classify_drawer_layout)
    DrawerLayout mDrawerLayout;
    /* @Bind(R.id.view_classify_content_fragment)
     Fragment mContentFragment;*/
    @Bind(R.id.view_classify_drawer_recyclerview)
    RecyclerView mDrawerContentRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_subclassify);
        ButterKnife.bind(this);

    }
}
