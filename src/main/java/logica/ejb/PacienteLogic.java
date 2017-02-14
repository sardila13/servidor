/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.ejb;

import dto.AlertaDTO;
import dto.PacienteDTO;
import java.util.ArrayList;
import java.util.Date;
import logica.interfaces.IPaciente;
import mock.PacienteMock;

/**
 *
 * @author s.ardila13
 */
public class PacienteLogic implements IPaciente {
    
    private PacienteMock persistence;
    
    public PacienteLogic(){
        persistence = new PacienteMock();
    }

    @Override
    public PacienteDTO crearPaciente(PacienteDTO paciente) {
        return persistence.create(paciente);
    }

    @Override
    public PacienteDTO buscarPaciente(Long id) {
        return persistence.get(id);
    }

    @Override
    public ArrayList<PacienteDTO> darPacientes() {
        return persistence.getAll();
    }

    @Override
    public void eliminarPaciente(Long id) {
        persistence.delete(id);
    }

    @Override
    public void modificarPaciente(Long id, PacienteDTO paciente) {
        persistence.put(id, paciente);
    }

    public ArrayList<AlertaDTO> getHistorialPorRango(int idPaciente, Date fechaInicio, Date fechaFinal)
    {
        //Implementar
        return null;
    }
    
}
