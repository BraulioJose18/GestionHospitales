package com.example.gestionhospitales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class PerfilUsuario extends AppCompatActivity {

    private Button cerrarSesion;
    private FirebaseAuth mAuth;
    private TextView viewName;
    private TextView viewApell;
    private TextView viewDni;
    private TextView viewCorreo;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);


        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        viewName =(TextView) findViewById(R.id.viewName);
        viewApell =(TextView) findViewById(R.id.viewApell);
        viewDni =(TextView) findViewById(R.id.viewDNI);
        viewCorreo =(TextView) findViewById(R.id.viewCorreo);

        cerrarSesion = (Button) findViewById(R.id.cerrarSesion);

        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(PerfilUsuario.this,MainActivity.class));
                finish();
            }
        });
        obtenerInfo();
    }
    private void obtenerInfo(){
        String id = mAuth.getCurrentUser().getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String name = snapshot.child("name").getValue().toString();
                    String firstLastName = snapshot.child("firstLastName").getValue().toString();
                    String secondLastName = snapshot.child("secondLastName").getValue().toString();
                    String apell = firstLastName + " " + secondLastName;
                    String correo = snapshot.child("email").getValue().toString();
                    String dni = snapshot.child("dni").getValue().toString();

                    viewName.setText(name);
                    viewApell.setText(apell);
                    viewCorreo.setText(correo);
                    viewDni.setText(dni);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}