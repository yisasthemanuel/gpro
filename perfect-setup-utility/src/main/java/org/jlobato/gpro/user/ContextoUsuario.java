package org.jlobato.gpro.user;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.jlobato.gpro.languages.ILanguage;
import org.jlobato.gpro.languages.LanguageManager;

/**
 *
 * @author JLOBATO
 *
 */
public class ContextoUsuario implements IContextoUsuario {
	
	private IUsuario usuario;

	private ILanguage language;
	private String username;
	private String password;
	
	private PropertyChangeSupport support;
	

	/**
	 *
	 */
	private static final long serialVersionUID = -3404404808892794461L;

	/**
	 *
	 */
	public ContextoUsuario() {
		this(null, "", "", null);
	}

	/**
	 *
	 * @param language
	 * @param password
	 * @param username
	 */
	public ContextoUsuario(IUsuario usuario, String username, String password, ILanguage language) {
		this.usuario = usuario;
		this.language = language == null ? LanguageManager.getInstance().getDefaultLanguage() : language;
		this.password = password;
		this.username = username;
		
		this.support = new PropertyChangeSupport(this);
	}

	/**
	 *
	 */
	public ILanguage getLanguage() {
		return this.language;
	}

	/**
	 *
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 *
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(ILanguage language) {
		this.language = language;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		String oldValue = this.username;
		this.username = username;
		if (support != null) {
			support.firePropertyChange(IUsuario.LOGIN_PROPERTY, oldValue, username);
		}
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		String oldValue = this.password;
		this.password = password;
		if (support != null) {
			support.firePropertyChange(IUsuario.PASSWORD_PROPERTY, oldValue, password);
		}
	}

	/**
	 * 
	 */
	public IUsuario getUsuario() {
		return usuario;
	}

	/**
	 * 
	 * @param usuario
	 */
	public void setUsuario(IUsuario usuario) {
		this.usuario = usuario;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		if (support == null) {
			support = new PropertyChangeSupport(this);
		}
		support.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		if (support != null) {
			support.removePropertyChangeListener(listener);
		}
	}

}
