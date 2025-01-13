package com.teacookies.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "examen_pregunta")
public class ExamenPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordenPregunta;

    @Column(nullable = false)
    private float puntajePregunta;

    @ManyToOne
    @JoinColumn(name = "codExamen", nullable = false)
    private Examen examen;

    @ManyToOne
    @JoinColumn(name = "codPregunta", nullable = false)
    private Pregunta pregunta;

    public ExamenPregunta() {
    }

    // Getters y Setters
    public int getOrdenPregunta() {
        return ordenPregunta;
    }

    public void setOrdenPregunta(int ordenPregunta) {
        this.ordenPregunta = ordenPregunta;
    }

    public float getPuntajePregunta() {
        return puntajePregunta;
    }

    public void setPuntajePregunta(float puntajePregunta) {
        this.puntajePregunta = puntajePregunta;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
}
