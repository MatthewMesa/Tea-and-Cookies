package com.teacookies.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "asistencia")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codAsistencia;

    @Column(nullable = false)
    private boolean asistenciaClase;

    @ManyToOne
    @JoinColumn(name = "codClase", nullable = false)
    private Clase clase;

    // Relación con InscripcionCurso
    @ManyToOne
    @JoinColumn(name = "cod_inscripcion_curso", nullable = false)
    private InscripcionCurso inscripcionCurso;

    public Asistencia() {
    }

    // Getters y Setters
    public int getCodAsistencia() {
        return codAsistencia;
    }

    public void setCodAsistencia(int codAsistencia) {
        this.codAsistencia = codAsistencia;
    }

    public boolean isAsistenciaClase() {
        return asistenciaClase;
    }

    public void setAsistenciaClase(boolean asistenciaClase) {
        this.asistenciaClase = asistenciaClase;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
