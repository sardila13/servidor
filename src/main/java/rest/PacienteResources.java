/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;
import dto.AlertaDTO;
import dto.HistorialDTO;
import dto.PacienteDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import logica.ejb.PacienteLogic;

/**
 *
 * @author s.ardila13
 */

@Path("/paciente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PacienteResources 
{

    private PacienteLogic logic = new PacienteLogic();
    
    //Requerimiento 1 Recibe info de los sensores...
    @GET
    @Path("/historial-fechas/{idPaciente:\\d+}/{fechaInicio:\\d+}/{fechaFinal:\\d+}")
    public List<AlertaDTO> getHistorialPorRango(@PathParam("idPaciente") long idPaciente, @PathParam("fechaInicio") Long fechaInicio, @PathParam("fechaFinal") Long fechaFinal)  
    {
        return logic.getHistorialPorRango(idPaciente, new Date(fechaInicio), new Date(fechaFinal));
    }
    
    //CRUD
    @POST
    public PacienteDTO createPaciente (PacienteDTO p )
    {
        return logic.crearPaciente(p);
    }
    
    @GET
    @Path("/paciente/{idPaciente:\\d+}")
    public PacienteDTO getPaciente(@PathParam("idPaciente")Long idPaciente)
    {
        System.out.println("Resoruces " + idPaciente);
        return logic.buscarPaciente(idPaciente);
    }
    
    @GET
    public List<PacienteDTO> getPacientes()
    {
        for (int i = 0; i < logic.darPacientes().size(); i++) {
            System.out.println(logic.darPacientes().get(i));
        }
        return logic.darPacientes();
    }
            
    @PUT
    public PacienteDTO upDatePaciente(@PathParam("idPaciente") long idPaciente, PacienteDTO p)
    {
        return logic.modificarPaciente(idPaciente, p);
    }
    
    @DELETE
    public void deletePaciente(@PathParam("idPaciente")long idPaciente)
    {
        logic.eliminarPaciente(idPaciente);
    }
    
    
    @GET
    @Path("/historial")
    public HistorialDTO getHistorialClinico (@PathParam("idPaciente") long idPaciente)
    {
        PacienteDTO p = logic.buscarPaciente(idPaciente);
        return p.getHistorialClinico();
    }
    
}
