/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DTO.ClienteDTO;
import DTO.PlanMembresiaDTO;
import Repository.ClienteRepository;
import Repository.PlanMembresiaRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nataliasabogalrada
 */
public class ClienteService {

    private ClienteRepository clienteRepository;
    private PlanMembresiaService planMembresiaService;
    private List<PlanMembresiaDTO>lista;
    
    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
        this.planMembresiaService = new PlanMembresiaService();
        this.lista = new ArrayList<>();
    }
    
    public List<PlanMembresiaDTO> obtenerPlanes(){
        return planMembresiaService.obtenerTodosPlanes();
    }

    public boolean registrarCliente(ClienteDTO cliente) {
        return clienteRepository.guardarCliente(cliente);
    }

    public ClienteDTO obtenerClientePorCedula(String cedula) {
        return clienteRepository.buscarClientePorCedula(cedula);
    }

    public boolean modificarCliente(ClienteDTO cliente) {
        return clienteRepository.actualizarCliente(cliente);
    }

    public boolean eliminarCliente(String cedula) {
        return clienteRepository.eliminarCliente(cedula);
    }

    public List<ClienteDTO> listarClientes() {
        return clienteRepository.obtenerTodosClientes();
    }
}
