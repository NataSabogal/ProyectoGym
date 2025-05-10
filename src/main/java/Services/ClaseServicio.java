/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DTO.AsistenciaDTO;
import DTO.ClaseDTO;
import Repository.ClaseRepositorio;

/**
 *
 * @author bran-
 */
public class ClaseServicio {

    
        
    private ClaseRepositorio asignarClaseGrupales;

    public ClaseServicio() {

        this.asignarClaseGrupales = new ClaseRepositorio();
    }
    
    public boolean registrarClase(ClaseDTO clase) {
        return asignarClaseGrupales.saveClase(clase);
    }
}
