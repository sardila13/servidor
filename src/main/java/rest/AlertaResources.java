/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Entites.AlertaEntity;
import Entites.DispositivoEntity;
import Entites.PacienteEntity;
import dto.AlertaDTO;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import logica.ejb.AlertaLogic;
import logica.ejb.DispositivoLogic;


/**
 *
 * @author s.ardila13
 */

@Path("alertas")
@Produces("application/json")
@Consumes(MediaType.APPLICATION_JSON)

public class AlertaResources 
{
    private AlertaLogic logic = new AlertaLogic();
    
    private DispositivoLogic dispositivologic = new DispositivoLogic();
    //Requerimiento 1 Recibe info de los sensores...
    
    
    @POST
    public void createAlerta(AlertaDTO alerta)  
    {
       logic.crearAlerta(alerta);
    }
    
    @GET
    public List<AlertaDTO> darAlertas() {
        return logic.darAlertas();
    }
    
    @GET
    @Path("/ejemplo")
    public AlertaDTO ejemplo(){
        Integer[] presion = new Integer[2];
        presion[0] = 60;
        presion[1] = 80;
        PacienteEntity pPaciente = new PacienteEntity("Brandon", 20, null, null, null, null, null, null);
        DispositivoEntity pDispositivo = new DispositivoEntity(pPaciente, null, null, null);
        pPaciente.setDispositivo(pDispositivo);
        AlertaEntity alerta = new AlertaEntity(0, presion, 100, 70, pDispositivo, 0, null, new Date());
        System.out.println("Entra al servicio x2");
        return alerta.toDTO();
    }
    
}
