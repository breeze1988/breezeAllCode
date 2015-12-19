package com.example.administrator.breezeallcode.util.ImageLoaderUtil;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.administrator.breezeallcode.util.Logger;

/**
 * Created by Administrator on 2015/12/18.
 * 完成图片压缩功能
 */
public class ImageResizer {

    private static final String TAG = "ImageResizer";

    public ImageResizer() {
    }

    public Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int requHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, requHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }


    public int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        if (reqWidth == 0 && reqHeight == 0) {
            return 1;
        }
        final int height = options.outHeight;
        final int width = options.outWidth;
        Logger.e("origin image ,w = " + " h = " + height);
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        Logger.e("inSampleSize = " + inSampleSize);
        return inSampleSize;
    }
}
