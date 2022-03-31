package com.example.jwcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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
    Double output;
    final double Meters = 1;final double Kilometers = 0.001;final double Centimeters = 100;final double Millimetres = 1000;final double Micrometres = 1000000;final double Nanometres = 1000000000;final double Miles = 0.000621371;final double Yards = 1.094;final double Feet = 3.281;final double Inches = 39.37008;final double NMiles = 0.000539957;

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

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.lengthArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertLengthOneSpinner.setAdapter(adapter1);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.lengthArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertLengthTwoSpinner.setAdapter(adapter2);
    }

    public void convertLength(){
        switch (convertLengthOneSpinner.getSelectedItem().toString()){
            case "Meters":output=Double.parseDouble(convertLengthOneEdit.getText().toString());break;
        }
    }
}