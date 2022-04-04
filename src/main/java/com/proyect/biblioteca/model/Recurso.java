package com.proyect.biblioteca.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Document(collection = "recursos")
public class Recurso {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private LocalDate fechaDeSalida;
    private boolean isPrestado;
    private String titulo;
    private String tipo;
    private String areaTematica;

    public Recurso(String titulo, String tipo,String areaTematica){
        this.fechaDeSalida = LocalDate.now();
        this.isPrestado = false;
        this.titulo = Objects.requireNonNull(titulo);
        this.tipo = Objects.requireNonNull(tipo);
        this.areaTematica = areaTematica;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaDeSalida() {
        return fechaDeSalida;
    }

    public void setFechaDeSalida(LocalDate fechaDeSalida) {
        this.fechaDeSalida = fechaDeSalida;
    }

    public boolean isPrestado() {
        return isPrestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Recurso setPrestado(boolean prestado) {
        this.isPrestado = prestado;
        return this;
    }

    public String getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(String areaTematica) {
        this.areaTematica = areaTematica;
    }
}
