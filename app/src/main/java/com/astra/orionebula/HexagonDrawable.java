package com.astra.orionebula;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.FloatMath;

/**
 * Created by Seby on 13/02/2016.
 */
public class HexagonDrawable extends Drawable {

    public static final int SIDES = 6;
    private Path hexagon = new Path();
    private Path temporal = new Path();
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public HexagonDrawable(int color) {
        paint.setColor(color);
        hexagon.setFillType(Path.FillType.EVEN_ODD);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawPath(hexagon, paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        paint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return paint.getAlpha();
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        computeHex(bounds);
        invalidateSelf();
    }

    public void computeHex(Rect bounds) {

        final int width = bounds.width();
        final int height = bounds.height();
        final int size = Math.min(width, height);
        final int centerX = bounds.left + (width / 2);
        final int centerY = bounds.top + (height / 2);

        hexagon.reset();
        hexagon.addPath(createHexagon(size, centerX, centerY));
        hexagon.addPath(createHexagon((int) (size * .8f), centerX, centerY));
    }

    private Path createHexagon(int size, int centerX, int centerY) {
        final float section = (float) (2.0 * Math.PI / SIDES);
        int radius = size / 2;
        Path hex = temporal;
        hex.reset();
        hex.moveTo(
                (float)(centerX + radius * Math.cos(0)),
                (float)(centerY + radius * Math.sin(0)));

        for (int i = 1; i < SIDES; i++) {
            hex.lineTo(
                    (float)(centerX + radius * Math.cos(section * i)),
                    (float)(centerY + radius * Math.sin(section * i)));
        }

        hex.close();
        return hex;
    }
}