/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author s.ardila13
 */
public class ConfiguracionDTO {
    private String configuracion;
    
    private Date fecha;

    public ConfiguracionDTO() {
    }

    public ConfiguracionDTO(String configuracion, Date fecha) {
        this.configuracion = configuracion;
        this.fecha = fecha;
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

    @Override
    public String toString() {
        return "ConfiguracionDTO{" + "configuracion=" + configuracion + ", fecha=" + fecha + '}';
    }

    
}
