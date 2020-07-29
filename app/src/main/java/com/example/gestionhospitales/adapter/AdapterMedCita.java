package com.example.gestionhospitales.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionhospitales.R;
import com.example.gestionhospitales.pojo.Medicos;

import java.util.List;

public class AdapterMedCita extends RecyclerView.Adapter<AdapterMedCita.MedViewHolder>{

    Context context;
    List<Medicos> medLista;

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

    @Override
    public int getItemCount() {
        return medLista.size();
    }

    public static class MedViewHolder extends RecyclerView.ViewHolder{

        TextView nombMedCita, apellMedCita;
        public MedViewHolder(@NonNull View itemView) {
            super(itemView);
            apellMedCita = (TextView) itemView.findViewById(R.id.apellMedCita);
            nombMedCita = (TextView) itemView.findViewById(R.id.nombMedCita);
        }
    }
}
