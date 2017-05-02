/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import dto.MedicoDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author s.ardila13
 */
@Entity
public class MedicoEntity implements Serializable
{
    
    @Id
    
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="medico_seq_gen")
    @SequenceGenerator(name="medico_seq_gen", sequenceName="MEDICO_SEQU")
    private Long id;
    
    @ManyToMany
    private List<PacienteEntity> pacientes;
    
    private String nombre;
        
    private int especialista;

    public MedicoEntity()
    {
        
    }
    
    private MedicoEntity(MedicoBuilder builder) {
        this.nombre = builder.nombre;
        this.especialista = builder.especialista;
        this.pacientes = builder.pacientes;
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

    public int getEspecialista() {
        return especialista;
    }

    public void setEspecialista(int especialista) {
        this.especialista = especialista;
    }

    public MedicoDTO toDTO() 
    {
        MedicoDTO m = new MedicoDTO(nombre, especialista);
        m.setId(id);
        return m;
    }
    
    public static class MedicoBuilder{
        private List<PacienteEntity> pacientes;
    
        private String nombre;

        private int especialista;
        
        public MedicoBuilder(String nombre) {
            this.nombre = nombre;
        }   
        
        public MedicoBuilder especialista(int especialista){
            this.especialista = especialista;
            return this;
        }
        
        public MedicoBuilder pacientes(ArrayList<PacienteEntity> pacientes){
            this.pacientes = pacientes;
            return this;
        }
        
        public MedicoEntity build(){
            return new MedicoEntity(this);
        }
    }
    
}
