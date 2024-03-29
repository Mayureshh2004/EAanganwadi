package com.example.aahaarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Children6M3YNutrition extends AppCompatActivity {
    CheckBox FalicAcid1,Iron1,Vitamin1,Calcium1,allopath,homopathy,ayush;
    EditText height,weight,fat,hemoglobin;
    RadioGroup radio;
    RadioButton r;
    Button btn;
    MyDBHelper6m3y helper;
    String nurtrition="",service="";
    String item;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.children_6m_3y_nutrition);
        helper = new MyDBHelper6m3y(this);

        String value = getIntent().getStringExtra("number");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        FalicAcid1 = findViewById(R.id.FalicAcid1);
        Iron1 = findViewById(R.id.Iron1);
        Vitamin1 = findViewById(R.id.Vitamin1);
        Calcium1 = findViewById(R.id.Calcium1);

        allopath = findViewById(R.id.allopath);
        homopathy = findViewById(R.id.homopathy);
        ayush = findViewById(R.id.ayush);

        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        fat = findViewById(R.id.fat);
        hemoglobin = findViewById(R.id.hemoglobin);


        if(FalicAcid1.isSelected())
        {
            nurtrition=nurtrition+","+(FalicAcid1.getText().toString());
        }
        if(Iron1.isSelected())
        {
            nurtrition=nurtrition+","+(Iron1.getText().toString());
        }
        if(Vitamin1.isSelected())
        {
            nurtrition=nurtrition+","+(Vitamin1.getText().toString());
        }
        if(Calcium1.isSelected())
        {
            nurtrition=nurtrition+","+(Calcium1.getText().toString());
        }

        if(allopath.isSelected())
        {
            service=service+","+(allopath.getText().toString());
        }
        if(homopathy.isSelected())
        {
            service=service+","+(homopathy.getText().toString());
        }
        if (ayush.isSelected())
        {
            service=service+","+(ayush.getText().toString());
        }

        radio = findViewById(R.id.radioheight);

        btn = findViewById(R.id.submitI);



        String[] vaccin = getResources().getStringArray(R.array.Vaccination);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.dropdown_menu, vaccin);
        AutoCompleteTextView autocompleteTV = findViewById(R.id.autoCompleteTextView);
        autocompleteTV.setAdapter(arrayAdapter);

        autocompleteTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Children6M3YNutrition.this, "item: "+item, Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightn = height.getText().toString();
                String weightn = weight.getText().toString();
                String fatn = fat.getText().toString();
                String hemoglobinn = hemoglobin.getText().toString();

                // Retrieve the selected RadioButton text
                // inside the OnClickListener
                int selectedId = radio.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    r = findViewById(selectedId);
                    String radion = r.getText().toString();

                    helper.updateColumns(value,nurtrition,heightn,weightn,fatn,radion,hemoglobinn,service,item);
                    Toast.makeText(Children6M3YNutrition.this, "Data Saved Successfully"+value, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Children6M3YAdd.class);
                    startActivity(intent);
                } else {
                    // Handle the case where no RadioButton is selected
                    Toast.makeText(Children6M3YNutrition.this, "Please Select ALl the Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
