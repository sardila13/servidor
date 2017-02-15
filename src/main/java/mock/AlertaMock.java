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
        Long[] arr= new Long[2];
        arr[0]=5l;
        arr[1]=8l;
        
        Integer[] arr1= new Integer[2];
        arr1[0]=5;
        arr1[1]=8;
        new AlertaDTO(true, arr1, 10, 10, 1L, 2, arr, new Date());
        new AlertaDTO(true, arr1, 10, 10, 2L, 2, arr, new Date());
        new AlertaDTO(true, arr1, 10, 10, 3L, 2, arr, new Date());
    }
    
    public AlertaDTO create(AlertaDTO alerta)
    {
        //Ya no se genera el id porque el id se refiere al id del dispositivo.
 
        alertas.add(alerta);
        System.out.println(alerta.getIdDispositivo());
        DispositivoDTO disp = dispositivoLogic.buscarDispositivo(alerta.getIdDispositivo());
        
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
