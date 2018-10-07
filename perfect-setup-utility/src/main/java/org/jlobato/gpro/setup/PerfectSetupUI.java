package org.jlobato.gpro.setup;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author JLOBATO
 *
 */
public class PerfectSetupUI {

	/**
	 *
	 */
	private CarSetup carSetup;
	/**
	 *
	 */
	private JPanel setupPanel;
	/**
	 *
	 */
	private boolean visible;
	/**
	 *
	 */
	private int row;
	/**
	 *
	 */
	private GridBagConstraints constraints;
	/**
	 * 
	 */
	private String label;
	
	private JLabel frontWingLabel;
	private JLabel rearWingLabel;
	private JLabel engineLabel;
	private JLabel brakesLabel;
	private JLabel gearboxLabel;
	private JLabel suspensionLabel;
	

	/**
	 *
	 * @param setupPanel
	 * @param visible
	 * @param row
	 * @param constraints
	 */
	public PerfectSetupUI(JPanel setupPanel, boolean visible, int row, GridBagConstraints constraints, String label) {
		this.setupPanel = setupPanel;
		this.visible = visible;
		this.row = row;
		this.constraints = constraints;
		this.label = label;

		buildUI(this.setupPanel, this.visible, this.row, this.constraints, this.label);
	}

	/**
	 *
	 * @param setupPanel
	 * @param visible
	 * @param row
	 * @param constraints
	 */
	private void buildUI(JPanel setupPanel, boolean visible, int row, GridBagConstraints constraints, String label) {
		constraints.gridx = 0;
		constraints.gridy = constraints.gridy + 1;
		constraints.gridwidth = 4;
		constraints.fill = GridBagConstraints.NONE;
		//setupPanel.add(new JLabel("Perfect SETUP (Q1):"), constraints);
		setupPanel.add(new JLabel(label), constraints);

		constraints.gridx = 4;
		constraints.gridwidth = 1;
		constraints.fill = GridBagConstraints.NONE;
		setupPanel.add(frontWingLabel = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(rearWingLabel = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(engineLabel = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(brakesLabel = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(gearboxLabel = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(suspensionLabel = new JLabel(), constraints);
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return the setupPanel
	 */
	public JPanel getSetupPanel() {
		return setupPanel;
	}

	/**
	 * @return the frontWingLabel
	 */
	public JLabel getFrontWingLabel() {
		return frontWingLabel;
	}

	/**
	 * @return the rearWingLabel
	 */
	public JLabel getRearWingLabel() {
		return rearWingLabel;
	}

	/**
	 * @return the engineLabel
	 */
	public JLabel getEngineLabel() {
		return engineLabel;
	}

	/**
	 * @return the brakesLabel
	 */
	public JLabel getBrakesLabel() {
		return brakesLabel;
	}

	/**
	 * @return the gearboxLabel
	 */
	public JLabel getGearboxLabel() {
		return gearboxLabel;
	}

	/**
	 * @return the suspensionLabel
	 */
	public JLabel getSuspensionLabel() {
		return suspensionLabel;
	}

	/**
	 * @return the carSetup
	 */
	public CarSetup getCarSetup() {
		return carSetup;
	}

	/**
	 * @param carSetup the carSetup to set
	 */
	public void setCarSetup(CarSetup carSetup) {
		this.carSetup = carSetup;
		
		boolean carSetupIsNotNull = carSetup != null;

		//Cambiamos los textos a los valores del practice lap
		updateLabel(getFrontWingLabel(), carSetupIsNotNull ? carSetup.getFrontWing() : null);
		updateLabel(getRearWingLabel(), carSetupIsNotNull ? carSetup.getRearWing() : null);
		updateLabel(getEngineLabel(), carSetupIsNotNull ? carSetup.getEngine() : null);
		updateLabel(getBrakesLabel(), carSetupIsNotNull ? carSetup.getBrakes() : null);
		updateLabel(getGearboxLabel(), carSetupIsNotNull ? carSetup.getGearbox() : null);
		updateLabel(getSuspensionLabel(), carSetupIsNotNull ? carSetup.getSuspension() : null);
//		getFrontWingLabel().setText((carSetup.getFrontWing() != null) ? carSetup.getFrontWing().toString() : "");
//		getRearWingLabel().setText((carSetup.getRearWing() != null) ? carSetup.getRearWing().toString() : "");
//		getEngineLabel().setText(carSetup.getEngine().toString());
//		getBrakesLabel().setText(carSetup.getBrakes().toString());
//		getGearboxLabel().setText(carSetup.getGearbox().toString());
//		getSuspensionLabel().setText(carSetup.getSuspension().toString());

	}

	private void updateLabel(JLabel label, Object value) {
		label.setText(value != null ? value.toString() : "");
	}

}
