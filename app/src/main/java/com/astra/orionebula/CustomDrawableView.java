package com.astra.orionebula;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seby on 12/02/2016.
 */
public class CustomDrawableView extends View {
    private HexagonDrawable mDrawable;
    private List<Drawable> drawableList = new ArrayList<>();

    public CustomDrawableView(Context context) {
        super(context);
        mDrawable = new HexagonDrawable(0xff74AC23);
        mDrawable.computeHex(new Rect(200, 200, 500, 500));
        drawableList.add(mDrawable);
    }

    protected void onDraw(Canvas canvas) {
        Paint myPaint = new Paint();
//        myPaint.setColor(Color.rgb(50, 47, 100));
//        myPaint.setStrokeWidth(10);
//        canvas.drawRect(mDrawable.getBounds(), myPaint);
//        mDrawable.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                //Non so per quale motivo ma sto return bisogna metterlo
                return true;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP: {
                for (Drawable current : drawableList) {

                    if(current instanceof HexagonDrawable){
                        Rect rect = current.getBounds();
                        if (rect.contains((int)eventX, (int)eventY)) {
                            System.out.println("Touched Rectangle, start activity.");

                        }
                    }

                }
                break;
            }
            default:
                return false;
        }
        return super.onTouchEvent(event);
    }
}
