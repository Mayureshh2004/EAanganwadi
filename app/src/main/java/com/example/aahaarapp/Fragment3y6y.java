package com.example.aahaarapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class Fragment3y6y extends BottomSheetDialogFragment {

    private static final String TAG = "Fragment_view";
    private Button b1,b2;
    String number;
    public static Fragment_view newInstance(){
        return new Fragment_view();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        b1= view.findViewById(R.id.button1);
        b2= view.findViewById(R.id.button2);

        Bundle bundle = getArguments();
        if(bundle != null){
            number = bundle.getString("number");
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Children3Y6YNutrition.class);
                intent.putExtra("number", number);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Child_3y_6y_view.class);
                intent.putExtra("number", number);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Activity activity = getActivity();
    }
}