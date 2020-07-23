package com.example.gestionhospitales.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestionhospitales.R;
import com.example.gestionhospitales.pojo.Doctores;

import java.util.List;

public class AdapterDoc extends RecyclerView.Adapter<AdapterDoc.DocViewHolder>{

    Context context;
    List<Doctores> docLista;
    public AdapterDoc(Context context, List<Doctores> docLista) {
        this.context = context;
        this.docLista = docLista;
    }

    @NonNull
    @Override
    public DocViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctores,parent, false);
        return new DocViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DocViewHolder holder, int position) {
        Doctores doc = docLista.get(position);
        holder.nameDoc.setText(doc.getNombre());
        holder.apellDoc.setText(doc.getApellido());
        holder.espDoc.setText(doc.getEspecialidad());

    }

    @Override
    public int getItemCount() {
        return docLista.size();
    }

    public static class DocViewHolder extends RecyclerView.ViewHolder{

        TextView nameDoc, apellDoc, espDoc;
        public DocViewHolder(@NonNull View itemView) {
            super(itemView);
            nameDoc = (TextView) itemView.findViewById(R.id.nameDoc);
            apellDoc = (TextView) itemView.findViewById(R.id.apellDoc);
            espDoc = (TextView) itemView.findViewById(R.id.espDoc);
        }
    }
}
