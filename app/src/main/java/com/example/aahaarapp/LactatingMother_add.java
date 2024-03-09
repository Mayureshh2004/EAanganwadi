package com.example.aahaarapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LactatingMother_add extends AppCompatActivity {

    Button btn;
    MyDBHelperLactatingMother helper;
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lactating_add);
        btn=findViewById(R.id.button6);
        helper = new MyDBHelperLactatingMother(this);
        Cursor cursor = helper.readAllData();

        if (cursor.getCount() == 0) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
        else {



        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LactatingMother_register.class));
            }
        });
    }
}