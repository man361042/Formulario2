package com.example.manuel.formulario2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Intent.*;

public class Detalle extends AppCompatActivity {//AppCompatActivity
    private Button botonregresar;

    private TextView Texttv;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvEdad;
    private TextView tvDescripcion;


    private TextView regresarNombre;
    private TextView regresarTelefono;
    private TextView regresarEmail;
    private TextView regresarEdad;
    private TextView regresarDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Texttv=(TextView)findViewById(R.id.tvRecibirNombre);
        tvTelefono=(TextView)findViewById(R.id.tvRecibirTelefono);
        tvEmail=(TextView)findViewById(R.id.tvRecibirEmail);
        tvEdad=(TextView)findViewById(R.id.tvRecibirEdad);
        tvDescripcion=(TextView)findViewById(R.id.tvRecibirDescripcion);

        regresarNombre=(TextView)findViewById(R.id.tvRecibirNombre);
        regresarTelefono=(TextView)findViewById(R.id.tvRecibirTelefono);
        regresarEmail=(TextView)findViewById(R.id.tvRecibirEmail);
        regresarEdad=(TextView)findViewById(R.id.tvRecibirEdad);
        regresarDescripcion=(TextView)findViewById(R.id.tvRecibirDescripcion);

       //optener intent de mainactivity
        Intent intent=getIntent();
        Bundle b= intent.getExtras();

        if (b!=null){
            String j=(String)b.get("nombre");
            String t=(String)b.get("telefono");
            String e=(String)b.get("email");
            String d=(String)b.get("descripcion");
            String ed=(String)b.get("edad");
            Texttv.setText(j);
            tvTelefono.setText(t);
            tvEmail.setText(e);
            tvEdad.setText(ed);
            tvDescripcion.setText(d);
        }

    botonregresar = (Button) findViewById(R.id.btRegresar);

        botonregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(Detalle.this,MainActivity.class);
                String rNombre = regresarNombre.getText().toString();
                String rTelefono = regresarTelefono.getText().toString();
                String rEmail = regresarEmail.getText().toString();
                String rEdad= regresarEdad.getText().toString();
                String rDescripcion= regresarDescripcion.getText().toString();
                intent1.putExtra("rnombre",rNombre);
                intent1.putExtra("rtelefono",rTelefono);
                intent1.putExtra("remail",rEmail);
                intent1.putExtra("redad",rEdad);
                intent1.putExtra("rdescripcion",rDescripcion);
                startActivity(intent1);
                finish();
            }
        });




    }

}
