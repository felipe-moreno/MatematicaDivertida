package com.example.felipemoreno.matematicadivertida;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Contagem extends AppCompatActivity {

    ImageView imgNumero;
    Button btn1, btn2, btn3, btnResultado;
    ArrayList<Integer> dados;
    ArrayList<Integer> repetidos = new ArrayList<>(5);
    int contador = 0, acertos, clickado;
    Integer[] imagens = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
            R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9,
            R.drawable.img10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contagem);

        imgNumero = findViewById(R.id.imgNumero);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btnResultado = findViewById(R.id.btnResultado);
        montaTela();
    }

    public ArrayList<Integer> geraImagem() {
        Random r = new Random();
        int randomImage = r.nextInt(10);
        for(int i = 0; i < repetidos.size(); i++){
            while(randomImage == repetidos.get(i)){
                randomImage = r.nextInt(10);
            }
        }
        int random1 = r.nextInt(10);
        while (random1 == randomImage){
            random1 = r.nextInt(10);
        }
        int random2 = r.nextInt(10);
        while (random2 == randomImage || random2 == random1){
            random2 = r.nextInt(10);
        }
        ArrayList<Integer> valores = new ArrayList<>();
        valores.add(randomImage);
        valores.add(random1);
        valores.add(random2);
        return valores;
    }

    public void montaTela() {
        dados = geraImagem();
        imgNumero.setImageResource(imagens[dados.get(0)]);
        Random r = new Random();
        int random = r.nextInt(3);
        switch (random){
            case 0:
                btn1.setText(String.valueOf(dados.get(0) + 1));
                btn2.setText(String.valueOf(dados.get(1) + 1));
                btn3.setText(String.valueOf(dados.get(2) + 1));
                break;
            case 1:
                btn1.setText(String.valueOf(dados.get(1) + 1));
                btn2.setText(String.valueOf(dados.get(0) + 1));
                btn3.setText(String.valueOf(dados.get(2) + 1));
                break;
            case 2:
                btn1.setText(String.valueOf(dados.get(2) + 1));
                btn2.setText(String.valueOf(dados.get(1) + 1));
                btn3.setText(String.valueOf(dados.get(0) + 1));
                break;
        }
    }

    public void verificaNumero(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (contador < 5) {
                contador++;
                switch (view.getId()){
                    case R.id.btn1:
                        clickado = Integer.parseInt(btn1.getText().toString());
                        if (clickado == (dados.get(0))+1) {
                            builder.setMessage("Acertou").setTitle("Questão " + contador);
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                            acertos++;
                            if (contador == 5){
                                btnResultado.setVisibility(View.VISIBLE);
                                btn1.setVisibility(View.INVISIBLE);
                                btn2.setVisibility(View.INVISIBLE);
                                btn3.setVisibility(View.INVISIBLE);
                            }
                        } else {
                            builder.setMessage("Errou, a resposta certa era " + (dados.get(0) + 1)).setTitle("Questão " + contador);
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                            if (contador == 5){
                                btnResultado.setVisibility(View.VISIBLE);
                                btn1.setVisibility(View.INVISIBLE);
                                btn2.setVisibility(View.INVISIBLE);
                                btn3.setVisibility(View.INVISIBLE);
                            }
                        }
                        repetidos.add(dados.get(0));
                        clickado = 0;
                        break;
                    case R.id.btn2:
                        clickado = Integer.parseInt(btn2.getText().toString());
                        if (clickado == (dados.get(0)) +1) {
                            builder.setMessage("Acertou").setTitle("Questão " + contador);
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                            acertos++;
                            if (contador == 5){
                                btnResultado.setVisibility(View.VISIBLE);
                                btn1.setVisibility(View.INVISIBLE);
                                btn2.setVisibility(View.INVISIBLE);
                                btn3.setVisibility(View.INVISIBLE);
                            }
                        } else {
                            builder.setMessage("Errou, a resposta certa era " + (dados.get(0) + 1)).setTitle("Questão " + contador);
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                            if (contador == 5){
                                btnResultado.setVisibility(View.VISIBLE);
                                btn1.setVisibility(View.INVISIBLE);
                                btn2.setVisibility(View.INVISIBLE);
                                btn3.setVisibility(View.INVISIBLE);
                            }
                        }
                        repetidos.add(dados.get(0));
                        clickado = 0;
                        break;
                    case R.id.btn3:
                        clickado = Integer.parseInt(btn3.getText().toString());
                        if (clickado == (dados.get(0))+1) {
                            builder.setMessage("Acertou").setTitle("Questão " + contador);
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                            acertos++;
                            if (contador == 5){
                                btnResultado.setVisibility(View.VISIBLE);
                                btn1.setVisibility(View.INVISIBLE);
                                btn2.setVisibility(View.INVISIBLE);
                                btn3.setVisibility(View.INVISIBLE);
                            }
                        } else {
                            builder.setMessage("Errou, a resposta certa era " + (dados.get(0) + 1)).setTitle("Questão " + contador);
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                            if (contador == 5){
                                btnResultado.setVisibility(View.VISIBLE);
                                btn1.setVisibility(View.INVISIBLE);
                                btn2.setVisibility(View.INVISIBLE);
                                btn3.setVisibility(View.INVISIBLE);
                            }
                        }
                        repetidos.add(dados.get(0));
                        clickado = 0;
                        break;
                    case R.id.btnResultado:
                        builder.setMessage(acertos * 20 + "%").setTitle("Resultado");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        break;
                }
                montaTela();
            }
         else {
            builder.setMessage(acertos * 20 + "%").setTitle("Resultado");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}
