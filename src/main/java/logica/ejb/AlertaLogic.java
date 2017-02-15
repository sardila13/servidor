/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.ejb;

import dto.AlertaDTO;
import java.util.List;
import logica.interfaces.IAlertaLogic;
import mock.AlertaMock;

/**
 *
 * @author ba.bohorquez10
 */
public class AlertaLogic implements IAlertaLogic
{
    private AlertaMock persistence;
    
    private HospitalLogicMock hospitalLogicMock;
    
    public AlertaLogic()
    {
        persistence = new AlertaMock();
        hospitalLogicMock = new HospitalLogicMock();
    }
    
    public AlertaDTO crearAlerta(AlertaDTO alerta)
    {
        //Requerimiento 2
        if(alerta.getFrecuenciaCardica()>100 ||alerta.getFrecuenciaCardica()<60
                || alerta.getPresionSanguinea()[0]>120 || alerta.getPresionSanguinea()[1]<80
                ||alerta.getNivelEstres()>70)
        {
            alerta.setEsEmergencia(true);
            hospitalLogicMock.notificarEmergencia(alerta);
        }
        return persistence.create(alerta);
    }
    
    //No se necesita public AlertaDTO buscarAlerta(int pId)

    
    public List<AlertaDTO> darAlertas()
    {
        return persistence.getAll();
    }
    
// no se necesita    public void modificarAlerta(Long id, AlertaDTO nueva)
    
   //no se necesita public void eliminarAlerta(Long id)

}
