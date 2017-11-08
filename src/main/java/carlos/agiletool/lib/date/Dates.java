package carlos.agiletool.lib.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dates {

	public static int contarD�asHabilesEntreFechas(Calendar fecInicio, Calendar fecFin) {

		if (fecInicio == null || fecFin == null)
			return 0;

		Calendar fechaInicioAux = (Calendar) fecInicio.clone();
		Calendar fecFinAux = (Calendar) fecFin.clone();

		// Antes de comparar las fechas, igualo las zonas horarias
		fechaInicioAux.setTimeZone(Calendar.getInstance().getTimeZone());
		fechaInicioAux.getTimeInMillis();
		fecFinAux.setTimeZone(Calendar.getInstance().getTimeZone());
		fecFinAux.getTimeInMillis();

		int days = 0;

		while (Dates.antes(fechaInicioAux, fecFin)) {

			// Si no es sabado ni domingo, cuento el d�a
			if (!esFinDeSemana(fechaInicioAux)) {
				days++;
			}

			fechaInicioAux.add(Calendar.DAY_OF_MONTH, 1);
		}

		return days;

	}

	/**
	 * Calcula la fecha fin en funcion de los d�as h�biles que han pasado desde
	 * la fechaInicio, sumando un n�mero de dias. Si la fechaInicio es fin de
	 * semana, devuelve el primer dia habil posterior. Tiene en cuenta que el
	 * d�a de la fechaInicio cuenta como d�a h�bil
	 * 
	 * @param fecInicio
	 * @param numDias
	 * @return
	 */
	public static Calendar calcularFechaFin(Calendar fecInicio, int numDias) {

		if (fecInicio == null)
			return null;

		Calendar fecFin = (Calendar) fecInicio.clone();

		while (numDias > 1 || esFinDeSemana(fecFin)) {

			// Si no es sabado ni domingo, cuento el d�a avanzado
			if (!esFinDeSemana(fecFin)) {
				numDias--;
			}

			fecFin.add(Calendar.DAY_OF_MONTH, 1);

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

	/**
	 * True su fec1Aux < f2, false si fec1Aux >= f2
	 * 
	 * @param fec1Aux
	 * @param fec2Aux
	 * @return
	 */
	public static Boolean antes(Calendar fec1, Calendar fec2) {
		Boolean antes;

		Calendar fec1Aux = (Calendar) fec1.clone();
		Calendar fec2Aux = (Calendar) fec2.clone();

		// Antes de comparar las fechas, igualo las zonas horarias
		fec1Aux.setTimeZone(Calendar.getInstance().getTimeZone());
		fec1Aux.getTimeInMillis();

		fec2Aux.setTimeZone(Calendar.getInstance().getTimeZone());
		fec2Aux.getTimeInMillis();

		// A�O MENOR
		if (fec1Aux.get(Calendar.YEAR) < fec2Aux.get(Calendar.YEAR)) {
			antes = true;
		}
		// A�O MAYOR
		else if (fec1Aux.get(Calendar.YEAR) > fec2Aux.get(Calendar.YEAR)) {
			antes = false;
			// A�OS IGUALES //MES MENOR
		} else if (fec1Aux.get(Calendar.MONTH) < fec2Aux.get(Calendar.MONTH)) {
			antes = true;
			// A�OS IGUALES //MES MAYOR
		} else if (fec1Aux.get(Calendar.MONTH) > fec2Aux.get(Calendar.MONTH)) {
			antes = false;
			// A�OS IGUALES //MES IGUALES //DIA MENOR
		} else if (fec1Aux.get(Calendar.DAY_OF_MONTH) < fec2Aux.get(Calendar.DAY_OF_MONTH)) {
			antes = true;
			// A�OS IGUALES //MES IGUALES //DIA MENOR
		} else if (fec1Aux.get(Calendar.DAY_OF_MONTH) > fec2Aux.get(Calendar.DAY_OF_MONTH)) {
			antes = false;
			// A�OS IGUALES //MES IGUALES //DIA IGUALES
		} else {
			antes = false;
		}

		return antes;
	}

	public static String toString(Calendar date) {

		String fechaString;

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss-SSS");

		fechaString = dateFormat.format(date.getTime());

		return fechaString;

	}
}
