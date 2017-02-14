/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;



import dto.AlertaDTO;
import java.util.ArrayList;
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
import logica.ejb.PacienteLogic;


/**
 *
 * @author s.ardila13
 */

@Path("paciente")
@Produces("application/json")
@Consumes(MediaType.APPLICATION_JSON)

public class PacienteResources 
{
    
    private PacienteLogic logic;
    
    //Requerimiento 1 Recibe info de los sensores...
    @GET
    
    public ArrayList<AlertaDTO> getHistorialPorRango(@PathParam("idPaciente") int idPaciente, @PathParam("fechaInicio") Date fechaInicio, @PathParam("fechaFinal") Date fechaFinal)  
    {
        return logic.getHistorialPorRango(idPaciente, fechaInicio, fechaFinal);
    }
    
}
