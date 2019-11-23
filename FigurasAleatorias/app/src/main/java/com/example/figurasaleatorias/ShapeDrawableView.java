package com.example.figurasaleatorias;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ShapeDrawableView extends View {

    private static int black=0;
    private static int blue=0;
    private static int green=0;
    private static int red=0;


    private List<ShapeDrawable> shapes = new ArrayList<ShapeDrawable>();
    private Integer[] mColors =
            { Color.BLACK, Color.BLUE, Color.GREEN, Color.RED };

    public ShapeDrawableView(Context context) {
        super(context);    }

    public ShapeDrawableView(Context context, AttributeSet attrs) {
        super(context, attrs);    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        contador(canvas);
        for(ShapeDrawable shape: shapes) {  shape.draw(canvas);  }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int)event.getX(); // Use getX(int) for multi-finger gestures
            int y = (int)event.getY();
            if (!isDeletingExistingShape(x, y)) {
                ShapeDrawable shapeDrawable=makeShapeDrawable(x,y);
                shapes.add(makeShapeDrawable(x, y));

                switch (shapeDrawable.getPaint().getColor()){

                    case Color.BLACK:
                        black++;
                        break;

                    case Color.BLUE:
                        blue++;
                        break;

                    case Color.GREEN:
                        green++;
                        break;

                    case Color.RED:
                        red++;
                        break;
                }


            }

            invalidate();
            return (true);  // Handled touch event
        } else {
            return (false); // Did not handle touch event
        }
    }

    private boolean isDeletingExistingShape(int x, int y) {
        for(ShapeDrawable shape: shapes) {
            Rect bounds = shape.getBounds();
            if (bounds.contains(x, y)) {

                switch (shape.getPaint().getColor()){
                    case Color.BLACK:

                        if(black>0){
                            black--;
                            break;
                        }else {
                            break;
                        }



                    case Color.BLUE:

                        if(blue>0){
                            blue--;
                            break;
                        }else {
                            break;
                        }



                    case Color.GREEN:
                        if(green>0){
                            blue--;
                            break;
                        }else {
                            break;
                        }




                    case Color.RED:

                        if(red>0){
                            red--;
                            break;
                        }else {
                            break;
                        }



                }




                shapes.remove(shape);
                return(true);
            }
        }
        return(false);
    }

    private ShapeDrawable makeShapeDrawable(int x, int y) {
        int maxWidth = getWidth()/10;
        int maxHeight = getHeight()/10;
        Shape shape;
        if (Math.random() < 0.5) {
            shape = new OvalShape();
        } else {
            shape = new RectShape();
        }
        ShapeDrawable shapeD = new ShapeDrawable(shape);
        int width = RandomUtils.randomInt(maxWidth)+5;
        int height = RandomUtils.randomInt(maxHeight)+5;
        shapeD.setBounds(x-width/2, y-height/2, x+width/2, y+height/2);
        shapeD.getPaint().setColor(RandomUtils.randomElement(mColors));
        return(shapeD);
    }

    private void contador(Canvas canvas){
        String datos="Figuras por colores Black: "+black+",Blue: "+blue+",Green: "+green+", red: "+red;
        Paint p=new Paint();
        p.setColor(Color.BLACK);
        p.setTextSize(42);
        canvas.drawText(datos,50,50,p);

    }
}
