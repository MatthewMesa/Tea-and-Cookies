package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "epic")
public class Epic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codEpic;

    @Column(nullable = false, length = 100)
    private String nombreEpic;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraFinVigenciaEpic;

    // Relación con Curso
    @OneToMany(mappedBy = "epic", cascade = CascadeType.ALL)
    private List<Curso> cursos;

    public Epic() {
    }

    // Getters y Setters
    public int getCodEpic() {
        return codEpic;
    }

    public void setCodEpic(int codEpic) {
        this.codEpic = codEpic;
    }

    public String getNombreEpic() {
        return nombreEpic;
    }

    public void setNombreEpic(String nombreEpic) {
        this.nombreEpic = nombreEpic;
    }

    public Date getFechaHoraFinVigenciaEpic() {
        return fechaHoraFinVigenciaEpic;
    }

    public void setFechaHoraFinVigenciaEpic(Date fechaHoraFinVigenciaEpic) {
        this.fechaHoraFinVigenciaEpic = fechaHoraFinVigenciaEpic;
    }
}
