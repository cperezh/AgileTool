import java.util.Calendar;

import org.junit.Test;

import carlos.agiletool.entity.Tarea;
import lib.date.Dates;

public class TareaTest {

	
	@Test
	public void recalcularTestNulo() {

		Tarea tarea = new Tarea();
		tarea.setHoras_tarea(16d);
		tarea.setPerformance(1d);

		Calendar fecInicio = Dates.normalizarFechaADiaMesAnio(Calendar.getInstance());
		fecInicio.set(2017, Calendar.OCTOBER, 16);
		tarea.setFec_inicio(fecInicio);

		tarea.recalcular();

		assert (tarea.getFec_fin_planificada()==null);
	}
	
	@Test
	public void recalcularTest1Week() {

		Tarea tarea = new Tarea();
		tarea.setHoras_tarea(40d);
		tarea.setPerformance(1d);

		Calendar fecInicio = Dates.normalizarFechaADiaMesAnio(Calendar.getInstance());
		tarea.setFec_inicio(fecInicio);
		
		Calendar fecFin = (Calendar)fecInicio.clone();
		fecFin.add(Calendar.DAY_OF_MONTH, 6);
	
		tarea.recalcular();

		assert (tarea.getFec_fin_planificada().equals(fecFin));
	}
	
	@Test
	public void recalcularTest1WeekEV() {

		Tarea tarea = new Tarea();
		tarea.setHoras_tarea(40d);
		tarea.setPerformance(1d);
		tarea.setPendiente_actual(40d);

		Calendar fecInicio = Dates.normalizarFechaADiaMesAnio(Calendar.getInstance());
		tarea.setFec_inicio(fecInicio);
		
		Calendar fecFin = (Calendar)fecInicio.clone();
		fecFin.add(Calendar.DAY_OF_MONTH, 6);
	
		tarea.recalcular();

		assert (tarea.getFec_fin_actual().equals(fecFin));
	}
}
