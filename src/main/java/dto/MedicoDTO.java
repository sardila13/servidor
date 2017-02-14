/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Sneider Velandia G
 */
public class MedicoDTO 
{
    //atributos
    String nombre;
    int id;
    int especialista;
    
    //constrcutor vacio
    public MedicoDTO()
    {}
    
    //contructor con atributos
    public MedicoDTO(String nombre, int id, int especialista)
    {
        this.nombre=nombre;
        this.id=id;
        this.especialista=especialista;
    }
    
    // metodos Get
    public String getNombre()
    {
        return nombre;
    }
    
    public int getId()
    {
        return id;
    }
    
    public int especialista()
    {
        return especialista;
    }
    //metodos Set
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setEspecialista(int especialista)
    {
        this.especialista=especialista;
    }

    
}
