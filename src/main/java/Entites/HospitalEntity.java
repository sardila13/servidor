/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Entites;

import dto.DispositivoDTO;
import dto.HospitalDTO;
import dto.PacienteDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author s.ardila13
 */
@Entity
public class HospitalEntity implements Serializable
{
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hospital_seq_gen")
    @SequenceGenerator(name="hospital_seq_gen", sequenceName="HOSPITAL_SEQU")
    private Long id;
    
    @PodamExclude
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DispositivoEntity> dispositivos;
    
    @PodamExclude
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PacienteEntity> pacientes;
    
    private String nombre;
    
    private HospitalEntity(HospitalBuilder builder) 
    {
        this.nombre = builder.nombre;
        dispositivos = builder.dispositivos;
        pacientes = builder.pacientes;
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

    public List<DispositivoEntity> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<DispositivoEntity> dispositivos) {
        this.dispositivos = dispositivos;
    }

    public List<PacienteEntity> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<PacienteEntity> pacientes) {
        this.pacientes = pacientes;
    }
    
     public ArrayList<DispositivoDTO> dispositivosDtos()
    {
        ArrayList<DispositivoDTO> nAlertas = new ArrayList<DispositivoDTO>();
        for(int i = 0; i < dispositivos.size(); i++){
            nAlertas.add(dispositivos.get(i).toDTO());
        }
        return nAlertas;
    }
    
     public ArrayList<PacienteDTO> pacientesDtos()
    {
        ArrayList<PacienteDTO> nAlertas = new ArrayList<PacienteDTO>();
        for(int i = 0; i < pacientes.size(); i++){
            nAlertas.add(pacientes.get(i).toDTO());
        }
        return nAlertas;
    }
    
    
    public HospitalDTO toDTO()
    {
        HospitalDTO h = new HospitalDTO(nombre);
        h.setDispositivos(dispositivosDtos());
        h.setPacientes(pacientesDtos());
        h.setId(id);
        return h;
    }

    @Override
    public String toString() 
    {
        return "HospitalEntity{" + "id=" + id + ", dispositivos=" + dispositivos + ", pacientes=" + pacientes + ", nombre=" + nombre + '}';
    }

    public void addPaciente(PacienteEntity toEntity) 
    {
        pacientes.add(toEntity);
    }
    
    
    public static class HospitalBuilder{
        private List<DispositivoEntity> dispositivos;
    
        private List<PacienteEntity> pacientes;
    
        private String nombre;
        
        public HospitalBuilder(String nombre) 
        {
            this.nombre = nombre;
        }
        
        public HospitalBuilder dispositivos(ArrayList<DispositivoEntity> dispositivos){
            this.dispositivos = dispositivos;
            return this;
        }
        
        public HospitalBuilder pacientes(ArrayList<PacienteEntity> pacientes){
            this.pacientes = pacientes;
            return this;
        }
        
        public HospitalEntity build(){
            return new HospitalEntity(this);
        }
    }
    
    
}
