package com.example.felipemoreno.matematicadivertida;

import android.app.IntentService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Aritmetica extends AppCompatActivity {

    EditText etNum1, etNum2, etOperacao, etResultado;
    Button btnVerifica;
    TextView tvContador;
    ArrayList<Integer> dados;
    int contador = 1, acertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmetica);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        etOperacao = findViewById(R.id.etOperacao);
        etResultado = findViewById(R.id.etResultado);
        btnVerifica = findViewById(R.id.btnVerifica);
        tvContador = findViewById(R.id.tvContador);

        montaTela();
    }

    public ArrayList<Integer> geraConta(){
        Random r = new Random();
        int random1 = r.nextInt(10);
        int random2 = r.nextInt(10);
        int randOpe = r.nextInt(3 - 1);
        ArrayList<Integer> valores = new ArrayList<>();
        valores.add(random1);
        valores.add(random2);
        valores.add(randOpe);
        return valores;
    }

    public int fazConta(int num1, int num2, int ope){
        int resultado = 0;
        if (ope == 0){
            resultado = num1 + num2;
        } else if (ope == 1){
            resultado = num1 - num2;
        }
        return resultado;
    }

    public void montaTela(){
        dados = geraConta();
        if (dados.get(2) == 0){
            etOperacao.setText("+");
        } else if (dados.get(2) == 1){
            etOperacao.setText("-");
        }
        etNum1.setText(dados.get(0).toString());
        etNum2.setText(dados.get(1).toString());
        tvContador.setText(String.valueOf(contador));
    }

    public void verificaConta(View view){
        if (contador == 5){
                Toast.makeText(this, "Nota: " + acertos, Toast.LENGTH_SHORT).show();
                btnVerifica.setClickable(false);
        } else {
            if (etResultado.length() == 0){
                Toast.makeText(this, "Digite o resultado", Toast.LENGTH_SHORT).show();
            } else {
                int digitado = Integer.parseInt(etResultado.getText().toString());
                int resultado = fazConta(dados.get(0), dados.get(1), dados.get(2));
                if (digitado == resultado){
                    Toast.makeText(this, "Acertou", Toast.LENGTH_SHORT).show();
                    acertos++;
                } else {
                    Toast.makeText(this, "Errou, a resposta certa era " + resultado, Toast.LENGTH_SHORT).show();
                }
                contador++;
                montaTela();
            }
        }
    }
}
