/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author s.ardila13
 */
@Entity
public class ConsejoEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="consejo_seq_gen")
    @SequenceGenerator(name="consejo_seq_gen", sequenceName="CONSEJO_SEQU")
    private Long id;
    
    private String consejo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @ManyToOne
    private PacienteEntity paciente;

    public ConsejoEntity() {
    }

    private ConsejoEntity(ConsejoBuilder builder) {
        this.consejo = builder.consejo;
        this.fecha = builder.fecha;
    }

    public String getConsejo() {
        return consejo;
    }

    public void setConsejo(String consejo) {
        this.consejo = consejo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long pId)
    {
        id = pId;
    }
    
    public static class ConsejoBuilder{
    
        private String consejo;
    
        private Date fecha;

        private PacienteEntity paciente;
        
        public ConsejoBuilder(String consejo) {
            this.consejo = consejo;
        }
        
        public ConsejoBuilder fecha(Date fecha){
            this.fecha = fecha;
            return this; 
        }
        
        public ConsejoEntity build(){
            return new ConsejoEntity(this);
        }
    }
}
