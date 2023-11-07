package com.example.lab9_base.Bean;

public class Partido {
    private int idPartido;
    private String fecha;
    private int numeroJornada;
    private SeleccionNacional seleccionLocal;
    private SeleccionNacional seleccionVisitante;
    private Arbitro arbitro;

    public String getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumeroJornada() {
        return numeroJornada;
    }

    public void setNumeroJornada(int numeroJornada) {
        this.numeroJornada = numeroJornada;
    }

    public String getSeleccionLocal() {
        return seleccionLocal;
    }

    public void setSeleccionLocal(SeleccionNacional seleccionLocal) {
        this.seleccionLocal = seleccionLocal;
    }

    public String getSeleccionVisitante() {
        return seleccionVisitante;
    }

    public void setSeleccionVisitante(SeleccionNacional seleccionVisitante) {
        this.seleccionVisitante = seleccionVisitante;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }
}
