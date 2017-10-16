import java.util.Calendar;

import org.junit.Test;

import lib.date.Dates;

public class DatesTest {

	@Test
	public void testContarD�asHabilesEntreFechas1dia() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2017, Calendar.OCTOBER, 6);
		fecFin.set(2017, Calendar.OCTOBER, 6);

		int dias = Dates.contarD�asHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 0);
	}
	
	@Test
	public void testContarD�asHabilesEntreFechas1diaSabado() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2017, Calendar.OCTOBER, 7);
		fecFin.set(2017, Calendar.OCTOBER, 7);

		int dias = Dates.contarD�asHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 0);
	}
	
	@Test
	public void testContarD�asHabilesEntreFechas1diaSabadoYDomingo() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2017, Calendar.OCTOBER, 7);
		fecFin.set(2017, Calendar.OCTOBER, 8);

		int dias = Dates.contarD�asHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 0);
	}
	
	@Test
	public void testContarD�asHabilesEntreFechas1diaSabadoDomingoYLunes() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2017, Calendar.OCTOBER, 7);
		fecFin.set(2017, Calendar.OCTOBER, 9);

		int dias = Dates.contarD�asHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 0);
	}
	
	@Test
	public void testContarD�asHabilesEntreFechas2dias() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2017, Calendar.OCTOBER, 9);
		fecFin.set(2017, Calendar.OCTOBER, 10);

		int dias = Dates.contarD�asHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 1);
	}
	
	@Test
	public void testContarD�asHabilesEntreFechas2diasFinDeSemana() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2017, Calendar.OCTOBER, 6);
		fecFin.set(2017, Calendar.OCTOBER, 9);

		int dias = Dates.contarD�asHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 1);
	}

	@Test
	public void testContarD�asHabilesEntreFechasOtrosMeses() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2017, Calendar.SEPTEMBER, 29);
		fecFin.set(2017, Calendar.OCTOBER, 2);

		int dias = Dates.contarD�asHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 1);
	}
	
	@Test
	public void testContarD�asHabilesEntreFechasError() {

		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();

		fecInicio.set(2016, Calendar.DECEMBER, 31);
		fecFin.set(2016, Calendar.DECEMBER, 30);

		int dias = Dates.contarD�asHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 0);
	}
	
	@Test
	public void testContarD�asHabilesEntreFechasNulosFecInicio() {

		Calendar fecInicio = null;
		Calendar fecFin = Calendar.getInstance();

		
		fecFin.set(2016, Calendar.DECEMBER, 30);

		int dias = Dates.contarD�asHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 0);
	}
	
	@Test
	public void testContarD�asHabilesEntreFechasNulosFecFin() {

		Calendar fecInicio = Calendar.getInstance();;
		Calendar fecFin = null;

		
		fecInicio.set(2016, Calendar.DECEMBER, 30);

		int dias = Dates.contarD�asHabilesEntreFechas(fecInicio, fecFin);

		assert (dias == 0);
	}
	
	@Test
	public void calcularFechaFinLunesMas1() {
		
		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFinAux = Calendar.getInstance();
		Calendar fecFin;
		 
		
		fecInicio.set(2017, Calendar.OCTOBER, 17);
		fecFinAux.set(2017, Calendar.OCTOBER, 18);
		
		fecFin = Dates.calcularFechaFin(fecInicio,1);
		
		assert(fecFin.equals(fecFinAux));
		
		
		
		
	}
	
	
}
