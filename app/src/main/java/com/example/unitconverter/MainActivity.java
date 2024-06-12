package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerFrom, spinnerTo;
    private EditText etInput;
    private TextView tvResult;
    private Button btnConvert;

    private String fromUnit, toUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        etInput = findViewById(R.id.etInput);
        tvResult = findViewById(R.id.tvResult);
        btnConvert = findViewById(R.id.btnConvert);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromUnit = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toUnit = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnConvert.setOnClickListener(v -> {
            String input = etInput.getText().toString();
            if (!input.isEmpty()) {
                double inputValue = Double.parseDouble(input);
                double result = convertUnits(inputValue, fromUnit, toUnit);
                tvResult.setText(String.valueOf(result));
            } else {
                tvResult.setText("Please enter a value");
            }
        });
    }

    private double convertUnits(double value, String fromUnit, String toUnit) {
        double conversionFactor = getConversionFactor(fromUnit, toUnit);
        return value * conversionFactor;
    }

    private double getConversionFactor(String fromUnit, String toUnit) {
        double factor = 1.0;

        switch (fromUnit) {
            case "Meter":
                if (toUnit.equals("Kilometer")) {
                    factor = 0.001;
                } else if (toUnit.equals("Centimeter")) {
                    factor = 100;
                } else if (toUnit.equals("Millimeter")) {
                    factor = 1000;
                } else if (toUnit.equals("Mile")) {
                    factor = 0.000621371;
                } else if (toUnit.equals("Yard")) {
                    factor = 1.09361;
                } else if (toUnit.equals("Foot")) {
                    factor = 3.28084;
                } else if (toUnit.equals("Inch")) {
                    factor = 39.3701;
                }
                break;
            case "Kilometer":
                if (toUnit.equals("Meter")) {
                    factor = 1000;
                } else if (toUnit.equals("Centimeter")) {
                    factor = 100000;
                } else if (toUnit.equals("Millimeter")) {
                    factor = 1000000;
                } else if (toUnit.equals("Mile")) {
                    factor = 0.621371;
                } else if (toUnit.equals("Yard")) {
                    factor = 1093.61;
                } else if (toUnit.equals("Foot")) {
                    factor = 3280.84;
                } else if (toUnit.equals("Inch")) {
                    factor = 39370.1;
                }
                break;
            case "Centimeter":
                if (toUnit.equals("Meter")) {
                    factor = 0.01;
                } else if (toUnit.equals("Kilometer")) {
                    factor = 0.00001;
                } else if (toUnit.equals("Millimeter")) {
                    factor = 10;
                } else if (toUnit.equals("Mile")) {
                    factor = 0.0000062137;
                } else if (toUnit.equals("Yard")) {
                    factor = 0.0109361;
                } else if (toUnit.equals("Foot")) {
                    factor = 0.0328084;
                } else if (toUnit.equals("Inch")) {
                    factor = 0.393701;
                }
                break;
            case "Millimeter":
                if (toUnit.equals("Meter")) {
                    factor = 0.001;
                } else if (toUnit.equals("Kilometer")) {
                    factor = 0.000001;
                } else if (toUnit.equals("Centimeter")) {
                    factor = 0.1;
                } else if (toUnit.equals("Mile")) {
                    factor = 0.000000621371;
                } else if (toUnit.equals("Yard")) {
                    factor = 0.00109361;
                } else if (toUnit.equals("Foot")) {
                    factor = 0.00328084;
                } else if (toUnit.equals("Inch")) {
                    factor = 0.0393701;
                }
                break;
            case "Mile":
                if (toUnit.equals("Meter")) {
                    factor = 1609.34;
                } else if (toUnit.equals("Kilometer")) {
                    factor = 1.60934;
                } else if (toUnit.equals("Centimeter")) {
                    factor = 160934;
                } else if (toUnit.equals("Millimeter")) {
                    factor = 1609340;
                } else if (toUnit.equals("Yard")) {
                    factor = 1760;
                } else if (toUnit.equals("Foot")) {
                    factor = 5280;
                } else if (toUnit.equals("Inch")) {
                    factor = 63360;
                }
                break;
            case "Yard":
                if (toUnit.equals("Meter")) {
                    factor = 0.9144;
                } else if (toUnit.equals("Kilometer")) {
                    factor = 0.0009144;
                } else if (toUnit.equals("Centimeter")) {
                    factor = 91.44;
                } else if (toUnit.equals("Millimeter")) {
                    factor = 914.4;
                } else if (toUnit.equals("Mile")) {
                    factor = 0.000568182;
                } else if (toUnit.equals("Foot")) {
                    factor = 3;
                } else if (toUnit.equals("Inch")) {
                    factor = 36;
                }
                break;
            case "Foot":
                if (toUnit.equals("Meter")) {
                    factor = 0.3048;
                } else if (toUnit.equals("Kilometer")) {
                    factor = 0.0003048;
                } else if (toUnit.equals("Centimeter")) {
                    factor = 30.48;
                } else if (toUnit.equals("Millimeter")) {
                    factor = 304.8;
                } else if (toUnit.equals("Mile")) {
                    factor = 0.000189394;
                } else if (toUnit.equals("Yard")) {
                    factor = 0.333333;
                } else if (toUnit.equals("Inch")) {
                    factor = 12;
                }
                break;
            case "Inch":
                if (toUnit.equals("Meter")) {
                    factor = 0.0254;
                } else if (toUnit.equals("Kilometer")) {
                    factor = 0.0000254;
                } else if (toUnit.equals("Centimeter")) {
                    factor = 2.54;
                } else if (toUnit.equals("Millimeter")) {
                    factor = 25.4;
                } else if (toUnit.equals("Mile")) {
                    factor = 0.0000157828;
                } else if (toUnit.equals("Yard")) {
                    factor = 0.0277778;
                } else if (toUnit.equals("Foot")) {
                    factor = 0.0833333;
                }
                break;
            default:
                factor = 1.0; // If the same unit is selected or unknown unit is passed
                break;
        }

        return factor;
    }

}
