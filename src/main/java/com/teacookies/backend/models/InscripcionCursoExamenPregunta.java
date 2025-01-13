package com.teacookies.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "inscripcion_curso_examen_pregunta")
public class InscripcionCursoExamenPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private String desarrollo;

    @Column(nullable = true)
    private float puntajeObtenido;

    @ManyToOne
    @JoinColumn(name = "codExamenPregunta", nullable = false)
    private ExamenPregunta examenPregunta;

    @ManyToOne
    @JoinColumn(name = "codOpcion", nullable = true)
    private Opcion opcion;

    @ManyToOne
    @JoinColumn(name = "id_inscripcion_curso_examen", nullable = false)
    private InscripcionCursoExamen inscripcionCursoExamen;

    public InscripcionCursoExamenPregunta() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesarrollo() {
        return desarrollo;
    }

    public void setDesarrollo(String desarrollo) {
        this.desarrollo = desarrollo;
    }

    public float getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public void setPuntajeObtenido(float puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }

    public ExamenPregunta getExamenPregunta() {
        return examenPregunta;
    }

    public void setExamenPregunta(ExamenPregunta examenPregunta) {
        this.examenPregunta = examenPregunta;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }
}
