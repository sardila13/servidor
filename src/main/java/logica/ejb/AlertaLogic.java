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
    
    private HospitalLogicMock hospitalLogicMock= new HospitalLogicMock();
    
    public AlertaLogic()
    {
        persistence = new AlertaMock();
    }
    
    public AlertaDTO crearAlerta(AlertaDTO alerta)
    {
        //TODO Requerimiento 2
        if(alerta.getFrecuenciaCardica()>10 )
        {
            alerta.setTipo(AlertaDTO.EMERGENCIA);
            hospitalLogicMock.notificarEmergencia(alerta);
        }
        return persistence.create(alerta);
    }
    
    public AlertaDTO buscarAlerta(int pId)
    {   
        return persistence.get(pId);
    }
    
    public List<AlertaDTO> darAlertas()
    {
        return persistence.getAll();
    }
    
    public void modificarAlerta(Long id, AlertaDTO nueva)
    {
        persistence.put(id, nueva);
    }
    
    public void eliminarAlerta(Long id)
    {
        persistence.delete(id);
    }

    @Override
    public AlertaDTO buscarAlerta(Long id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
