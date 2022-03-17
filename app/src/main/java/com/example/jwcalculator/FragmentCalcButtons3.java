package com.example.jwcalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentCalcButtons3 extends Fragment {

    public FragmentCalcButtons3() {
        // Required empty public constructor
    }

    public static FragmentCalcButtons3 newInstance(String param1, String param2) {
        FragmentCalcButtons3 fragment = new FragmentCalcButtons3();
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
        return inflater.inflate(R.layout.fragment_calc_buttons3, container, false);
    }
}