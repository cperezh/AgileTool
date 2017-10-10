package lib.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dates {

	public static int contarDíasHabilesEntreFechas(Calendar fecInicio,Calendar fecFin) {
		
		Calendar fechaInicioAux = (Calendar) fecInicio.clone();
		int days = 0;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(dateFormat.format(fechaInicioAux.getTime()));
		System.out.println(dateFormat.format(fecFin.getTime()));
		
		while (fechaInicioAux.getTimeInMillis()<fecFin.getTimeInMillis()) {
			
			System.out.println(dateFormat.format(fechaInicioAux.getTime()));
			
			days++;
			
			fechaInicioAux.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		return days;
	}
}
