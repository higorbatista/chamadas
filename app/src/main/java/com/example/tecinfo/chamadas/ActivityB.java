package com.example.tecinfo.chamadas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity {
    SharedPreferences meusDasdos;
    public static final String mypreference = "call";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        final EditText emailb = findViewById(R.id.emailb);
        final EditText senhaB  = findViewById(R.id.senhaB);
        final EditText csenha = findViewById(R.id.csenha);
        Button cadastrar = findViewById(R.id.btn_cadastro);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (senhaB.getText().toString().equals(csenha.getText().toString())){

                    SharedPreferences.Editor editor = meusDasdos.edit();
                    editor.putString("email", emailb.getText().toString());
                    editor.putString("senha", csenha.getText().toString());

                    editor.commit();
                    Toast.makeText(getApplicationContext(),
                            "dados salvos com sucesso!", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent( ActivityB.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(),
                            "As senhas não conferm", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
