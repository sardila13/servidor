/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns;

import Entites.MedicoEntity;
import Persitence.PersistenceManager;
import dto.MedicoDTO;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author ba.bohorquez10
 */
public class MedicoDTOPool 
{
    @PersistenceContext(unitName = "Oracle final", type = PersistenceContextType.TRANSACTION)
    private EntityManager em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    
    protected Hashtable<MedicoDTO, Long> dtos;
    
    private long tiempoExp;
    
    public MedicoDTOPool()
    {
        tiempoExp = 30000;
        dtos = new Hashtable<MedicoDTO, Long>();
    }
    
    public synchronized MedicoDTO checkOut(Long id)
    {
        long t1 = System.currentTimeMillis();
        
        MedicoDTO elem = null;
        
        if (dtos.size() > 0)
        {
            Enumeration<MedicoDTO> en = dtos.keys();
            
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
        
        elem = em.find(MedicoEntity.class, id).toDTO();
        dtos.put(elem, t1);
        
        return elem;
    }
    
}
