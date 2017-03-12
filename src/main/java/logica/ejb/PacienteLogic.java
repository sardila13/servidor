/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package logica.ejb;

import Entites.DispositivoEntity;
import Entites.PacienteEntity;
import Persitence.PersistenceManager;
import dto.AlertaDTO;
import dto.ConsejoDTO;
import dto.DispositivoDTO;
import dto.HistorialDTO;
import dto.PacienteDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javafx.scene.control.Alert;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.swing.text.html.HTML;
import javax.transaction.UserTransaction;
import logica.interfaces.IPaciente;

/**
 *
 * @author s.ardila13
 */
//@Stateless
@Singleton
public class PacienteLogic implements IPaciente {
    
    @PersistenceContext(unitName = "Persistence", type = PersistenceContextType.TRANSACTION)
    private EntityManager em = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    
    @Resource
            UserTransaction userTran;
    
    @Inject
            HospitalLogic hospitalLogic;
    
    public PacienteLogic(){
    }
    
    @Override
    public PacienteDTO crearPaciente(PacienteDTO paciente)
    {
        try{
            userTran.begin();
            PacienteEntity pe = paciente.toEntity();
            System.out.println("Id antes " + pe.getId());
            em.persist(pe);
            userTran.commit();
            System.out.println("Id despues " + pe.getId());
            return pe.toDTO();
        }
        catch(Exception e){
            return null;
        }
//        hospitalLogic.agregarPaciente(paciente);
    }
    
    @Override
    public PacienteDTO buscarPaciente(Long id) {
        System.out.println("Logic " + id);
        return em.find(PacienteDTO.class, id);
    }
    
    @Override
    public List<PacienteDTO> darPacientes() {
        Query q = em.createQuery("select u from PacienteEntity u");
        return q.getResultList();
    }
    
    @Override
    public void eliminarPaciente(Long id) {
        em.remove(em.find(PacienteDTO.class, id));
    }
    
    @Override
    public PacienteDTO modificarPaciente(Long id, PacienteDTO paciente) {
        paciente.setId(id);
        em.merge(paciente);
        return paciente;
    }
    
    public ArrayList<AlertaDTO> getHistorialPorRango(long idPaciente, Date fechaInicio, Date fechaFinal)
    {
        PacienteDTO p= em.find(PacienteDTO.class,idPaciente);
        ArrayList<AlertaDTO> r = new ArrayList<>();
        for (int i =0; i<p.getAlertas().size();i++)
        {
            AlertaDTO actual = p.getAlertas().get(i);
            
            if(actual.getFecha().after(fechaInicio) && actual.getFecha().before(fechaFinal))
            {
                r.add(actual);
            }
        }
        return r;
    }
    
    @Override
    public String toString() {
        return "PacienteLogic{" + '}';
    }
    
    public HistorialDTO modificarHistorialPaciente(Long idPaciente, HistorialDTO p) {
        PacienteDTO paciente = em.find(PacienteDTO.class, idPaciente);
        paciente.setHistorial(p);
        em.merge(paciente);
        return p;
    }
    
    public PacienteDTO agregarConsejo(long idPaciente, ConsejoDTO consejo) {
        PacienteDTO paciente = em.find(PacienteDTO.class, idPaciente);
        paciente.agregarConsejo(consejo);
        em.merge(paciente);
        return paciente;
    }
    
    public void agregarDispositivo(DispositivoEntity dispositivo) {
        PacienteEntity paciente = em.find(PacienteEntity.class, dispositivo.getPaciente().getId());
        paciente.setDispositivo(dispositivo);
        try{
            userTran.begin();
            em.merge(paciente);
            userTran.commit();
        }
        catch(Exception e){

        }
    }

    
    
    
}
