package com.example.canvasentreactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }

    class MiDibujo extends View {

        public MiDibujo(Context context){
            super(context);
        }

        protected  void onDraw(Canvas canvas){



            //Ejemplo hecho en clase
            Paint pincel=new Paint();
            pincel.setColor(Color.BLACK);
            pincel.setStrokeWidth(15);
            canvas.drawCircle(200,200,150,pincel);
            canvas.drawLine(200,200,200,800,pincel);
            canvas.drawLine(200,500,600,200,pincel);



            pincel.setColor(Color.argb(185,168,155,255));
            pincel.setStrokeWidth(8);
            pincel.setStyle(Paint.Style.FILL);

            canvas.drawCircle(420,175,100,pincel);
           // canvas.drawText("hola",300,300,12,12,pincel);






        }
    }

}
