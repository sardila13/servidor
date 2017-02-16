/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.ejb;

import dto.ConfiguracionDTO;
import dto.DispositivoDTO;
import java.util.ArrayList;
import logica.interfaces.IDispositivo;
import mock.DispositivoMock;

/**
 *
 * @author s.ardila13
 */
public class DispositivoLogic implements IDispositivo {
    
    private DispositivoMock persistence;
    
    public DispositivoLogic(){
        persistence = new DispositivoMock();
    }

    @Override
    public DispositivoDTO crearPaciente(DispositivoDTO dispositivo) {
        return persistence.create(dispositivo);
    }

    @Override
    public DispositivoDTO buscarDispositivo(Long id) 
    {
        return persistence.get(id);
    }

    @Override
    public ArrayList<DispositivoDTO> darDispositivos() {
        return persistence.getAll();
    }

    @Override
    public void eliminarDispositivo(Long id) {
        persistence.delete(id);
    }

    @Override
    public void modificarDispositivo(Long id, DispositivoDTO paciente) {
        persistence.put(id, paciente);
    }

    @Override
    public ConfiguracionDTO setConfiguracion(ConfiguracionDTO confi, Long idDispositivo)
    {
        return persistence.setConfiguracion(idDispositivo, confi);
    }
    
}
