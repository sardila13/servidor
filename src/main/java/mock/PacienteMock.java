/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import dto.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author gc.andrade10
 */
public class PacienteMock
{
    
    private List<PacienteDTO> dtos;

    public PacienteMock(){
        dtos = new ArrayList<PacienteDTO>();
        dtos.add(new PacienteDTO("Brandon", 1L, 18, null, null, null));
        dtos.add(new PacienteDTO("German", 2L, 19, null, null, null));
        dtos.add(new PacienteDTO("Sebastian", 3L, 20, null, null, null));
               
    }
    
    public PacienteDTO create(PacienteDTO paciente)
    {
        Long max = 0L;
        
        for (Iterator<PacienteDTO> iterator = dtos.iterator(); iterator.hasNext();) {
            PacienteDTO next = iterator.next();
            if(max < next.getId())
                max = next.getId();
        }        
        Long newId = max + 1L;
        paciente.setId(newId);
        
        dtos.add(paciente);
        return dtos.get(dtos.size()-1);
    }

    public PacienteDTO put(Long id, PacienteDTO paciente)
    {
        boolean encontrado = false;
        int i;
        for (i = 0; i < dtos.size() && !encontrado; i++) {
            PacienteDTO dto = dtos.get(i);
            if(dto.getId() == id){
                encontrado = true;
                dtos.set(i, paciente);
                return paciente;
            }
        }
        return null;
    }

    public void delete(Long id)
    {
        boolean encontrado = false;
        int i;
        for (i = 0; i < dtos.size() && !encontrado; i++) {
            PacienteDTO dto = dtos.get(i);
            if(dto.getId() == id){
                encontrado = true;
                dtos.remove(i);    
            }
        }
            
    }

    public List<PacienteDTO> getAll()
    {
        return dtos;
    }

    public PacienteDTO get(Long id)
    {
        boolean encontrado = false;
        int i;
        for (i = 0; i < dtos.size() && !encontrado; i++) {
            PacienteDTO dto = dtos.get(i);
            if(dto.getId() == id){
                encontrado = true;
                return dtos.get(i);
            }
        }
        
        return null;
    }

    @Override
    public String toString() 
    {
        return "PacienteMock{" + "dtos=" + dtos + '}';
    }
    
}
