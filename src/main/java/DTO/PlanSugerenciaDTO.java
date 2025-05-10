/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author nataliasabogalrada
 */
public class PlanSugerenciaDTO {
    
    private String objetivo;
    private String planRecomendado;

    public PlanSugerenciaDTO(String objetivo, String planRecomendado) {
        this.objetivo = objetivo;
        this.planRecomendado = planRecomendado;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getPlanRecomendado() {
        return planRecomendado;
    }

    public void setPlanRecomendado(String planRecomendado) {
        this.planRecomendado = planRecomendado;
    }

    
    
}
