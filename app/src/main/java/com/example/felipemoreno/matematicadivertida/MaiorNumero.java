package com.example.felipemoreno.matematicadivertida;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MaiorNumero extends AppCompatActivity {

    EditText etNum1, etNum2, etNum3, etResposta;
    Button btnVerifica;
    ArrayList<Integer> dados;
    int contador = 0, acertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maior_numero);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        etNum3 = findViewById(R.id.etNum3);
        etResposta = findViewById(R.id.etResposta);
        btnVerifica = findViewById(R.id.btnVerifica);

        montaTela();
    }

    public ArrayList<Integer> geraNumeros() {
        Random r = new Random();
        int random1 = r.nextInt(10);
        int random2 = r.nextInt(10);
        int random3 = r.nextInt(10);
        ArrayList<Integer> valores = new ArrayList<>();
        valores.add(random1);
        valores.add(random2);
        valores.add(random3);
        return valores;
    }

    public void montaTela() {
        dados = geraNumeros();
        etNum1.setText(dados.get(0).toString());
        etNum2.setText(dados.get(1).toString());
        etNum3.setText(dados.get(2).toString());
    }


    public void verificaNumero(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        Collections.sort(dados);
        Collections.reverse(dados);
        String numeroCorreto = dados.get(0).toString() + dados.get(1).toString() + dados.get(2).toString();
        int resposta = Integer.parseInt(numeroCorreto);

        if (contador < 5) {
            if (etResposta.length() == 0) {
                Toast.makeText(this, "Digite a resposta", Toast.LENGTH_SHORT).show();
            } else if (etResposta.length() > 3){
                Toast.makeText(this, "Apenas 3 digitos são permitidos", Toast.LENGTH_SHORT).show();
            } else {
                contador++;
                int digitado = Integer.parseInt(etResposta.getText().toString());
                if (digitado == resposta) {
                    builder.setMessage("Acertou").setTitle("Questão " + contador);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    acertos++;
                    if (contador == 5){
                        btnVerifica.setText("Resultado");
                        etResposta.setVisibility(View.INVISIBLE);
                        etNum1.setVisibility(View.INVISIBLE);
                        etNum2.setVisibility(View.INVISIBLE);
                        etNum3.setVisibility(View.INVISIBLE);
                    }
                } else {
                    builder.setMessage("Errou, a resposta certa era " + resposta).setTitle("Questão " + contador);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    if (contador == 5){
                        btnVerifica.setText("Resultado");
                        etResposta.setVisibility(View.INVISIBLE);
                        etNum1.setVisibility(View.INVISIBLE);
                        etNum2.setVisibility(View.INVISIBLE);
                        etNum3.setVisibility(View.INVISIBLE);
                    }
                }
                montaTela();
            }
        } else {
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
        etResposta.setText("");
    }
}
