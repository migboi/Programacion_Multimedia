package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView tv2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        tv2 = findViewById(R.id.tv2);
        Intent intent= getIntent();
        Bundle bundle=intent.getBundleExtra("bundle");



        tv2.setText(bundle.getString("texto").toString());
    }

    public void anterior(){



    }
}
