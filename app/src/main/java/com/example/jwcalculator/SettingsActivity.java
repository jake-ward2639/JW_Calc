package com.example.jwcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView = findViewById(R.id.calMenu);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        bottomNavigationView.setSelectedItemId(R.id.ToSettings);
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
    }
}