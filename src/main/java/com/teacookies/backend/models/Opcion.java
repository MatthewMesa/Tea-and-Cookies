package com.teacookies.backend.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "opcion")
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codOpcion;

    @Column(nullable = false)
    private boolean correcta;

    @Column(nullable = false)
    private String descripcionOpcion;

    @Column(nullable = false)
    private LocalDate fechaHoraFinVigenciaOpcion;

    @ManyToOne
    @JoinColumn(name = "codPregunta", nullable = false)
    private Pregunta pregunta;

    // Getters y Setters
    public int getCodOpcion() {
        return codOpcion;
    }

    public void setCodOpcion(int codOpcion) {
        this.codOpcion = codOpcion;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    public String getDescripcionOpcion() {
        return descripcionOpcion;
    }

    public void setDescripcionOpcion(String descripcionOpcion) {
        this.descripcionOpcion = descripcionOpcion;
    }

    public LocalDate getFechaHoraFinVigenciaOpcion() {
        return fechaHoraFinVigenciaOpcion;
    }

    public void setFechaHoraFinVigenciaOpcion(LocalDate fechaHoraFinVigenciaOpcion) {
        this.fechaHoraFinVigenciaOpcion = fechaHoraFinVigenciaOpcion;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
}
