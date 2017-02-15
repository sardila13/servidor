/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author ba.bohorquez10
 */
public class AlertaDTO 
{
    public final static int VERDE = 0;
    public final static int AMARILLO = 1;
    public final static int ROJO = 2;
    
    private Boolean esEmergencia;
    private Integer[] presionSanguinea;
    private Integer frecuenciaCardica;
    private Integer nivelEstres;
    private Long idDispositivo;
    private Integer tipo;
    private Long[] ubicacion;
    private Date fecha;

    public AlertaDTO()
    {
    }

    public AlertaDTO(Boolean esEmergencia, Integer[] presionSanguinea, Integer frecuenciaCardica, Integer nivelEstres, Long idDispositivo, Integer tipo, Long[] ubicacion, Date fecha)
    {
        this.esEmergencia = esEmergencia;
        this.presionSanguinea = presionSanguinea;
        this.frecuenciaCardica = frecuenciaCardica;
        this.nivelEstres = nivelEstres;
        this.idDispositivo = idDispositivo;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
    }

    public Boolean getEsEmergencia()
    {
        return esEmergencia;
    }

    public void setEsEmergencia(Boolean esEmergencia)
    {
        this.esEmergencia = esEmergencia;
    }

    public Integer[] getPresionSanguinea()
    {
        return presionSanguinea;
    }

    public void setPresionSanguinea(Integer[] presionSanguinea)
    {
        this.presionSanguinea = presionSanguinea;
    }

    public Integer getFrecuenciaCardica()
    {
        return frecuenciaCardica;
    }

    public void setFrecuenciaCardica(Integer frecuenciaCardica)
    {
        this.frecuenciaCardica = frecuenciaCardica;
    }

    public Integer getNivelEstres()
    {
        return nivelEstres;
    }

    public void setNivelEstres(Integer nivelEstres)
    {
        this.nivelEstres = nivelEstres;
    }

    public Long getIdDispositivo()
    {
        return idDispositivo;
    }

    public void setIdDispositivo(Long idDispositivo)
    {
        this.idDispositivo = idDispositivo;
    }

    public Integer getTipo()
    {
        return tipo;
    }

    public void setTipo(Integer tipo)
    {
        this.tipo = tipo;
    }

    public Long[] getUbicacion()
    {
        return ubicacion;
    }

    public void setUbicacion(Long[] ubicacion)
    {
        this.ubicacion = ubicacion;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    @Override
    public String toString()
    {
        return "AlertaDTO{" + "esEmergencia=" + esEmergencia + ", presionSanguinea=" + presionSanguinea + ", frecuenciaCardica=" + frecuenciaCardica + ", nivelEstres=" + nivelEstres + ", idDispositivo=" + idDispositivo + ", tipo=" + tipo + ", ubicacion=" + ubicacion + ", fecha=" + fecha + '}';
    }
    
    
    
}
