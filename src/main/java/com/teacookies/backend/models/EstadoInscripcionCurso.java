package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "estado_inscripcion_curso")
public class EstadoInscripcionCurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codEstadoInscripcionCurso;

    @Column(nullable = false, length = 100)
    private String nombreEstadoInscripcionCurso;

    @Column(nullable = true)
    private String descripcionEstadoInscripcionCurso;

    @Column(nullable = false)
    private java.time.LocalDateTime fechaHoraFinVigenciaEstadoInscripcionCurso;

    // Relación con InscripcionCurso
    @OneToMany(mappedBy = "estadoInscripcionCurso", cascade = CascadeType.ALL)
    private List<InscripcionCurso> inscripcionesCurso;

    public EstadoInscripcionCurso() {
    }

    // Getters y Setters
    public int getCodEstadoInscripcionCurso() {
        return codEstadoInscripcionCurso;
    }

    public void setCodEstadoInscripcionCurso(int codEstadoInscripcionCurso) {
        this.codEstadoInscripcionCurso = codEstadoInscripcionCurso;
    }

    public String getNombreEstadoInscripcionCurso() {
        return nombreEstadoInscripcionCurso;
    }

    public void setNombreEstadoInscripcionCurso(String nombreEstadoInscripcionCurso) {
        this.nombreEstadoInscripcionCurso = nombreEstadoInscripcionCurso;
    }

    public String getDescripcionEstadoInscripcionCurso() {
        return descripcionEstadoInscripcionCurso;
    }

    public void setDescripcionEstadoInscripcionCurso(String descripcionEstadoInscripcionCurso) {
        this.descripcionEstadoInscripcionCurso = descripcionEstadoInscripcionCurso;
    }

    public java.time.LocalDateTime getFechaHoraFinVigenciaEstadoInscripcionCurso() {
        return fechaHoraFinVigenciaEstadoInscripcionCurso;
    }

    public void setFechaHoraFinVigenciaEstadoInscripcionCurso(java.time.LocalDateTime fechaHoraFinVigenciaEstadoInscripcionCurso) {
        this.fechaHoraFinVigenciaEstadoInscripcionCurso = fechaHoraFinVigenciaEstadoInscripcionCurso;
    }
}
