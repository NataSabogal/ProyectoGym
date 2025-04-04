/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DTO.AsistenciaDTO;

/**
 *
 * @author bran-
 */
public class AsistenciaService {

    private AsistenciaService asistenciaService;

    public AsistenciaService() {
        this.asistenciaService = new AsistenciaService();

    }

    public AsistenciaService obtenerClientePorCedula(String cedula) {
        return asistenciaService.obtenerClientePorCedula(cedula);
    }

    public AsistenciaDTO registrarAsistencia(String cedula) {
        return asistenciaService.registrarAsistencia(cedula);
    }

}
