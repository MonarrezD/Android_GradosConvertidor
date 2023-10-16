package com.example.mt_utt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity2 extends AppCompatActivity {
Button convertir=null;
EditText cantidad=null;
TextView resultado=null;
Spinner spinci=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        convertir=(Button) findViewById(R.id.btntem);
        cantidad=(EditText) findViewById(R.id.cant);
        resultado=(TextView) findViewById(R.id.Resu);
        spinci=(Spinner) findViewById(R.id.spinila);

        String[]op={"Selecciona Una Opcion","°Celcius a °Farenheit","°Celcius a °Kelvin","°Farenheit a °Celcius","°Farenheit a °Kelvin","°Kelvin a °Celcius","°Kelvin a °Farenheit"};
        ArrayAdapter<String> adapter=new
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,op);
        spinci.setAdapter(adapter);
        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidad.getText().toString().equals("")){
                    Toast msg=Toast.makeText(getApplicationContext(),"Escribe una cantidad",Toast.LENGTH_SHORT);
                    msg.show();
                }else{
                    Double c=Double.parseDouble(cantidad.getText().toString());
                    Double res=null;
                    int select=spinci.getSelectedItemPosition();

                    switch (select) {
                        case 0:
                            res = 0.0;
                            Toast.makeText(getApplicationContext(), "Selecciona una opcion", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            res = 1.8 * c + 32;
                            break;
                        case 2:
                            res = c + 273.15;
                            break;
                        case 3:
                            res = (c - 32) / 1.8;
                            break;
                        case 4:
                            res = c + 1;
                            break;
                        case 5:
                            res= c - 273.15;
                            break;
                        case 6:
                            res = (c - 273.15) * 9 / 5 + 32;
                            break;
                    }
                    if (res != null) {
                        resultado.setText(res.toString()) ;
                    }
                }
            }
        });
    }
}