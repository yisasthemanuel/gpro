package org.jlobato.gpro.languages;

import java.util.Locale;

import javax.swing.Icon;

public class DefaultLanguage implements ILanguage {

	/**
	 * Clave identificativa de este idioma
	 */
	private String key;

	/**
	 * Token con el que se le identifica en GPRO
	 */
	private String token;

	/**
	 * Locale Java correspondiente a este idioma
	 */
	private Locale locale;

	/**
	 * 
	 */
	private String description;

	/**
	 * 
	 */
	private Icon icon;

	/**
	 * serial uid
	 */
	private static final long serialVersionUID = 6545878090853385003L;

	/**
	 * Constructor por defecto
	 */
	public DefaultLanguage() {
		this(null, null, null, null, null);
	}

	/**
	 * 
	 * @param key
	 * @param token
	 * @param description
	 * @param locale
	 * @param icon
	 */
	public DefaultLanguage(String key, String token, String description, Locale locale, Icon icon) {
		this.key = key;
		this.token = token;
		this.locale = locale;
		this.description = description;
		this.icon = icon;
	}

	/**
	 *
	 * @param key
	 * @param token
	 */
	public DefaultLanguage(String key, String token) {
		this(key, token, null, null, null);
	}

	/**
	 *
	 */
	public String getKey() {
		return key;
	}

	/**
	 *
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 *
	 */
	public String getToken() {
		return token;
	}

	/**
	 *
	 */
	public int compareTo(ILanguage o) {
		return 0;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 *
	 */
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 *
	 */
	public String toString() {
		return "[key=" + getKey() + ";token=" + getToken() + ";locale=" + getLocale() + "]";
	}

	/**
	 *
	 */
	public int hashCode() {
		int result = 0;
		if (getKey() != null) {
			result = getKey().hashCode();
		}
		return result;
	}

	/**
	 * 
	 */
	public boolean equals(Object obj) {
		ILanguage other = (ILanguage)obj;
		return this.getKey().equals(other.getKey());
	}

	/**
	 * 
	 */
	public Icon getIcon() {
		return icon;
	}

	/**
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @param icon
	 */
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	
}
