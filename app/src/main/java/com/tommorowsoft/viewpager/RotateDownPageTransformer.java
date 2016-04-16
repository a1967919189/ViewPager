package com.tommorowsoft.viewpager;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by Administrator on 2016/4/16.
 */
public class RotateDownPageTransformer implements ViewPager.PageTransformer {
    private static final float MAX_ROTATE = 20f;
    private  float Rot;
    //A页0~-20,B页20~0
    @Override
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        Log.e("TAG","view="+view+",position="+position);

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
                ViewHelper.setRotation(view,0);
/**
 *A页切换到B页，A页的position0,0~-1，B页的position1~0.0
 */
        } else if (position <= 0) { // [-1,0]     A 页
            //0~-20
                Rot=position*MAX_ROTATE;
                ViewHelper.setRotationX(view,pageWidth/2);
                ViewHelper.setRotationY(view,view.getMeasuredHeight());
                ViewHelper.setRotation(view,Rot);

        } else if (position <= 1) { // (0,1]  B页
            //20~0
            Rot=position*MAX_ROTATE;
            ViewHelper.setRotationX(view,pageWidth/2);
            ViewHelper.setRotationY(view,view.getMeasuredHeight());
            ViewHelper.setRotation(view,Rot);

        } else { // (1,+Infinity]
            ViewHelper.setRotation(view,0);
        }
    }
}
