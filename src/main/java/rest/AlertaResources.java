/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package rest;

import Entites.DispositivoEntity;
import Entites.PacienteEntity;
import dto.AlertaDTO;
import dto.ConfiguracionDTO;
import dto.DispositivoDTO;
import dto.HospitalDTO;
import dto.MedicoDTO;
import dto.PacienteDTO;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import logica.ejb.AlertaLogic;
import logica.ejb.DispositivoLogic;
import logica.ejb.HospitalLogic;
import logica.ejb.MedicoLogic;
import logica.ejb.PacienteLogic;
import logica.interfaces.IAlertaLogic;
import logica.interfaces.IDispositivo;


/**
 *
 * @author s.ardila13
 */

@Path("alertas")
@Produces("application/json")
@Consumes(MediaType.APPLICATION_JSON)

public class AlertaResources
{
    @Inject
    private PacienteLogic pacienteLogic;
    
    @Inject
    private HospitalLogic hospitalLogic;
    
    @Inject MedicoLogic medicoLogic;
    
    @Inject
    private IAlertaLogic logic;
    
    @Inject
    private IDispositivo dispositivologic;
    //Requerimiento 1 Recibe info de los sensores...
    
//    @PostConstruct
//    public void init(){
//        logic = new AlertaLogic();
//    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createAlerta(AlertaDTO alerta)
    {
        System.out.println("La instancia es " + logic.hashCode());
//       System.out.println("Hola " + alerta);

logic.crearAlerta(alerta);
    }
    
    @GET
    public List<AlertaDTO> darAlertas() {
        return logic.darAlertas();
    }
    
    @GET
    @Path("/ejemplo")
    public AlertaDTO ejemplo()
    {
        Integer[] presion = new Integer[2];
        presion[0] = 60;
        presion[1] = 80;
        
        Long[] ubicacion = new Long[2];
        ubicacion[0] = 60L;
        ubicacion[1] = 80L;
        
        Integer frecuencia = 85;
        Integer estres = 65;
//        PacienteEntity pPaciente = new PacienteEntity("Brandon", 20, null, null, null, null, null, null);
////        DispositivoEntity pDispositivo = new DispositivoEntity(pPaciente, null, null, null);
//
////        pPaciente.setDispositivo(pDispositivo);
//        AlertaEntity alerta = new AlertaEntity(0, presion, 100, 70, null, 0,ubicacion , new Date());
//        System.out.println("Entra al servicio x2");
//
//        PacienteDTO p  =new PacienteDTO("Brandon", 1L, 17, null, medicos, hospital);
//        Long d = new Long(Long.MIN_VALUE, p, hospital, configuracion);
//        p.setDispositivo(d);
//
//        dispositivologic.crearPaciente(new Long(1L, pPaciente, hospital, configuracion))
HospitalDTO h = new HospitalDTO("Uniandes");
hospitalLogic.crear(h);
medicoLogic.crearMedico(new MedicoDTO("German", 0));
PacienteDTO p = new PacienteDTO("Brandon", 20 , h);
pacienteLogic.crearPaciente(p);
dispositivologic.crearDispositivo(new DispositivoDTO( p, p.getHospital(), new ConfiguracionDTO("config ")));
DispositivoDTO d = dispositivologic.darDispositivos().get(0);
AlertaDTO a = new AlertaDTO(0, presion,frecuencia, estres, d.getId(), AlertaDTO.AMARILLO, ubicacion);
return a;
    }
    
}
