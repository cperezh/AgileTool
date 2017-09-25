package carlos.agiletool.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Tarea implements Serializable {

	private String nombre;
	private String tarea;
	private Double performance;

	public Tarea() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public Double getPerformance() {
		return performance;
	}

	public void setPerformance(Double performance) {
		this.performance = performance;
	}

}
