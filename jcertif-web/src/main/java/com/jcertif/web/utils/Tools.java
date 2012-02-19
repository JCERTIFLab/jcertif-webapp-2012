/**
 * Created on [19 févr. 2012 04:52:57]
 */
package com.jcertif.web.utils;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Olivier MBIELEU
 * 
 */
public class Tools {

	private static final Logger logger = LoggerFactory.getLogger(Tools.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean isEmptyOrNull(Object object) {
		logger.trace("Enter isEmptyOrNull(Object " + object + ")");
		boolean bResult = false;
		if (object == null) bResult = true;
		if (object instanceof String) {
			if (((String) object).length() == 0) bResult = true;
		}
		if (object instanceof List) {
			if (((List<Object>) object).isEmpty()) bResult = true;
		}
		if (object instanceof Map) {
			if (((Map) object).isEmpty()) bResult = true;
		}
		logger.trace("Exit isEmptyOrNull(Object)");
		return bResult;
	}

	public static String getBlankIfNull(String value) {
		if (value == null) {
			return "";
		}
		return value;
	}

	@SuppressWarnings("rawtypes")
	public static List<?> getEmptyIfNull(List<?> liste) {
		if (liste == null) {
			return new ArrayList();
		}
		return liste;
	}

	@SuppressWarnings("rawtypes")
	public static Map<?, ?> getEmptyIfNull(Map<?, ?> map) {
		if (map == null) {
			return new HashMap();
		}
		return map;
	}

	public static boolean isNull(Object object) {
		return object == null;
	}

	private static String getPrintableDate() {
		logger.trace("Enter getPrintableDate()");
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		df = DateFormat
				.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM);
		logger.trace("Exit getPrintableDate()");
		return "" + df.format(new Date());
	}

	public static void println(String sComment, String strToPrint) {
		logger.trace("Enter println(String " + sComment + ", String "
				+ strToPrint + ")");
		System.out.print(getPrintableDate());
		if (!isEmptyOrNull(sComment)) System.out.print(" " + sComment);
		if (!isEmptyOrNull(strToPrint)) System.out.print(" " + strToPrint);
		System.out.println();
		logger.trace("Exit println(String, String)");
	}

	public static void println(String strToPrint) {
		logger.trace("Enter println(String " + strToPrint + ")");
		println("", strToPrint);
		logger.trace("Exit println(String)");
	}

	@SuppressWarnings("rawtypes")
	public static void println(String sComment, List listToPrint) {
		logger.trace("Enter println(String " + sComment + ", List "
				+ listToPrint + ")");
		System.out.print(getPrintableDate());
		if (!isEmptyOrNull(sComment)) System.out.print(" " + sComment);
		if (!isEmptyOrNull(listToPrint)) {
			System.out.println();
			System.out.println(" List Size : " + listToPrint.size());
			for (Object object : listToPrint) {
				System.out.println("	" + object);
			}
		} else
			System.out.println();
		logger.trace("Exit println(String, List)");
	}

	@SuppressWarnings("rawtypes")
	public static void println(List listToPrint) {
		logger.trace("Enter println(List " + listToPrint + ")");
		println("", listToPrint);
		logger.trace("Exit println(List)");
	}

	@SuppressWarnings("rawtypes")
	public static void println(String sComment, Map mapToPrint) {
		logger.trace("Enter println(String " + sComment + ", Map " + mapToPrint
				+ ")");
		System.out.print(getPrintableDate());
		if (!isEmptyOrNull(sComment)) System.out.print(" " + sComment);
		if (!isEmptyOrNull(mapToPrint)) {
			System.out.println();
			System.out.println(" Map Size : " + mapToPrint.size());
			Iterator it = mapToPrint.keySet().iterator();
			while (it.hasNext()) {
				Object object = it.next();
				System.out.println("	" + (String) object + " : "
						+ mapToPrint.get(object));
			}

		} else
			System.out.println();
		logger.trace("Exit println(String, Map)");
	}

	@SuppressWarnings("rawtypes")
	public static void println(Map mapToPrint) {
		logger.trace("Enter println(Map " + mapToPrint + ")");
		println("", mapToPrint);
		logger.trace("Exit println(Map )");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String[] split(String chaine, String separator) {
		logger.trace("Enter split(String " + chaine + ", String " + separator
				+ ")");
		if (chaine != null) {
			Vector vector = new Vector(0);
			if (separator != null) {
				boolean finished = false;
				String currentChaine = chaine;

				while (!finished) {
					int pos = currentChaine.indexOf(separator);
					if (pos == 0) {
						// start with separator
						vector.add("");
						currentChaine = currentChaine.substring(
								separator.length(), currentChaine.length());
					} else if (pos == -1) {
						// last field
						vector.add(currentChaine);
						currentChaine = "";
						finished = true;
					} else {
						// classic case
						vector.add(currentChaine.substring(0, pos));
						currentChaine = currentChaine.substring(
								pos + separator.length(),
								currentChaine.length());
					}
				}
			} else {
				vector.add(chaine);
			}
			logger.trace("Exit split(String , String )");
			return (String[]) vector.toArray(new String[vector.size()]);
		} else {
			logger.trace("Exit split(String , String )");
			return null;
		}
	}

}
