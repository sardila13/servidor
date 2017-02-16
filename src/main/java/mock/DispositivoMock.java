/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import dto.ConfiguracionDTO;
import dto.DispositivoDTO;
import dto.PacienteDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author gc.andrade10
 */
public class DispositivoMock
{

    private ArrayList<DispositivoDTO> dtos;
    
    public DispositivoMock(){
        dtos = new ArrayList<DispositivoDTO>();
        dtos.add(new DispositivoDTO(1L, null, null,new ConfiguracionDTO("Cnosejo", new Date())));
        dtos.add(new DispositivoDTO(2L, null, null,new ConfiguracionDTO("Cnosejo", new Date())));
        dtos.add(new DispositivoDTO(3L, null, null,new ConfiguracionDTO("Cnosejo", new Date())));
        
    }
    
    public DispositivoDTO create(DispositivoDTO dispositivo)
    {
        Long max = 0L;
        
        for (Iterator<DispositivoDTO> iterator = dtos.iterator(); iterator.hasNext();) {
            DispositivoDTO next = iterator.next();
            if(max < next.getId())
                max = next.getId();
        }        
        Long newId = max + 1L;
        dispositivo.setId(newId);
        
        dtos.add(dispositivo);
        return dtos.get(dtos.size()-1);
    }

    public DispositivoDTO get(Long id)
    {
       DispositivoDTO dto=null;
        int i;
        for (i = 0; i < dtos.size() && dto == null; i++) 
        {
            DispositivoDTO temp = dtos.get(i);
            if(id.compareTo(temp.getId()) == 0)
            {
                dto=temp;
            }
        }    
         return dto;
    }

    public ArrayList<DispositivoDTO> getAll()
    {
        return dtos;
    }

    public void delete(Long id)
    {
        boolean encontrado = false;
        int i;
        for (i = 0; i < dtos.size() && !encontrado; i++) {
            DispositivoDTO dto = dtos.get(i);
            if(dto.getId() == id){
                encontrado = true;
                dtos.remove(i);
            }
        }
        
    }

    public void put(Long id, DispositivoDTO dispositivo)
    {
        boolean encontrado = false;
        int i;
        for (i = 0; i < dtos.size() && !encontrado; i++) {
            DispositivoDTO dto = dtos.get(i);
            if(dto.getId() == id){
                encontrado = true;
                dtos.set(i, dispositivo);
            }
        }
        
    }

    public ConfiguracionDTO setConfiguracion(Long idDispositivo, ConfiguracionDTO confi)
    {
        get(idDispositivo).setConfiguration(confi);
        return confi;
    }
    
}
