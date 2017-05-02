package com.example.vivian.calculosalarial;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tx_salario;
    private TextView tx_percentual;

    private EditText edt_salario;

    private RadioGroup radioGroup;
    private RadioButton rad_percentual_40;
    private RadioButton rad_percentual_45;
    private RadioButton rad_percentual_50;

    private Button bt_mostrar_salario;

    double percentual_40 = 0.4;
    double percentual_45 = 0.45;
    double percentual_50 = 0.5;
    double percentualAtualizado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tx_salario = (TextView) findViewById(R.id.tx_salario);
        tx_percentual = (TextView) findViewById(R.id.tx_percentual);
        edt_salario = (EditText) findViewById(R.id.edt_salario);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rad_percentual_40 = (RadioButton) findViewById(R.id.rad_percentual_40);
        rad_percentual_45 = (RadioButton) findViewById(R.id.rad_percentual_45);
        rad_percentual_50 = (RadioButton) findViewById(R.id.rad_percentual_50);
        bt_mostrar_salario = (Button) findViewById(R.id.bt_mostrar_salario);

        tx_salario.setText("Digite seu salário (R$)");
        edt_salario.setTextColor(Color.BLACK);
        tx_percentual.setText("Qual será o percentual?");
        rad_percentual_40.setText("40%");
        rad_percentual_45.setText("45%");
        rad_percentual_50.setText("50%");
        bt_mostrar_salario.setText("Mostrar Novo Salario");

        bt_mostrar_salario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    double valor_digitado;
                    valor_digitado = Double.parseDouble(edt_salario.getText().toString());

                    if(rad_percentual_40.isChecked()) {
                        percentualAtualizado = (valor_digitado + (percentual_40 * valor_digitado));
                    }
                    if(rad_percentual_45.isChecked()) {
                        percentualAtualizado += (valor_digitado + (percentual_45 * valor_digitado));
                    }
                    if(rad_percentual_50.isChecked()) {
                        percentualAtualizado += (valor_digitado + (percentual_50 * valor_digitado));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                AlertDialog.Builder alertDialog;
                alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Reajuste Salarial!");
                alertDialog.setIcon(R.drawable.ic_salario);
                alertDialog.setMessage("Salário Atualizado em R$: " + String.format("%.2f", percentualAtualizado));
                alertDialog.setPositiveButton("Ok", null);
                alertDialog.show();
            }
        });
    }
}
