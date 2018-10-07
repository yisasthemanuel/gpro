package org.jlobato.gpro.user;

import java.beans.PropertyChangeListener;
import java.io.Serializable;

import org.jlobato.gpro.languages.ILanguage;

/**
 *
 * @author JLOBATO
 *
 */
public interface IContextoUsuario extends Serializable {
	/**
	 *
	 * @return
	 */
	public ILanguage getLanguage();

	/**
	 *
	 * @return
	 */
	public String getUsername();

	/**
	 *
	 * @return
	 */
	public String getPassword();
	
	/**
	 * 
	 * @return
	 */
	public IUsuario getUsuario();
	
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

	/**
	 * 
	 * @param selectedItem
	 */
	public void setLanguage(ILanguage selectedItem);
	
}
