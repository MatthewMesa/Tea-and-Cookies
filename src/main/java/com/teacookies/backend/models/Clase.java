package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clase")
public class Clase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codClase;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaClase;

    @Column(nullable = false, length = 200)
    private String temaClase;

    @ManyToOne
    @JoinColumn(name = "codTipoClase", nullable = false)
    private TipoClase tipoClase;

    // Relación con UserStory
    @ManyToOne
    @JoinColumn(name = "cod_user_story", nullable = false)
    private UserStory userStory;

    public Clase() {
    }

    // Getters y Setters
    public int getCodClase() {
        return codClase;
    }

    public void setCodClase(int codClase) {
        this.codClase = codClase;
    }

    public Date getFechaClase() {
        return fechaClase;
    }

    public void setFechaClase(Date fechaClase) {
        this.fechaClase = fechaClase;
    }

    public String getTemaClase() {
        return temaClase;
    }

    public void setTemaClase(String temaClase) {
        this.temaClase = temaClase;
    }

    public TipoClase getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(TipoClase tipoClase) {
        this.tipoClase = tipoClase;
    }
}
