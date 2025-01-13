package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pregunta")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codPregunta;

    @Column(nullable = false, length = 255)
    private String enunciadoPregunta;

    @Column(nullable = false)
    private LocalDateTime fechaHoraFinVigenciaPregunta;

    @ManyToOne
    @JoinColumn(name = "codTipoPregunta", nullable = false)
    private TipoPregunta tipoPregunta;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
    private List<Opcion> opciones;

    public Pregunta() {
    }

    // Getters y Setters
    public int getCodPregunta() {
        return codPregunta;
    }

    public void setCodPregunta(int codPregunta) {
        this.codPregunta = codPregunta;
    }

    public String getEnunciadoPregunta() {
        return enunciadoPregunta;
    }

    public void setEnunciadoPregunta(String enunciadoPregunta) {
        this.enunciadoPregunta = enunciadoPregunta;
    }

    public LocalDateTime getFechaHoraFinVigenciaPregunta() {
        return fechaHoraFinVigenciaPregunta;
    }

    public void setFechaHoraFinVigenciaPregunta(LocalDateTime fechaHoraFinVigenciaPregunta) {
        this.fechaHoraFinVigenciaPregunta = fechaHoraFinVigenciaPregunta;
    }

    public TipoPregunta getcodTipoPregunta() {
        return tipoPregunta;
    }

    public void setcodTipoPregunta(TipoPregunta tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
    }
}
