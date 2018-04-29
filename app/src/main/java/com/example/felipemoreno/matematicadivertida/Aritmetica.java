package com.example.felipemoreno.matematicadivertida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;

public class Aritmetica extends AppCompatActivity {

    EditText etNum1, etNum2, etOperacao, etResultado;
    Button btnVerifica;
    final int min = 0;
    final int max = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmetica);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        etOperacao = findViewById(R.id.etOperacao);
        etResultado = findViewById(R.id.etResultado);
        btnVerifica = findViewById(R.id.btnVerifica);

        int dados[] = gerarConta();
        etNum2.setText(dados[1]);
        etNum2.setText(dados[2]);
        etOperacao.setText(dados[3]);
    }

    public int[] gerarConta(){
        Random r = new Random();
        int random1 = r.nextInt(10 - 0);
        int random2 = r.nextInt(10 - 0);
        int randOpe = r.nextInt(3 - 1);
        ArrayList<Integer> dados = new ArrayList<>();
        dados[1] = random1;
        return dados;
    }
}
