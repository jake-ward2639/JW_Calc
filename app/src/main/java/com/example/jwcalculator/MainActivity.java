package com.example.jwcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    String newSum;
    TextView currentSum;
    TextView previousSum;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.calMenu);

        bottomNavigationView.setSelectedItemId(R.id.ToCalc);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()){
                    case R.id.ToCalc:
                        startActivity(new Intent(getApplicationContext()
                                ,MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ToUC:
                        startActivity(new Intent(getApplicationContext()
                                ,UnitConverterActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ToCE:
                        startActivity(new Intent(getApplicationContext()
                        ,CurrencyExchangeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ToSettings:
                        startActivity(new Intent(getApplicationContext()
                                ,SettingsActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

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

    public void btn0Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("0");
    }
    public void btn1Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("1");
    }
    public void btn2Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("2");
    }
    public void btn3Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("3");
    }
    public void btn4Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("4");
    }
    public void btn5Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("5");
    }
    public void btn6Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("6");
    }
    public void btn7Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("7");
    }
    public void btn8Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("8");
    }
    public void btn9Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("9");
    }
    public void btnDotClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("1");
    }
    public void btnPlusClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("+");
    }
    public void btnMinusClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("-");
    }
    public void btnDivClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("\u00F7");
    }
    public void btnXClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnDelClicked(View v){
        Log.d("CheckF","ButtonClicked");
        String currentSumContent = currentSum.getText().toString();
        StringBuffer sb= new StringBuffer(currentSumContent);
        sb.deleteCharAt(sb.length()-1);
        currentSum.setText(sb);
    }
    public void btnAcClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("1");
    }
    public void btnX10XClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("1");
    }
    public void btnAnsClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("1");
    }
    public void btnEqualsClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("1");
    }
    public void btnSinClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnCosClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnTanClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnSinM1Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnCosM1Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnTanM1Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnSqRClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnPiClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnA2Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnAXClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnOBracClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnCBracClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnPerClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnRCLClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnENGClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnNCRClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
}