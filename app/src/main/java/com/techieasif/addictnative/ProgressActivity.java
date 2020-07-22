package com.techieasif.addictnative;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import java.util.HashMap;

public class ProgressActivity extends AppCompatActivity {
    //counter TextView variables declaration
    TextView cA, cD, cD2, cI, cC, cT;

    //target TextView variables declaration
    TextView tA, tD, tD2, tI, tC, tT;

    CardView cardA, cardD, cardD2, cardI, cardC, cardT;
    String targetAVal, targetDVal, targetD2Val, targetIVal, targetCVal, targetTVal;
    int counterAVal = 0, counterDVal = 0, counterD2Val = 0, counterIVal = 0, counterCVal = 0, counterTVal = 0;
    String targetDuration = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        Intent intent = getIntent();
        HashMap<String, String> hashMap = (HashMap<String, String>) intent.getSerializableExtra("target");

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //getting user target values
        targetAVal = hashMap.get("targetA");
        targetDVal = hashMap.get("targetD");
        targetD2Val = hashMap.get("targetD2");
        targetIVal = hashMap.get("targetI");
        targetCVal = hashMap.get("targetC");
        targetTVal = hashMap.get("targetT");
        targetDuration = hashMap.get("targetDuration");

        //Counter views id mapping.
        cA = (TextView) findViewById(R.id.txtACounter);
        cD = (TextView) findViewById(R.id.txtDCounter);
        cD2 = (TextView) findViewById(R.id.txtD2Counter);
        cI = (TextView) findViewById(R.id.txtICounter);
        cC = (TextView) findViewById(R.id.txtCCounter);
        cT = (TextView) findViewById(R.id.txtTCounter);

        //Target views id mapping
        tA = (TextView) findViewById(R.id.txtATarget);
        tD = (TextView) findViewById(R.id.txtDTarget);
        tD2 = (TextView) findViewById(R.id.txtD2Target);
        tI = (TextView) findViewById(R.id.txtITarget);
        tC = (TextView) findViewById(R.id.txtCTarget);
        tT = (TextView) findViewById(R.id.txtTTarget);

        //Card view id mapping
        cardA = (CardView) findViewById(R.id.cardA);
        cardD = (CardView) findViewById(R.id.cardD);
        cardD2 = (CardView) findViewById(R.id.cardD2);
        cardI = (CardView) findViewById(R.id.cardI);
        cardC = (CardView) findViewById(R.id.cardC);
        cardT = (CardView) findViewById(R.id.cardT);


        //setting target values
        if (targetAVal != null) {
            tA.setText((targetAVal));
        } else {
            tA.setText(("0"));
        }

        if (targetDVal != null) {
            tD.setText(targetDVal);
        } else {
            tD.setText("0");
        }

        if (targetD2Val != null) {
            tD2.setText(targetD2Val);

        } else {
            tD2.setText("0");
        }

        if (targetIVal != null) {
            tI.setText(targetIVal);
        } else {
            tI.setText("0");
        }

        if (targetCVal != null) {
            tC.setText(targetCVal);
        } else {
            tC.setText("0");
        }

        if (targetTVal != null) {
            tT.setText(targetTVal);
        } else {
            tT.setText("0");
        }


        //setting initial Target value
        setValues();

        cardA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterAVal == Integer.parseInt(targetAVal)) {
                    Toast.makeText(ProgressActivity.this, "You, exceeded your limit for A", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    counterAVal++;
                    cA.setText(String.valueOf(counterAVal));
                }
            }
        });
        cardD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterDVal == Integer.parseInt(targetDVal)) {
                    Toast.makeText(ProgressActivity.this, "You, exceeded your limit for D", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    counterDVal++;
                    cD.setText(String.valueOf(counterDVal));
                }
            }
        });

        cardD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterD2Val == Integer.parseInt(targetD2Val)) {
                    Toast.makeText(ProgressActivity.this, "You, exceeded your limit for D", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    counterD2Val++;
                    cD2.setText(String.valueOf(counterD2Val));
                }
            }
        });

        cardI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterIVal == Integer.parseInt(targetIVal)) {
                    Toast.makeText(ProgressActivity.this, "You, exceeded your limit for I", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    counterIVal++;
                    cI.setText(String.valueOf(counterIVal));
                }
            }
        });

        cardC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterCVal == Integer.parseInt(targetCVal)) {
                    Toast.makeText(ProgressActivity.this, "You, exceeded your limit for C", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    counterCVal++;
                    cC.setText(String.valueOf(counterCVal));
                }
            }
        });

        cardT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterTVal == Integer.parseInt(targetTVal)) {
                    Toast.makeText(ProgressActivity.this, "You, exceeded your limit for T", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    counterTVal++;
                    cT.setText(String.valueOf(counterTVal));
                }
            }
        });
    }

    private void setValues() {
        cA.setText(String.valueOf(counterAVal));
        cD.setText(String.valueOf(counterDVal));
        cD2.setText(String.valueOf(counterD2Val));
        cI.setText(String.valueOf(counterIVal));
        cC.setText(String.valueOf(counterCVal));
        cT.setText(String.valueOf(counterTVal));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.reset) {
            clearCounterValues();
            setValues();
            Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.newTarget) {
            Toast.makeText(this, "New Target", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }

        return true;
    }

    private void clearCounterValues() {
        counterAVal = 0;
        counterDVal = 0;
        counterD2Val = 0;
        counterIVal = 0;
        counterCVal = 0;
        counterTVal = 0;
    }
}