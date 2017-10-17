import java.util.Calendar;

import org.junit.Test;

import carlos.agiletool.entity.Tarea;

public class TareaTest {

	@Test
	public void recalcularTest() {

		Tarea tarea = new Tarea();
		tarea.setHoras_tarea(16d);
		tarea.setPerformance(1d);

		Calendar fecInicio = Calendar.getInstance();
		fecInicio.set(2017, Calendar.OCTOBER, 16);
		tarea.setFec_inicio(fecInicio);

		Calendar fecFinAux = (Calendar) fecInicio.clone();
		fecFinAux.set(2017, Calendar.OCTOBER, 17);

		tarea.recalcular();

		assert (tarea.getFec_fin_planificada().equals(fecFinAux));
	}
}
