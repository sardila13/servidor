/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;
import dto.MedicoDTO;
import java.util.ArrayList;
/**
 *
 * @author Sneider Velandia G
 */
public interface IMedicoLogic 
{
    public void crearMedico(MedicoDTO medico);
    public MedicoDTO buscarMedico(int id);
    public ArrayList<MedicoDTO>darMedicos();
    public void eliminarMedico(int id);
    public void configurarMarcapasos(int id, String cofiguracion);
    
}
