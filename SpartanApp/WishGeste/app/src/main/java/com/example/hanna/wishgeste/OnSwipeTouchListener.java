package com.example.hanna.wishgeste;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;


public class OnSwipeTouchListener implements OnTouchListener {

    private final GestureDetector gestureDetector;
    private View view;
    private Context context;

    public OnSwipeTouchListener (Context ctx){
        context = ctx;
        gestureDetector = new GestureDetector(ctx, new GestureListener());
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        view = v;
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                        result = true;
                    }
                }
                else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeBottom();
                    } else {
                        onSwipeTop();
                    }
                    result = true;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    public void onSwipeRight() {
        Log.e("Swipe", "left");
        Drawable image = context.getResources().getDrawable(R.drawable.candle1);
        view.setBackground(image);

        View parent = (View) view.getParent();
        Integer color = ContextCompat.getColor(context, R.color.yellow);
        parent.setBackgroundColor(color);

    }

    public void onSwipeLeft() {
        Log.e("Swipe", "right");
        Drawable image = context.getResources().getDrawable(R.drawable.candle0);
        view.setBackground(image);

        View parent = (View) view.getParent();
        Integer color = ContextCompat.getColor(context, R.color.grey);
        parent.setBackgroundColor(color);

    }

    public void onSwipeTop() {
    }

    public void onSwipeBottom() {
    }
}