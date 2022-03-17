package com.example.jwcalculator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class VPAdapter extends FragmentStateAdapter {

    public VPAdapter(@NonNull FragmentActivity fragmentActivity)
    {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return  new FragmentCalcButtons1();
            case 1:
                return  new FragmentCalcButtons2();
            default:
                return  new FragmentCalcButtons3();
        }
    }
    @Override
    public int getItemCount() {return 3; }
}