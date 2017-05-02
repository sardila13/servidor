/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns;

import Entites.PacienteEntity;
import Persitence.PersistenceManager;
import dto.PacienteDTO;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author ba.bohorquez10
 */
public class PacienteDTOPool
{
    @PersistenceContext(unitName = "Oracle final", type = PersistenceContextType.TRANSACTION)
    private EntityManager em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    
    protected Hashtable<PacienteDTO, Long> dtos;
    
    private long tiempoExp;
    
    public PacienteDTOPool()
    {
        tiempoExp = 30000;
        dtos = new Hashtable<PacienteDTO, Long>();
    }
    
    public synchronized PacienteDTO checkOut(Long id)
    {
        long t1 = System.currentTimeMillis();
        
        PacienteDTO elem = null;
        
        if (dtos.size() > 0)
        {
            Enumeration<PacienteDTO> en = dtos.keys();
            
            while ( en.hasMoreElements() )
            {
                elem = en.nextElement();
                
                if(elem.getId() == id)
                {
                    dtos.put(elem, t1);
                    return elem;
                }
                
                if ( (t1 - dtos.get(elem) ) > tiempoExp)
                {
                    // object has expired
                    dtos.remove(elem);
                    elem = null;
                }
            }
        }
        
        elem = em.find(PacienteEntity.class, id).toDTODetail();
        dtos.put(elem, t1);
        
        return elem;
    }
}
