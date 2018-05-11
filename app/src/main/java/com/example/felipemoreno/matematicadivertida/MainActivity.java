package com.example.felipemoreno.matematicadivertida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnContagem, btnAritmetica, btnMaiorNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContagem = findViewById(R.id.btnContagem);
        btnAritmetica = findViewById(R.id.btnAritmetica);
        btnMaiorNum = findViewById(R.id.btnMaiorNum);

    }

    public void aritmetica (View view){
        Intent it = new Intent(this, Aritmetica.class);
        startActivity(it);
    }

    public void maiorNumero (View view){
        Intent it = new Intent(this, MaiorNumero.class);
        startActivity(it);
    }

    public void contagem (View view){
        Intent it = new Intent(this, Contagem.class);
        startActivity(it);
    }
}
