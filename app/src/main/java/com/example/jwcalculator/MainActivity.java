package com.example.jwcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

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
                case "\u00F7": AXMode = false;deleteLastChar();UpdateSum("/");break;
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
                case '/':
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
        UpdateSum("/");
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
        previousSum.setText(readableSum);
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
        String total;
        try {
            total = Double.toString(eval(readableSum));
        } catch (Exception e) {
            e.printStackTrace();
            total = "Error";
        }
        if (total.endsWith(".0")){
            total = total.substring(0,total.length()-2);
        }
        previousSum.setText(interpretedSum.getText());
        readableSum=total;
        interpretedSum.setText(total);
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
    public void btnInClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnLogClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public void btnEXPClicked(View v){
        Log.d("CheckF","ButtonClicked");
        UpdateSum("X");
    }
    public static double eval(final String input) {
        return new Object() {
            int pos = -1, ch;
            String str = input;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;//move onto next character until done
                Log.d("CheckF", String.valueOf(ch));
            }

            boolean use(int charToUse) {
                while (ch == ' ') nextChar();//check if blank, if so move on
                if (ch == charToUse) { //check if the same as parameter, if so move on otherwise return false
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                for (int i = 0; i < str.length(); i++){ //check for pi, if so replace with pi as number and operators
                    if (str.charAt(i) == '\u03c0'){
                        String constructPI = "3.141592654";
                        if (!(i == 0)){
                            if ((str.charAt(i-1) >= '0' && str.charAt(i-1) <= '9') || ch == '\u03c0'){
                                constructPI = "*"+constructPI;
                            }
                        }
                        if (!(i == str.length()-1)){
                            if ((str.charAt(i + 1) >= '0' && str.charAt(i+1) <= '9') || ch == '\u03c0') {
                                constructPI = constructPI+"*";
                            }
                        }
                        str = str.substring(0,i)+constructPI+str.substring(i+1,str.length());
                    }
                    //add a check for percentage
                }

                nextChar();//start moving through sum
                double x = parseExpression();//recursive calls start
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;//return total
            }

            double parseExpression() {//check if + or -
                double x = parseTerm();
                for (;;) {
                    if      (use('+')) x += parseTerm();
                    else if (use('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {//check if times or divide
                double x = parseFactor();
                for (;;) {
                    if      (use('*')) x *= parseFactor();
                    else if (use('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (use('+')) return +parseFactor(); //Positive or negative
                if (use('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if (use('(')) { // check for parentheses
                    x = parseExpression();
                    if (!use(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // check if numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                    if (ch == '\u2070' ||ch == '\u00B9' ||ch == '\u00B2' ||ch == '\u00B3' ||ch == '\u2074' ||ch == '\u2075' ||ch == '\u2076' ||ch == '\u2077' ||ch == '\u2078' ||ch == '\u2079') {//powers
                        String powNum = ""; //check if powers
                        while (ch == '\u2070' ||ch == '\u00B9' ||ch == '\u00B2' ||ch == '\u00B3' ||ch == '\u2074' ||ch == '\u2075' ||ch == '\u2076' ||ch == '\u2077' ||ch == '\u2078' ||ch == '\u2079'){
                            switch (ch){
                                case '\u2070':powNum = powNum + "0";break;
                                case '\u00B9':powNum = powNum + "1";break;
                                case '\u00B2':powNum = powNum + "2";break;
                                case '\u00B3':powNum = powNum + "3";break;
                                case '\u2074':powNum = powNum + "4";break;
                                case '\u2075':powNum = powNum + "5";break;
                                case '\u2076':powNum = powNum + "6";break;
                                case '\u2077':powNum = powNum + "7";break;
                                case '\u2078':powNum = powNum + "8";break;
                                case '\u2079':powNum = powNum + "9";break;
                            }
                            nextChar();
                        }
                        Log.d("CheckF", String.valueOf(x));
                        Log.d("CheckF",powNum);
                        Log.d("CheckF", String.valueOf(Double.parseDouble(powNum)));
                        x = Math.pow(x, Double.parseDouble(powNum));
                        Log.d("CheckF", String.valueOf(x));
                    }
                } else if ((ch >= 'a' && ch <= 'z') || ch == '\u221a' || (ch >= 'A' && ch <= 'Z')) { // check if function
                    nextChar(); //base had a while loop to distinguish functions but im only using single characters
                    String function = str.substring(startPos, this.pos);
                    if (use('(')) {
                        x = parseExpression();
                        if (!use(')')) throw new RuntimeException("Missing ')' after argument to " + function);
                    } else {
                        x = parseFactor();
                    }
                    switch (function) {
                        case "\u221a":
                            x = Math.sqrt(x);
                            break;
                        case "S":
                            x = Math.sin(Math.toRadians(x));
                            break;
                        case "C":
                            x = Math.cos(Math.toRadians(x));
                            break;
                        case "T":
                            x = Math.tan(Math.toRadians(x));
                            break;
                        case "s":
                            x = Math.asin(Math.toRadians(x));
                            break;
                        case "c":
                            x = Math.acos(Math.toRadians(x));
                            break;
                        case "t":
                            x = Math.atan(Math.toRadians(x));
                            break;
                        default:
                            throw new RuntimeException("Unknown function: " + function);
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                return x;
            }
        }.parse();
    }
}