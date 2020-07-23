package com.example.gestionhospitales.pojo;

public class Especialidad {

    private String nombEsp, descrip;

    public Especialidad() {
    }

    public Especialidad(String nombEsp, String descrip) {
        this.nombEsp = nombEsp;
        this.descrip = descrip;
    }

    public String getNombEsp() {
        return nombEsp;
    }

    public void setNombEsp(String nombEsp) {
        this.nombEsp = nombEsp;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
