package com.astra.orionebula;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends Activity {

    CustomDrawableView mCustomDrawableView;

//    LinearLayout mLinearLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a LinearLayout in which to add the ImageView
//        mLinearLayout = new LinearLayout(this);


//        HexagonDrawable myImage = new HexagonDrawable(60000);
//        myImage.computeHex(new Rect(10, 10, 30, 40));
        // Instantiate an ImageView and define its properties
//        ImageView i = new ImageView(this);
        //i.setImageDrawable(myImage);
//        i.setAdjustViewBounds(true); // set the ImageView bounds to match the Drawable's dimensions
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        i.setLayoutParams(layoutParams);

        // Add the ImageView to the layout and set the layout as the content view
 //       mLinearLayout.addView(i);
        mCustomDrawableView = new CustomDrawableView(this);

        setContentView(mCustomDrawableView);

    }



   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        mCustomDrawableView = new CustomDrawableView(this);

        setContentView(mCustomDrawableView);
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
