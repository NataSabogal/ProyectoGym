/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DTO.AsistenciaDTO;
import Services.AsistenciaService;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author bran-
 */
public class AsistenciaController {
    
    private final AsistenciaService asistenciaService;

    public AsistenciaController() {
        this.asistenciaService = new AsistenciaService();
    }

    public boolean registrarAsistencia(String cedula, LocalDate fecha, LocalTime horaEntrada) {
        return asistenciaService.registrarAsistencia(cedula, fecha, horaEntrada);
    }

    public AsistenciaDTO buscarAsistenciaPorCedula(String cedula) {
        return asistenciaService.buscarAsistenciaPorCedula(cedula);
    }
     
}
