package org.jlobato.gpro.utils;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

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

	/**
	 * 
	 * @param numero
	 * @param decimales
	 * @return
	 */
	public static double redondeo(double numero, int decimales) {
		double result = 0.0;
		try {
			String valor = Double.toString(numero);
			BigDecimal big = new BigDecimal(valor);
			big = big.setScale(decimales, RoundingMode.HALF_UP);
			result = big.doubleValue();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 * @param linkUrl
	 * @return
	 */
	public static String getIDManagerFromLink(String linkUrl) {
		String result = "";
		int index = linkUrl.indexOf("IDM") + "IDM".length() + 1;
		result = linkUrl.substring(index, linkUrl.length());
		return result;
	}
	
	public static String getCategoryCode(String group) {
		String result = "";
		int index = group.indexOf("-");
		result = (index >= 0) ? group.substring(0, index) : group.equals("Ret") ? "-" : "E"; //En el caso de que no hay guión, siempre es Elite		
		return result;
	}
	
	/**
	 * 
	 * @param group
	 * @return
	 */
	public static String getGroupId(String group) {
		String result = null;
		
		int index = group.indexOf("-");
		if (index > 0) result = group.substring(index + 1, group.length());
		
		return result;
	}
	
	/**
	 * 
	 * @param value
	 * @param clazz
	 * @return
	 */
	public static <T> T castIfNotNull(Object value, Class<T>clazz) {
		T result = null;
		if (value != null) {
			try {
				result = clazz.getConstructor(value.getClass()).newInstance(value);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	public static String getTyreBrandCode(String url) {
		Optional<String> result = Optional.ofNullable(url);
		if (result.isPresent()) {
			if (result.get().contains("avonn")) return "AV";
			else if (result.get().contains("pipirelli")) return "PI";
			else if (result.get().contains("dunnolop")) return "DU";
			else if (result.get().contains("yokomama")) return "YO";
			else if (result.get().contains("hancock")) return "HA";
			else if (result.get().contains("michelini")) return "MI";
			else if (result.get().contains("contimental")) return "CO";
			else if (result.get().contains("bridgerock")) return "BR";
			else if (result.get().contains("badyear")) return "BY";
			else return null;
		}
		else return null;
	}
	
	
	public static void main(String[] args) {
		//TODO Pasarlo a TEST
		//Test getIDManagerFromLink
		System.out.println("ID Manager: " + getIDManagerFromLink("ManagerProfile.asp?IDM=113612"));
		
		//Test getCategoryCode
		String group = "M-1";
		System.out.println("Category for " + group + " -> " + getCategoryCode(group));
		
		//Test getGroupId
		System.out.println("Group id for " + group + " -> " + getGroupId(group));
		
		group = "Elite";
		System.out.println("Category for " + group + " -> " + getCategoryCode(group));
		
		//Test getGroupId
		System.out.println("Group id for " + group + " -> " + getGroupId(group));
		
	}

}
