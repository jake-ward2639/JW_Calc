package com.example.jwcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    String newSum;
    TextView currentSum;
    TextView previousSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.calTabLayout);
        viewPager = findViewById(R.id.calcViewPager);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new FragmentCalcButtons1(), "Calc");
        vpAdapter.addFragment(new FragmentCalcButtons2(), "Func");
        vpAdapter.addFragment(new FragmentCalcButtons3(), "History");
        viewPager.setAdapter(vpAdapter);

        //get outputs
        currentSum = (TextView)findViewById(R.id.calcOutput1);
        previousSum = (TextView)findViewById(R.id.calcOutput2);
    }

    public void UpdateSum(String newSum){
        String currentSumContent = currentSum.getText().toString();
        if (currentSumContent.equals("0")){currentSumContent="";}
        currentSum.setText(currentSumContent + newSum);
    }

    public void btn1Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("1");
    }
}