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

	@Test
	public void testContarDíasHabilesEntreFechasNulosFecInicio() {

		Calendar fecInicio = null;
		Calendar fecFin = Calendar.getInstance();

		fecFin.set(2016, Calendar.DECEMBER, 30);

		int dias = Dates.contarDíasHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 0);
	}

	@Test
	public void testContarDíasHabilesEntreFechasNulosFecFin() {

		Calendar fecInicio = Calendar.getInstance();
		;
		Calendar fecFin = null;

		fecInicio.set(2016, Calendar.DECEMBER, 30);

		int dias = Dates.contarDíasHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 0);
	}

	@Test
	public void calcularFechaFinLunesMas1() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFinAux = (Calendar) fecInicio.clone();
		Calendar fecFin;

		fecInicio.set(2017, Calendar.OCTOBER, 17);
		fecFinAux.set(2017, Calendar.OCTOBER, 18);

		fecFin = Dates.calcularFechaFin(fecInicio, 1);

		assert (fecFin.equals(fecFinAux));

	}

	@Test
	public void calcularFechaFinLunesMas0() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFinAux = (Calendar) fecInicio.clone();
		Calendar fecFin;

		fecInicio.set(2017, Calendar.OCTOBER, 18);
		fecFinAux.set(2017, Calendar.OCTOBER, 18);

		fecFin = Dates.calcularFechaFin(fecInicio, 0);

		assert (fecFin.equals(fecFinAux));

	}

	@Test
	public void calcularFechaFinLunesMenos1() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFinAux = (Calendar) fecInicio.clone();
		Calendar fecFin;

		fecInicio.set(2017, Calendar.OCTOBER, 18);
		fecFinAux.set(2017, Calendar.OCTOBER, 18);

		fecFin = Dates.calcularFechaFin(fecInicio, -1);

		assert (fecFin.equals(fecFinAux));

	}

	@Test
	public void calcularFechaFinLunesMas2() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFinAux = (Calendar) fecInicio.clone();
		Calendar fecFin;

		fecInicio.set(2017, Calendar.OCTOBER, 18);
		fecFinAux.set(2017, Calendar.OCTOBER, 20);

		fecFin = Dates.calcularFechaFin(fecInicio, 2);

		assert (fecFin.equals(fecFinAux));

	}

	@Test
	public void calcularFechaFinViernesMas1() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFinAux = (Calendar) fecInicio.clone();
		Calendar fecFin;

		fecInicio.set(2017, Calendar.OCTOBER, 13);
		fecFinAux.set(2017, Calendar.OCTOBER, 16);

		fecFin = Dates.calcularFechaFin(fecInicio, 1);

		assert (fecFin.equals(fecFinAux));

	}
	
	@Test
	public void calcularFechaFinSabadoMas1() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFinAux = (Calendar) fecInicio.clone();
		Calendar fecFin;

		fecInicio.set(2017, Calendar.OCTOBER, 14);
		fecFinAux.set(2017, Calendar.OCTOBER, 16);

		fecFin = Dates.calcularFechaFin(fecInicio, 1);

		assert (fecFin.equals(fecFinAux));

	}
	
	@Test
	public void calcularFechaFinJuevesMas3() {

		Calendar fecInicio = Dates.normalizarFechaADiaMesAnio(Calendar.getInstance());
		Calendar fecFinAux = (Calendar) fecInicio.clone();
		Calendar fecFin;

		fecInicio.set(2017, Calendar.OCTOBER, 12);
		fecFinAux.set(2017, Calendar.OCTOBER, 17);

		fecFin = Dates.calcularFechaFin(fecInicio, 3);

		assert (fecFin.equals(fecFinAux));

	}

}
