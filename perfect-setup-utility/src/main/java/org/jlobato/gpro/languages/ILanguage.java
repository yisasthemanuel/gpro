package org.jlobato.gpro.languages;

import java.io.Serializable;
import java.util.Locale;

import javax.swing.Icon;

public interface ILanguage extends Cloneable, Serializable, Comparable<ILanguage> {

	/**
	 * Clave identificativa del idioma
	 * @return
	 */
	public String getKey();

	/**
	 * Token identificativo del idioma dentro de la web de GPRO
	 * @return
	 */
	public String getToken();

	/**
	 * Locale asociado al idioma
	 * @return
	 */
	public Locale getLocale();
	
	/**
	 * Icono asociado al idioma
	 * @return
	 */
	public Icon getIcon();

	/**
	 * Texto descriptivo del idioma
	 * @return
	 */
	public String getDescription();

}
