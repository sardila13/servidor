/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;



import dto.AlertaDTO;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

public class AlertaResources 
{
    private AlertaLogic logic;
    //Requerimiento 1 Recibe info de los sensores...
    @POST
    public AlertaDTO createAlerta(AlertaDTO alerta)  
    {
        return logic.crearAlerta(alerta);
    }
    
    @GET
    public AlertaDTO createAlerta()  
    {
        Long[] arr= new Long[2];
        arr[0]=5l;
        arr[1]=8l;
        return new AlertaDTO(true, 0, 0, 0, Long.MIN_VALUE, 0, arr, 0, new Date());
    }

    
}
