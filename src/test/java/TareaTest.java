import java.util.Calendar;

import org.junit.Test;

import carlos.agiletool.entity.Tarea;
import carlos.agiletool.lib.date.Dates;

public class TareaTest {

	
	@Test
	public void recalcularTest1Week() {

		Tarea tarea = new Tarea();
		tarea.setHoras_tarea(40d);
		tarea.setPerformance(1d);

		Calendar fecInicio = Calendar.getInstance();
		fecInicio.set(2017, Calendar.OCTOBER, 17);
		tarea.setFec_inicio(fecInicio);
		
		Calendar fecFin = (Calendar)fecInicio.clone();
		fecFin.add(Calendar.DAY_OF_MONTH, 6);
	
		tarea.recalcular();

		assert (Dates.iguales(tarea.getFec_fin_planificada(),fecFin));
	}
	
	@Test
	public void recalcularTest1WeekEV() {

		Tarea tarea = new Tarea();
		tarea.setHoras_tarea(40d);
		tarea.setPerformance(1d);
		tarea.setPendiente_actual(40d);

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Dates.calcularFechaFin(fecInicio, 5);
				
		tarea.setFec_inicio(fecInicio);
	
		tarea.recalcular();

		assert (Dates.iguales(tarea.getFec_fin_actual(),fecFin));
	}
	
	@Test
	public void recalcularTestSeguimientoDomingo() {

		Tarea tarea = new Tarea();
		tarea.setHoras_tarea(16d);
		tarea.setPerformance(1d);
		tarea.setPendiente_actual(5d);

		Calendar fecInicio = Calendar.getInstance();
		fecInicio.set(2017, Calendar.OCTOBER, 19);
		tarea.setFec_inicio(fecInicio);
		
		Calendar fecFin = (Calendar)fecInicio.clone();
		fecFin.add(Calendar.DAY_OF_MONTH, 1);
	
		tarea.recalcular();

		assert (Dates.iguales(tarea.getFec_fin_planificada(),fecFin));
	}
}
