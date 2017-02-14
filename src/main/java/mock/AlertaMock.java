/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import dto.AlertaDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author gc.andrade10
 */
public class AlertaMock
{
    private List<AlertaDTO> alertas;
    
    public AlertaMock()
    {
        alertas = new ArrayList<AlertaDTO>();
        Long[] ub = new Long[2];
        ub[0] = 1L;
        ub[1] = 1L;
        
        alertas.add( new AlertaDTO(false, 100, 50, 1L, AlertaDTO.VERDE, ub, 0, new Date() ) );
        alertas.add( new AlertaDTO(false, 80, 70, 2L, AlertaDTO.VERDE, ub, 0, new Date() ) );
        alertas.add( new AlertaDTO(false, 90, 40, 3L, AlertaDTO.VERDE, ub, 0, new Date() ) );
    }
    
    public AlertaDTO create(AlertaDTO alerta)
    {
        Long max = Long.MIN_VALUE;
        
        for (Iterator<AlertaDTO> iterator = alertas.iterator(); iterator.hasNext();) 
        {
            AlertaDTO next = iterator.next();
            
            if(next.getId() > max) max = next.getId();
        }
        
        alerta.setId(max + 1L);
        alertas.add(alerta);
        
        return alerta;
    }

    public AlertaDTO get(int pId)
    {
        for (int i = 0; i < alertas.size(); i++) 
        {
            AlertaDTO actual = alertas.get(i);
            
            if(actual.getId() == pId) return actual;
        }
        
        return null;
    }

    public List<AlertaDTO> getAll()
    {
        return alertas;
    }

    public void delete(Long id)
    {
        boolean encontro = false;
        
        for(int i = 0; i < alertas.size() && !encontro; i++)
        {
            AlertaDTO actual = alertas.get(i);
            
            if(actual.getId() == id)
            {
                alertas.remove(i);
                encontro = true;
            }
        }
    }

    public void put(Long id, AlertaDTO nueva)
    {
        boolean encontrado = false;
        int i;
        for (i = 0; i < alertas.size() && !encontrado; i++) {
            AlertaDTO dto = alertas.get(i);
            if(dto.getId() == id){
                alertas.set(i, nueva);
                encontrado = true;
            }
        }
        
        
    }
    
}
