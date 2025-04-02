 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DTO.EntrenadorDTO;
import Repository.EntrenadorRepository;

/**
 *
 * @author nataliasabogalrada
 */
public class EntrenadorService {
    
    private EntrenadorRepository entrenadorRepository;

    public EntrenadorService() {
        this.entrenadorRepository = new EntrenadorRepository();
    }

    public boolean registrarEntrenador(EntrenadorDTO entrenador) {
        if (entrenador.getCedula().isEmpty() || entrenador.getNombre().isEmpty()) {
            System.out.println("La cédula y el nombre son obligatorios.");
            return false;
        }
        return entrenadorRepository.guardarEntrenador(entrenador);
    }

    public EntrenadorDTO obtenerEntrenador(String cedula) {
        return entrenadorRepository.buscarEntrenador(cedula);
    }

    public boolean modificarEntrenador(EntrenadorDTO entrenador) {
        return entrenadorRepository.actualizarEntrenador(entrenador);
    }

    public boolean eliminarEntrenador(String cedula) {
        return entrenadorRepository.eliminarEntrenador(cedula);
    }
}
