package carlos.agiletool.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import carlos.agiletool.lib.date.Dates;

@Entity
@NamedQueries({ @NamedQuery(name = "Tarea.buscarTodas", query = "SELECT t FROM Tarea t") })

public class Tarea {

	private static final int horasDia = 8;

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
	private String dias_off;
	@Transient
	private List<Calendar> festivos;

	public Tarea() {
		performance = 1d;
		horas_tarea = 0d;
		fec_inicio = Calendar.getInstance();
		pendiente_actual = 0d;
	}

	public void recalcular() {

		setTime();

		calcularPV();
		calcularSV();
		calcularFechaFinPV();
		calcularFechaFinEV();
	}

	private void setTime() {
		this.getFec_inicio().getTimeInMillis();
		this.getFec_inicio().setTimeZone(Calendar.getInstance().getTimeZone());
	}

	private void calcularPV() {

		int diasHabiles;

		diasHabiles = Dates.contarDiasHabilesEntreFechas(fec_inicio, Calendar.getInstance(), festivos);

		pendiente_planificado = horas_tarea - (performance * horasDia * diasHabiles);

		if (pendiente_planificado < 0)
			pendiente_planificado = 0d;

	}

	private void calcularSV() {

		desviacion = pendiente_planificado - pendiente_actual;

	}

	/**
	 * Calculo la fecha fin planificada, en funcion de la fecha de incio y las
	 * horas tarea
	 */
	private void calcularFechaFinPV() {

		Double numDiasTarea;

		numDiasTarea = Math.ceil(horas_tarea / horasDia / performance);

		fec_fin_planificada = Dates.calcularFechaFin(fec_inicio, numDiasTarea.intValue(), festivos);

	}

	/**
	 * Calculo la fecha fin actuakl, en funcion de los dias pendientes y la
	 * fecha de hoy
	 */
	private void calcularFechaFinEV() {

		Double numDiasPendientes;

		numDiasPendientes = Math.ceil(pendiente_actual / horasDia / performance);

		fec_fin_actual = Dates.calcularFechaFin(Calendar.getInstance(), numDiasPendientes.intValue(), festivos);

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

	public String getDias_off() {
		return dias_off;
	}

	public void setDias_off(String dias_off) throws ParseException {
		this.dias_off = dias_off;
		
		festivos = new ArrayList<Calendar>();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String[] festivoString = dias_off.split(",");

		for (String fecha : festivoString) {
			cal = Calendar.getInstance();
			cal.setTime(sdf.parse(fecha));
			festivos.add(cal);
		}
	}

	public List<Calendar> getFestivos() {
		return festivos;
	}

	public void setFestivos(List<Calendar> festivos) {
		this.festivos = festivos;
	}

//	@Override
//	public String toString() {
//		return "Tarea [id=" + id + ", nombre_persona=" + nombre_persona + ", nombre_tarea=" + nombre_tarea + ", performance=" + performance + ", horas_tarea=" + horas_tarea + ", fec_inicio="
//				+ fec_inicio.get(Calendar.DAY_OF_MONTH) + "/" + (fec_inicio.get(Calendar.MONTH) + 1) + "/" + fec_inicio.get(Calendar.YEAR) + ", pendiente_planificado=" + pendiente_planificado
//				+ ", pendiente_actual=" + pendiente_actual + ", desviacion=" + desviacion + ", fec_fin_planificada=" + fec_fin_planificada + ", fec_fin_actual=" + fec_fin_actual + ", dias_off="
//				+ dias_off + "]";
//	}

}
