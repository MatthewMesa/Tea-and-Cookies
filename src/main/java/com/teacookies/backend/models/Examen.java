package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "examen")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codExamen;

    @Column(nullable = false)
    private String descripcionExamen;

    @Column(nullable = false)
    private LocalDateTime fechaHoraFinVigenciaExamen;

    public Examen() {
    }

    // Getters y Setters
    public int getCodExamen() {
        return codExamen;
    }

    public void setCodExamen(int codExamen) {
        this.codExamen = codExamen;
    }

    public String getDescripcionExamen() {
        return descripcionExamen;
    }

    public void setDescripcionExamen(String descripcionExamen) {
        this.descripcionExamen = descripcionExamen;
    }

    public LocalDateTime getFechaHoraFinVigenciaExamen() {
        return fechaHoraFinVigenciaExamen;
    }

    public void setFechaHoraFinVigenciaExamen(LocalDateTime fechaHoraFinVigenciaExamen) {
        this.fechaHoraFinVigenciaExamen = fechaHoraFinVigenciaExamen;
    }
}
