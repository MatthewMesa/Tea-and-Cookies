package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ejercitacion")
public class Ejercitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codEjercitacion;

    @Column(nullable = false, length = 200)
    private String nombreEjercitacion;

    @Column(nullable = false, length = 300)
    private String linkEjercitacion;

    @Column(nullable = false)
    private LocalDateTime fechaHoraFinVigenciaEjercitacion;

    // Relación con UserStory
    @ManyToOne
    @JoinColumn(name = "cod_user_story", nullable = false)
    private UserStory userStory;

    public Ejercitacion() {
    }

    // Getters y Setters
    public int getCodEjercitacion() {
        return codEjercitacion;
    }

    public void setCodEjercitacion(int codEjercitacion) {
        this.codEjercitacion = codEjercitacion;
    }

    public String getNombreEjercitacion() {
        return nombreEjercitacion;
    }

    public void setNombreEjercitacion(String nombreEjercitacion) {
        this.nombreEjercitacion = nombreEjercitacion;
    }

    public String getLinkEjercitacion() {
        return linkEjercitacion;
    }

    public void setLinkEjercitacion(String linkEjercitacion) {
        this.linkEjercitacion = linkEjercitacion;
    }

    public LocalDateTime getFechaHoraFinVigenciaEjercitacion() {
        return fechaHoraFinVigenciaEjercitacion;
    }

    public void setFechaHoraFinVigenciaEjercitacion(LocalDateTime fechaHoraFinVigenciaEjercitacion) {
        this.fechaHoraFinVigenciaEjercitacion = fechaHoraFinVigenciaEjercitacion;
    }
}
