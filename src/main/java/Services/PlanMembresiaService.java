/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DTO.PlanMembresiaDTO;
import Repository.PlanMembresiaRepository;
import java.util.List;

/**
 *
 * @author nataliasabogalrada
 */
public class PlanMembresiaService {

    private PlanMembresiaRepository planMembresiaRepository;

    public PlanMembresiaService() {
        planMembresiaRepository = new PlanMembresiaRepository();
    }

   public boolean crearPlanMembresia(PlanMembresiaDTO plan) {
        return planMembresiaRepository.guardarPlan(plan);
    }

    public PlanMembresiaDTO buscarPlan(String nombre) {
        return planMembresiaRepository.buscarPlan(nombre);
    }

    public boolean actualizarPlan(PlanMembresiaDTO plan) {
        return planMembresiaRepository.actualizarPlan(plan);
    }

    public boolean eliminarPlan(String nombre) {
        return planMembresiaRepository.eliminarPlan(nombre);
    }
    
     public List<PlanMembresiaDTO> obtenerTodosPlanes() {
        return planMembresiaRepository.obtenerTodosPlanes();
    }

}
