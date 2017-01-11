package com.vivien.clipimage.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.vivien.clipimage.R;

/**
 * Created by vivien on 17/1/9.
 */

public class ClipImageLayout extends RelativeLayout {

    private ClipImageBorderView mClipImageBorderView;
    private ClipZoomImageView mClipZoomImageView;

    private int mHorizontalPadding = 20;

    public ClipImageLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        mClipImageBorderView = new ClipImageBorderView(context);
        mClipZoomImageView = new ClipZoomImageView(context);

        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        mClipZoomImageView.setImageDrawable(getResources().getDrawable(R.mipmap.pic2));

        addView(mClipZoomImageView, lp);
        addView(mClipImageBorderView, lp);

        initPaddingValue();
    }

    /**
     * 对外公布的设置边距的方法，单位dp
     *
     * @param mHorizontalPadding
     */
    public void setHorizontalPadding(int mHorizontalPadding) {
        this.mHorizontalPadding = mHorizontalPadding;
        initPaddingValue();
    }

    /**
     * 计算padding的px
     */
    private void initPaddingValue() {
        // 计算padding的px
        mHorizontalPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                mHorizontalPadding, getResources().getDisplayMetrics());
        mClipZoomImageView.setHorizontalPadding(mHorizontalPadding);
        mClipImageBorderView.setHorizontalPadding(mHorizontalPadding);
    }

    /**
     * 截取图片
     *
     * @return
     */
    public Bitmap clip() {
        return mClipZoomImageView.clip();
    }
}
