/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import dto.AlertaDTO;
import dto.DispositivoDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import logica.ejb.DispositivoLogic;

/**
 *
 * @author gc.andrade10
 */
public class AlertaMock
{
    private List<AlertaDTO> alertas;
    
    private DispositivoLogic dispositivoLogic = new DispositivoLogic();
    
    public AlertaMock()
    {
        alertas = new ArrayList<AlertaDTO>();
        Long[] ub = new Long[2];
        ub[0] = 1L;
        ub[1] = 1L;
        
        alertas.add( new AlertaDTO(false, 100,75, 50, 1L, AlertaDTO.VERDE, ub, 0, new Date() ) );
        alertas.add( new AlertaDTO(false, 80,77, 70, 2L, AlertaDTO.VERDE, ub, 0, new Date() ) );
        alertas.add( new AlertaDTO(false, 90,73, 40, 3L, AlertaDTO.VERDE, ub, 0, new Date() ) );
        
    }
    
    public AlertaDTO create(AlertaDTO alerta)
    {
        //Ya no se genera el id porque el id se refiere al id del dispositivo.
 
        alertas.add(alerta);
        
        DispositivoDTO disp=dispositivoLogic.buscarDispositivo(alerta.getIdDispositivo());
        
        disp.agregarAlerta(alerta);
        
        return alerta;
    }
//NO se necesita public AlertaDTO get(int pId)

    public List<AlertaDTO> getAll()
    {
        return alertas;
    }

  // NO se necesita  public void delete(Long id)
    
}
