package com.tommorowsoft.viewpager;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    private int[] ImageIds = new int[]{R.drawable.guide_image1, R.drawable.guide_image2
            , R.drawable.guide_image3};
    private ArrayList<ImageView> Images = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
//        为ViewPager设置动画效果,3.0以上系统有效
        assert viewPager != null;
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
//        viewPager.setPageTransformer(true,new DepthPageTransformer());
        viewPager.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(ImageIds[position]);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                container.addView(imageView);
                Images.add(imageView);
                return imageView;
            }


            @Override
            public int getCount() {
                return ImageIds.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(Images.get(position));
            }


        });
    }
}
