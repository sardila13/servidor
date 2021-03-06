/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;
import dto.AlertaDTO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author s.ardila13
 */
@Entity
public class AlertaEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="alerta_seq_gen")
    @SequenceGenerator(name="alerta_seq_gen", sequenceName="ALERTA_SEQU")
    private Long id;
    
    private Integer esEmergencia;
    
    private Integer[] presionSanguinea;
    
    private Integer frecuenciaCardiaca;
    
    private Integer nivelEstres;
    
//    @ManyToOne
//    @PodamExclude
//    private DispositivoEntity dispositivo;
    
//    @ManyToOne
//    @PodamExclude
//    private HistorialEntity historial;
    
    private Integer tipo;
    
    private Double[] ubicacion;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
//    @ManyToOne
//    @PodamExclude
//    private PacienteEntity paciente;

    public AlertaEntity()
    {
        
    }
    
    private AlertaEntity(AlertaBuilder builder){
        this.esEmergencia = builder.esEmergencia;
        this.presionSanguinea = builder.presionSanguinea;
        this.frecuenciaCardiaca = builder.frecuenciaCardiaca;
        this.nivelEstres = builder.nivelEstres;
        this.tipo = builder.tipo;
        this.ubicacion = builder.ubicacion;
        this.fecha = builder.fecha;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEsEmergencia() {
        return esEmergencia;
    }

    public void setEsEmergencia(Integer esEmergencia) {
        this.esEmergencia = esEmergencia;
    }

    public Integer[] getPresionSanguinea() {
        return presionSanguinea;
    }

    public void setPresionSanguinea(Integer[] presionSanguinea) {
        this.presionSanguinea = presionSanguinea;
    }

    public Integer getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(Integer frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public Integer getNivelEstres() {
        return nivelEstres;
    }

    public void setNivelEstres(Integer nivelEstres) {
        this.nivelEstres = nivelEstres;
    }

//    public DispositivoEntity getDispositivo() {
//        return dispositivo;
//    }
//
//    public void setDispositivo(DispositivoEntity dispositivo) {
//        this.dispositivo = dispositivo;
//    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Double[] getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Double[] ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public AlertaDTO toDTO() 
    {
//        DispositivoDTO pDispositivo = null;
//        if(dispositivo != null){
//            pDispositivo = dispositivo.toDTO();
//        }
        return new AlertaDTO(getEsEmergencia(), getPresionSanguinea(), frecuenciaCardiaca, nivelEstres, /*pDispositivo,*/ tipo, ubicacion);
    }

    @Override
    public String toString() {
        return "AlertaEntity{" + "id=" + id + ", esEmergencia=" + esEmergencia + ", presionSanguinea=" + presionSanguinea + ", frecuenciaCardiaca=" + frecuenciaCardiaca + ", nivelEstres=" + nivelEstres + ", tipo=" + tipo + ", ubicacion=" + ubicacion + ", fecha=" + fecha + '}';
    }

    public static class AlertaBuilder{
        private Long id;
    
        private Integer esEmergencia;

        private Integer[] presionSanguinea;

        private Integer frecuenciaCardiaca;

        private Integer nivelEstres;

        private Integer tipo;

        private Double[] ubicacion;
        
        private Date fecha;

    
        public AlertaBuilder(Integer esEmergencia, Integer[] presionSanguinea, Integer frecuenciaCardiaca, Integer nivelEstres) {
            this.esEmergencia = esEmergencia;
            this.presionSanguinea = presionSanguinea;
            this.frecuenciaCardiaca = frecuenciaCardiaca;
            this.nivelEstres = nivelEstres;
    
        }
        
        public AlertaBuilder tipo(Integer tipo){
            this.tipo = tipo;
            return this;
        }
        
        public AlertaBuilder ubicacion(Double ubicacion[]){
            this.ubicacion = ubicacion;
            return this;
        }
        
        public AlertaBuilder fecha(Date fecha){
            this.fecha = fecha;
            return this;
        }
        
        public AlertaEntity build(){
            return new AlertaEntity(this);
        }
    
    }
    
    
}
