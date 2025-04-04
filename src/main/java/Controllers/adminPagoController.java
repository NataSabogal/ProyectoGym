/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DTO.ClienteDTO;
import Services.AdminPagoService;

/**
 *
 * @author bran-
 */
public class adminPagoController {
    
    AdminPagoService adminPagoService;

    public adminPagoController() {
        this.adminPagoService = new AdminPagoService();
    }
    
    public ClienteDTO obtenerClientePorCedula(String cedula) {
        return adminPagoService.obtenerClientePorCedula(cedula);
    }
}
