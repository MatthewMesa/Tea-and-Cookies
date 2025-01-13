package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCurso;

    @Column(nullable = false)
    private String nombreCurso;

    @Column(nullable = false)
    private String descripcionCurso;

    @Column(nullable = false)
    private Date fechaInicioCurso;

    @Column(nullable = false)
    private Date fechaFinCurso;

    private Integer porcentajeAprobacion;

    private String planEstudio;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InscripcionCurso> inscripciones = new ArrayList<>();

    // Relación recursiva
    @ManyToOne
    @JoinColumn(name = "curso_previo", referencedColumnName = "codCurso")
    private Curso cursoPrevio;

    @OneToMany(mappedBy = "cursoPrevio", cascade = CascadeType.ALL)
    private List<Curso> cursosPosteriores;

    // Dentro de la clase Curso
    @ManyToOne
    @JoinColumn(name = "cod_epic", nullable = false)
    private Epic epic;


    // Getters y Setters
    public Long getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Long codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    public Date getFechaInicioCurso() {
        return fechaInicioCurso;
    }

    public void setFechaInicioCurso(Date fechaInicioCurso) {
        this.fechaInicioCurso = fechaInicioCurso;
    }

    public Date getFechaFinCurso() {
        return fechaFinCurso;
    }

    public void setFechaFinCurso(Date fechaFinCurso) {
        this.fechaFinCurso = fechaFinCurso;
    }

    public Integer getPorcentajeAprobacion() {
        return porcentajeAprobacion;
    }

    public void setPorcentajeAprobacion(Integer porcentajeAprobacion) {
        this.porcentajeAprobacion = porcentajeAprobacion;
    }

    public String getPlanEstudio() {
        return planEstudio;
    }

    public void setPlanEstudio(String planEstudio) {
        this.planEstudio = planEstudio;
    }

    public List<InscripcionCurso> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<InscripcionCurso> inscripciones) {
        this.inscripciones = inscripciones;
    }
}
