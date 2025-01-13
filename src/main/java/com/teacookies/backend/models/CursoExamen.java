package com.teacookies.backend.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "curso_examen")
public class CursoExamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private float ponderacionExamen;

    @Column(nullable = false)
    private String tiempoResolucion;

    @Column(nullable = false)
    private String unidadCurso;

    @ManyToOne
    @JoinColumn(name = "codExamen", nullable = false)
    private Examen examen;

    @ManyToOne
    @JoinColumn(name = "codCurso", nullable = false)
    private Curso curso;

    // Relación con UserStory
    @ManyToOne
    @JoinColumn(name = "cod_user_story", nullable = false)
    private UserStory userStory;

    // Relación con InscripcionCursoExamen
    @OneToMany(mappedBy = "cursoExamen", cascade = CascadeType.ALL)
    private List<InscripcionCursoExamen> inscripcionCursoExamenes;

    public CursoExamen() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPonderacionExamen() {
        return ponderacionExamen;
    }

    public void setPonderacionExamen(float ponderacionExamen) {
        this.ponderacionExamen = ponderacionExamen;
    }

    public String getTiempoResolucion() {
        return tiempoResolucion;
    }

    public void setTiempoResolucion(String tiempoResolucion) {
        this.tiempoResolucion = tiempoResolucion;
    }

    public String getUnidadCurso() {
        return unidadCurso;
    }

    public void setUnidadCurso(String unidadCurso) {
        this.unidadCurso = unidadCurso;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
