package com.example.administrator.breezeallcode.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.example.administrator.breezeallcode.R;
import com.example.administrator.breezeallcode.constant.Constant;
import com.example.administrator.breezeallcode.view.fragment.MainFragment;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/12/24.
 */
public class ThirdLevelClassifyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_level_classify);
        ButterKnife.bind(this);
        int index = getIntent().getIntExtra(Constant.KEY_POSITION, 0);
        String title = getIntent().getStringExtra(Constant.KEY_TITLE);
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        } else {
            setTitle("title 丢失");
        }
        Fragment fragment = MainFragment.newMainFragement();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.KEY_TITLE, title);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.third_classify_container, fragment).commit();
    }
}
