package com.example.gestionhospitales.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionhospitales.R;
import com.example.gestionhospitales.pojo.Medicos;

import java.util.List;

public class AdapterMed extends RecyclerView.Adapter<AdapterMed.MedViewHolder>{

    Context context;
    List<Medicos> medLista;

    public AdapterMed(Context context, List<Medicos> medLista) {
        this.context = context;
        this.medLista = medLista;
    }

    @NonNull
    @Override
    public MedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medicos,parent, false);
        return new MedViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MedViewHolder holder, int position) {
        Medicos doc = medLista.get(position);
        holder.nombMed.setText(doc.getNombres());
        holder.apellMed.setText(doc.getApellidos());
        holder.correoMed.setText(doc.getCorreo());

    }

    @Override
    public int getItemCount() {
        return medLista.size();
    }

    public static class MedViewHolder extends RecyclerView.ViewHolder{

        TextView nombMed, apellMed, correoMed;
        public MedViewHolder(@NonNull View itemView) {
            super(itemView);
            apellMed = (TextView) itemView.findViewById(R.id.apellMed);
            nombMed = (TextView) itemView.findViewById(R.id.nombMed);
            correoMed = (TextView) itemView.findViewById(R.id.correoMed);
        }
    }
}
