/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DTO.ClienteDTO;
import Repository.AdminPagoRepository;

/**
 *
 * @author bran-
 */
public class AdminPagoService {
    
    AdminPagoRepository adminPagoRepository;

    public AdminPagoService() {
        this.adminPagoRepository = new AdminPagoRepository();
    }
    
    public ClienteDTO obtenerClientePorCedula(String cedula) {
        return adminPagoRepository.buscarClientePorCedula(cedula);
    }
    
}
