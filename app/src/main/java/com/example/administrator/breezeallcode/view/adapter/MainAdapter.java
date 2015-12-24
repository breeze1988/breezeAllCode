package com.example.administrator.breezeallcode.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.breezeallcode.R;
import com.example.administrator.breezeallcode.constant.Constant;
import com.example.administrator.breezeallcode.view.activity.SubClassifiyActivity;
import com.example.administrator.breezeallcode.view.activity.ThirdLevelClassifyActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2015/12/24.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainAdapterHodler> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private String[] mClassfiy;
    private int mLevel = 0;

    public MainAdapter(Context context, String[] datas, int level) {
        mLevel = level;
        mClassfiy = datas;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MainAdapterHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainAdapterHodler(mLayoutInflater.inflate(R.layout.item_cardview_text, parent, false), this, mLevel);
    }

    @Override
    public void onBindViewHolder(MainAdapterHodler holder, int position) {
        holder.mTextView.setText(mClassfiy[position]);
    }

    @Override
    public int getItemCount() {
        return mClassfiy == null ? 0 : mClassfiy.length;
    }

    public static class MainAdapterHodler extends RecyclerView.ViewHolder {
        @Bind(R.id.text_view)
        TextView mTextView;
        MainAdapter mAdapter;
        int mLevel = 0;

        MainAdapterHodler(View view, MainAdapter adapter, int level) {
            super(view);
            mLevel = level;
            mAdapter = adapter;
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.cv_item)
        void onItemClick() {
            Intent intent = null;
            if (mLevel == 0) {
                intent = new Intent(mAdapter.mContext, SubClassifiyActivity.class);
            } else if (mLevel == 1) {
                intent = new Intent(mAdapter.mContext, ThirdLevelClassifyActivity.class);
            }
            intent.putExtra(Constant.KEY_POSITION, getPosition());
            intent.putExtra(Constant.KEY_TITLE, mTextView.getText());
            mAdapter.mContext.startActivity(intent);
        }
    }
}
