package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "inscripcion_curso_examen")
public class InscripcionCursoExamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private float calificacionExamen;

    @Column(nullable = true)
    private LocalDateTime fechaHoraFinRendir;

    @Column(nullable = true)
    private LocalDateTime fechaHoraInicioRendir;

    @ManyToOne
    @JoinColumn(name = "codInscripcionCurso", nullable = false)
    private InscripcionCurso inscripcionCurso;

    @OneToMany(mappedBy = "inscripcionCursoExamen", cascade = CascadeType.ALL)
    private List<InscripcionCursoExamenPregunta> preguntas;

    @ManyToOne
    @JoinColumn(name = "cod_curso_examen", nullable = false)
    private CursoExamen cursoExamen;

    public InscripcionCursoExamen() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCalificacionExamen() {
        return calificacionExamen;
    }

    public void setCalificacionExamen(float calificacionExamen) {
        this.calificacionExamen = calificacionExamen;
    }

    public LocalDateTime getFechaHoraFinRendir() {
        return fechaHoraFinRendir;
    }

    public void setFechaHoraFinRendir(LocalDateTime fechaHoraFinRendir) {
        this.fechaHoraFinRendir = fechaHoraFinRendir;
    }

    public LocalDateTime getFechaHoraInicioRendir() {
        return fechaHoraInicioRendir;
    }

    public void setFechaHoraInicioRendir(LocalDateTime fechaHoraInicioRendir) {
        this.fechaHoraInicioRendir = fechaHoraInicioRendir;
    }

    public InscripcionCurso getInscripcionCurso() {
        return inscripcionCurso;
    }

    public void setInscripcionCurso(InscripcionCurso inscripcionCurso) {
        this.inscripcionCurso = inscripcionCurso;
    }
}
