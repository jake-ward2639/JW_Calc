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

    public FragmentCalcButtons1() {
        // Required empty public constructor
    }

    public static FragmentCalcButtons1 newInstance(String param1, String param2) {
        FragmentCalcButtons1 fragment = new FragmentCalcButtons1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        Log.d("CheckF","Fragment1 Created");
        return inflater.inflate(R.layout.fragment_calc_buttons1, container, false);
    }

}