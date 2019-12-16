package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView detalles;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        detalles=findViewById(R.id.textView);

        detalles.setText(getIntent().getStringExtra("dato"));
        imagen=findViewById(R.id.imageView);

        String num=getIntent().getStringExtra("nume");
        int op=Integer.parseInt(num);

        switch (op){

            case 0:
                imagen.setImageResource(R.drawable.ic_india);
                break;
            case 1:
                imagen.setImageResource(R.drawable.ic_china);
                break;
            case 2:
                imagen.setImageResource(R.drawable.ic_usa);
                break;
            case 3:
                imagen.setImageResource(R.drawable.ic_germay);
                break;
            case 4:
                imagen.setImageResource(R.drawable.ic_sapin);
                break;
            case 5:
                imagen.setImageResource(R.drawable.ic_urs);
                break;
        }
    }
}
