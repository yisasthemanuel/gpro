package org.jlobato.gpro.user;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author JLOBATO
 *
 */
public class Usuario implements IUsuario {

	private String name;

	private IContextoUsuario contextoUsuario;

	/**
	 * 
	 */
	private PropertyChangeSupport support;
	

	/**
	 *
	 */
	private static final long serialVersionUID = -2663822927738814911L;

	/**
	 *
	 */
	public Usuario() {
		this("", new ContextoUsuario());
		((ContextoUsuario)getContextoUsuario()).setUsuario(this);
	}

	/**
	 *
	 * @param name
	 */
	public Usuario(String name, IContextoUsuario contextoUsuario) {
		this.name = name;
		this.contextoUsuario = contextoUsuario;
		this.support = new PropertyChangeSupport(this);
	}

	/**
	 *
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		if (support != null) {
			support.firePropertyChange(USERNAME_PROPERTY, oldValue, name);
		}
	}

	/**
	 *
	 */
	public IContextoUsuario getContextoUsuario() {
		return this.contextoUsuario;
	}

	/**
	 * @param contextoUsuario the contextoUsuario to set
	 */
	public void setContextoUsuario(IContextoUsuario contextoUsuario) {
		this.contextoUsuario = contextoUsuario;
		//TODO hay que eliminar todos los listeners que tuviera de antes y añadirles los que tiene este
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		if (support == null) {
			support = new PropertyChangeSupport(this);
		}
		support.addPropertyChangeListener(listener);
		
		if (getContextoUsuario() != null) {
			getContextoUsuario().addPropertyChangeListener(listener);
		}
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		if (support != null) {
			support.removePropertyChangeListener(listener);
		}
		if (getContextoUsuario() != null) {
			getContextoUsuario().removePropertyChangeListener(listener);
		}
	}
}
