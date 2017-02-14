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
public class PacienteDTO {
    
    private String nombre;
    
    private Long id;
    
    private int edad;
    
    private DispositivoDTO dispositivo;
    
    private ArrayList<MedicoDTO> medicos;
    
    private HospitalDTO hospital;
    
    private HistorialDTO historial;
    
    private ArrayList<AlertaDTO> alertas;
    
    public PacienteDTO(String nombre, Long id, int edad, DispositivoDTO dispositivo, ArrayList<MedicoDTO> medicos, HospitalDTO hospital, HistorialDTO historial, ArrayList<AlertaDTO> alertas){
        this.nombre = nombre;
        
        this.id = id;
        
        this.edad = edad;
        
        this.dispositivo = dispositivo;
        
        this.medicos = medicos;
        
        this.hospital = hospital;
        
        this.historial = historial;
        
        this.alertas = alertas;
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
    
    public void agregarMedico(MedicoDTO medico){
        medicos.add(medico);
    }
    
    public void eliminarMedicoPorIndex(int index){
        medicos.remove(index);
    }
    
    public void eliminarMedicoPorObjeto(MedicoDTO medico){
        medicos.remove(medico);
    }
    
    public void cambiarMedico(int index, MedicoDTO medico){
        medicos.set(index, medico);
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public void setDispositivo(DispositivoDTO dispositivo){
        this.dispositivo = dispositivo;
    }
    
    public void setMedicos(ArrayList<MedicoDTO> medicos){
        this.medicos = medicos;
    }
    
    public void setHistorialCzlinico(HistorialDTO historial){
        this.historial = historial;
    }
    
    public void setHospital(HospitalDTO hospital){
        this.hospital = hospital;
    }
    
    public void setAlertas(ArrayList<AlertaDTO> alertas){
        this.alertas = alertas;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Long getId(){
        return id;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public DispositivoDTO getDispositivo(){
        return dispositivo;
    }
    
    public ArrayList<MedicoDTO> getMedicos(){
        return medicos;
    }
    
    public HospitalDTO getHospital(){
        return hospital;
    }
    
    public HistorialDTO getHistorialClinico(){
        return historial;
    }
    
    public ArrayList<AlertaDTO> getAlertas(){
        return alertas;
    }
    
}
