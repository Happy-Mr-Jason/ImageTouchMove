package com.example.imagetouchmove;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

public class MyGraphicView extends View {

    static float startPosX, startPosY;
    private float myPosX, myPosY;
    public static final int BUTTON_COLOR_BLUE = 0;
    public static final int BUTTON_COLOR_RED = 1;
    public static final int BUTTON_COLOR_GREEN = 2;
    public static final int BUTTON_COLOR_YELLOW = 3;
    private float startX;
    private float startY;
    private int buttonColor;
    private float touchStartPosX;
    private float touchStartPosY;
    private float touchMoveX;
    private float touchMoveY;
    private int imgId;
    private float width;
    private float height;
    private float touchStartOffsetX;
    private float touchStartOffsetY;

    public MyGraphicView(Context context, int buttonColor) {
        super(context);
        this.buttonColor = buttonColor;
        myPosX = startPosX;
        myPosY = startPosY;
        startPosX += 100;
        startPosY += 100;
        Log.i("Init_Position", startPosX + " " + startPosY);
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        startX = this.getX() + touchMoveX;
        startY = this.getY() + touchMoveY;
        Log.i("button_Position", getX() + " " + getY());
        switch (buttonColor) {
            case BUTTON_COLOR_BLUE:
                imgId = R.drawable.blue;
                break;
            case BUTTON_COLOR_RED:
                imgId = R.drawable.red;
                break;
            case BUTTON_COLOR_GREEN:
                imgId = R.drawable.green;
                break;
            case BUTTON_COLOR_YELLOW:
                imgId = R.drawable.yellow;
                break;
        }

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgId);
        int picX = (getWidth() - bitmap.getWidth()) / 2;
        int picY = (getHeight() - bitmap.getHeight()) / 2;
        myPosX = touchMoveX;
        myPosY = touchMoveY;

        canvas.translate(myPosX, myPosY);
        Log.i("Start_Positon", myPosX + " " + myPosY);
        canvas.drawBitmap(bitmap, 0, 0, null);

        bitmap.recycle();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (isPointInBitmap(event.getX(), event.getY())) {
                    touchStartPosX = event.getX();
                    touchStartPosY = event.getY();
                    touchStartOffsetX = getX();
                    touchStartOffsetY = getY();
                    Log.i("Touch_Position_down", event.getX() + " " + event.getY());
                }
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                touchMoveX = event.getX() - touchStartPosX + touchStartOffsetX;
                touchMoveY = event.getY() - touchStartPosY + touchStartOffsetY;
                Log.i("Touch_Position_move", event.getX() + " " + event.getY());
                Log.i("TouchMovePosition_move", touchMoveX + " " + touchMoveY);
                this.invalidate();

                break;
        }

        return true;
    }

    private boolean isPointInBitmap(float pointX, float pointY) {
        float startPosX = this.getX();
        float endPosX = this.getX() + this.getWidth();
        float startPosY = this.getY();
        float endPosY = this.getY() + this.getHeight();
        if (startPosX <= pointX && pointX <= endPosX && startPosY <= pointY && pointY <= endPosY) {
            return true;
        } else {
            return false;
        }
    }
}
