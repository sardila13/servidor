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

    public final static int EMERGENCIA=1;
    private int presionSanguinea;
    private int frecuenciaCardica;
    private int nivelEstres;
    private int id;
    private int tipo;
    private String descripcion;
    private Long[] ubicacion;
    private Date fecha;
    
    public AlertaDTO()
    {
        
    }
    
    public AlertaDTO(int pre, int fre, int id, int tip, String des, Long[] ubi, int nivelEstres, Date fecha)
    {
        this.presionSanguinea = pre;
        this.frecuenciaCardica = fre;
        this.id = id;
        this.tipo = tip;
        this.descripcion = des;
        this.ubicacion = ubi;
        this.nivelEstres = nivelEstres;
        this.fecha = fecha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long[] getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Long[] ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getFrecuenciaCardica() {
        return frecuenciaCardica;
    }

    public void setFrecuenciaCardica(int frecuenciaCardica) {
        this.frecuenciaCardica = frecuenciaCardica;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPresionSanguinea() {
        return presionSanguinea;
    }

    public void setPresionSanguinea(int darPresionSanguinea) {
        this.presionSanguinea = darPresionSanguinea;
    }

    public int getNivelEstres() {
        return nivelEstres;
    }

    public void setNivelEstres(int nivelEstres) {
        this.nivelEstres = nivelEstres;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
