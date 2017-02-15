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
import logica.ejb.DispositivoLogic;
import mock.DispositivoMock;


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
    public AlertaDTO createAlerta()  
    {
        Long[] arr= new Long[2];
        arr[0]=5l;
        arr[1]=8l;
        
        Integer[] arr1= new Integer[2];
        arr1[0]=5;
        arr1[1]=8;
        return new AlertaDTO(true, arr1, 10, 10, 1L, 2, arr, new Date());
    }

    
}
