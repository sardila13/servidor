/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author gc.andrade10
 */
public class HospitalDTO
{
 private String nombre;
 private long id;

    public HospitalDTO()
    {
    }

    public HospitalDTO(String nombre, long id)
    {
        this.nombre = nombre;
        this.id=id;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @return the id
     */
    public long getId()
    {
        return id;
    }
 
    
 
}
