package com.techieasif.addictnative;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String[] targetDuration = {"Daily", "Weekly", "Monthly", "Yearly"};
    Spinner spinner;
    EditText editTextA, editTextD, editTextD2, editTextI, editTextC, editTextT;
    Button btnSave;
    String selectedTargetDuration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = (EditText) findViewById(R.id.eTextA);
        editTextD = (EditText) findViewById(R.id.eTextD);
        editTextD2 = (EditText) findViewById(R.id.eTextD2);
        editTextI = (EditText) findViewById(R.id.eTextI);
        editTextC = (EditText) findViewById(R.id.eTextC);
        editTextT = (EditText) findViewById(R.id.eTextT);
        btnSave = (Button) findViewById(R.id.btn_save);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner = (Spinner) findViewById(R.id.spin);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), targetDuration[position], Toast.LENGTH_LONG).show();
                selectedTargetDuration = targetDuration[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, targetDuration);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textInputA = editTextA.getText().toString();
                String textInputD = editTextD.getText().toString();
                String textInputD2 = editTextD2.getText().toString();
                String textInputI = editTextI.getText().toString();
                String textInputC = editTextC.getText().toString();
                String textInputT = editTextT.getText().toString();

                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("targetA", textInputA);
                hashMap.put("targetD", textInputD);
                hashMap.put("targetD2", textInputD2);
                hashMap.put("targetI", textInputI);
                hashMap.put("targetC", textInputC);
                hashMap.put("targetT", textInputT);
                hashMap.put("targetDuration", selectedTargetDuration);

                //Sending data to progress activity
                Intent intent = new Intent(MainActivity.this, ProgressActivity.class);
                intent.putExtra("target", hashMap);
                startActivity(intent);
            }
        });
    }
}