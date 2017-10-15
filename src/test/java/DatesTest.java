import java.util.Calendar;

import org.junit.Test;

import lib.date.Dates;

public class DatesTest {

	@Test
	public void testContarDíasHabilesEntreFechas1dia() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2017, Calendar.OCTOBER, 6);
		fecFin.set(2017, Calendar.OCTOBER, 6);

		int dias = Dates.contarDíasHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 0);
	}
	
	@Test
	public void testContarDíasHabilesEntreFechas1diaSabado() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2017, Calendar.OCTOBER, 7);
		fecFin.set(2017, Calendar.OCTOBER, 7);

		int dias = Dates.contarDíasHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 0);
	}
	
	@Test
	public void testContarDíasHabilesEntreFechas1diaSabadoYDomingo() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2017, Calendar.OCTOBER, 7);
		fecFin.set(2017, Calendar.OCTOBER, 8);

		int dias = Dates.contarDíasHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 0);
	}
	
	@Test
	public void testContarDíasHabilesEntreFechas1diaSabadoDomingoYLunes() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2017, Calendar.OCTOBER, 7);
		fecFin.set(2017, Calendar.OCTOBER, 9);

		int dias = Dates.contarDíasHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 0);
	}
	
	@Test
	public void testContarDíasHabilesEntreFechas2dias() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2017, Calendar.OCTOBER, 9);
		fecFin.set(2017, Calendar.OCTOBER, 10);

		int dias = Dates.contarDíasHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 1);
	}
	
	@Test
	public void testContarDíasHabilesEntreFechas2diasFinDeSemana() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2017, Calendar.OCTOBER, 6);
		fecFin.set(2017, Calendar.OCTOBER, 9);

		int dias = Dates.contarDíasHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 1);
	}

	@Test
	public void testContarDíasHabilesEntreFechasOtrosMeses() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2017, Calendar.SEPTEMBER, 29);
		fecFin.set(2017, Calendar.OCTOBER, 2);

		int dias = Dates.contarDíasHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 1);
	}
	
	@Test
	public void testContarDíasHabilesEntreFechasError() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2016, Calendar.DECEMBER, 31);
		fecFin.set(2016, Calendar.DECEMBER, 30);

		int dias = Dates.contarDíasHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 0);
	}
	
	
}
