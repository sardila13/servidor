/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ IServicioCarritoMockLocal.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package logica.interfaces;


import dto.AlertaDTO;
import dto.DispositivoDTO;
import javax.ejb.Local;

/**
 * Contrato funcional de los servicios para el carrito de compras
 * @author Juan Sebastián Urrego
 */
@Local
public interface IHospital
{
    
    public void guardarAlerta(AlertaDTO a, DispositivoDTO d);
}
