/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.ejb;

import Persitence.PersistenceManager;
import dto.ConfiguracionDTO;
import dto.DispositivoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import logica.interfaces.IDispositivo;
import mock.DispositivoMock;

/**
 *
 * @author s.ardila13
 */
public class DispositivoLogic implements IDispositivo {
    
    //private DispositivoMock persistence;
    
    @PersistenceContext(unitName = "Persistence", type = PersistenceContextType.TRANSACTION)
    private EntityManager em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    
    public DispositivoLogic(){
        //persistence = new DispositivoMock();
    }

    @Override
    public DispositivoDTO crearPaciente(DispositivoDTO dispositivo) {
        em.persist(dispositivo);
        return dispositivo;
    }

    @Override
    public DispositivoDTO buscarDispositivo(Long id) 
    {
        return em.find(DispositivoDTO.class, id);
        
    }

    @Override
    public List<DispositivoDTO> darDispositivos() {
        Query q = em.createQuery("select u from DispositivoEntity u");
        return q.getResultList();
    }

    @Override
    public void eliminarDispositivo(Long id) {
        em.remove(em.find(DispositivoDTO.class,id));
    }

    @Override
    public void modificarDispositivo(Long id, DispositivoDTO paciente) {
        em.merge(paciente);
    }

    @Override
    public ConfiguracionDTO setConfiguracion(ConfiguracionDTO confi, Long idDispositivo)
    {
        DispositivoDTO dispositivo = em.find(DispositivoDTO.class, idDispositivo);
        dispositivo.setConfiguration(confi);
        em.merge(dispositivo);
        return confi;
    }
    
}
