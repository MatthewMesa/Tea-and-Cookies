package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "material")
public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codMaterial;

    @Column(nullable = false, length = 200)
    private String nombreMaterial;

    @Column(nullable = false, length = 300)
    private String linkMaterial;

    @Column(nullable = false)
    private LocalDateTime fechaHoraFinVigenciaMaterial;

    // Relación con UserStory
    @ManyToOne
    @JoinColumn(name = "codUS", nullable = false)
    private UserStory userStory;

    public Material() {
    }

    // Getters y Setters
    public int getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(int codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getLinkMaterial() {
        return linkMaterial;
    }

    public void setLinkMaterial(String linkMaterial) {
        this.linkMaterial = linkMaterial;
    }

    public LocalDateTime getFechaHoraFinVigenciaMaterial() {
        return fechaHoraFinVigenciaMaterial;
    }

    public void setFechaHoraFinVigenciaMaterial(LocalDateTime fechaHoraFinVigenciaMaterial) {
        this.fechaHoraFinVigenciaMaterial = fechaHoraFinVigenciaMaterial;
    }
}
