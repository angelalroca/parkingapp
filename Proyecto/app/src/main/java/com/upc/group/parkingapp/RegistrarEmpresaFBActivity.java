package com.upc.group.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upc.group.parkingapp.modelos.Empresa;

import java.util.UUID;

public class RegistrarEmpresaFBActivity extends AppCompatActivity {

    EditText editTextRUC, editTextNombreLocal, editTextRepresentante,
            editTextDireccion, editTextNiveles, editTextTotalEst,
            editTextPassword;
    Button btnRegistrarEmpresa;
    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empresa_f_b);
        asignarReferencias();
    }

    private void asignarReferencias() {

        editTextRUC = findViewById(R.id.editTextRUC);
        editTextNombreLocal = findViewById(R.id.editTextNombreLocal);
        editTextNombreLocal = findViewById(R.id.editTextNombreLocal);
        editTextRepresentante = findViewById(R.id.editTextRepresentante);
        editTextDireccion = findViewById(R.id.editTextDireccion);
        editTextNiveles = findViewById(R.id.editTextNiveles);
        editTextTotalEst = findViewById(R.id.editTextTotalEst);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnRegistrarEmpresa = findViewById(R.id.btnRegistrarEmpresa);
        inicializarFirebase();
        btnRegistrarEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarEmpresa();
            }
        });

    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        db = FirebaseDatabase.getInstance();
        reference = db.getReference();
    }

    private void registrarEmpresa(){
        Empresa e = new Empresa();
        e.setId(UUID.randomUUID().toString());
        e.setRuc(editTextRUC.getText().toString());
        e.setNombreLocal(editTextNombreLocal.getText().toString());
        e.setRepresentante(editTextRepresentante.getText().toString());
        e.setDireccion(editTextDireccion.getText().toString());
        e.setNiveles(Integer.parseInt(editTextNiveles.getText().toString()));
        e.setTotalEst(Integer.parseInt(editTextNiveles.getText().toString()));
        //e.setHorarios(edit.getText().toString());

       /* if (ruc.equals("") || ruc.equals("")){
            validacion();
        }
        */
    }

    private void validacion() {
        if (editTextRUC.getText().toString().equals("")){

        }
    }
}