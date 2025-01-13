package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tipo_pregunta")
public class TipoPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codTipoPregunta;

    @Column(nullable = false, length = 255)
    private String nombreTipoPregunta;

    @Column(nullable = false)
    private LocalDateTime fechaHoraFinVigenciaTipoPregunta;

    // Relación con Pregunta
    @OneToMany(mappedBy = "tipoPregunta", cascade = CascadeType.ALL)
    private List<Pregunta> preguntas;

    public TipoPregunta() {
    }

    // Getters y Setters
    public int getCodTipoPregunta() {
        return codTipoPregunta;
    }

    public void setCodTipoPregunta(int codTipoPregunta) {
        this.codTipoPregunta = codTipoPregunta;
    }

    public String getNombreTipoPregunta() {
        return nombreTipoPregunta;
    }

    public void setNombreTipoPregunta(String nombreTipoPregunta) {
        this.nombreTipoPregunta = nombreTipoPregunta;
    }

    public LocalDateTime getFechaHoraFinVigenciaTipoPregunta() {
        return fechaHoraFinVigenciaTipoPregunta;
    }

    public void setFechaHoraFinVigenciaTipoPregunta(LocalDateTime fechaHoraFinVigenciaTipoPregunta) {
        this.fechaHoraFinVigenciaTipoPregunta = fechaHoraFinVigenciaTipoPregunta;
    }
}
