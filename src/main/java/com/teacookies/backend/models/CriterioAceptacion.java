package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "criterio_aceptacion")
public class CriterioAceptacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codCriterioAceptacion;

    @Column(nullable = false, length = 200)
    private String nombreCriterio;

    @Column(nullable = false, length = 500)
    private String descripcionCriterio;

    // Relación con UserStory
    @ManyToOne
    @JoinColumn(name = "codUS", nullable = false)
    private UserStory userStory;

    public CriterioAceptacion() {
    }

    // Getters y Setters
    public int getCodCriterioAceptacion() {
        return codCriterioAceptacion;
    }

    public void setCodCriterioAceptacion(int codCriterioAceptacion) {
        this.codCriterioAceptacion = codCriterioAceptacion;
    }

    public String getNombreCriterio() {
        return nombreCriterio;
    }

    public void setNombreCriterio(String nombreCriterio) {
        this.nombreCriterio = nombreCriterio;
    }

    public String getDescripcionCriterio() {
        return descripcionCriterio;
    }

    public void setDescripcionCriterio(String descripcionCriterio) {
        this.descripcionCriterio = descripcionCriterio;
    }
}
