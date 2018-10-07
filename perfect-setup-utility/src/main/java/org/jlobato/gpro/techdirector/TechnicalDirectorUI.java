package org.jlobato.gpro.techdirector;

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
public class TechnicalDirectorUI extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 7949038638793281222L;
	/**
	 *
	 */
	private JTextField nameField;
	/**
	 *
	 */
	private JTextField nationalityField;
	/**
	 *
	 */
	private JTextField leadershipField;
	/**
	 *
	 */
	private JTextField mechanicsField;
	/**
	 *
	 */
	private JTextField electronicsField;
	/**
	 *
	 */
	private JTextField aerodynamicsField;
	/**
	 *
	 */
	private JTextField experienceField;
	/**
	 *
	 */
	private JTextField pitCoordinationField;
	/**
	 *
	 */
	private JTextField motivationField;
	/**
	 *
	 */
	private ITechnicalDirector technicalDirector;

	/**
	 *
	 */
	public TechnicalDirectorUI() {
		buildUI();
	}

	/**
	 *
	 */
	private void buildUI() {
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 1, 1);

		//Name
		add(new JLabel("Name:"), constraints);
		constraints.weightx = 1;
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(nameField = new JTextField(), constraints);
		constraints.weightx = 0;
		constraints.gridy = 1;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("Nationality:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(nationalityField = new JTextField(), constraints);
		constraints.gridy = 2;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Nationality
		add(new JLabel("Leadership:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(leadershipField = new JTextField(), constraints);
		constraints.gridy = 3;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("R&D mechanics:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(mechanicsField = new JTextField(), constraints);
		constraints.gridy = 4;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("R&D electronics:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(electronicsField = new JTextField(), constraints);
		constraints.gridy = 5;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("R&D aerodynamics:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(aerodynamicsField = new JTextField(), constraints);
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
		add(new JLabel("Pit coordination:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(pitCoordinationField = new JTextField(), constraints);
		constraints.gridy = 8;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.NONE;

		//Name
		add(new JLabel("Motivation:"), constraints);
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(motivationField = new JTextField(), constraints);

		constraints.gridy = 9;
		constraints.gridx = 0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 1.0;
		constraints.gridwidth = 2;
		add(new JPanel(), constraints);

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
	 * @return the leadershipField
	 */
	public JTextField getLeadershipField() {
		return leadershipField;
	}

	/**
	 * @param leadershipField the leadershipField to set
	 */
	public void setLeadershipField(JTextField leadershipField) {
		this.leadershipField = leadershipField;
	}

	/**
	 * @return the mechanicsField
	 */
	public JTextField getMechanicsField() {
		return mechanicsField;
	}

	/**
	 * @param mechanicsField the mechanicsField to set
	 */
	public void setMechanicsField(JTextField mechanicsField) {
		this.mechanicsField = mechanicsField;
	}

	/**
	 * @return the electronicsField
	 */
	public JTextField getElectronicsField() {
		return electronicsField;
	}

	/**
	 * @param electronicsField the electronicsField to set
	 */
	public void setElectronicsField(JTextField electronicsField) {
		this.electronicsField = electronicsField;
	}

	/**
	 * @return the aerodynamicsField
	 */
	public JTextField getAerodynamicsField() {
		return aerodynamicsField;
	}

	/**
	 * @param aerodynamicsField the aerodynamicsField to set
	 */
	public void setAerodynamicsField(JTextField aerodynamicsField) {
		this.aerodynamicsField = aerodynamicsField;
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
	 * @return the pitCoordinationField
	 */
	public JTextField getPitCoordinationField() {
		return pitCoordinationField;
	}

	/**
	 * @param pitCoordinationField the pitCoordinationField to set
	 */
	public void setPitCoordinationField(JTextField pitCoordinationField) {
		this.pitCoordinationField = pitCoordinationField;
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
	 * @return the technicalDirector
	 */
	public ITechnicalDirector getTechnicalDirector() {
		return technicalDirector;
	}

	/**
	 * @param technicalDirector the technicalDirector to set
	 */
	public void setTechnicalDirector(ITechnicalDirector technicalDirector) {
		this.technicalDirector = technicalDirector;

		if (this.technicalDirector == null) {
			this.nameField.setText("");
			this.nationalityField.setText("");
			this.leadershipField.setText("");
			this.mechanicsField.setText("");
			this.electronicsField.setText("");
			this.aerodynamicsField.setText("");
			this.experienceField.setText("");
			this.pitCoordinationField.setText("");
			this.motivationField.setText("");
		}
		else {
			this.nameField.setText(this.technicalDirector.getName());
			this.nationalityField.setText(this.technicalDirector.getNationality());
			this.leadershipField.setText(Integer.toString(this.technicalDirector.getLeadership()));
			this.mechanicsField.setText(Integer.toString(this.technicalDirector.getMechanics()));
			this.electronicsField.setText(Integer.toString(this.technicalDirector.getElectronics()));
			this.aerodynamicsField.setText(Integer.toString(this.technicalDirector.getAerodynamics()));
			this.experienceField.setText(Integer.toString(this.technicalDirector.getExperience()));
			this.pitCoordinationField.setText(Integer.toString(this.technicalDirector.getPitCoordination()));
			this.motivationField.setText(Integer.toString(this.technicalDirector.getMotivation()));
		}
	}

	/**
	 *
	 * @return
	 */
	public ITechnicalDirector getModel() {
		return getTechnicalDirector();
	}

	/**
	 *
	 * @param techDirector
	 */
	public void setModel(ITechnicalDirector techDirector) {
		setTechnicalDirector(techDirector);
	}

}
