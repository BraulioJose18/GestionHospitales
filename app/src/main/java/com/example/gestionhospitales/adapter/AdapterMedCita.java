package com.example.gestionhospitales.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionhospitales.MedicosListado;
import com.example.gestionhospitales.R;
import com.example.gestionhospitales.ReservaCitaForm;
import com.example.gestionhospitales.pojo.Medicos;

import java.util.List;

public class AdapterMedCita extends RecyclerView.Adapter<AdapterMedCita.MedViewHolder>{

    Context context;
    List<Medicos> medLista;
    static String especialidad;

    public AdapterMedCita(Context context, List<Medicos> medLista) {
        this.context = context;
        this.medLista = medLista;
    }

    @NonNull
    @Override
    public MedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medico_cita,parent, false);
        return new MedViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MedViewHolder holder, int position) {
        Medicos doc = medLista.get(position);
        holder.nombMedCita.setText(doc.getNombres());
        holder.apellMedCita.setText(doc.getApellidos());
    }
    public void enviarDatos(String especialidad){
        AdapterMedCita.especialidad = especialidad;
    }
    @Override
    public int getItemCount() {
        return medLista.size();
    }

    public static class MedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        Context contextMed;

        TextView nombMedCita, apellMedCita, nombEspeCita;
        Button  medCita;
        public MedViewHolder(@NonNull View itemView) {
            super(itemView);
            contextMed = itemView.getContext();
            apellMedCita = (TextView) itemView.findViewById(R.id.apellMedCita);
            nombMedCita = (TextView) itemView.findViewById(R.id.nombMedCita);
            medCita =(Button) itemView.findViewById(R.id.medCitaReser);
            setOnClickListeners();
        }
        public void setOnClickListeners(){
            medCita.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(contextMed, ReservaCitaForm.class);

            //Apellido del Médico
            String apellMed = apellMedCita.getText().toString();
            String apell = apellMed.substring(0,apellMed.indexOf(" "));

            //Nombre del Médico
            String nombMed = nombMedCita.getText().toString();
            String nomb = nombMed.substring(0,nombMed.indexOf(" "));

            String nombCompMed = apell + " " + nomb;
            intent.putExtra("nameDoctor", nombCompMed);
            intent.putExtra("espeDoctor", especialidad);
            contextMed.startActivity(intent);
        }
    }
}
