/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import dto.PacienteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s.ardila13
 */
public interface IPaciente {
    
    public PacienteDTO crearPaciente(PacienteDTO paciente);
    
    public PacienteDTO buscarPaciente(Long id);
    
    public List<PacienteDTO> darPacientes();
    
    public void eliminarPaciente(Long id);
    
    public PacienteDTO modificarPaciente(Long id, PacienteDTO paciente);
}
