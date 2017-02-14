/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.ejb;

import dto.AlertaDTO;
import dto.DispositivoDTO;
import logica.interfaces.IHospital;


/**
 *
 * @author gc.andrade10
 */
public class HospitalLogicMock implements IHospital
{

    public void notificarEmergencia(AlertaDTO alerta)
    {
        //TODO
        
    }

    @Override
    public void guardarAlerta(AlertaDTO a, DispositivoDTO d)
    {
        //Guarda la alerta
        if(a.getFrecuenciaCardica()>100)
        {
            a.setTipo(1);
        }
        //buscar ultimo id de alerta
        a.setId(7);
        
    }
    
}
