/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author nataliasabogalrada
 */
public class ClienteDTO {

    private int id;
    private String cedula;
    private String nombre;
    private String correo;
    private String telefono;
    private int planId;
    private Date fechaPago;
    private double montoPago;
    private String objetivo; 

    public ClienteDTO() {
    }

    public ClienteDTO(int id, String cedula, String nombre, String correo, String telefono, int planId, Date fechaPago, double montoPago, String objetivo) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.planId = planId;
        this.fechaPago = fechaPago;
        this.montoPago = montoPago;
        this.objetivo = objetivo;
    }

    public ClienteDTO(String cedula, String nombre, String correo, String telefono, int planId, Date fechaPago, double montoPago, String objetivo) {
        this(0, cedula, nombre, correo, telefono, planId, fechaPago, montoPago, objetivo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public String toString() {
        return "ClienteDTO{"
                + "id=" + id
                + ", cedula='" + cedula + '\''
                + ", nombre='" + nombre + '\''
                + ", correo='" + correo + '\''
                + ", telefono='" + telefono + '\''
                + ", planId=" + planId
                + ", fechaPago=" + fechaPago
                + ", montoPago=" + montoPago
                + ", objetivo='" + objetivo + '\''
                + '}';
    }

}
