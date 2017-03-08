/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.ejb;

import Persitence.PersistenceManager;
import dto.AlertaDTO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import logica.interfaces.IAlertaLogic;
import mock.AlertaMock;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;

/**
 *
 * @author ba.bohorquez10
 */
public class AlertaLogic implements IAlertaLogic
{
    //private AlertaMock persistence;
    
    private HospitalLogic hospitalLogic;
    
    @PersistenceContext(unitName = "Persistence", type = PersistenceContextType.TRANSACTION)
    private EntityManager em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    
    public AlertaLogic()
    {
        //persistence = new AlertaMock();
        hospitalLogic = new HospitalLogic();
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
        em.persist(alerta);
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
