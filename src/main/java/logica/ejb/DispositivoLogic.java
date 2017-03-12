/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package logica.ejb;

import Persitence.PersistenceManager;
import dto.ConfiguracionDTO;
import dto.DispositivoDTO;
import dto.PacienteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import logica.interfaces.IDispositivo;

/**
 *
 * @author s.ardila13
 */
@Singleton
//@Stateless
public class DispositivoLogic implements IDispositivo {
    
    //private DispositivoMock persistence;
    
    @PersistenceContext(unitName = "Persistence", type = PersistenceContextType.TRANSACTION)
    private EntityManager em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    
    @Resource
            UserTransaction userTran;
    
    
    public DispositivoLogic(){
        //persistence = new DispositivoMock();
    }
    
    @Override
    public void crearDispositivo(DispositivoDTO dispositivo)
    {
        System.out.println("Dispositivo: " + dispositivo.toString());
        try {
            System.out.println("Dipsositivo: " + dispositivo.toEntity());
            userTran.begin();
            em.persist(dispositivo.toEntity());
            userTran.commit();
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
        em.remove(em.find(Long.class,id));
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
