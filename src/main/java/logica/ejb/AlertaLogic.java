/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.ejb;

import Persitence.PersistenceManager;
import dto.AlertaDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import logica.interfaces.IAlertaLogic;

/**
 *
 * @author ba.bohorquez10
 */
@Singleton
//@Stateless
public class AlertaLogic implements IAlertaLogic
{
    //private AlertaMock persistence;
    
    @Inject
    private HospitalLogic hospitalLogic;
    
    @PersistenceContext(unitName = "Persistence")
    protected EntityManager em;
    
//    = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    //type = PersistenceContextType.TRANSACTION
    
    public AlertaLogic()
    {
    }
    
  
    
    public AlertaDTO crearAlerta(AlertaDTO alerta)
    {
        //Requerimiento 2
        if(alerta.getFrecuenciaCardica()>100 ||alerta.getFrecuenciaCardica()<60
                || alerta.getPresionSanguinea()[0]>120 || alerta.getPresionSanguinea()[1]<80
                ||alerta.getNivelEstres()>70)
        {
            alerta.setEsEmergencia(1);
            hospitalLogic.notificarEmergencia(alerta);
        }
        System.out.println(alerta.toString());
        System.out.println("e: "+alerta.toEntity());
        em.persist(alerta.toEntity());
        return alerta;
    }
    
    //No se necesita public AlertaDTO buscarAlerta(int pId)

    
    public List<AlertaDTO> darAlertas()
    {
        Query q = em.createQuery("select u from AlertaEntity u");
        return q.getResultList();
    }
    
// no se necesita    public void modificarAlerta(Long id, AlertaDTO nueva)
    
   //no se necesita public void eliminarAlerta(Long id)

}
