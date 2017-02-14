/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author gc.andrade10
 */
public class HistorialDTO 
{
    private ArrayList alertas;
    
    private PacienteDTO paciente;

    public HistorialDTO()
    {
    }
    
    

    /**
     * @return the alertas
     */
    public ArrayList getAlertas()
    {
        return alertas;
    }

    /**
     * @param alertas the alertas to set
     */
    public void setAlertas(ArrayList alertas)
    {
        this.alertas = alertas;
    }

    /**
     * @return the paciente
     */
    public PacienteDTO getPaciente()
    {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(PacienteDTO paciente)
    {
        this.paciente = paciente;
    }
    
    
    
}
