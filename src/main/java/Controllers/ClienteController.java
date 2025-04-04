/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DTO.ClienteDTO;
import DTO.PlanMembresiaDTO;
import Services.ClienteService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author nataliasabogalrada
 */
public class ClienteController {
    
    private ClienteService clienteService;
    
    public ClienteController() {
        this.clienteService = new ClienteService();
    }
    
    public boolean registrarCliente(ClienteDTO cliente) {
        return clienteService.registrarCliente(cliente);
    }
    
    public ClienteDTO buscarCliente(String cedula) {
        return clienteService.obtenerClientePorCedula(cedula);
    }
    
    public boolean actualizarCliente(ClienteDTO cliente) {
        //ClienteDTO cliente = new ClienteDTO(0, cedula, nombre, correo, telefono, 0, Date.valueOf(LocalDate.MAX),  0);
        return clienteService.modificarCliente(cliente);
    }
    
    public ClienteDTO obtenerClientePorCedula(String cedula) {
        return clienteService.obtenerClientePorCedula(cedula);
    }
    
    public boolean modificarCliente(ClienteDTO cliente) {
        return clienteService.modificarCliente(cliente);
    }
    
    public boolean eliminarCliente(String cedula) {
        return clienteService.eliminarCliente(cedula);
    }
    
    public List<ClienteDTO> obtenerTodosLosClientes() {
        return clienteService.listarClientes();
    }
    
    public List<PlanMembresiaDTO> obtenerPlanes() {
        return clienteService.obtenerPlanes();
    }
}
