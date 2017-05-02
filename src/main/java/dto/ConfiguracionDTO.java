/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package dto;

import Entites.ConfiguracionEntity;
import Entites.ConfiguracionEntity.ConfiguracionEvent;
import Entites.HospitalEntity;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author s.ardila13
 */
public class ConfiguracionDTO implements Observer {
    
    private Long id;
    
    private String configuracion;
    
    private Date fecha;
    
//    private DispositivoDTO dispositivo;
    
    public ConfiguracionDTO() {
    }
    
    public ConfiguracionDTO(String config)
    {
//        this.dispositivo = dis;
        this.configuracion = config;
        fecha= new Date();
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

//    public DispositivoDTO getDispositivo() {
//        return dispositivo;
//    }
//
//    public void setDispositivo(DispositivoDTO dispositivo) {
//        this.dispositivo = dispositivo;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    @Override
    public String toString() {
        return "ConfiguracionDTO{" + "configuracion=" + configuracion + ", fecha=" + fecha + '}';
    }
    
    public ConfiguracionEntity toEntity()
    {
        return new
            ConfiguracionEntity.ConfiguracionBuilder(configuracion).fecha(fecha).build();
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof ConfiguracionEntity.ConfiguracionEvent){
            this.configuracion = ((ConfiguracionEvent) arg).getConfiguracionNueva();
            System.out.println("Se ha cambiado la configuración");
        }
    }
    
}
