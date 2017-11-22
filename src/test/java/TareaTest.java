import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.text.ParseException;
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

		Calendar fecFin = (Calendar) fecInicio.clone();
		fecFin.add(Calendar.DAY_OF_MONTH, 6);

		tarea.recalcular();

		assert (Dates.iguales(tarea.getFec_fin_planificada(), fecFin));
	}

	@Test
	public void recalcularTest1WeekEV() {

		Tarea tarea = new Tarea();
		tarea.setHoras_tarea(40d);
		tarea.setPerformance(1d);
		tarea.setPendiente_actual(40d);

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Dates.calcularFechaFin(fecInicio, 5, null);

		tarea.setFec_inicio(fecInicio);

		tarea.recalcular();

		assert (Dates.iguales(tarea.getFec_fin_actual(), fecFin));
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

		Calendar fecFin = (Calendar) fecInicio.clone();
		fecFin.add(Calendar.DAY_OF_MONTH, 1);

		tarea.recalcular();

		assert (Dates.iguales(tarea.getFec_fin_planificada(), fecFin));
	}

	@Test
	public void testSetDias_off1FestivoOK() {
		Tarea tarea = new Tarea();
		String festivo = "25/03/2017";
		try {
			tarea.setDias_off(festivo);
		} catch (ParseException e) {
			fail();
		}

		Calendar fecInicio = Calendar.getInstance();
		fecInicio.set(2017, Calendar.MARCH, 25);

		assert (Dates.iguales(fecInicio, tarea.getFestivos().get(0)));

	}

	@Test
	public void testSetDias_off1FestivoKO() {
		Tarea tarea = new Tarea();
		String festivo = "25/03/2017";
		try {
			tarea.setDias_off(festivo);
		} catch (ParseException e) {
			fail();
		}

		Calendar fecInicio = Calendar.getInstance();
		fecInicio.set(2017, Calendar.MARCH, 26);

		assertFalse(Dates.iguales(fecInicio, tarea.getFestivos().get(0)));

	}

	@Test
	public void testSetDias_off2FestivosOK() {

		Tarea tarea = new Tarea();
		String festivos = "25/03/2017,26/03/2017";
		try {
			tarea.setDias_off(festivos);
		} catch (ParseException e) {
			fail();
		}

		Calendar fecInicio = Calendar.getInstance();
		fecInicio.set(2017, Calendar.MARCH, 25);
		Calendar fecInicio2 = Calendar.getInstance();
		fecInicio2.set(2017, Calendar.MARCH, 26);

		assert (Dates.iguales(fecInicio, tarea.getFestivos().get(0)) && Dates.iguales(fecInicio2, tarea.getFestivos().get(1)));

	}

	@Test
	public void testSetDias_off2FestivosKO() {

		Tarea tarea = new Tarea();
		String festivos = "25/03/2017,26/03/2017";
		try {
			tarea.setDias_off(festivos);
		} catch (ParseException e) {
			fail();
		}

		Calendar fecInicio = Calendar.getInstance();
		fecInicio.set(2017, Calendar.MARCH, 25);
		Calendar fecInicio2 = Calendar.getInstance();
		fecInicio2.set(2017, Calendar.MARCH, 27);

		assertFalse(Dates.iguales(fecInicio, tarea.getFestivos().get(0)) && Dates.iguales(fecInicio2, tarea.getFestivos().get(1)));

	}

	@Test(expected = ParseException.class)
	public void testSetDias_off2FestivosParseError() throws ParseException {

		Tarea tarea = new Tarea();
		String festivos = "a/03/2017,26/03/2017";
		tarea.setDias_off(festivos);

		Calendar fecInicio = Calendar.getInstance();
		fecInicio.set(2017, Calendar.MARCH, 25);
		Calendar fecInicio2 = Calendar.getInstance();
		fecInicio2.set(2017, Calendar.MARCH, 27);

	}
}
