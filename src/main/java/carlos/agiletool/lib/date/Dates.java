package carlos.agiletool.lib.date;

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
	 * la fechaInicio, sumando un número de dias. Si la fechaInicio es fin de
	 * semana, devuelve el primer dia habil posterior. Tiene en cuenta que el
	 * día de la fechaInicio cuenta como día hábil
	 * 
	 * @param fecInicio
	 * @param numDias
	 * @return
	 */
	public static Calendar calcularFechaFin(Calendar fecInicio, int numDias) {

		if (fecInicio == null)
			return null;

		Calendar fecFin = (Calendar) fecInicio.clone();

		// Si es fin de semana sumo un día, porque el día de hoy no puede contar
		// como día hábil
		if (esFinDeSemana(fecFin))
			numDias++;

		while (numDias > 1 || esFinDeSemana(fecFin)) {

			fecFin.add(Calendar.DAY_OF_MONTH, 1);

			// Si no es sabado ni domingo, cuento el día avanzado
			if (!esFinDeSemana(fecFin)) {
				numDias--;
			}

		}
		return fecFin;
	}

	public static Boolean esFinDeSemana(Calendar fecha) {

		if (fecha.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || fecha.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean iguales(Calendar fecha1, Calendar fecha2) {

		Boolean diaIgual, mesIgual, anioIgual;

		diaIgual = (fecha1.get(Calendar.DAY_OF_MONTH) == fecha2.get(Calendar.DAY_OF_MONTH)) ? true : false;
		mesIgual = (fecha1.get(Calendar.MONTH) == fecha2.get(Calendar.MONTH)) ? true : false;
		anioIgual = (fecha1.get(Calendar.YEAR) == fecha2.get(Calendar.YEAR)) ? true : false;

		return diaIgual && mesIgual && anioIgual;
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

		dateTrunc.set(Calendar.HOUR_OF_DAY, 0);
		dateTrunc.set(Calendar.HOUR, 0);
		dateTrunc.set(Calendar.MINUTE, 0);
		dateTrunc.set(Calendar.SECOND, 0);
		dateTrunc.set(Calendar.MILLISECOND, 0);

		return dateTrunc;
	}

	public static String toString(Calendar date) {

		String fechaString;

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss-SSS");

		fechaString = dateFormat.format(date.getTime());

		return fechaString;

	}
}
