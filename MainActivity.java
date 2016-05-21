package com.example.manuel.formulario2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button botonsiguiente;
    private EditText entrarNombre;
    private EditText entrarTelefono;
    private EditText entrarEmail;
    private EditText entrarEdad;
    private EditText entrarDescripcion;

    private EditText editNombre;
    private EditText editTelefono;
    private EditText editEmail;
    private EditText editEdad;
    private EditText editDescripcion;
//seleccionar fecha

    Button btnCalendar;
    EditText txtDate;
    // Variable for storing current date and time
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalendar = (Button) findViewById(R.id.btFecha);
        txtDate = (EditText) findViewById(R.id.eEdad);

        entrarNombre = (EditText) findViewById(R.id.eNombre);
        entrarTelefono =(EditText) findViewById(R.id.eTelefono);
        entrarEmail = (EditText) findViewById(R.id.eEmail);
        entrarDescripcion = (EditText) findViewById(R.id.eDescripcion);
        entrarEdad= (EditText)findViewById(R.id.eEdad);
        botonsiguiente = (Button) findViewById(R.id.btSiguiente);

        editNombre=(EditText)findViewById(R.id.eNombre);
        editTelefono=(EditText)findViewById(R.id.eTelefono);
        editEmail=(EditText)findViewById(R.id.eEmail);
        editEdad=(EditText)findViewById(R.id.eEdad);
        editDescripcion=(EditText)findViewById(R.id.eDescripcion);

        //click en boton fecha
        btnCalendar.setOnClickListener(this);
        botonsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, Detalle.class);
                String Nombre = entrarNombre.getText().toString();
                String Telefono= entrarTelefono.getText().toString();
                String Email= entrarEmail.getText().toString();
                String Edad= entrarEdad.getText().toString();
                String Descripcion= entrarDescripcion.getText().toString();
                intent.putExtra("nombre",Nombre);
                intent.putExtra("telefono",Telefono);
                intent.putExtra("email",Email);
                intent.putExtra("edad",Edad);
                intent.putExtra("descripcion",Descripcion);
                startActivity(intent);

            }
        });
        //optener intent de activity Detalle
        Intent intent1=getIntent();
        Bundle d= intent1.getExtras();

        if (d!=null){
            String n=(String)d.get("rnombre");
            String t=(String)d.get("rtelefono");
            String e=(String)d.get("remail");
            String ed=(String)d.get("redad");
            String des=(String)d.get("rdescripcion");
            editNombre.setText(n);
            editTelefono.setText(t);
            editEmail.setText(e);
            editEdad.setText(ed);
            editDescripcion.setText(des);
        }
    }


    @Override
    public void onClick(View v) {
        if (v == btnCalendar) {

            // Process to get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // Display Selected date in textbox
                            txtDate.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            dpd.show();
        }
    }
}


