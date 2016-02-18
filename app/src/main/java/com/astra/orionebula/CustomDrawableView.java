package com.astra.orionebula;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

/**
 * Created by Seby on 12/02/2016.
 */
public class CustomDrawableView extends View {
    private HexagonDrawable mDrawable;

    public CustomDrawableView(Context context) {
        super(context);

        int x = 10;
        int y = 10;
        int width = 300;
        int height = 50;

        mDrawable = new HexagonDrawable(0xff74AC23);
        mDrawable.computeHex(new Rect(100,200, 500, 500));
    }

    protected void onDraw(Canvas canvas) {
        mDrawable.draw(canvas);
    }
}
