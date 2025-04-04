/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;



/**
 *
 * @author bran-
 */
public class ClaseDTO {

    private int id;
    private String nombreClase;
    private String entrenadorDTO; // No es un String es un objeto
    private Date fechaClase;
    private String horaClase;

    public ClaseDTO() {

    }

    public ClaseDTO(int id, String nombreClase, String entrenadorDTO, Date fechaClase, String horaClase) {
        this.id = id;
        this.nombreClase = nombreClase;
        this.entrenadorDTO = entrenadorDTO;
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

    public String getEntrenadorDTO() {
        return entrenadorDTO;
    }

    public void setEntrenadorDTO(String entrenadorDTO) {
        this.entrenadorDTO = entrenadorDTO;
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


