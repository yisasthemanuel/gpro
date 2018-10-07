package org.jlobato.gpro.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.IntrospectionException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyDescriptor;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import org.jlobato.gpro.languages.ILanguage;


public class UsuarioUIController implements PropertyChangeListener, ActionListener {
	
	private UsuarioUI userUI;
	
	private PropertyLock userNameLock = new PropertyLock();
	private PropertyLock usernameLock = new PropertyLock();
	private PropertyLock passwordLock = new PropertyLock();
	
	public UsuarioUIController(UsuarioUI userUI) {
		this.setUsuarioUI(userUI);
	}
	
	public void setUsuarioUI(UsuarioUI userUI) {
		this.userUI = userUI;
		
		this.userUI.getUserNameField().getDocument().addDocumentListener(new UsuarioUIControllerInnerDocumentListener(userUI.getModel(), IUsuario.USERNAME_PROPERTY, userNameLock, false));
		this.userUI.getUsernameField().getDocument().addDocumentListener(new UsuarioUIControllerInnerDocumentListener(userUI.getModel().getContextoUsuario(), IUsuario.LOGIN_PROPERTY, usernameLock, false));
		this.userUI.getPasswordField().getDocument().addDocumentListener(new UsuarioUIControllerInnerDocumentListener(userUI.getModel().getContextoUsuario(), IUsuario.PASSWORD_PROPERTY, passwordLock, false));
		this.userUI.getLanguageCombo().addActionListener(this);
		
	}
	
	private class UsuarioUIControllerInnerDocumentListener implements DocumentListener {

		private Object source;
		private String property;
		private PropertyDescriptor descriptor;
		private PropertyLock lock;
		private boolean convertToInteger;

		/**
		 *
		 * @param source
		 * @param property
		 * @param lock
		 */
		public UsuarioUIControllerInnerDocumentListener(Object source, String property, PropertyLock lock) {
			this(source, property, lock, true);
		}

		/**
		 * 
		 * @param source
		 * @param property
		 * @param lock
		 * @param convertToInteger
		 */
		public UsuarioUIControllerInnerDocumentListener(Object source, String property, PropertyLock lock, boolean convertToInteger) {
			this.source = source;
			this.property = property;
			this.lock = lock;
			this.convertToInteger = convertToInteger;
			try {
				this.descriptor = new PropertyDescriptor(this.property, source.getClass());
			} catch (IntrospectionException e) {
				e.printStackTrace();
				this.descriptor = null;
			}
		}

		/**
		 *
		 */
		public void changedUpdate(DocumentEvent e) {
			doTextUpdate(e);
		}

		/**
		 *
		 */
		public void insertUpdate(DocumentEvent e) {
			doTextUpdate(e);
		}

		/**
		 *
		 */
		public void removeUpdate(DocumentEvent e) {
			doTextUpdate(e);
		}

		/**
		 * @param e
		 */
		private void doTextUpdate(DocumentEvent e) {
			synchronized (lock) {
				if (!lock.isValue()) {
					lock.setValue(true);
					try {
						Object theNewValue = (convertToInteger) ? getIntegerValue(e) : (Object)getString(e);
						if (this.descriptor != null) {
							this.descriptor.getWriteMethod().invoke(this.source, new Object [] {theNewValue});
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						lock.setValue(false);
					}
				}
			}
		}

		private String getString(DocumentEvent e) throws BadLocationException {
			String newValue = e.getDocument().getText(0, e.getDocument().getLength());
			return newValue;
		}

		/**
		 * @param e
		 * @return
		 * @throws BadLocationException
		 */
		private Integer getIntegerValue(DocumentEvent e) throws BadLocationException {
			String newValue = e.getDocument().getText(0, e.getDocument().getLength());
			if (newValue != null && newValue.equals("")) {
				newValue = "0";
			}
			Integer theNewValue = new Integer(newValue);
			return theNewValue;
		}

	}
	
	
	private class PropertyLock {
		/**
		 *
		 */
		private boolean value;
		/**
		 *
		 */
		public PropertyLock() {
			this(false);
		}

		/**
		 *
		 * @param value
		 */
		public PropertyLock(boolean value) {
			this.value = value;
		}

		/**
		 * @return the value
		 */
		public boolean isValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(boolean value) {
			this.value = value;
		}
	}


	/**
	 * 
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(IUsuario.USERNAME_PROPERTY)) {
			IUsuario user = (IUsuario)evt.getSource();
			updateTextField(userUI.getUserNameField(), user.getName(), this.userNameLock);
		}
		else if (evt.getPropertyName().equals(IUsuario.LOGIN_PROPERTY)) {
			IContextoUsuario contextoUsuario = (IContextoUsuario)evt.getSource();
			updateTextField(userUI.getUsernameField(), contextoUsuario.getUsername(), this.usernameLock);
		}
		else if (evt.getPropertyName().equals(IUsuario.LOGIN_PROPERTY)) {
			IContextoUsuario contextoUsuario = (IContextoUsuario)evt.getSource();
			updateTextField(userUI.getPasswordField(), contextoUsuario.getPassword(), this.passwordLock);
		}
	}
	
	/**
	 * 
	 * @param textField
	 * @param newValue
	 * @param lock
	 */
	private void updateTextField(JTextField textField, String newValue, PropertyLock lock) {
		synchronized(lock) {
			if (!lock.isValue()) {
				textField.setText(newValue);
				lock.setValue(false);
			}
		}
	}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		JComboBox combo = (JComboBox)e.getSource();
		this.userUI.getModel().getContextoUsuario().setLanguage((ILanguage)combo.getSelectedItem());
	}
	

}
