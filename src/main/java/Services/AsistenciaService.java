/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DTO.AsistenciaDTO;
import Repository.AsistenciaRepository;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author bran-
 */
public class AsistenciaService {
    
    private final AsistenciaRepository asistenciaRepository;

    public AsistenciaService() {
        this.asistenciaRepository = new AsistenciaRepository();
    }

    public boolean registrarAsistencia(String cedula, LocalDate fecha, LocalTime horaEntrada) {
        return asistenciaRepository.saveAsistencia(cedula, fecha, horaEntrada);
    }

    public AsistenciaDTO buscarAsistenciaPorCedula(String cedula) {
        return asistenciaRepository.buscarAsistenciaPorCedula(cedula);
    }

}
