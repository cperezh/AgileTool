import java.util.Calendar;

import org.junit.Test;

import carlos.agiletool.entity.Tarea;

public class TareaTest {

	
	@Test
	public void calcularPVTestEmpezoAnteAyer() {
		
		Tarea tarea = new Tarea();
		
		tarea.setHoras_tarea(20.5);
		tarea.setPerformance(1.0);
		Calendar fecInicio = Calendar.getInstance();
		fecInicio.add(Calendar.DAY_OF_MONTH,-2);
		
		tarea.setFec_inicio(fecInicio);
		
		tarea.calcularPV();
		
		assert(tarea.getPendiente_planificado()==4.5);		
		
	}
	
	@Test
	public void calcularPVTestEmpezoAyer() {
		
		Tarea tarea = new Tarea();
		
		tarea.setHoras_tarea(8d);
		tarea.setPerformance(1.0);
		Calendar fecInicio = Calendar.getInstance();
		fecInicio.add(Calendar.DAY_OF_MONTH,-1);
		
		tarea.setFec_inicio(fecInicio);
		
		tarea.calcularPV();
		
		assert(tarea.getPendiente_planificado()==0);		
		
	}
	
	@Test
	public void calcularPVTestEmpezoAyerPerformanceMitad() {
		
		Tarea tarea = new Tarea();
		
		tarea.setHoras_tarea(8d);
		tarea.setPerformance(0.5);
		Calendar fecInicio = Calendar.getInstance();
		fecInicio.add(Calendar.DAY_OF_MONTH,-1);
		
		tarea.setFec_inicio(fecInicio);
		
		tarea.calcularPV();
		
		assert(tarea.getPendiente_planificado()==4);		
		
	}
	
	@Test
	public void calcularPVTestEmpezoHoy() {
		
		Tarea tarea = new Tarea();
		
		tarea.setHoras_tarea(8d);
		tarea.setPerformance(1.0);
		Calendar fecInicio = Calendar.getInstance();
		
		
		tarea.setFec_inicio(fecInicio);
		
		tarea.calcularPV();
		
		assert(tarea.getPendiente_planificado()==8);		
		
	}
	
	@Test
	public void calcularPVTestEmpiezaManana() {
		
		Tarea tarea = new Tarea();
		
		tarea.setHoras_tarea(8d);
		tarea.setPerformance(1.0);
		Calendar fecInicio = Calendar.getInstance();
		
		
		tarea.setFec_inicio(fecInicio);
		
		tarea.calcularPV();
		
		assert(tarea.getPendiente_planificado()==8);		
		
	}

}
