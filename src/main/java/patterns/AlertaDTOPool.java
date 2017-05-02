/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns;

import Entites.AlertaEntity;
import Persitence.PersistenceManager;
import dto.AlertaDTO;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author ba.bohorquez10
 */
public class AlertaDTOPool 
{
//    @PersistenceContext(unitName = "Oracle final", type = PersistenceContextType.TRANSACTION)
//    private EntityManager em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
//    
//    protected Hashtable<AlertaDTO, Long> dtos;
//    
//    private long tiempoExp;
//    
//    public AlertaDTOPool()
//    {
//        tiempoExp = 30000;
//        dtos = new Hashtable<AlertaDTO, Long>();
//    }
//    
//    public synchronized AlertaDTO checkOut(Long id)
//    {
//        long t1 = System.currentTimeMillis();
//        
//        AlertaDTO elem = null;
//        
//        if (dtos.size() > 0)
//        {
//            Enumeration<AlertaDTO> en = dtos.keys();
//            
//            while ( en.hasMoreElements() )
//            {
//                elem = en.nextElement();
//                
//                if(elem.get == id)
//                {
//                    dtos.put(elem, t1);
//                    return elem;
//                }
//                
//                if ( (t1 - dtos.get(elem) ) > tiempoExp)
//                {
//                    // object has expired
//                    dtos.remove(elem);
//                    elem = null;
//                }
//            }
//        }
//        
//        elem = em.find(AlertaEntity.class, id).toDTO();
//        dtos.put(elem, t1);
//        
//        return elem;
//    }
}
