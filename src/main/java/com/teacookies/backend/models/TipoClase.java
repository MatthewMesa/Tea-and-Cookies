package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipo_clase")
public class TipoClase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codTipoClase;

    @Column(nullable = false, length = 200)
    private String nombreTipoClase;

    @Column(nullable = false)
    private String fechaHoraFinVigenciaTipoClase;

    public TipoClase() {
    }

    // Getters y Setters
    public int getCodTipoClase() {
        return codTipoClase;
    }

    public void setCodTipoClase(int codTipoClase) {
        this.codTipoClase = codTipoClase;
    }

    public String getNombreTipoClase() {
        return nombreTipoClase;
    }

    public void setNombreTipoClase(String nombreTipoClase) {
        this.nombreTipoClase = nombreTipoClase;
    }

    public String getFechaHoraFinVigenciaTipoClase() {
        return fechaHoraFinVigenciaTipoClase;
    }

    public void setFechaHoraFinVigenciaTipoClase(String fechaHoraFinVigenciaTipoClase) {
        this.fechaHoraFinVigenciaTipoClase = fechaHoraFinVigenciaTipoClase;
    }
}
