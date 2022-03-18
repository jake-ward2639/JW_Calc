package com.example.jwcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    String readableSum;
    TextView interpretedSum;
    TextView previousSum;
    BottomNavigationView bottomNavigationView;
    Boolean AXMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.calMenu);

        bottomNavigationView.setSelectedItemId(R.id.ToCalc);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
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
        });

        tabLayout = findViewById(R.id.calTabLayout);
        viewPager = findViewById(R.id.calcViewPager);

        VPAdapter vpAdapter = new VPAdapter(this);
        viewPager.setAdapter(vpAdapter);

        String[] tabTitles = {"Calc","Func","History"};

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(tabTitles[position])).attach();

        //get outputs
        interpretedSum = findViewById(R.id.calcOutput1);
        previousSum = findViewById(R.id.calcOutput2);
        readableSum = "0";

        AXMode = false;
    }

    public boolean UpdateSum(String newSum){
        if (AXMode){
            switch (newSum){
                case "0": AXMode = false;deleteLastChar();UpdateSum("\u2070");UpdateSum("\u25AB");AXMode = true;break;
                case "1": AXMode = false;deleteLastChar();UpdateSum("\u00B9");UpdateSum("\u25AB");AXMode = true;break;
                case "2": AXMode = false;deleteLastChar();UpdateSum("\u00B2");UpdateSum("\u25AB");AXMode = true;break;
                case "3": AXMode = false;deleteLastChar();UpdateSum("\u00B3");UpdateSum("\u25AB");AXMode = true;break;
                case "4": AXMode = false;deleteLastChar();UpdateSum("\u2074");UpdateSum("\u25AB");AXMode = true;break;
                case "5": AXMode = false;deleteLastChar();UpdateSum("\u2075");UpdateSum("\u25AB");AXMode = true;break;
                case "6": AXMode = false;deleteLastChar();UpdateSum("\u2076");UpdateSum("\u25AB");AXMode = true;break;
                case "7": AXMode = false;deleteLastChar();UpdateSum("\u2077");UpdateSum("\u25AB");AXMode = true;break;
                case "8": AXMode = false;deleteLastChar();UpdateSum("\u2078");UpdateSum("\u25AB");AXMode = true;break;
                case "9": AXMode = false;deleteLastChar();UpdateSum("\u2079");UpdateSum("\u25AB");AXMode = true;break;
                case "+": AXMode = false;deleteLastChar();UpdateSum("+");break;
                case "-": AXMode = false;deleteLastChar();UpdateSum("-");break;
                case "X": AXMode = false;deleteLastChar();UpdateSum("*");break;
                case "\u00F7": AXMode = false;deleteLastChar();UpdateSum("\\");break;
            }
            return true;
        }
        if (readableSum.equals("0")){readableSum="";}
        readableSum = readableSum + newSum;
        InterpretSum(readableSum);
        return true;
    }

    public void InterpretSum(String readingSum){
        StringBuilder readSum = new StringBuilder();
        for (int i = 0; i < readingSum.length(); i++){
            char currentChar = readingSum.charAt(i);
            switch (currentChar){
                case 'S':
                    readSum.append("SIN");break;
                case 'C':
                    readSum.append("COS");break;
                case 'T':
                    readSum.append("TAN");break;
                case 's':
                    readSum.append("SIN-1");break;
                case 'c':
                    readSum.append("COS-1");break;
                case 't':
                    readSum.append("TAN-1");break;
                case '\\':
                    readSum.append("\u00F7");break;
                case '*':
                    readSum.append("x");break;
                default: readSum.append(readingSum.charAt(i));
            }
        }
        interpretedSum.setText(readSum.toString());
    }

    public boolean deleteLastChar(){
        if(readableSum.equals("0")){
            return true;
        }
        Log.d("CheckF","ButtonClicked");
        StringBuffer sb= new StringBuffer(readableSum);
        readableSum = String.valueOf(sb.deleteCharAt(sb.length()-1));
        if(readableSum.equals("")){
            readableSum = "0";
        }
        InterpretSum(readableSum);
        return true;
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
        UpdateSum(".");
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
        UpdateSum("\\");
    }
    public void btnXClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("*");
    }
    public void btnDelClicked(View v){
        deleteLastChar();
        if(AXMode){AXMode=false;}
    }
    public void btnAcClicked(View v){
        readableSum = "0";
        interpretedSum.setText(readableSum);
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
        UpdateSum("S");
    }
    public void btnCosClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("C");
    }
    public void btnTanClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("T");
    }
    public void btnSinM1Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("s");
    }
    public void btnCosM1Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("c");
    }
    public void btnTanM1Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("t");
    }
    public void btnSqRClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("\u221a");
    }
    public void btnPiClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("\u03c0");
    }
    public void btnA2Clicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("\u00B2");
    }
    public void btnAXClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("\u25AB");
        AXMode = true;
    }
    public void btnOBracClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("(");
    }
    public void btnCBracClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum(")");
    }
    public void btnPerClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("\u0025");
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