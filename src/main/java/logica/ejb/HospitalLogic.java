/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package logica.ejb;

import Persitence.PersistenceManager;
import dto.AlertaDTO;
import dto.HospitalDTO;
import javax.ejb.Stateless;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import logica.interfaces.IHospital;


/**
 *
 * @author gc.andrade10
 */
//@Stateless
@Singleton
public class HospitalLogic implements IHospital
{
    @PersistenceContext(unitName = "Persistence")
    private EntityManager em;
    
    //= PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    //, type = PersistenceContextType.TRANSACTION

    public HospitalLogic() 
    {
    }
    
    
    
    public void notificarEmergencia(AlertaDTO alerta)
    {
        System.out.println("EMERGENCIA "+alerta.toString());
    }
    
    public void crear(HospitalDTO hospitalDTO)
    {
        System.out.println(hospitalDTO);
        System.out.println(em.hashCode());
        em.persist(hospitalDTO.toEntity());
    }
    
}
