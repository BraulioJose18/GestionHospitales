package com.example.gestionhospitales.pojo;

public class CitasHist {

    private String diagnostico;
    private String especialidad;
    private String fecha;
    private String hora;
    private String medico;

    public CitasHist() {
    }
    public CitasHist( String especialidad, String fecha, String hora, String medico) {
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.hora = hora;
        this.medico = medico;
    }

    public CitasHist(String diagnostico, String especialidad, String fecha, String hora, String medico) {
        this.diagnostico = diagnostico;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.hora = hora;
        this.medico = medico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }
}
