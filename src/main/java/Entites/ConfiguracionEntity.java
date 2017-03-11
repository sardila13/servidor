/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import dto.ConfiguracionDTO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author s.ardila13
 */
@Entity
public class ConfiguracionEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private DispositivoEntity dispositivo;
    
    private String configuracion;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public ConfiguracionEntity()
    {
        
    }

    public ConfiguracionEntity(String configuracion, Date fecha) {
        this.configuracion = configuracion;
        this.fecha = fecha;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(String configuracion) {
        this.configuracion = configuracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ConfiguracionDTO toDTO() 
    {
        ConfiguracionDTO c = new ConfiguracionDTO(configuracion);
        c.setFecha(fecha);
        return c;
    }
    
    
}
