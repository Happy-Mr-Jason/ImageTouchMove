package com.example.imagetouchmove;

import android.view.MotionEvent;
import android.view.View;

public class MyTouchListener implements View.OnTouchListener {
    private float startPositionY;
    private float startPositionX;
    private float startEventPosX;
    private float startEventPosY;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startEventPosX = event.getX();
                startEventPosY = event.getY();
                startPositionX = v.getX();
                startPositionY = v.getY();
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                v.setX(startPositionX + event.getX() - startEventPosX);
                v.setY(startPositionY + event.getY() - startEventPosY);
                break;
        }
        return true;
    }
}