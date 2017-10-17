package lib.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dates {

	public static int contarDíasHabilesEntreFechas(Calendar fecInicio, Calendar fecFin) {

		if (fecInicio == null || fecFin == null)
			return 0;

		Calendar fechaInicioAux = Dates.normalizarFechaADiaMesAnio(fecInicio);

		Calendar fechaFinAux = Dates.normalizarFechaADiaMesAnio(fecFin);

		int days = 0;

		while (fechaInicioAux.before(fechaFinAux.clone())) {

			// Si no es sabado ni domingo, cuento el día
			if (fechaInicioAux.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && fechaInicioAux.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				days++;
			}

			fechaInicioAux.add(Calendar.DAY_OF_MONTH, 1);
		}

		return days;
	}

	/**
	 * Calcula la fecha fin en funcion de los días hábiles que han pasado desde
	 * la fechaInicio, sumando un número de dias
	 * 
	 * @param fecInicio
	 * @param numDias
	 * @return
	 */
	public static Calendar calcularFechaFin(Calendar fecInicio, int numDias) {

		if (fecInicio == null)
			return null;
		
		Calendar fecFin = (Calendar) fecInicio.clone();

		while (numDias > 0) {
			
			fecFin.add(Calendar.DAY_OF_MONTH, 1);

			// Si no es sabado ni domingo, cuento el día
			if (fecFin.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && fecFin.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				numDias--;
			}

			
		}
		return fecFin;
	}

	public static Calendar normalizarFechaADiaMesAnio(Calendar f1) {

		Calendar faux = Calendar.getInstance();

		faux = Dates.trunc(faux);

		// Normalizo la zona horaria para poder coger la fecha, que depende de
		// la zona horaria
		f1.setTimeZone(faux.getTimeZone());

		faux.set(Calendar.DAY_OF_MONTH, f1.get(Calendar.DAY_OF_MONTH));
		faux.set(Calendar.MONTH, f1.get(Calendar.MONTH));
		faux.set(Calendar.YEAR, f1.get(Calendar.YEAR));

		return faux;
	}

	private static Calendar trunc(Calendar date) {

		Calendar dateTrunc = (Calendar) date.clone();

		dateTrunc.clear(Calendar.HOUR_OF_DAY);
		dateTrunc.clear(Calendar.HOUR);
		dateTrunc.clear(Calendar.MINUTE);
		dateTrunc.clear(Calendar.SECOND);
		dateTrunc.clear(Calendar.MILLISECOND);

		return dateTrunc;
	}

	public static String toString(Calendar date) {

		String fechaString;

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss-SSS");

		fechaString = dateFormat.format(date.getTime());

		return fechaString;

	}
}
