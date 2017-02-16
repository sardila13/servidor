/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.ejb;

import dto.AlertaDTO;
import dto.HistorialDTO;
import dto.PacienteDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javafx.scene.control.Alert;
import javax.ejb.Stateless;
import logica.interfaces.IPaciente;
import mock.PacienteMock;

/**
 *
 * @author s.ardila13
 */
@Stateless
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
        System.out.println("Logic " + id);
        return persistence.get(id);
    }

    @Override
    public List<PacienteDTO> darPacientes() {
        return persistence.getAll();
    }

    @Override
    public void eliminarPaciente(Long id) {
        persistence.delete(id);
    }

    @Override
    public PacienteDTO modificarPaciente(Long id, PacienteDTO paciente) {
        return persistence.put(id, paciente);
    }

    public ArrayList<AlertaDTO> getHistorialPorRango(long idPaciente, Date fechaInicio, Date fechaFinal)
    {
       PacienteDTO p= persistence.get(idPaciente);
       ArrayList<AlertaDTO> r = new ArrayList<>();
        for (int i =0; i<p.getAlertas().size();i++)
        {
            AlertaDTO actual = p.getAlertas().get(i);
            
            if(actual.getFecha().after(fechaInicio) && actual.getFecha().before(fechaFinal))
            {
                r.add(actual);
            }
        }
        return r;
    }

    @Override
    public String toString() {
        return "PacienteLogic{" + "persistence=" + persistence + '}';
    }

    public HistorialDTO modificarHistorialPaciente(Long idPaciente, HistorialDTO p) {
        return persistence.modificarHistorialPaciente(idPaciente, p);
    }
    
    
    
}
