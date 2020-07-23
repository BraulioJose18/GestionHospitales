package com.example.gestionhospitales.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionhospitales.R;
import com.example.gestionhospitales.StaffMedico;
import com.example.gestionhospitales.pojo.Especialidad;

import java.util.List;

public class AdapterEspecialidad extends RecyclerView.Adapter<AdapterEspecialidad.EspecialidadViewHolder>{

    Context context;
    List<Especialidad> espLista;

    public AdapterEspecialidad(Context context, List<Especialidad> espLista) {
        this.context = context;
        this.espLista = espLista;
    }

    @NonNull
    @Override
    public EspecialidadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_especialidad,parent, false);
        return new EspecialidadViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EspecialidadViewHolder holder, int position) {
        Especialidad esp = espLista.get(position);
        holder.nameEspe.setText(esp.getNombEsp());
        holder.descEspe.setText(esp.getDescrip());
    }

    @Override
    public int getItemCount() {
        return espLista.size();
    }

    public static class EspecialidadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context contextEsp;
        TextView nameEspe, descEspe;

        Button docEspe;
        public EspecialidadViewHolder(@NonNull View itemView) {
            super(itemView);
            contextEsp = itemView.getContext();
            nameEspe = (TextView) itemView.findViewById(R.id.nameEspe);
            descEspe = (TextView) itemView.findViewById(R.id.descEspe);

            docEspe =(Button) itemView.findViewById(R.id.docEspe);
            setOnClickListeners();

        }
        public void setOnClickListeners(){
            docEspe.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(contextEsp, StaffMedico.class);
            contextEsp.startActivity(intent);
        }
    }
}
