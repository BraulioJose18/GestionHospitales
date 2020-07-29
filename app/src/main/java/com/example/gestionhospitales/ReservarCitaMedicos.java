package com.example.gestionhospitales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.gestionhospitales.adapter.AdapterMed;
import com.example.gestionhospitales.adapter.AdapterMedCita;
import com.example.gestionhospitales.pojo.Medicos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ReservarCitaMedicos extends AppCompatActivity {

    List<Medicos> listMed;

    RecyclerView rvMedicosCita;

    AdapterMedCita adapterMedicos;

    LinearLayoutManager lmMedicosCita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_cita_medicos);

        rvMedicosCita = findViewById(R.id.rvMedicoCita);
        lmMedicosCita = new LinearLayoutManager(this);
        rvMedicosCita.setLayoutManager(lmMedicosCita);

        Bundle extraEsp = getIntent().getExtras();
        String extra = "";
        if(extraEsp != null){
            extra = extraEsp.getString("nameEspeCita");
        }

        listMed =  new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        adapterMedicos = new AdapterMedCita(ReservarCitaMedicos.this,listMed);
        rvMedicosCita.setAdapter(adapterMedicos);
        database.getReference().child("EspecialidadMedico/"+extra).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listMed.clear();
                for(DataSnapshot snap : snapshot.getChildren()){
                    String val = snap.getKey();
                    Log.d("Valor de la key: ",val);
                    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
                    database1.getReference().child("Medicos").orderByKey().equalTo(val).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot snap : snapshot.getChildren()) {
                                Medicos medico = snap.getValue(Medicos.class);
                                listMed.add(medico);
                            }
                            adapterMedicos.notifyDataSetChanged();
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}