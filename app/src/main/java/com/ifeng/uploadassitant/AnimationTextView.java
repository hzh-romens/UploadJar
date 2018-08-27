package com.ifeng.uploadassitant;

import android.animation.ObjectAnimator;
import android.animation.PointFEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

/**
 * @author zhaogaofeng
 * @date 2018/8/24
 * @description
 */

public class AnimationTextView extends TextView {
    public AnimationTextView(Context context) {
        super(context);
        initView();
    }

    public AnimationTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public AnimationTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public AnimationTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    public void initView() {
        startInterPoilatorAnimation();
    }

    private com.ifeng.uploadassitant.Point currentPoint;

    //开启动画
    private void startInterPoilatorAnimation() {
        Point startPoint = new Point(getWidth() / 2, getHeight() / 2);
        Point endPoint = new Point(getWidth() / 2, getHeight() - 100);
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (com.ifeng.uploadassitant.Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setInterpolator(new BounceInterpolator());
        animator.setDuration(3000);
        animator.start();
    }
}
