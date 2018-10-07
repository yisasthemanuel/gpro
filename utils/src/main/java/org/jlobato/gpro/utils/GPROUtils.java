package org.jlobato.gpro.utils;

import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

/**
 * 
 * @author jlobato
 *
 */
public class GPROUtils {
	

	/**
	 * 
	 * @param lapTime
	 * @return
	 */
	public static Integer getMiliseconds(String lapTime) {
		Integer result = null;
		String[] milis = lapTime.split("\\.");
		//Si el array no tiene dos elementos es que es nulo
		if (milis.length > 1) {
			String parteEntera = milis[0];
			String parteDecimal = milis[1];
			String[] partesEnteras = parteEntera.split("\\:");
			int acum = Integer.parseInt(parteDecimal);
			int index = 0;
			for (int i = partesEnteras.length - 1; i >= 0; i--) {
				acum += Integer.parseInt(partesEnteras[i]) * TIME_FACTORS[index];
				index++;
			}
			result = new Integer(acum);
		}
		return result;
	}
	
	/**
	 * 
	 * @param lapTime
	 * @return
	 */
	public static Integer getMilis(String lapTime) {
		Integer result = null;
		try {
			PeriodFormatter periodFormat = new PeriodFormatterBuilder().minimumPrintedDigits(2).appendMinutes()
					.appendSeparator(":").minimumPrintedDigits(2).appendSeconds().appendSeparator(".")
					.appendMillis3Digit().toFormatter();
			Period period = Period.parse(lapTime, periodFormat);
			result = new Integer((int) period.toStandardDuration().getMillis());
		} catch (Exception e) {
			// Nos callamos como ...
		}
		return result;
	}
	
	/**
	 * 
	 * @param pitInfo
	 * @return
	 */
	public static Integer getPitNo(String pitInfo) {
		int index1 = pitInfo.indexOf("Stop") + "Stop".length();
		int index2 = pitInfo.indexOf("(");
		String lapNo = excellTrim(pitInfo.substring(index1, index2));
		Integer result = new Integer(lapNo.trim());
		return result;
	}
	
	/**
	 * 
	 * @param excelSting
	 * @return
	 */
	public static String excellTrim(String excelSting) {
		return excelSting.replaceAll("\\u00A0", "");
	}

	/**
	 * 
	 */
	public static int[] TIME_FACTORS = {1000, 60 * 1000, 60 * 60 * 1000};

}
