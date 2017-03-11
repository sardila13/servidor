/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import Entites.HospitalEntity;

/**
 *
 * @author gc.andrade10
 */
public class HospitalDTO
{
 private String nombre;
 private Long id;

    public HospitalDTO()
    {
    }

    public HospitalDTO(String nombre)
    {
        this.nombre = nombre;
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
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long pId)
    {
        id=pId;
    }

    public HospitalEntity toEntity() 
    {
        System.out.println(nombre);
        return new HospitalEntity(nombre);
    }
 
    
 
}
