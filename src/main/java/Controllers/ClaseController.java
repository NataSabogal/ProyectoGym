/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DTO.ClaseDTO;
import Services.ClaseServicio;

/**
 *
 * @author bran-
 */
public class ClaseController {
    
    private ClaseServicio claseServicio;

    public ClaseController() {
        this.claseServicio = new ClaseServicio();
    }

    public ClaseController(ClaseServicio claseServicio) {
        this.claseServicio = claseServicio;
    }
    
   public boolean registrarClase(ClaseDTO clase) {
        return claseServicio.registrarClase(clase);
    }
    
}
