package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_story")
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codUS;

    @Column(nullable = false, length = 255)
    private String descripcionUS;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraFinVigenciaUS;

    @Column(nullable = false, length = 50)
    private String modalidadUS;

    @Column(nullable = false)
    private float cantidadHoras;

    @Column(nullable = false)
    private int storyPoints;

    @ManyToOne
    @JoinColumn(name = "codEpic", nullable = false)
    private Epic epic;

    @OneToMany(mappedBy = "userStory", cascade = CascadeType.ALL)
    private List<Ejercitacion> ejercitaciones;

    @OneToMany(mappedBy = "userStory", cascade = CascadeType.ALL)
    private List<CriterioAceptacion> criteriosAceptacion;

    public UserStory() {
    }

    // Getters y Setters
    public int getCodUS() {
        return codUS;
    }

    public void setCodUS(int codUS) {
        this.codUS = codUS;
    }

    public String getDescripcionUS() {
        return descripcionUS;
    }

    public void setDescripcionUS(String descripcionUS) {
        this.descripcionUS = descripcionUS;
    }

    public Date getFechaHoraFinVigenciaUS() {
        return fechaHoraFinVigenciaUS;
    }

    public void setFechaHoraFinVigenciaUS(Date fechaHoraFinVigenciaUS) {
        this.fechaHoraFinVigenciaUS = fechaHoraFinVigenciaUS;
    }

    public String getModalidadUS() {
        return modalidadUS;
    }

    public void setModalidadUS(String modalidadUS) {
        this.modalidadUS = modalidadUS;
    }

    public float getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(float cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public int getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(int storyPoints) {
        this.storyPoints = storyPoints;
    }

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }
}
