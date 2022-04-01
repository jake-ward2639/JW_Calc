package com.example.jwcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

public class CurrencyExchangeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    EditText fromCurrencyEdit;
    Spinner  fromCurrencySpinner;
    EditText toCurrencyEdit;
    Spinner  toCurrencySpinner;
    String fromCurrency = "GBP";
    String toCurrency = "EUR";
    Float exchangeRate = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_exchange);

        bottomNavigationView = findViewById(R.id.calMenu);
        fromCurrencyEdit = findViewById(R.id.convertOneEdit);
        fromCurrencySpinner = findViewById(R.id.convertOneSpinner); //setup spinners
        toCurrencyEdit = findViewById(R.id.convertTwoEdit);
        toCurrencySpinner = findViewById(R.id.convertTwoSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currencyFrom, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//populate Spinners
        fromCurrencySpinner.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.toCurrency, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toCurrencySpinner.setAdapter(adapter1);

        bottomNavigationView.setSelectedItemId(R.id.ToCE);
        bottomNavigationView.setOnNavigationItemSelectedListener(menuitem -> {
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
        });

        fromCurrencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //listeners call the api method
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromCurrency = fromCurrencySpinner.getSelectedItem().toString();
                getAPIExchangeRate();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        toCurrencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toCurrency = toCurrencySpinner.getSelectedItem().toString();
                getAPIExchangeRate();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        fromCurrencyEdit.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                getAPIExchangeRate();
            }
        });
    }

    public void updateERActivity(){//display the correct conversion in the "TO" box
        if(fromCurrencyEdit.getText().length()!=0) {
            float result = Float.parseFloat(String.valueOf(fromCurrencyEdit.getText())) * exchangeRate;
            toCurrencyEdit.setText(String.valueOf(result));
        }
    }

    private void getAPIExchangeRate() {//get the exchange rate from the api and display the result
        if(fromCurrencyEdit.getText().length() != 0){
            String url_str = "https://api.exchangerate.host/latest?base=" + fromCurrency + "&symbols=" + toCurrency;
            StringRequest request = new StringRequest(Request.Method.GET, url_str,
                    new Response.Listener() {
                        @Override
                        public void onResponse(Object response)
                        {
                            try
                            {

                                JSONObject reader = new JSONObject(response.toString());
                                String results = reader.getJSONObject("rates").getString(toCurrency);
                                exchangeRate = Float.parseFloat(results);
                                updateERActivity();

                            } catch (JSONException e) { Log.d("CheckF", e.getLocalizedMessage()); }
                        }
                    },
                    error -> {
                    });
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            queue.add(request);
        }
    }
}