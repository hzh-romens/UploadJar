package com.ifeng.uploadassitant;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ifeng.uploadassitant.media.entity.Album;
import com.ifeng.uploadassitant.media.ui.AlbumActivity;
import com.ifeng.uploadassitant.media.ui.VedioActivity;

/**
 * @author zhaogaofeng
 * @date 2018/8/22
 * @description
 */

public class PublishDialog extends Dialog implements View.OnClickListener {
    public PublishDialog(@NonNull Context context) {
        super(context, R.style.MyDialogTheme);
    }

    public PublishDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected PublishDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    private LinearLayout publishLayout;
    private TextView article, media;
    private ImageView close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_publish);
        publishLayout = findViewById(R.id.publishLayout);
        article = findViewById(R.id.article);
        media = findViewById(R.id.media);
        close = findViewById(R.id.close);
        startAnimation();
        close.setOnClickListener(this);
        article.setOnClickListener(this);
        media.setOnClickListener(this);
    }

    //开启动画
    private void startAnimation() {
        //ValueAnimator animator = ValueAnimator.ofFloat(publishLayout, "translationX", 0f, -300f, 0f).;
        //animator.setDuration(2000);
        //animator.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.article:
                Intent intent=new Intent(getContext(), AlbumActivity.class);
                getContext().startActivity(intent);
                break;
            case R.id.media:
                Intent intent2=new Intent(getContext(), VedioActivity.class);
                getContext().startActivity(intent2);
                break;
            case R.id.close:
                this.dismiss();
                break;
        }
    }

//    public class PointEvaluator implements TypeEvaluator {
//
//        @Override
//        public Object evaluate(float fraction, Object startValue, Object endValue) {
//            // 将动画初始值startValue 和 动画结束值endValue 强制类型转换成Point对象
//            Point startPoint = (Point) startValue;
//            Point endPoint = (Point) endValue;
//
//            // 根据fraction来计算当前动画的x和y的值
//            // float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
//            // float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
//
//            // 将计算后的坐标封装到一个新的Point对象中并返回
//            //Point point = new Point(x, y);
//            //return point;
//            return null;
//        }
//    }
}
