/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.ejb;

import Persitence.PersistenceManager;
import dto.ConfiguracionDTO;
import dto.ConsejoDTO;
import dto.DispositivoDTO;
import dto.MedicoDTO;
import dto.PacienteDTO;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import logica.interfaces.IDispositivo;
import logica.interfaces.IMedicoLogic;

/**
 *
 * @author Sneider Velandia G
 */
public class MedicoLogic implements IMedicoLogic{

    private PacienteLogic pacienteLogic = new PacienteLogic();
    private DispositivoLogic dispositivoLogic = new DispositivoLogic();
    
    @PersistenceContext(unitName = "Persistence", type = PersistenceContextType.TRANSACTION)
    private EntityManager em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    
    @Override
    public void crearMedico(MedicoDTO medico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MedicoDTO buscarMedico(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MedicoDTO> darMedicos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarMedico(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConfiguracionDTO configurarMarcapasos(long idDispositivo, ConfiguracionDTO configuracion) 
    {
        return dispositivoLogic.setConfiguracion( configuracion, idDispositivo);
    }

    public ConsejoDTO enviarConsejo(long idPaciente, ConsejoDTO consejo)
    {
        PacienteDTO p = pacienteLogic.agregarConsejo(idPaciente, consejo);
        return consejo;
    }
    
}
