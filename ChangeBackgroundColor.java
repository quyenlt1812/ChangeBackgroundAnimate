package dev.android.example.jobland.others;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;

/**
 * Created by quyen on 10/24/2017.
 */

public class ChangeBackgroundColor {

    private View view;
    private int fromColor, toColor;

    public ChangeBackgroundColor(Context context, View view, int fromColor, int toColor){
        this.view = view;
        this.fromColor = context.getResources().getColor(fromColor);
        this.toColor = context.getResources().getColor(toColor);
    }

    public void changeColor(){
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), fromColor, toColor);
        colorAnimation.setDuration(250); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                view.setBackgroundColor((int) animator.getAnimatedValue());
            }

        });
        colorAnimation.start();
    }

    public void revertBack(){
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), toColor, fromColor);
        colorAnimation.setDuration(250); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                view.setBackgroundColor((int) animator.getAnimatedValue());
            }

        });
        colorAnimation.start();
    }

}
