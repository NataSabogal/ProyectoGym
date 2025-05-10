/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DTO.PlanMembresiaDTO;
import Services.PlanMembresiaService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nataliasabogalrada
 */
public class PlanMembresiaController {

    private PlanMembresiaService planMembresiaService;

    public PlanMembresiaController() {
        planMembresiaService = new PlanMembresiaService();
    }

    public boolean crearPlanMembresia(String nombre, String descripcion, double precio, int duracion) {
        PlanMembresiaDTO plan = new PlanMembresiaDTO(nombre, descripcion, precio, duracion);
        return planMembresiaService.crearPlanMembresia(plan);
    }

    public PlanMembresiaDTO buscarPlan(String nombre) {
        return planMembresiaService.buscarPlan(nombre);

    }

    public PlanMembresiaDTO buscarPlanPorId(Integer idPlan) {
        return planMembresiaService.buscarPlanPorId(idPlan);
    }

    public boolean actualizarPlan(String nombre, String descripcion, double precio, int duracion) {
        PlanMembresiaDTO plan = new PlanMembresiaDTO(nombre, descripcion, precio, duracion);
        return planMembresiaService.actualizarPlan(plan);
    }

    public boolean eliminarPlan(String nombre) {
        return planMembresiaService.eliminarPlan(nombre);
    }

    public List<PlanMembresiaDTO> obtenerTodosPlanes() {
        return planMembresiaService.obtenerTodosPlanes();
    }

    public List<String> obtenerNombresPlanes() {
        List<PlanMembresiaDTO> planes = planMembresiaService.obtenerTodosPlanes();
        List<String> nombresPlanes = new ArrayList<>();
        for (PlanMembresiaDTO plan : planes) {
            nombresPlanes.add(plan.getNombre());
        }
        return nombresPlanes;
    }

    public List<String> obtenerDescripcionesPlanes() {
        List<PlanMembresiaDTO> planes = planMembresiaService.obtenerTodosPlanes();
        List<String> descripcionesPlanes = new ArrayList<>();
        for (PlanMembresiaDTO plan : planes) {
            descripcionesPlanes.add(plan.getDescripcion()); 
        }
        return descripcionesPlanes;
    }
}
