/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;



import dto.AlertaDTO;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import logica.ejb.AlertaLogic;


/**
 *
 * @author s.ardila13
 */

@Path("alertas")
@Produces("application/json")
@Consumes(MediaType.APPLICATION_JSON)

public class AlertaResources {
    
    private AlertaLogic logic = new AlertaLogic();
    
    //Requerimiento 1 Recibe info de los sensores...
    /**
     * TODO Requerimiento 1 Recibe una alerta.
     * @param alerta
     * @return alerta
     */
    @POST
    public AlertaDTO createAlerta(AlertaDTO alerta)  
    {
        return logic.crearAlerta(alerta);
    }
    /**
     * Metodo que permite obtener la estructura de los json de alerta
     * @return un ejemplo del json alert
     */
    @GET
    public AlertaDTO darAlertaEjemplo()
    {
        Long [] pos = new Long[2];
        pos[0]=8l;
        pos[1]=7l;
        return new AlertaDTO(10, 120, 1, 1, "descrip", pos, 0, new Date());
    }
    
}
