package com.example.gestionhospitales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText correo;
    private EditText password;
    private Button iniciarSesion;
    private Button registrarse;

    private String emailS = "";
    private String passwordS = "";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        correo = (EditText) findViewById(R.id.correo);
        password= (EditText) findViewById(R.id.password);
        iniciarSesion = (Button) findViewById(R.id.iniciarSesion);
        registrarse =(Button) findViewById(R.id.registrarse);

        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailS = correo.getText().toString();
                passwordS = password.getText().toString();

                if(!emailS.isEmpty() && !passwordS.isEmpty()){
                    loginUser();
                }else{
                    Toast.makeText(MainActivity.this, "Complete los campos necesarios", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });
    }
    private void loginUser(){
        mAuth.signInWithEmailAndPassword(emailS,passwordS).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(MainActivity.this,MenuCardView.class));
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "No se pudo Iniciar Sesión", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(MainActivity.this, MenuCardView.class));
            finish();
        }
    }
}