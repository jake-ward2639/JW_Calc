package com.example.jwcalculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;

public class FragmentCalcButtons1 extends Fragment {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPlus, btnMinus, btnDiv, btnX, btnDel, btnAC, btnDot, btnX10X, btnAns, btnEquals;
    onMessageReadListener messageReadListener;

    public interface onMessageReadListener{
        public void onMessageRead(String message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calc_buttons1, container, false);
        btn1 = (Button) view.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CheckF","ButtonClicked");
                messageReadListener.onMessageRead("1");
                btn1.setText("hell0");
            }
        });

        // Inflate the layout for this fragment
        Log.d("CheckF","Fragment1 Created");
        return inflater.inflate(R.layout.fragment_calc_buttons1, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        Log.d("CheckF","Fragment1 Attached");
        try {
            messageReadListener = (onMessageReadListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" must implement onMessageRead");
        }
    }

}