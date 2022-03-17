package com.example.jwcalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentCalcButtons2 extends Fragment {

    public FragmentCalcButtons2() {
        // Required empty public constructor
    }

    public static FragmentCalcButtons2 newInstance(String param1, String param2) {
        FragmentCalcButtons2 fragment = new FragmentCalcButtons2();
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
        return inflater.inflate(R.layout.fragment_calc_buttons2, container, false);
    }
}