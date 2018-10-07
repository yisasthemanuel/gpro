package org.jlobato.gpro.driver;

import java.beans.IntrospectionException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyDescriptor;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class DriverUIController implements PropertyChangeListener {

	private DriverUI driverUI;

	private PropertyLock experienceLock = new PropertyLock();
	private PropertyLock techInsightLock = new PropertyLock();
	private PropertyLock concentrationLock = new PropertyLock();
	private PropertyLock talentLock = new PropertyLock();
	private PropertyLock aggressivenessLock = new PropertyLock();
	private PropertyLock staminaLock = new PropertyLock();
	private PropertyLock charismaLock = new PropertyLock();
	private PropertyLock motivationLock = new PropertyLock();

	private PropertyLock weightLock = new PropertyLock();

	private PropertyLock nameLock = new PropertyLock();
	private PropertyLock nationalityLock = new PropertyLock();
	private PropertyLock reputationLock = new PropertyLock();
	private PropertyLock ageLock = new PropertyLock();

	public DriverUIController(DriverUI driverUI) {
		this.setDriverUI(driverUI);
	}

	public void setDriverUI(DriverUI driverUI) {
		this.driverUI = driverUI;
		this.driverUI.getExperienceField().getDocument().addDocumentListener(new DriverUIControllerInnerDocumentListener(driverUI.getDriver(), IDriver.EXPERIENCE_PROPERTY, experienceLock));
		this.driverUI.getTechInsightField().getDocument().addDocumentListener(new DriverUIControllerInnerDocumentListener(driverUI.getDriver(), IDriver.TECH_INSIGHT_PROPERTY, techInsightLock));
		this.driverUI.getConcentrationField().getDocument().addDocumentListener(new DriverUIControllerInnerDocumentListener(driverUI.getDriver(), IDriver.CONCENTRATION_PROPERTY, concentrationLock));
		this.driverUI.getTalentField().getDocument().addDocumentListener(new DriverUIControllerInnerDocumentListener(driverUI.getDriver(), IDriver.TALENT_PROPERTY, talentLock));
		this.driverUI.getAggressivenessField().getDocument().addDocumentListener(new DriverUIControllerInnerDocumentListener(driverUI.getDriver(), IDriver.AGGRESSIVENESS_PROPERTY, aggressivenessLock));
		this.driverUI.getStaminaField().getDocument().addDocumentListener(new DriverUIControllerInnerDocumentListener(driverUI.getDriver(), IDriver.STAMINA_PROPERTY, staminaLock));
		this.driverUI.getCharismaField().getDocument().addDocumentListener(new DriverUIControllerInnerDocumentListener(driverUI.getDriver(), IDriver.CHARISMA_PROPERTY, charismaLock));
		this.driverUI.getMotivationField().getDocument().addDocumentListener(new DriverUIControllerInnerDocumentListener(driverUI.getDriver(), IDriver.MOTIVATION_PROPERTY, motivationLock));
		this.driverUI.getWeightField().getDocument().addDocumentListener(new DriverUIControllerInnerDocumentListener(driverUI.getDriver(), IDriver.WEIGHT_PROPERTY, weightLock));
		this.driverUI.getNameField().getDocument().addDocumentListener(new DriverUIControllerInnerDocumentListener(driverUI.getDriver(), IDriver.NAME_PROPERTY, nameLock, false));
		this.driverUI.getNationalityField().getDocument().addDocumentListener(new DriverUIControllerInnerDocumentListener(driverUI.getDriver(), IDriver.NATIONALITY_PROPERTY, nationalityLock, false));
		this.driverUI.getReputationField().getDocument().addDocumentListener(new DriverUIControllerInnerDocumentListener(driverUI.getDriver(), IDriver.REPUTATION_PROPERTY, reputationLock));
		this.driverUI.getAgeField().getDocument().addDocumentListener(new DriverUIControllerInnerDocumentListener(driverUI.getDriver(), IDriver.AGE_PROPERTY, ageLock));
	}

	public DriverUI getDriverUI() {
		return driverUI;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		IDriver source = (IDriver)evt.getSource();
		if (evt.getPropertyName().equals(IDriver.EXPERIENCE_PROPERTY)) {
			updateTextField(driverUI.getExperienceField(), source.getExperience(), this.experienceLock);
			updateSetupRange(source);
			updateOverall(source);
		}
		else if (evt.getPropertyName().equals(IDriver.TECH_INSIGHT_PROPERTY)) {
			updateTextField(driverUI.getTechInsightField(), source.getTechInsight(), this.techInsightLock);
			updateSetupRange(source);
			updateOverall(source);
		}
		else if (evt.getPropertyName().equals(IDriver.CONCENTRATION_PROPERTY)) {
			updateTextField(driverUI.getConcentrationField(), source.getConcentration(), this.concentrationLock);
			updateOverall(source);
		}
		else if (evt.getPropertyName().equals(IDriver.TALENT_PROPERTY)) {
			updateTextField(driverUI.getTalentField(), source.getTalent(), this.talentLock);
			updateOverall(source);
		}
		else if (evt.getPropertyName().equals(IDriver.AGGRESSIVENESS_PROPERTY)) {
			updateTextField(driverUI.getAggressivenessField(), source.getAggressiveness(), this.aggressivenessLock);
			updateOverall(source);
		}
		else if (evt.getPropertyName().equals(IDriver.STAMINA_PROPERTY)) {
			updateTextField(driverUI.getStaminaField(), source.getStamina(), this.staminaLock);
			updateOverall(source);
		}
		else if (evt.getPropertyName().equals(IDriver.CHARISMA_PROPERTY)) {
			updateTextField(driverUI.getCharismaField(), source.getCharisma(), this.charismaLock);
			updateOverall(source);
		}
		else if (evt.getPropertyName().equals(IDriver.MOTIVATION_PROPERTY)) {
			updateTextField(driverUI.getMotivationField(), source.getMotivation(), this.motivationLock);
			updateOverall(source);
		}
		else if (evt.getPropertyName().equals(IDriver.WEIGHT_PROPERTY)) {
			updateTextField(driverUI.getWeightField(), source.getWeight(), this.weightLock);
			updateOverall(source);
		}
		else if (evt.getPropertyName().equals(IDriver.NAME_PROPERTY)) {
			updateTextField(driverUI.getNameField(), source.getName(), this.nameLock);
		}
		else if (evt.getPropertyName().equals(IDriver.NATIONALITY_PROPERTY)) {
			updateTextField(driverUI.getNationalityField(), source.getNationality(), this.nationalityLock);
		}
		else if (evt.getPropertyName().equals(IDriver.REPUTATION_PROPERTY)) {
			updateTextField(driverUI.getReputationField(), source.getReputation(), this.reputationLock);
		}
		else if (evt.getPropertyName().equals(IDriver.AGE_PROPERTY)) {
			updateTextField(driverUI.getAgeField(), source.getAge(), this.ageLock);
		}
	}

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

	/**
	 * @param source
	 */
	private void updateSetupRange(IDriver source) {
		String newSetupChange = Integer.toString(source.getSetupRange());
		driverUI.getSetupLabel().setText(newSetupChange);
	}

	/**
	 * @param source
	 */
	private void updateOverall(IDriver source) {
		String newOverall = Integer.toString(source.getOverall());
		driverUI.getOverallLabel().setText(newOverall);
	}


	private class DriverUIControllerInnerDocumentListener implements DocumentListener {

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
		public DriverUIControllerInnerDocumentListener(Object source, String property, PropertyLock lock) {
			this(source, property, lock, true);
		}

		public DriverUIControllerInnerDocumentListener(Object source, String property, PropertyLock lock, boolean convertToInteger) {
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

	/**
	 *
	 * @author JLOBATO
	 *
	 */
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

}
