package com.limxing.xlistview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.limxing.xlistview.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by limxing on 16/1/7.
 */
public class LoadView extends ImageView {
    private float degrees = 0f;
    private Matrix max;
    private int width;
    private int height;
    private MyRunable runnable;

    public LoadView(Context context) {
        super(context);
        init();
    }

    public LoadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setScaleType(ScaleType.MATRIX);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.loading);
        setImageBitmap(bitmap);
        max = new Matrix();
        width = bitmap.getWidth() / 2;
        height = bitmap.getHeight() / 2;

        runnable = new MyRunable();
        postDelayed(runnable, 80);


    }

    class MyRunable implements Runnable {
        @Override
        public void run() {
            degrees += 30f;
            max.setRotate(degrees, width, height);
            setImageMatrix(max);
            if (degrees == 360) {
                degrees = 0;
            }
            postDelayed(runnable, 80);
        }
    }
}