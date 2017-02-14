/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import dto.DispositivoDTO;
import dto.PacienteDTO;
import java.util.ArrayList;
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
        dtos.add(new DispositivoDTO(1L, null, null, null));
        dtos.add(new DispositivoDTO(2L, null, null, null));
        dtos.add(new DispositivoDTO(3L, null, null, null));
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
       boolean encontrado = false;
        int i;
        for (i = 0; i < dtos.size() && !encontrado; i++) {
            DispositivoDTO dto = dtos.get(i);
            if(dto.getId() == id){
                encontrado = true;
                return dtos.get(i);
            }
        }    
         return null;
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
    
}
