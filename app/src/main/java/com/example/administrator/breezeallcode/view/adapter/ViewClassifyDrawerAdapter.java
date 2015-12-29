package com.example.administrator.breezeallcode.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.breezeallcode.R;

import butterknife.Bind;

/**
 * Created by Administrator on 2015/12/25.
 */
public class ViewClassifyDrawerAdapter {


    public static class ViewClassifyDrawerHodler extends RecyclerView.ViewHolder {
        @Bind(R.id.text_view)
        TextView mTextView;

        public ViewClassifyDrawerHodler(View itemView) {
            super(itemView);
        }
    }
}
