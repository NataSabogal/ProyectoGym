package DTO;

import java.sql.Date;

public class ClaseDTO {

    private int id;
    private String nombreClase;
    private String cedulaEntrenador;
    private Date fechaClase;
    private String horaClase;

    public ClaseDTO() {
    }

    public ClaseDTO(int id, String nombreClase, String cedulaEntrenador, Date fechaClase, String horaClase) {
        this.id = id;
        this.nombreClase = nombreClase;
        this.cedulaEntrenador = cedulaEntrenador;
        this.fechaClase = fechaClase;
        this.horaClase = horaClase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getCedulaEntrenador() {
        return cedulaEntrenador;
    }

    public void setCedulaEntrenador(String entrenadorDTO) {
        this.cedulaEntrenador = entrenadorDTO;
    }

    public Date getFechaClase() {
        return fechaClase;
    }

    public void setFechaClase(Date fechaClase) {
        this.fechaClase = fechaClase;
    }

    public String getHoraClase() {
        return horaClase;
    }

    public void setHoraClase(String horaClase) {
        this.horaClase = horaClase;
    }
}
