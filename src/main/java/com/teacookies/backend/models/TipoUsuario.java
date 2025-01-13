package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codTipoUsuario;

    @Column(nullable = false, length = 100)
    private String nombreTipoUsuario;

    @Column(nullable = true)
    private String descripcionTipoUsuario;

    @Column(nullable = false)
    private java.time.LocalDateTime fechaHoraFinVigenciaTipoUsuario;

    // Relación con InscripcionCurso
    @OneToMany(mappedBy = "tipoUsuario", cascade = CascadeType.ALL)
    private List<InscripcionCurso> inscripcionesCurso;

    public TipoUsuario() {
    }

    // Getters y Setters
    public int getCodTipoUsuario() {
        return codTipoUsuario;
    }

    public void setCodTipoUsuario(int codTipoUsuario) {
        this.codTipoUsuario = codTipoUsuario;
    }

    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }

    public String getDescripcionTipoUsuario() {
        return descripcionTipoUsuario;
    }

    public void setDescripcionTipoUsuario(String descripcionTipoUsuario) {
        this.descripcionTipoUsuario = descripcionTipoUsuario;
    }

    public java.time.LocalDateTime getFechaHoraFinVigenciaTipoUsuario() {
        return fechaHoraFinVigenciaTipoUsuario;
    }

    public void setFechaHoraFinVigenciaTipoUsuario(java.time.LocalDateTime fechaHoraFinVigenciaTipoUsuario) {
        this.fechaHoraFinVigenciaTipoUsuario = fechaHoraFinVigenciaTipoUsuario;
    }
}
