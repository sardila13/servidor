/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import dto.AlertaDTO;
import dto.PacienteDTO;
import java.util.List;
import logica.ejb.PacienteLogic;

/**
 *
 * @author gc.andrade10
 */
public class AlertaMock
{
    PacienteLogic pacienteLogic = new PacienteLogic();

    public AlertaDTO get(int pId)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<AlertaDTO> getAll()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Long id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void put(Long id, AlertaDTO nueva)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AlertaDTO create(AlertaDTO alerta, int idDispositivo)
    {
        PacienteDTO p =pacienteLogic.buscarPacientePorIdDispositivo(idDispositivo);
                p.agregarAlerta(alerta);
        return alerta;
        
    }
                           
}
