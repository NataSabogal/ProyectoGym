/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DTO.EntrenadorDTO;
import Services.EntrenadorService;
import java.util.List;

/**
 *
 * @author nataliasabogalrada
 */
public class EntrenadorController {
    
     private EntrenadorService entrenadorService;

    public EntrenadorController() {
        this.entrenadorService = new EntrenadorService();
    }

    public boolean registrarEntrenador(String cedula, String nombre, String correo, String telefono) {
        EntrenadorDTO entrenador = new EntrenadorDTO(cedula, nombre, correo, telefono);
        return entrenadorService.registrarEntrenador(entrenador);
    }

    public EntrenadorDTO buscarEntrenador(String cedula) {
        return entrenadorService.obtenerEntrenador(cedula);
    }

    public boolean actualizarEntrenador(String cedula, String nombre, String correo, String telefono) {
        EntrenadorDTO entrenador = new EntrenadorDTO(cedula, nombre, correo, telefono);
        return entrenadorService.modificarEntrenador(entrenador);
    }

    public boolean eliminarEntrenador(String cedula) {
        return entrenadorService.eliminarEntrenador(cedula);
    }
    
    public List<EntrenadorDTO> obtenerListaEntrenadores(){
        return entrenadorService.obtenerTodosEntrenadores();
    }
}
