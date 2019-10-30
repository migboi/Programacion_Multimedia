package com.example.dibujo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }

   class MiDibujo extends View {

           public MiDibujo(Context context){
               super(context);
           }

           protected  void onDraw(Canvas lienzo){

               Paint pincel=new Paint();
               pincel.setColor(Color.BLACK);
               pincel.setStrokeWidth(15);
               lienzo.drawCircle(200,200,150,pincel);
               lienzo.drawLine(200,200,200,800,pincel);
               lienzo.drawLine(200,500,600,200,pincel);





           }
    }





}
