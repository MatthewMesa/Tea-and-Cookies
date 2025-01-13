package com.teacookies.backend.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "correo_usuario", nullable = false, unique = true)
    private String correoUsuario;

    @Column(name = "nombre_usuario", nullable = false)
    private String nombreUsuario;

    @Column(name = "fecha_nacimiento_usuario", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimientoUsuario;

    @Column(name = "razon_social_usuario")
    private String razonSocialUsuario;

    @Column(name = "cuil_usuario", nullable = false, unique = true)
    private String cuilUsuario;

    public Usuario() {
    }

    public Usuario(String correoUsuario, String nombreUsuario, Date fechaNacimientoUsuario, String razonSocialUsuario, String cuilUsuario) {
        this.correoUsuario = correoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
        this.razonSocialUsuario = razonSocialUsuario;
        this.cuilUsuario = cuilUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Date getFechaNacimientoUsuario() {
        return fechaNacimientoUsuario;
    }

    public void setFechaNacimientoUsuario(Date fechaNacimientoUsuario) {
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
    }

    public String getRazonSocialUsuario() {
        return razonSocialUsuario;
    }

    public void setRazonSocialUsuario(String razonSocialUsuario) {
        this.razonSocialUsuario = razonSocialUsuario;
    }

    public String getCuilUsuario() {
        return cuilUsuario;
    }

    public void setCuilUsuario(String cuilUsuario) {
        this.cuilUsuario = cuilUsuario;
    }
}
