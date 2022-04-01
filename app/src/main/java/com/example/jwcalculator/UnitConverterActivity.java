package com.example.jwcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UnitConverterActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    EditText convertLengthOneEdit;
    Spinner convertLengthOneSpinner;
    EditText convertLengthTwoEdit;
    Spinner convertLengthTwoSpinner;
    EditText convertMassOneEdit;
    Spinner convertMassOneSpinner;
    EditText convertMassTwoEdit;
    Spinner convertMassTwoSpinner;
    EditText convertVolumeOneEdit;
    Spinner convertVolumeOneSpinner;
    EditText convertVolumeTwoEdit;
    Spinner convertVolumeTwoSpinner;
    Double output; //initialise all elements including conversion formulas. Bases for types are meters, kilograms and millimeters
    final double Meters = 1;final double Kilometers = 0.001;final double Centimeters = 100;final double Millimetres = 1000;final double Micrometres = 1000000;final double Nanometres = 1000000000;final double Miles = 0.000621371;final double Yards = 1.094;final double Feet = 3.281;final double Inches = 39.37008;final double NMiles = 0.000539957;
    final double Kilograms = 1;final double Tonnes =  0.001;final double Grams = 1000;final double Milligrams = 1000000;final double Micrograms =  1000000000;final double ITon = 0.000984207;final double USTon =  0.00110231;final double Stone = 0.157473;final double Pounds =  2.20462;final double Ounces =  35.274;
    final double Milliliters = 1;final double USLGallon = 3785.41;final double USLQuart = 946.353;final double USLPint = 473.176;final double USLCup = 240;final double FOunces = 29.5735;final double USTablespoon = 14.7868;final double USTeaspoon = 4.92892;final double CMeters = 1000000;final double CFeet = 28316.8;final double CInches = 16.3871;final double Liters = 1000;final double ILGallon = 4546.09;final double ILQuart = 1136.52;final double ILPint = 568.261;final double ILCup = 284.131;final double ITablespoon = 17.7582;final double ITeaspoon = 5.91939;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);

        bottomNavigationView = findViewById(R.id.calMenu);

        bottomNavigationView.setSelectedItemId(R.id.ToUC);
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

        convertLengthOneEdit = findViewById(R.id.convertLengthOneEdit);
        convertLengthOneSpinner = findViewById(R.id.convertLengthOneSpinner);
        convertLengthTwoEdit = findViewById(R.id.convertLengthTwoEdit);
        convertLengthTwoSpinner = findViewById(R.id.convertLengthTwoSpinner);
        convertMassOneEdit = findViewById(R.id.convertMassOneEdit);
        convertMassOneSpinner = findViewById(R.id.convertMassOneSpinner);
        convertMassTwoEdit = findViewById(R.id.convertMassTwoEdit);
        convertMassTwoSpinner = findViewById(R.id.convertMassTwoSpinner);
        convertVolumeOneEdit = findViewById(R.id.convertVolumeOneEdit);
        convertVolumeOneSpinner = findViewById(R.id.convertVolumeOneSpinner);
        convertVolumeTwoEdit = findViewById(R.id.convertVolumeTwoEdit);
        convertVolumeTwoSpinner = findViewById(R.id.convertVolumeTwoSpinner); //spinner setup

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.lengthArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertLengthOneSpinner.setAdapter(adapter1);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.lengthArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertLengthTwoSpinner.setAdapter(adapter2);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.massArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertMassOneSpinner.setAdapter(adapter3);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.massArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertMassTwoSpinner.setAdapter(adapter4);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.volumeArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertVolumeOneSpinner.setAdapter(adapter5);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.volumeArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertVolumeTwoSpinner.setAdapter(adapter6);

        convertLengthOneSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //listeners call corresponding conversion method
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertLength();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        convertLengthTwoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertLength();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        convertLengthOneEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                convertLength();
            }
        });
        convertMassOneSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertMass();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        convertMassTwoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertMass();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        convertMassOneEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                convertMass();
            }
        });
        convertVolumeOneSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertVolume();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        convertVolumeTwoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertVolume();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        convertVolumeOneEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                convertVolume();
            }
        });
    }

    public void convertLength(){ //conversion methods convert to and from a common unit, meters is used here
        if(convertLengthOneEdit.getText().length()!=0) {
            switch (convertLengthOneSpinner.getSelectedItem().toString()) {
                case "Meters":
                    output = Double.parseDouble(convertLengthOneEdit.getText().toString());
                    break;
                case "Kilometers":
                    output = Double.parseDouble(convertLengthOneEdit.getText().toString())/Kilometers;
                    break;
                case "Centimeters":
                    output = Double.parseDouble(convertLengthOneEdit.getText().toString())/Centimeters;
                    break;
                case "Millimetres":
                    output = Double.parseDouble(convertLengthOneEdit.getText().toString())/Millimetres;
                    break;
                case "Micrometres":
                    output = Double.parseDouble(convertLengthOneEdit.getText().toString())/Micrometres;
                    break;
                case "Nanometres":
                    output = Double.parseDouble(convertLengthOneEdit.getText().toString())/Nanometres;
                    break;
                case "Miles":
                    output = Double.parseDouble(convertLengthOneEdit.getText().toString())/Miles;
                    break;
                case "Yards":
                    output = Double.parseDouble(convertLengthOneEdit.getText().toString())/Yards;
                    break;
                case "Feet":
                    output = Double.parseDouble(convertLengthOneEdit.getText().toString())/Feet;
                    break;
                case "Inches":
                    output = Double.parseDouble(convertLengthOneEdit.getText().toString())/Inches;
                    break;
                case "Nautical Miles":
                    output = Double.parseDouble(convertLengthOneEdit.getText().toString())/NMiles;
                    break;
            }

            switch (convertLengthTwoSpinner.getSelectedItem().toString()) {
                case "Meters":
                    break;
                case "Kilometres":
                    output = output * Kilometers;
                    break;
                case "Centimeters":
                    output = output * Centimeters;
                    break;
                case "Millimetres":
                    output = output * Millimetres;
                    break;
                case "Micrometres":
                    output = output * Micrometres;
                    break;
                case "Nanometres":
                    output = output * Nanometres;
                    break;
                case "Miles":
                    output = output * Miles;
                    break;
                case "Yards":
                    output = output * Yards;
                    break;
                case "Feet":
                    output = output * Feet;
                    break;
                case "Inches":
                    output = output * Inches;
                    break;
                case "Nautical Miles":
                    output = output * NMiles;
                    break;
            }

            convertLengthTwoEdit.setText(String.valueOf(output));
        }
    }

    public void convertMass(){
        if(convertMassOneEdit.getText().length()!=0) {
            switch (convertMassOneSpinner.getSelectedItem().toString()) {
                case "Kilograms":
                    output = Double.parseDouble(convertMassOneEdit.getText().toString());
                    break;
                case "Tonnes":
                    output = Double.parseDouble(convertMassOneEdit.getText().toString())/Tonnes;
                    break;
                case "Grams":
                    output = Double.parseDouble(convertMassOneEdit.getText().toString())/Grams;
                    break;
                case "Milligrams":
                    output = Double.parseDouble(convertMassOneEdit.getText().toString())/Milligrams;
                    break;
                case "Micrograms":
                    output = Double.parseDouble(convertMassOneEdit.getText().toString())/Micrograms;
                    break;
                case "Imperial Ton":
                    output = Double.parseDouble(convertMassOneEdit.getText().toString())/ITon;
                    break;
                case "US Ton":
                    output = Double.parseDouble(convertMassOneEdit.getText().toString())/USTon;
                    break;
                case "Stone":
                    output = Double.parseDouble(convertMassOneEdit.getText().toString())/Stone;
                    break;
                case "Pounds":
                    output = Double.parseDouble(convertMassOneEdit.getText().toString())/Pounds;
                    break;
                case "Ounces":
                    output = Double.parseDouble(convertMassOneEdit.getText().toString())/Ounces;
                    break;
            }

            switch (convertMassTwoSpinner.getSelectedItem().toString()) {
                case "Kilograms":
                    break;
                case "Tonnes":
                    output = output * Tonnes;
                    break;
                case "Grams":
                    output = output * Grams;
                    break;
                case "Milligrams":
                    output = output * Milligrams;
                    break;
                case "Micrograms":
                    output = output * Micrograms;
                    break;
                case "Imperial Ton":
                    output = output * ITon;
                    break;
                case "US Ton":
                    output = output * USTon;
                    break;
                case "Stone":
                    output = output * Stone;
                    break;
                case "Pounds":
                    output = output * Pounds;
                    break;
                case "Ounces":
                    output = output * Ounces;
                    break;
            }

            convertMassTwoEdit.setText(String.valueOf(output));
        }
    }

    public void convertVolume(){
        if(convertVolumeOneEdit.getText().length()!=0) {
            switch (convertVolumeOneSpinner.getSelectedItem().toString()) {
                case "Milliliters":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString());
                    break;
                case "US Liquid Gallon":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/USLGallon;
                    break;
                case "US Liquid Quart":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/USLQuart;
                    break;
                case "US Liquid Pint":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/USLPint;
                    break;
                case "US Liquid Cup":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/USLCup;
                    break;
                case "Fluid Ounces":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/FOunces;
                    break;
                case "US TableSpoon":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/USTablespoon;
                    break;
                case "US TeaSpoon":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/USTeaspoon;
                    break;
                case "Cubic Meters":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/CMeters;
                    break;
                case "Cubic Feet":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/CFeet;
                    break;
                case "Cubic Inches":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/CInches;
                    break;
                case "Liters":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/Liters;
                    break;
                case "Imperial Liquid Gallon":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/ILGallon;
                    break;
                case "Imperial Liquid Quart":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/ILQuart;
                    break;
                case "Imperial Liquid Pint":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/ILPint;
                    break;
                case "Imperial Liquid Cup":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/ILCup;
                    break;
                case "Imperial TableSpoon":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/ITablespoon;
                    break;
                case "Imperial TeaSpoon":
                    output = Double.parseDouble(convertVolumeOneEdit.getText().toString())/ITeaspoon;
                    break;
            }

            switch (convertVolumeTwoSpinner.getSelectedItem().toString()) {
                case "Milliliters":
                    break;
                case "US Liquid Gallon":
                    output = output * USLGallon;
                    break;
                case "US Liquid Quart":
                    output = output * USLQuart;
                    break;
                case "US Liquid Pint":
                    output = output * USLPint;
                    break;
                case "US Liquid Cup":
                    output = output * USLCup;
                    break;
                case "Fluid Ounces":
                    output = output * FOunces;
                    break;
                case "US TableSpoon":
                    output = output * USTablespoon;
                    break;
                case "US TeaSpoon":
                    output = output * USTeaspoon;
                    break;
                case "Cubic Meters":
                    output = output * CMeters;
                    break;
                case "Cubic Feet":
                    output = output * CFeet;
                    break;
                case "Cubic Inches":
                    output = output * CInches;
                    break;
                case "Liters":
                    output = output * Liters;
                    break;
                case "Imperial Liquid Gallon":
                    output = output * ILGallon;
                    break;
                case "Imperial Liquid Quart":
                    output = output * ILQuart;
                    break;
                case "Imperial Liquid Pint":
                    output = output * ILPint;
                    break;
                case "Imperial Liquid Cup":
                    output = output * ILCup;
                    break;
                case "Imperial TableSpoon":
                    output = output * ITablespoon;
                    break;
                case "Imperial TeaSpoon":
                    output = output * ITeaspoon;
                    break;
            }

            convertVolumeTwoEdit.setText(String.valueOf(output));
        }
    }
}