package com.example.gestionhospitales.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionhospitales.R;
import com.example.gestionhospitales.pojo.CitasHist;

import java.util.List;

public class AdapterHistorialCitas extends RecyclerView.Adapter<AdapterHistorialCitas.HistorialCitasViewHolder>{

    Context context;
    List<CitasHist> listHistCitas;

    public AdapterHistorialCitas(Context context, List<CitasHist> listHistCitas) {
        this.context = context;
        this.listHistCitas = listHistCitas;
    }

    @NonNull
    @Override
    public HistorialCitasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historial_citas,parent, false);
        return new HistorialCitasViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull HistorialCitasViewHolder holder, int position) {
        CitasHist histCit = listHistCitas.get(position);
        holder.fechaHistCita.setText(histCit.getFecha());
        holder.horaHistCita.setText(histCit.getHora());
        holder.espHistCita.setText(histCit.getEspecialidad());
        holder.medHistCita.setText(histCit.getMedico());
        holder.diagHistCita.setText(histCit.getDiagnostico());

    }

    @Override
    public int getItemCount() {
        return listHistCitas.size();
    }

    public static class HistorialCitasViewHolder extends RecyclerView.ViewHolder{

        TextView fechaHistCita, horaHistCita, espHistCita, medHistCita, diagHistCita;
        public HistorialCitasViewHolder(@NonNull View itemView) {
            super(itemView);

            fechaHistCita = (TextView) itemView.findViewById(R.id.fechaHistCita);
            horaHistCita = (TextView) itemView.findViewById(R.id.horaHistCita);
            espHistCita = (TextView) itemView.findViewById(R.id.espHistCita);
            medHistCita = (TextView) itemView.findViewById(R.id.medHistCita);
            diagHistCita = (TextView) itemView.findViewById(R.id.diagHistCita);

        }
    }
}

