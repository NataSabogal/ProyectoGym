/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DTO.AsistenciaDTO;
import Services.AsistenciaService;

/**
 *
 * @author bran-
 */
public class AsistenciaController {
    
    private AsistenciaService asistenciaService;

    public AsistenciaController() {
        this.asistenciaService = new AsistenciaService();
    }
    
    public AsistenciaService obtenerClientePorCedula(String cedula) {
        return asistenciaService.obtenerClientePorCedula(cedula);
    }
    
     public AsistenciaDTO registrarAsistencia(String cedula) {
         return asistenciaService.registrarAsistencia(cedula);
     }
}
