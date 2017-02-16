/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;

/**
 *
 * @author s.ardila13
 */
public class DispositivoDTO {
    
    private Long id;
    
    private PacienteDTO paciente;
    
    private ArrayList<AlertaDTO> alertas;
    
    private HospitalDTO hospital;
    
    private ConfiguracionDTO configuracion;
    
    public DispositivoDTO(Long id, PacienteDTO paciente,  HospitalDTO hospital,
    ConfiguracionDTO configuracion)
    {
        this.id = id;
        
        this.paciente = paciente;

        this.alertas = new ArrayList<AlertaDTO>();
                
        this.hospital = hospital;
        this.configuracion=configuracion;
    }
    
    public void agregarAlerta(AlertaDTO alerta){
        alertas.add(alerta);
    }
    
    public void eliminarAlertaPorIndex(int index){
        alertas.remove(index);
    }
    
    public void eliminarAlertaPorObjeto(AlertaDTO alerta){
        alertas.remove(alerta);
    }
    
    public void cambiarAlerta(int index, AlertaDTO alerta){
        alertas.set(index, alerta);
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public void setPaciente(PacienteDTO paciente){
        this.paciente = paciente;
    }
    
    public void setAlertas(ArrayList<AlertaDTO> alertas){
        this.alertas = alertas;
    }
    
    public void setHospital(HospitalDTO hospital){
        this.hospital = hospital;
    }
    
    public Long getId(){
        return id;
    }
    
    public PacienteDTO getPaciente(){
        return paciente;
    }
    
    public ArrayList<AlertaDTO> getAlertas(){
        return alertas;
    }
    
    public HospitalDTO getHospital(){
        return hospital;
    }

    public void setConfiguration(ConfiguracionDTO confi)
    {
       configuracion=confi; 
    }
    
    public ConfiguracionDTO getConfiguration(String confi)
    {
       return configuracion; 
    }
    
}
