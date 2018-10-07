package org.jlobato.gpro.driver;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JLOBATO
 *
 */
public class DriverUI extends JPanel {

	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = -5795311890234369243L;
	private IDriver driver;
	private JTextField nameField;
	private JTextField nationalityField;
	private JTextField concentrationField;
	private JTextField talentField;
	private JTextField aggressivenessField;
	private JTextField experienceField;
	private JTextField techInsightField;
	private JTextField staminaField;
	private JTextField charismaField;
	private JTextField motivationField;
	private JTextField reputationField;
	private JTextField weightField;
	private JTextField ageField;
	private JLabel overallLabel;
	private JLabel setupLabel;

	/**
	 *
	 */
	public DriverUI() {
		buildUI();
	}

	/**
	 *
	 */
	private void buildUI() {
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 1, 1);

		//Overall
		add(new JLabel("Overall:"), constraints);
		constraints.weightx = 1;
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(overallLabel = new JLabel(), constraints);
		constraints.weightx = 0;
		constraints.gridy = 1;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("Name:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(nameField = new JTextField(), constraints);
		constraints.gridy = 2;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("Nationality:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(nationalityField = new JTextField(), constraints);
		constraints.gridy = 3;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Nationality
		add(new JLabel("Concentration:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(concentrationField = new JTextField(), constraints);
		constraints.gridy = 4;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("Talent:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(talentField = new JTextField(), constraints);
		constraints.gridy = 5;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("Aggressiveness:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(aggressivenessField = new JTextField(), constraints);
		constraints.gridy = 6;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("Experience:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(experienceField = new JTextField(), constraints);
		constraints.gridy = 7;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("Technical Insight:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(techInsightField = new JTextField(), constraints);
		constraints.gridy = 8;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("Stamina:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(staminaField = new JTextField(), constraints);
		constraints.gridy = 9;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("Charisma:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(charismaField = new JTextField(), constraints);
		constraints.gridy = 10;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("Motivation:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(motivationField = new JTextField(), constraints);
		constraints.gridy = 11;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("Reputation:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(reputationField = new JTextField(), constraints);
		constraints.gridy = 12;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("Weight:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(weightField = new JTextField(), constraints);
		constraints.gridy = 13;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("Age:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(ageField = new JTextField(), constraints);
		constraints.gridy = 14;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Overall
//		constraints.fill = GridBagConstraints.NONE;
//		constraints.weighty = 1.0;
//		constraints.anchor = GridBagConstraints.NORTHWEST;
		add(new JLabel("Setup Range:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(setupLabel = new JLabel(), constraints);

		constraints.gridy = 15;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 1.0;
		constraints.gridwidth = 2;
		add(new JPanel(), constraints);

		setModel(null);

	}

	/**
	 *
	 * @param driver
	 */
	public void setModel(IDriver driver) {
		this.driver = (driver == null) ? new Driver() : driver;

		this.nameField.setText(this.driver.getName());
		this.nationalityField.setText(this.driver.getNationality());
		this.concentrationField.setText(Integer.toString(this.driver.getConcentration()));
		this.talentField.setText(Integer.toString(this.driver.getTalent()));
		this.aggressivenessField.setText(Integer.toString(this.driver.getAggressiveness()));
		this.experienceField.setText(Integer.toString(this.driver.getExperience()));
		this.techInsightField.setText(Integer.toString(this.driver.getTechInsight()));
		this.staminaField.setText(Integer.toString(this.driver.getStamina()));
		this.charismaField.setText(Integer.toString(this.driver.getCharisma()));
		this.motivationField.setText(Integer.toString(this.driver.getMotivation()));
		this.reputationField.setText(Integer.toString(this.driver.getReputation()));
		this.weightField.setText(Integer.toString(this.driver.getWeight()));
		this.ageField.setText(Integer.toString(this.driver.getAge()));
		this.overallLabel.setText(Integer.toString(this.driver.getOverall()));
		this.setupLabel.setText(Integer.toString(this.driver.getSetupRange()));
	}

	/**
	 * @return the driver
	 */
	public IDriver getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(IDriver driver) {
		setModel(driver);
	}

	/**
	 * @return the nameField
	 */
	public JTextField getNameField() {
		return nameField;
	}

	/**
	 * @param nameField the nameField to set
	 */
	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	/**
	 * @return the nationalityField
	 */
	public JTextField getNationalityField() {
		return nationalityField;
	}

	/**
	 * @param nationalityField the nationalityField to set
	 */
	public void setNationalityField(JTextField nationalityField) {
		this.nationalityField = nationalityField;
	}

	/**
	 * @return the concentrationField
	 */
	public JTextField getConcentrationField() {
		return concentrationField;
	}

	/**
	 * @param concentrationField the concentrationField to set
	 */
	public void setConcentrationField(JTextField concentrationField) {
		this.concentrationField = concentrationField;
	}

	/**
	 * @return the talentField
	 */
	public JTextField getTalentField() {
		return talentField;
	}

	/**
	 * @param talentField the talentField to set
	 */
	public void setTalentField(JTextField talentField) {
		this.talentField = talentField;
	}

	/**
	 * @return the aggressivenessField
	 */
	public JTextField getAggressivenessField() {
		return aggressivenessField;
	}

	/**
	 * @param aggressivenessField the aggressivenessField to set
	 */
	public void setAggressivenessField(JTextField aggressivenessField) {
		this.aggressivenessField = aggressivenessField;
	}

	/**
	 * @return the experienceField
	 */
	public JTextField getExperienceField() {
		return experienceField;
	}

	/**
	 * @param experienceField the experienceField to set
	 */
	public void setExperienceField(JTextField experienceField) {
		this.experienceField = experienceField;
	}

	/**
	 * @return the techInsightField
	 */
	public JTextField getTechInsightField() {
		return techInsightField;
	}

	/**
	 * @param techInsightField the techInsightField to set
	 */
	public void setTechInsightField(JTextField techInsightField) {
		this.techInsightField = techInsightField;
	}

	/**
	 * @return the staminaField
	 */
	public JTextField getStaminaField() {
		return staminaField;
	}

	/**
	 * @param staminaField the staminaField to set
	 */
	public void setStaminaField(JTextField staminaField) {
		this.staminaField = staminaField;
	}

	/**
	 * @return the charismaField
	 */
	public JTextField getCharismaField() {
		return charismaField;
	}

	/**
	 * @param charismaField the charismaField to set
	 */
	public void setCharismaField(JTextField charismaField) {
		this.charismaField = charismaField;
	}

	/**
	 * @return the motivationField
	 */
	public JTextField getMotivationField() {
		return motivationField;
	}

	/**
	 * @param motivationField the motivationField to set
	 */
	public void setMotivationField(JTextField motivationField) {
		this.motivationField = motivationField;
	}

	/**
	 * @return the reputationField
	 */
	public JTextField getReputationField() {
		return reputationField;
	}

	/**
	 * @param reputationField the reputationField to set
	 */
	public void setReputationField(JTextField reputationField) {
		this.reputationField = reputationField;
	}

	/**
	 * @return the weightField
	 */
	public JTextField getWeightField() {
		return weightField;
	}

	/**
	 * @param weightField the weightField to set
	 */
	public void setWeightField(JTextField weightField) {
		this.weightField = weightField;
	}

	/**
	 * @return the ageField
	 */
	public JTextField getAgeField() {
		return ageField;
	}

	/**
	 * @param ageField the ageField to set
	 */
	public void setAgeField(JTextField ageField) {
		this.ageField = ageField;
	}

	/**
	 * @return the overallLabel
	 */
	public JLabel getOverallLabel() {
		return overallLabel;
	}

	/**
	 * @param overallLabel the overallLabel to set
	 */
	public void setOverallLabel(JLabel overallLabel) {
		this.overallLabel = overallLabel;
	}

	/**
	 * @return the setupLabel
	 */
	public JLabel getSetupLabel() {
		return setupLabel;
	}

	/**
	 * @param setupLabel the setupLabel to set
	 */
	public void setSetupLabel(JLabel setupLabel) {
		this.setupLabel = setupLabel;
	}

}
