/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import dto.*;
import java.util.ArrayList;
import java.util.Date;
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
        
        Long[] ubicacion = new Long[2];
        ubicacion[0] = 1L;
        ubicacion[1] = 1L;
        
        Integer[] presion = new Integer[2];
        presion[0] = 100;
        presion[1] = 80;
        
        dtos = new ArrayList<PacienteDTO>();
        DispositivoDTO dispositivo1 = new DispositivoDTO(1L, null, null, new ConfiguracionDTO("Cnosejo", new Date()));
        PacienteDTO brandon = new PacienteDTO("Brandon", 1L, 18, null, null, null);
        dispositivo1.setPaciente(brandon);
        brandon.setDispositivo(dispositivo1);
        brandon.setHistorial(new HistorialDTO());
        brandon.getHistorialClinico().getExamenes().add("Examen 1");
        brandon.getHistorialClinico().getTratamientos().add("Tratamiento 1");
        brandon.agregarAlerta(new AlertaDTO(false, presion, 80, 75, 1L, 1, ubicacion, new Date()));
        dtos.add(brandon);
        
        DispositivoDTO dispositivo2 = new DispositivoDTO(2L, null, null, new ConfiguracionDTO("Cnosejo", new Date()));
        PacienteDTO german = new PacienteDTO("German", 2L, 19, null, null, null);
        dispositivo2.setPaciente(german);
        brandon.setDispositivo(dispositivo2);
        dtos.add(german);
        
        DispositivoDTO dispositivo3 = new DispositivoDTO(3L, null, null, new ConfiguracionDTO("Cnosejo", new Date()));
        PacienteDTO sebastian = new PacienteDTO("Sebastian", 3L, 20, null, null, null);
        dispositivo3.setPaciente(sebastian);
        brandon.setDispositivo(dispositivo2);
        dtos.add(sebastian);
        
               
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
        System.out.println(id);
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

    public HistorialDTO modificarHistorialPaciente(Long idPaciente, HistorialDTO p) {
        PacienteDTO paciente = get(idPaciente);
        paciente.setHistorial(p);
        return paciente.getHistorialClinico();
    }
    
}
