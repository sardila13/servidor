/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import dto.HospitalDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author s.ardila13
 */
@Entity
public class HospitalEntity implements Serializable
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<DispositivoEntity> dispositivos;
    
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PacienteEntity> pacientes;
    
    private String nombre;

    public HospitalEntity(String nombre) {
        this.nombre = nombre;
    }
    
    public HospitalEntity()
    {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HospitalDTO toDTO() {
        return new HospitalDTO(nombre, id);
    }
    
}