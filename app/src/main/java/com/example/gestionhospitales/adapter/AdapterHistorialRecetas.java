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
import com.example.gestionhospitales.pojo.Recetas;

import java.util.List;

public class AdapterHistorialRecetas extends RecyclerView.Adapter<AdapterHistorialRecetas.HistorialCitasViewHolder>{

    Context context;
    List<Recetas> listHistRecetas;

    public AdapterHistorialRecetas(Context context, List<Recetas> listHistRecetas) {
        this.context = context;
        this.listHistRecetas = listHistRecetas;
    }

    @NonNull
    @Override
    public HistorialCitasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historial_recetas,parent, false);
        return new HistorialCitasViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull HistorialCitasViewHolder holder, int position) {
        Recetas histRec = listHistRecetas.get(position);
        holder.fechaHistReceta.setText(histRec.getFecha());
        holder.horaHistReceta.setText(histRec.getHora());
        holder.recetaHist.setText(histRec.getMedicamentos());
    }

    @Override
    public int getItemCount() {
        return listHistRecetas.size();
    }

    public static class HistorialCitasViewHolder extends RecyclerView.ViewHolder{

        TextView fechaHistReceta, horaHistReceta, recetaHist;
        public HistorialCitasViewHolder(@NonNull View itemView) {
            super(itemView);

            fechaHistReceta = (TextView) itemView.findViewById(R.id.fechaHistReceta);
            horaHistReceta = (TextView) itemView.findViewById(R.id.horaHistReceta);
            recetaHist = (TextView) itemView.findViewById(R.id.recetaHist);

        }
    }
}

