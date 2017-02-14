/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;



import dto.AlertaDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import logica.ejb.MedicoLogic;
import logica.ejb.PacienteLogic;


/**
 *
 * @author s.ardila13
 */

@Path("paciente")
@Produces("application/json")
@Consumes(MediaType.APPLICATION_JSON)

public class MedicoResources 
{
    
    private  MedicoLogic medicoLogic;
    
    //Requerimiento 4 dar consejo a un dispositivo...
    @POST
    @Path("consejo")
    public void enviarConsejo(@PathParam("idPaciente") long idPaciente, @PathParam("consejo") String consejo)  
    {
        medicoLogic.enviarConsejo(idPaciente,consejo);
        //return "Mensaje enviado satisfactoriamente";
    }
    
    
    @POST
    @Path("configuracion")
    public void enviarReconfiguracion(@PathParam("idDispositivo") long idDispositivo, @PathParam("config") String config)  
    {
        medicoLogic.configurarMarcapasos(idDispositivo,config );
        //return "Configuración enviada satisfactoriamente";
    }
    
}
