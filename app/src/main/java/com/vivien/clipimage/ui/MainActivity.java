package com.vivien.clipimage.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vivien.clipimage.R;
import com.vivien.clipimage.view.ClipImageLayout;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private ClipImageLayout mClipImageLayout;
    private TextView mClipTv;
    private ImageView mShowImgIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClipImageLayout = (ClipImageLayout) findViewById(R.id.clip_image_layout);
        mClipImageLayout.setHorizontalPadding(40);

        mClipTv = (TextView) findViewById(R.id.clip_click);
        mClipTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClipTv.getText().equals("裁剪")) {
                    onClip();
                    mClipTv.setText("返回");
                    mShowImgIv.setVisibility(View.VISIBLE);
                    mClipImageLayout.setVisibility(View.GONE);
                } else {
                    mClipTv.setText("裁剪");
                    mShowImgIv.setVisibility(View.GONE);
                    mClipImageLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        mShowImgIv = (ImageView) findViewById(R.id.show_img);
    }

    private void onClip() {
        Bitmap bitmap = mClipImageLayout.clip();
        mShowImgIv.setImageBitmap(bitmap);
    }

    private void onClip2() {
        Bitmap bitmap = mClipImageLayout.clip();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] datas = baos.toByteArray();

        Intent intent = new Intent(MainActivity.this, ShowImageActivity.class);
        intent.putExtra("bitmap", datas);
        startActivity(intent);
    }
}
