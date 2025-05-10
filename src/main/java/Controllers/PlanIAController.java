/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DTO.PlanMembresiaDTO;
import Services.PlanIAService;
import java.util.List;

/**
 *
 * @author nataliasabogalrada
 */
public class PlanIAController {

    private final PlanIAService planIAService;
    private final PlanMembresiaController planMembresiaController;

    public PlanIAController(PlanIAService planIAService, PlanMembresiaController planMembresiaController) {
        this.planIAService = planIAService;
        this.planMembresiaController = planMembresiaController;
    }

    public String construirPrompt(String objetivo) {
        // Obtener los nombres de los planes registrados
        List<PlanMembresiaDTO> planes = planMembresiaController.obtenerTodosPlanes();

        StringBuilder planesDetalles = new StringBuilder();
        for (PlanMembresiaDTO plan : planes) {
            planesDetalles.append(plan.getNombre())
                    .append(": ")
                    .append(plan.getDescripcion())
                    .append("; ");
        }
        
        return "Con base en el objetivo: " + objetivo
                + ", hablame de un plan de membresía adecuado entre los nombre de los siguientes planes de membrsia: " + planesDetalles+
                " ten en cuenta la descripcion que tiene cada plan de membresia y comparalos no hables mal de los planes de membresia existentes ni de que tienen poca información, explícame por qué es el mas adecuado para ese objetivo que tiene el cliente, se muy claro y objetivo explicalo máximo de 7 líneas.";
    }

    public String obtenerMensajeSugerencia(String objetivo) {
        String prompt = construirPrompt(objetivo);

        String sugerenciaIA = planIAService.sugerirPlan(prompt);

        List<String> nombresPlanes = planMembresiaController.obtenerNombresPlanes();
        return "Podria decir que: " + sugerenciaIA;

    }
}
