/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import dto.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author gc.andrade10
 */
public class PacienteMock
{
    
    private ArrayList<PacienteDTO> dtos;

    public PacienteMock(){
        dtos = new ArrayList<PacienteDTO>();
        dtos.add(new PacienteDTO("Brandon", 1L, 18, null, null, null, null, null));
        dtos.add(new PacienteDTO("German", 2L, 19, null, null, null, null, null));
        dtos.add(new PacienteDTO("Sebastian", 3L, 20, null, null, null, null, null));
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

    public void put(Long id, PacienteDTO paciente)
    {
        boolean encontrado = false;
        int i;
        for (i = 0; i < dtos.size() && !encontrado; i++) {
            PacienteDTO dto = dtos.get(i);
            if(dto.getId() == id){
                encontrado = true;
                dtos.set(i, paciente);

            }
        }
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

    public ArrayList<PacienteDTO> getAll()
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
    
}
