package org.jlobato.gpro.user;

import java.beans.PropertyChangeListener;
import java.io.Serializable;

/**
 *
 * @author JLOBATO
 *
 */
public interface IUsuario extends Serializable {
	
	public static final String USERNAME_PROPERTY = "name";
	public static final String LOGIN_PROPERTY = "username";
	public static final String PASSWORD_PROPERTY = "password";

	/**
	 *
	 * @return
	 */
	public String getName();

	/**
	 *
	 * @return
	 */
	public IContextoUsuario getContextoUsuario();
	
	/**
	 * 
	 * @param listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener);
	
	/**
	 * 
	 * @param listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener);

}
