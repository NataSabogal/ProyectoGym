/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DTO.ClienteDTO;
import Services.ClienteService;
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
    
}
