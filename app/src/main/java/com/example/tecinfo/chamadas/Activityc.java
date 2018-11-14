package com.example.tecinfo.chamadas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activityc extends AppCompatActivity {
    String memoria ="";
    TextView txtnumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityc);

        txtnumero = findViewById(R.id.txt_numero);
        Button btnapagar  = findViewById(R.id.btnP);
        Button btnvelha = findViewById(R.id.btnVelha);
        Button btnaste  = findViewById(R.id.btnAste);
        Button btn0  = findViewById(R.id.btn0);
        Button btn1  = findViewById(R.id.btn1);
        Button btn2  = findViewById(R.id.btn2);
        Button btn3  = findViewById(R.id.btn3);
        Button btn4  = findViewById(R.id.btn4);
        Button btn5  = findViewById(R.id.btn5);
        Button btn6  = findViewById(R.id.btn6);
        Button btn7  = findViewById(R.id.btn7);
        Button btn8  = findViewById(R.id.btn8);
        Button btn9  = findViewById(R.id.btn9);
        Button btnligar  = findViewById(R.id.btnligar);

        btn0 .setOnClickListener(myListener);
        btn1 .setOnClickListener(myListener);
        btn2 .setOnClickListener(myListener);
        btn3 .setOnClickListener(myListener);
        btn4 .setOnClickListener(myListener);
        btn5 .setOnClickListener(myListener);
        btn6 .setOnClickListener(myListener);
        btn7 .setOnClickListener(myListener);
        btn8 .setOnClickListener(myListener);
        btn9 .setOnClickListener(myListener);
        btnligar .setOnClickListener(myListener);
        btnapagar .setOnClickListener(myListener);
        btnvelha .setOnClickListener(myListener);
        btnaste .setOnClickListener(myListener);

    }
    private View.OnClickListener myListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btn0:
                    setDisplayText("0");
                    break;
                case R.id.btn1:
                    setDisplayText("1");
                    break;
                case R.id.btn2:
                    setDisplayText("2");
                    break;
                case R.id.btn3:
                    setDisplayText("3");
                    break;
                case R.id.btn4:
                    setDisplayText("4");
                    break;
                case R.id.btn5:
                    setDisplayText("5");
                    break;
                case R.id.btn6:
                    setDisplayText("6");
                    break;
                case R.id.btn7:
                    setDisplayText("7");
                    break;
                case R.id.btn8:
                    setDisplayText("8");
                    break;
                case R.id.btn9:
                    setDisplayText("9");
                    break;
                case R.id.btnVelha:
                    setDisplayText("#");
                    break;
                case R.id.btnAste:
                    setDisplayText("*");
                    break;
                case R.id.btnP:
                    if(memoria.length() > 0){
                        memoria = memoria.substring(0, memoria.length() - 1);
                        txtnumero.setText(memoria);
                    }
                    break;
                case R.id.btnligar:

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + memoria));

                    if (ActivityCompat.checkSelfPermission(Activityc.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(Activityc.this,
                                new String[]{Manifest.permission.CALL_PHONE}, 0);
                    }

                    startActivity(intent);

                    break;

            }
        }
    };

    private void setDisplayText(String valor) {
        memoria = memoria + valor;
        txtnumero.setText(memoria);
    }
}
