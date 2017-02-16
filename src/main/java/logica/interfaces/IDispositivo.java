/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import dto.ConfiguracionDTO;
import dto.DispositivoDTO;
import java.util.ArrayList;

/**
 *
 * @author s.ardila13
 */
public interface IDispositivo {
    
    public DispositivoDTO crearPaciente(DispositivoDTO dispositivo);
    
    public DispositivoDTO buscarDispositivo(Long id);
    
    public ArrayList<DispositivoDTO> darDispositivos();
    
    public void eliminarDispositivo(Long id);
    
    public void modificarDispositivo(Long id, DispositivoDTO paciente);
    
    public ConfiguracionDTO setConfiguracion(ConfiguracionDTO confi, Long idDispositivo);

    
}
