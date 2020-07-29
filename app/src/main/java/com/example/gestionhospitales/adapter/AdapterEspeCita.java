package com.example.gestionhospitales.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionhospitales.MedicosListado;
import com.example.gestionhospitales.R;
import com.example.gestionhospitales.ReservarCitaMedicos;
import com.example.gestionhospitales.pojo.Especialidad;

import java.util.List;

public class AdapterEspeCita extends RecyclerView.Adapter<AdapterEspeCita.EspecialidadViewHolder>{

    Context context;
    List<Especialidad> espLista;

    public AdapterEspeCita(Context context, List<Especialidad> espLista) {
        this.context = context;
        this.espLista = espLista;
    }

    @NonNull
    @Override
    public EspecialidadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_espec_cita,parent, false);
        return new EspecialidadViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EspecialidadViewHolder holder, int position) {
        Especialidad esp = espLista.get(position);
        holder.nameEspeCita.setText(esp.getNombEsp());
        holder.descEspeCita.setText(esp.getDescrip());
    }

    @Override
    public int getItemCount() {
        return espLista.size();
    }

    public static class EspecialidadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context contextEsp;
        TextView nameEspeCita, descEspeCita;

        Button docEspeCita;
        public EspecialidadViewHolder(@NonNull View itemView) {
            super(itemView);
            contextEsp = itemView.getContext();
            nameEspeCita = (TextView) itemView.findViewById(R.id.nameEspeCita);
            descEspeCita = (TextView) itemView.findViewById(R.id.descEspeCita);

            docEspeCita =(Button) itemView.findViewById(R.id.docEspeCita);
            setOnClickListeners();

        }
        public void setOnClickListeners(){
            docEspeCita.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(contextEsp, ReservarCitaMedicos.class);
            intent.putExtra("nameEspeCita", nameEspeCita.getText());
            contextEsp.startActivity(intent);
        }
    }
}
