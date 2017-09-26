package carlos.agiletool.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "Tarea.buscarTodas", query = "SELECT t FROM Tarea t") })

public class Tarea implements Serializable {

	@Id
	private Integer id;
	private String nombre_persona;
	private String nombre_tarea;
	private Double performance;

	public Tarea() {

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



}
