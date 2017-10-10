import java.util.Calendar;

import org.junit.Test;

import lib.date.Dates;

public class DatesTest {

	
	@Test
	public void testContarDíasHabilesEntreFechas() {
		
		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();
		
		fecInicio.set(2017,Calendar.JANUARY,1);
		fecFin.set(2017, Calendar.JANUARY,3);
		
		int dias = Dates.contarDíasHabilesEntreFechas(fecInicio, fecFin);
		
		assert(dias == 2);
	}
	
	@Test
	public void testContarDíasHabilesEntreFechasOtrosMeses() {
		
		Calendar fecInicio = Calendar.getInstance();
		Calendar fecFin = Calendar.getInstance();
		
		fecInicio.set(2016,Calendar.DECEMBER,31);
		fecFin.set(2017, Calendar.JANUARY,2);
		
		int dias = Dates.contarDíasHabilesEntreFechas(fecInicio, fecFin);
		
		assert(dias == 2);
	}
}
