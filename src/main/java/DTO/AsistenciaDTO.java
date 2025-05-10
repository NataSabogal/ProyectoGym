/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author bran-
 */
public class AsistenciaDTO {
    
    ClienteDTO cliente;
    LocalDate fecha;
    LocalTime horaEntrada;

    public AsistenciaDTO() {
    }

    public AsistenciaDTO(ClienteDTO cliente, LocalDate fecha, LocalTime horaEntrada) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

}
