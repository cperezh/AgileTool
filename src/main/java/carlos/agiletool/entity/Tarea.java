package carlos.agiletool.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
		@NamedQuery(name = "Tarea.buscarTodas", query = "SELECT t FROM Tarea t") })

public class Tarea implements Serializable {

	@Id
	private Integer id;
	private String nombre_persona;
	private String nombre_tarea;
	private Double performance;
	private Double horas_tarea;
	@Temporal(TemporalType.DATE)
	private Calendar fec_inicio;
	private Double pendiente_planificado;
	private Double pendiente_actual;
	private Double desviacion;
	@Temporal(TemporalType.DATE)
	private Calendar fec_fin_planificada;
	@Temporal(TemporalType.DATE)
	private Calendar fec_fin_actual;
	private Double dias_off;

	public Tarea() {

	}
	
	public void calcularPV() {
		this.setPendiente_planificado(new Double(6.0));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre_persona() {
		return nombre_persona;
	}

	public void setNombre_persona(String nombre_persona) {
		this.nombre_persona = nombre_persona;
	}

	public String getNombre_tarea() {
		return nombre_tarea;
	}

	public void setNombre_tarea(String nombre_tarea) {
		this.nombre_tarea = nombre_tarea;
	}

	public Double getPerformance() {
		return performance;
	}

	public void setPerformance(Double performance) {
		this.performance = performance;
	}

	public Double getHoras_tarea() {
		return horas_tarea;
	}

	public void setHoras_tarea(Double horas_tarea) {
		this.horas_tarea = horas_tarea;
	}

	public Calendar getFec_inicio() {
		return fec_inicio;
	}

	public void setFec_inicio(Calendar fec_inicio) {
		this.fec_inicio = fec_inicio;
	}

	public Double getPendiente_planificado() {
		return pendiente_planificado;
	}

	public void setPendiente_planificado(Double pendiente_planificado) {
		this.pendiente_planificado = pendiente_planificado;
	}

	public Double getPendiente_actual() {
		return pendiente_actual;
	}

	public void setPendiente_actual(Double pendiente_actual) {
		this.pendiente_actual = pendiente_actual;
	}

	public Double getDesviacion() {
		return desviacion;
	}

	public void setDesviacion(Double desviacion) {
		this.desviacion = desviacion;
	}

	public Calendar getFec_fin_planificada() {
		return fec_fin_planificada;
	}

	public void setFec_fin_planificada(Calendar fec_fin_planificada) {
		this.fec_fin_planificada = fec_fin_planificada;
	}

	public Calendar getFec_fin_actual() {
		return fec_fin_actual;
	}

	public void setFec_fin_actual(Calendar fec_fin_actual) {
		this.fec_fin_actual = fec_fin_actual;
	}

	public Double getDias_off() {
		return dias_off;
	}

	public void setDias_off(Double dias_off) {
		this.dias_off = dias_off;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", nombre_persona=" + nombre_persona + ", nombre_tarea=" + nombre_tarea + ", performance=" + performance + ", horas_tarea=" + horas_tarea + ", fec_inicio="
				+ fec_inicio.get(Calendar.DAY_OF_MONTH)+"/"+(fec_inicio.get(Calendar.MONTH)+1)+"/"+fec_inicio.get(Calendar.YEAR) + ", pendiente_planificado=" + pendiente_planificado + ", pendiente_actual=" + pendiente_actual + ", desviacion=" + desviacion + ", fec_fin_planificada="
				+ fec_fin_planificada + ", fec_fin_actual=" + fec_fin_actual + ", dias_off=" + dias_off + "]";
	}
	
	



}
