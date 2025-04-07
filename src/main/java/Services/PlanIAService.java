/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Repository.PlanIARepository;

/**
 *
 * @author nataliasabogalrada
 */
public class PlanIAService {

    private final PlanIARepository planIARepository;

    public PlanIAService(PlanIARepository planIARepository) {
        this.planIARepository = planIARepository;
    }

    public String sugerirPlan(String prompt) {
        if (prompt == null || prompt.isEmpty()) {
            throw new IllegalArgumentException("El prompt no puede estar vacío.");
        }

        try {
            return planIARepository.obtenerPlanRecomendado(prompt);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el plan sugerido: " + e.getMessage(), e);
        }
    }
}
