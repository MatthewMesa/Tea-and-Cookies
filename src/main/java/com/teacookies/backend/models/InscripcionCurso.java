package com.teacookies.backend.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class InscripcionCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "codCurso", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    // Relación con EstadoInscripcionCurso
    @ManyToOne
    @JoinColumn(name = "cod_estado_inscripcion_curso", nullable = false)
    private EstadoInscripcionCurso estadoInscripcionCurso;

    // Relación con TipoUsuario
    @ManyToOne
    @JoinColumn(name = "codTipoUsuario", nullable = false)
    private TipoUsuario tipoUsuario;

    // Relación con Asistencia
    @OneToMany(mappedBy = "inscripcionCurso", cascade = CascadeType.ALL)
    private List<Asistencia> asistencias;

    private Float calificacionFinal;
    private Integer numeroInscripcion;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Float getCalificacionFinal() {
        return calificacionFinal;
    }

    public void setCalificacionFinal(Float calificacionFinal) {
        this.calificacionFinal = calificacionFinal;
    }

    public Integer getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(Integer numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }
}
