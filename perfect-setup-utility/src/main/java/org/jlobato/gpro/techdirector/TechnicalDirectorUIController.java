package org.jlobato.gpro.techdirector;

import java.beans.IntrospectionException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyDescriptor;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;



/**
 *
 * @author JLOBATO
 *
 */
public class TechnicalDirectorUIController implements PropertyChangeListener {

	/**
	 *
	 */
	private TechnicalDirectorUI techDirectorUI;

	private PropertyLock pitCoordinationLock = new PropertyLock();
	private PropertyLock mechanicsLock = new PropertyLock();
	private PropertyLock aerodynamicsLock = new PropertyLock();
	private PropertyLock electronicsLock = new PropertyLock();
	private PropertyLock leadershipLock = new PropertyLock();
	private PropertyLock motivationLock = new PropertyLock();
	private PropertyLock experienceLock = new PropertyLock();

	private PropertyLock nameLock = new PropertyLock();
	private PropertyLock nationalityLock = new PropertyLock();
	//private PropertyLock ageLock = new PropertyLock();

	public TechnicalDirectorUIController(TechnicalDirectorUI techDirectorUI) {
		this.setTechnicalDirectorUI(techDirectorUI);
	}

	public void setTechnicalDirectorUI(TechnicalDirectorUI techDirectorUI) {
		this.techDirectorUI = techDirectorUI;
		this.techDirectorUI.getPitCoordinationField().getDocument().addDocumentListener(new TechnicalDirectorUIUIControllerInnerDocumentListener(techDirectorUI.getTechnicalDirector(), ITechnicalDirector.PITCOORDINATION_PROPERTY, pitCoordinationLock));
		this.techDirectorUI.getMechanicsField().getDocument().addDocumentListener(new TechnicalDirectorUIUIControllerInnerDocumentListener(techDirectorUI.getTechnicalDirector(), ITechnicalDirector.MECHANICS_PROPERTY, mechanicsLock));
		this.techDirectorUI.getAerodynamicsField().getDocument().addDocumentListener(new TechnicalDirectorUIUIControllerInnerDocumentListener(techDirectorUI.getTechnicalDirector(), ITechnicalDirector.AERODYNAMICS_PROPERTY, aerodynamicsLock));
		this.techDirectorUI.getElectronicsField().getDocument().addDocumentListener(new TechnicalDirectorUIUIControllerInnerDocumentListener(techDirectorUI.getTechnicalDirector(), ITechnicalDirector.ELECTRONICS_PROPERTY, electronicsLock));
		this.techDirectorUI.getLeadershipField().getDocument().addDocumentListener(new TechnicalDirectorUIUIControllerInnerDocumentListener(techDirectorUI.getTechnicalDirector(), ITechnicalDirector.LEADERSHIP_PROPERTY, leadershipLock));
		this.techDirectorUI.getExperienceField().getDocument().addDocumentListener(new TechnicalDirectorUIUIControllerInnerDocumentListener(techDirectorUI.getTechnicalDirector(), ITechnicalDirector.EXPERIENCE_PROPERTY, experienceLock));
		this.techDirectorUI.getMotivationField().getDocument().addDocumentListener(new TechnicalDirectorUIUIControllerInnerDocumentListener(techDirectorUI.getTechnicalDirector(), ITechnicalDirector.MOTIVATION_PROPERTY, motivationLock));
		this.techDirectorUI.getNameField().getDocument().addDocumentListener(new TechnicalDirectorUIUIControllerInnerDocumentListener(techDirectorUI.getTechnicalDirector(), ITechnicalDirector.NAME_PROPERTY, nameLock, false));
		this.techDirectorUI.getNationalityField().getDocument().addDocumentListener(new TechnicalDirectorUIUIControllerInnerDocumentListener(techDirectorUI.getTechnicalDirector(), ITechnicalDirector.NATIONALITY_PROPERTY, nationalityLock, false));
		//this.techDirectorUI.getAgeField().getDocument().addDocumentListener(new TechnicalDirectorUIUIControllerInnerDocumentListener(driverUI.getDriver(), IDriver.AGE_PROPERTY, ageLock));
	}

	public TechnicalDirectorUI getTechnicalDirectorUI() {
		return this.techDirectorUI;
	}

	/**
	 *
	 * @param evt
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		ITechnicalDirector source = (ITechnicalDirector)evt.getSource();
		if (evt.getPropertyName().equals(ITechnicalDirector.EXPERIENCE_PROPERTY)) {
			updateTextField(techDirectorUI.getExperienceField(), source.getExperience(), this.experienceLock);
		}
		else if (evt.getPropertyName().equals(ITechnicalDirector.PITCOORDINATION_PROPERTY)) {
			updateTextField(techDirectorUI.getPitCoordinationField(), source.getPitCoordination(), this.pitCoordinationLock);
		}
		else if (evt.getPropertyName().equals(ITechnicalDirector.MECHANICS_PROPERTY)) {
			updateTextField(techDirectorUI.getMechanicsField(), source.getMechanics(), this.mechanicsLock);
		}
		else if (evt.getPropertyName().equals(ITechnicalDirector.AERODYNAMICS_PROPERTY)) {
			updateTextField(techDirectorUI.getAerodynamicsField(), source.getAerodynamics(), this.aerodynamicsLock);
		}
		else if (evt.getPropertyName().equals(ITechnicalDirector.ELECTRONICS_PROPERTY)) {
			updateTextField(techDirectorUI.getElectronicsField(), source.getElectronics(), this.electronicsLock);
		}
		else if (evt.getPropertyName().equals(ITechnicalDirector.LEADERSHIP_PROPERTY)) {
			updateTextField(techDirectorUI.getLeadershipField(), source.getLeadership(), this.leadershipLock);
		}
		else if (evt.getPropertyName().equals(ITechnicalDirector.MOTIVATION_PROPERTY)) {
			updateTextField(techDirectorUI.getMotivationField(), source.getMotivation(), this.motivationLock);
		}
		else if (evt.getPropertyName().equals(ITechnicalDirector.NAME_PROPERTY)) {
			updateTextField(techDirectorUI.getNameField(), source.getName(), this.nameLock);
		}
		else if (evt.getPropertyName().equals(ITechnicalDirector.NATIONALITY_PROPERTY)) {
			updateTextField(techDirectorUI.getNationalityField(), source.getNationality(), this.nationalityLock);
		}
//		else if (evt.getPropertyName().equals(ITechnicalDirector.AGE_PROPERTY)) {
//			updateTextField(driverUI.getAgeField(), source.getAge(), this.ageLock);
//		}
	}

	//TODO Esto hay que refactorizarlo para no repetir código con DriverUIController
	/**
	 *
	 * @param textField
	 * @param newValue
	 * @param lock
	 */
	private void updateTextField(JTextField textField, int newValue, PropertyLock lock) {
		synchronized(lock) {
			if (!lock.isValue()) {
				textField.setText(Integer.toString(newValue));
				lock.setValue(false);
			}
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

	//TODO Esto hay que refactorizarlo para no repetir código con DriverUIController
	private class TechnicalDirectorUIUIControllerInnerDocumentListener implements DocumentListener {

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
		public TechnicalDirectorUIUIControllerInnerDocumentListener(Object source, String property, PropertyLock lock) {
			this(source, property, lock, true);
		}

		public TechnicalDirectorUIUIControllerInnerDocumentListener(Object source, String property, PropertyLock lock, boolean convertToInteger) {
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

	//TODO Esto hay que refactorizarlo para no repetir código con DriverUIController
	private class PropertyLock {
		private boolean value;
		public PropertyLock() {
			this(false);
		}

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

}
