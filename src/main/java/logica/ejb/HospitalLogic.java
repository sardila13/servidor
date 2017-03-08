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
public class HospitalLogic implements IHospital
{
    
    public void notificarEmergencia(AlertaDTO alerta)
    {
        System.out.println("EMERGENCIA "+alerta.toString());
    }
    
}
