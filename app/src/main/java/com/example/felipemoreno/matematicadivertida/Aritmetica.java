package com.example.felipemoreno.matematicadivertida;

import android.app.AlertDialog;
import android.app.IntentService;
import android.content.DialogInterface;
import android.content.Intent;
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
    ArrayList<Integer> dados;
    int contador = 0, acertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aritmetica);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        etOperacao = findViewById(R.id.etOperacao);
        etResultado = findViewById(R.id.etResultado);
        btnVerifica = findViewById(R.id.btnVerifica);

        montaTela();
    }

    public ArrayList<Integer> geraConta() {
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

    public int fazConta(int num1, int num2, int ope) {
        int resultado = 0;
        if (ope == 0) {
            resultado = num1 + num2;
        } else if (ope == 1) {
            resultado = num1 - num2;
        }
        return resultado;
    }

    public void montaTela() {
        dados = geraConta();
        if (dados.get(2) == 0) {
            etOperacao.setText("+");
        } else if (dados.get(2) == 1) {
            etOperacao.setText("-");
        }
        etNum1.setText(dados.get(0).toString());
        etNum2.setText(dados.get(1).toString());
    }

    public void verificaConta(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (contador < 5) {
            if (etResultado.length() == 0) {
                Toast.makeText(this, "Digite o resultado", Toast.LENGTH_SHORT).show();
            } else {
                contador++;
                int digitado = Integer.parseInt(etResultado.getText().toString());
                int resultado = fazConta(dados.get(0), dados.get(1), dados.get(2));
                if (digitado == resultado) {
                    builder.setMessage("Acertou").setTitle("Questão " + contador);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    acertos++;
                } else {
                    builder.setMessage("Errou, a resposta certa era " + resultado).setTitle("Questão " + contador);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                montaTela();
            }
        } else {
            btnVerifica.setText("Resultado");
            builder.setMessage(acertos * 20 + "%").setTitle("Resultado");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
            btnVerifica.setClickable(false);
        }
        etResultado.setText("");
    }
}

