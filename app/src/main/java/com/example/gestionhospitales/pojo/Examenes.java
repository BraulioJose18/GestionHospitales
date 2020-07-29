package com.example.gestionhospitales.pojo;

public class Examenes {

    private String fecha;
    private String tipo;
    private String hora;

    public Examenes() {
    }

    public Examenes(String fecha, String tipo, String hora) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
