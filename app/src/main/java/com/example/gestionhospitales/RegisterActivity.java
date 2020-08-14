package com.example.gestionhospitales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText name;
    private EditText firstLastName;
    private EditText secondLastName;
    private EditText dni;
    private EditText correo;
    private EditText password;
    private Button registrar;
    private RadioButton masculino;
    private RadioButton femenino;

    //VARIABLES A REGISTRAR
    private String nameS = "";
    private String firstLastNameS = "";
    private String secondLastNameS = "";
    private String dniS="";
    private String correoS = "";
    private String passwordS = "";
    private String gender = "";

    //Auth
    FirebaseAuth mAuth;
    DatabaseReference mDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        mDataBase = FirebaseDatabase.getInstance().getReference();

        name = (EditText) findViewById(R.id.nameRegistro);
        firstLastName = (EditText) findViewById(R.id.firstlastnameR);
        secondLastName= (EditText) findViewById(R.id.secondlastnameR);
        dni = (EditText) findViewById(R.id.dniRegistro);
        correo = (EditText) findViewById(R.id.correoRegistro);
        password= (EditText) findViewById(R.id.passwordRegistro);
        masculino = (RadioButton) findViewById(R.id.Masculino);
        femenino = (RadioButton) findViewById(R.id.Femenino);
        registrar = (Button) findViewById(R.id.registrarRegistro);

        registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                nameS = name.getText().toString();
                firstLastNameS = firstLastName.getText().toString();
                secondLastNameS = secondLastName.getText().toString();
                dniS = ""+Integer.parseInt(dni.getText().toString());
                correoS = correo.getText().toString();
                passwordS = password.getText().toString();
                if(masculino.isChecked()){
                    gender = "Masculino";
                }else if(femenino.isChecked()){
                    gender = "Femenino";
                }
                if(!nameS.isEmpty() && !firstLastNameS.isEmpty() && !secondLastNameS.isEmpty() && /*!dniS.isEmpty() && */ !correoS.isEmpty() && !passwordS.isEmpty()){
                    if(passwordS.length()>6){
                        registerUser();
                    }else{
                        Toast.makeText(RegisterActivity.this, "El password debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(RegisterActivity.this, "Debe completar los campos faltantes", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean validar(){
        boolean status = true;

        return true;

    }
    protected void registerUser(){
        mAuth.createUserWithEmailAndPassword(correoS,passwordS).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    final Map<String,Object> map = new HashMap<>();
                    map.put("name",nameS);
                    map.put("firstLastName",firstLastNameS);
                    map.put("secondLastName",secondLastNameS);
                    map.put("dni",dniS);
                    map.put("email",correoS);
                    map.put("password",passwordS);
                    map.put("gender",gender);
                    String id =  mAuth.getCurrentUser().getUid();
                    mDataBase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                finish();
                            }
                            else{
                                Toast.makeText(RegisterActivity.this, "No se pudieron crear los datos", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(RegisterActivity.this, "No se pudo registrar este usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}