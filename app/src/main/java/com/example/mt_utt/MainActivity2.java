package com.example.mt_utt;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mt_utt.models.Celsius;
import com.example.mt_utt.models.Kelvin;
import com.example.mt_utt.models.Farenheit;
import com.example.mt_utt.models.Grado;

public class MainActivity2 extends AppCompatActivity {

    String[] item = {"Celsius a Kelvin", "Celsius a Farenheit", "Kelvin a Celsius", "Kelvin a Farenheit", "Farenheit a Kelvin", "Farenheit a Celsius"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RelativeLayout relativeLayout = findViewById(R.id.mainLayout);


        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, item);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                // Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });

        Celsius c= new Celsius(0.0);
        Kelvin k= new Kelvin(0.0);
        Farenheit f= new Farenheit(0.0);

        Button convertButton = findViewById(R.id.btnconvert);



        EditText editTextGrados = findViewById(R.id.iniciotxt);
        TextView textViewResultado = findViewById(R.id.resultadotxt);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtén la opción seleccionada en el AutoCompleteTextView
                String selectedOption = autoCompleteTextView.getText().toString();

                if (!selectedOption.isEmpty()) {
                    // Obtén el valor ingresado en el EditText
                    String inputText = editTextGrados.getText().toString();

                    if (!inputText.isEmpty()) {
                        // Convierte el valor ingresado a un número
                        double valorIngresado = Double.parseDouble(inputText);

                        switch (selectedOption) {
                            case "Celsius a Kelvin":
                                // Crear una instancia de Kelvin con un valor específico (valorIngresado)
                                Kelvin kelvin = new Kelvin(valorIngresado);

                                Celsius celsius = new Celsius(valorIngresado);

                                // Llamar al método parse(celsius) de la clase kelvin
                                Celsius resultadoCelsius = celsius.parse(kelvin);
                                textViewResultado.setText(String.format("%.2f", resultadoCelsius.getValor()));

                                break;
                            case "Celsius a Farenheit":
                                Farenheit farenheit = new Farenheit(valorIngresado);
                                Celsius celsius1 = new Celsius(valorIngresado);
                                Celsius resultadoCelsius2 = celsius1.parse(farenheit);

                                textViewResultado.setText(String.format("%.2f", resultadoCelsius2.getValor()));
                                break;
                            case "Kelvin a Celsius":
                                Celsius celsius2  = new Celsius(valorIngresado);
                                Kelvin kelvin1 = new Kelvin(valorIngresado);
                                Kelvin resultadoKelvin1 = kelvin1.parse(celsius2);
                                textViewResultado.setText(String.format("%.2f", resultadoKelvin1.getValor()));

                                break;

                            case "Kelvin a Farenheit":
                                Farenheit farenheit1 = new Farenheit(valorIngresado);
                                Kelvin kelvin2 = new Kelvin(valorIngresado);
                                Kelvin resultadoKelvin2 = kelvin2.parse(farenheit1);
                                textViewResultado.setText(String.format("%.2f", resultadoKelvin2.getValor()));
                                break;

                            case "Farenheit a Kelvin":
                                Kelvin kelvin3 = new Kelvin(valorIngresado);
                                Farenheit farenheit2 = new Farenheit(valorIngresado);
                                Farenheit resultadoFarenheit = farenheit2.parse(kelvin3);
                                textViewResultado.setText(String.format("%.2f", resultadoFarenheit.getValor()));
                                break;

                            case "Farenheit a Celsius":
                                Celsius celsius3 = new Celsius(valorIngresado);
                                Farenheit farenheit3 = new Farenheit(valorIngresado);
                                Farenheit resultadoFarenheit1 = farenheit3.parse(celsius3);
                                textViewResultado.setText(String.format("%.2f", resultadoFarenheit1.getValor()));
                                break;

                            default:
                                textViewResultado.setText("Opción no reconocida");
                                break;
                        }
                    } else {
                        Toast.makeText(MainActivity2.this, "Por favor, ingresa un valor válido.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity2.this, "Por favor, selecciona una opción válida.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}