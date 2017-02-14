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
    
    private boolean esEmergencia;
    private int[] presionSanguinea;
    private int frecuenciaCardica;
    private int nivelEstres;
    private Long idDispositivo;
    private int tipo;
    private Long[] ubicacion;
    private Date fecha;
    
    public AlertaDTO()
    {
        
    }
    
    public AlertaDTO(boolean pEsEmergencia, int pPresionSistolica, int pPresionDiastolica, int pFrecuancia, Long pId, int pTipo, Long[] pUbicacion, int pNivelEstres, Date pFecha)
    {
        this.esEmergencia = pEsEmergencia;
        this.presionSanguinea[0] = pPresionSistolica;
        this.presionSanguinea[1] = pPresionDiastolica;
        this.frecuenciaCardica = pFrecuancia;
        this.idDispositivo = pId;
        this.tipo = pTipo;
        this.ubicacion = pUbicacion;
        this.nivelEstres = pNivelEstres;
        this.fecha = pFecha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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

    public Long getIdDispositivo() {
        return idDispositivo;
    }

    public void setId(Long idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public int[] getPresionSanguinea() {
        return presionSanguinea;
    }

    public void setPresionSanguinea(int darPresionSanguinea, int diastolica) {
        this.presionSanguinea[0] = darPresionSanguinea;
        this.presionSanguinea[1] = diastolica;
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

    public boolean esEmergencia() {
        return esEmergencia;
    }

    public void setEsEmergencia(boolean esEmergencia) {
        this.esEmergencia = esEmergencia;
    }

    @Override
    public String toString()
    {
        return "AlertaDTO{" + "esEmergencia=" + esEmergencia + ", presionSanguinea=" + presionSanguinea + ", frecuenciaCardica=" + frecuenciaCardica + ", nivelEstres=" + nivelEstres + ", idDispositivo=" + idDispositivo + ", tipo=" + tipo + ", ubicacion=" + ubicacion + ", fecha=" + fecha + '}';
    }
    
    
    
    
    
}
