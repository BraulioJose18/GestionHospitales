package com.example.gestionhospitales.pojo;

public class Recetas {

    private String fecha;
    private String hora;
    private String medicamentos;

    public Recetas() {
    }

    public Recetas(String fecha, String hora, String medicamentos) {
        this.fecha = fecha;
        this.hora = hora;
        this.medicamentos = medicamentos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }
}
