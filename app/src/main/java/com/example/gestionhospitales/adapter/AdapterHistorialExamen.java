package com.example.gestionhospitales.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionhospitales.R;
import com.example.gestionhospitales.pojo.Examenes;

import java.util.List;

public class AdapterHistorialExamen extends RecyclerView.Adapter<AdapterHistorialExamen.ExamenViewHolder>{

    Context context;
    List<Examenes> listExamenes;

    public AdapterHistorialExamen(Context context, List<Examenes> listExamenes) {
        this.context = context;
        this.listExamenes = listExamenes;
    }

    @NonNull
    @Override
    public ExamenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historial_examen,parent, false);
        return new ExamenViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ExamenViewHolder holder, int position) {
        Examenes histExam = listExamenes.get(position);
        holder.fechaHistExam.setText(histExam.getFecha());
        holder.horaHistExam.setText(histExam.getHora());
        holder.examenHist.setText(histExam.getTipo());

    }

    @Override
    public int getItemCount() {
        return listExamenes.size();
    }

    public static class ExamenViewHolder extends RecyclerView.ViewHolder{

        TextView fechaHistExam, horaHistExam, examenHist;
        public ExamenViewHolder(@NonNull View itemView) {
            super(itemView);

            fechaHistExam = (TextView) itemView.findViewById(R.id.fechaHistExamen);
            horaHistExam = (TextView) itemView.findViewById(R.id.horaHistExamen);
            examenHist = (TextView) itemView.findViewById(R.id.examenHist);

        }
    }
}

