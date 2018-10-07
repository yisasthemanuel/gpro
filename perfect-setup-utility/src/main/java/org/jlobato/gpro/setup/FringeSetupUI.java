package org.jlobato.gpro.setup;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FringeSetupUI {
	private static final String HIGH_LABEL = "HIGH";
	private static final String LOW_LABEL = "LOW";
	/**
	 *
	 */
	private CarFringe carFringe;
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

	private JLabel frontWingLabelMax;
	private JLabel rearWingLabelMax;
	private JLabel engineLabelMax;
	private JLabel brakesLabelMax;
	private JLabel gearboxLabelMax;
	private JLabel suspensionLabelMax;

	private JLabel frontWingLabelMin;
	private JLabel rearWingLabelMin;
	private JLabel engineLabelMin;
	private JLabel brakesLabelMin;
	private JLabel gearboxLabelMin;
	private JLabel suspensionLabelMin;

	private JLabel frontWingLabelLim;
	private JLabel rearWingLabelLim;
	private JLabel engineLabelLim;
	private JLabel brakesLabelLim;
	private JLabel gearboxLabelLim;
	private JLabel suspensionLabelLim;

	/**
	 *
	 * @param setupPanel
	 * @param visible
	 * @param row
	 * @param constraints
	 */
	public FringeSetupUI(JPanel setupPanel, boolean visible, int row, GridBagConstraints constraints) {
		this.setupPanel = setupPanel;
		this.visible = visible;
		this.row = row;
		this.constraints = constraints;

		buildUI(this.setupPanel, this.visible, this.row, this.constraints);
	}

	/**
	 *
	 * @param setupPanel
	 * @param visible
	 * @param row
	 * @param constraints
	 */
	private void buildUI(JPanel setupPanel, boolean visible, int row, GridBagConstraints constraints) {
		constraints.gridx = 0;
		constraints.gridy = constraints.gridy + 1;
		constraints.gridwidth = 3;
		constraints.gridheight = 3;
		constraints.fill = GridBagConstraints.NONE;
		int oldAnchor = constraints.anchor;
		constraints.anchor = GridBagConstraints.EAST;

		JLabel label = new JLabel("FRINGES");
		setupPanel.add(label, constraints);

		constraints.anchor = oldAnchor;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.gridx = 3;
		constraints.fill = GridBagConstraints.BOTH;
		setupPanel.add(new JLabel("MAX:"), constraints);

		constraints.gridx = 4;
		constraints.gridwidth = 1;
		constraints.fill = GridBagConstraints.NONE;
		setupPanel.add(frontWingLabelMax = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(rearWingLabelMax = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(engineLabelMax = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(brakesLabelMax = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(gearboxLabelMax = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(suspensionLabelMax = new JLabel(), constraints);



		constraints.gridy = constraints.gridy + 1;
		constraints.gridx = 3;
		constraints.fill = GridBagConstraints.BOTH;
		setupPanel.add(new JLabel("MIN:"), constraints);

		constraints.gridx = 4;
		constraints.gridwidth = 1;
		constraints.fill = GridBagConstraints.NONE;
		setupPanel.add(frontWingLabelMin = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(rearWingLabelMin = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(engineLabelMin = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(brakesLabelMin = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(gearboxLabelMin = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(suspensionLabelMin = new JLabel(), constraints);

		constraints.gridy = constraints.gridy + 1;
		constraints.gridx = 3;
		constraints.fill = GridBagConstraints.BOTH;
		setupPanel.add(new JLabel("LIM:"), constraints);


		constraints.gridx = 4;
		constraints.gridwidth = 1;
		constraints.fill = GridBagConstraints.NONE;
		setupPanel.add(frontWingLabelLim = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(rearWingLabelLim = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(engineLabelLim = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(brakesLabelLim = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(gearboxLabelLim = new JLabel(), constraints);

		constraints.gridx = constraints.gridx + 1;
		setupPanel.add(suspensionLabelLim = new JLabel(), constraints);
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
	 * @return the carSetup
	 */
	public CarFringe getCarFringe() {
		return carFringe;
	}

	/**
	 * @param carSetup the carSetup to set
	 */
	public void setCarFringe(CarFringe carFringe) {
		this.carFringe = carFringe;

//		updateFrontWingFringe(this.carFringe.getWingsFringe());
//		updateRearWingFringe(this.carFringe.getWingsFringe());
//
//		updateEngineFringe(this.carFringe.getEngineFringe());
//		updateBrakesFringe(this.carFringe.getBrakesFringe());
//
//		updateGearboxFringe(this.carFringe.getGearboxFringe());
		

		if (this.carFringe != null) {
			updateCarPartFringe(this.carFringe.getWingsFringe(), getFrontWingLabelMax(), getFrontWingLabelMin(), getFrontWingLabelLim());
			updateCarPartFringe(this.carFringe.getWingsFringe(), getRearWingLabelMax(), getRearWingLabelMin(), getRearWingLabelLim());
	
			updateCarPartFringe(this.carFringe.getEngineFringe(), getEngineLabelMax(), getEngineLabelMin(), getEngineLabelLim());
			updateCarPartFringe(this.carFringe.getBrakesFringe(), getBrakesLabelMax(), getBrakesLabelMin(), getBrakesLabelLim());
	
			updateCarPartFringe(this.carFringe.getGearboxFringe(), getGearboxLabelMax(), getGearboxLabelMin(), getGearboxLabelLim());
			updateCarPartFringe(this.carFringe.getSuspensionFringe(), getSuspensionLabelMax(), getSuspensionLabelMin(), getSuspensionLabelLim());
		}
	}

	/**
	 *
	 * @param suspensionFringe
	 */
	private void updateCarPartFringe(Fringe suspensionFringe, JLabel maxLabel, JLabel minLabel, JLabel limLabel) {
		maxLabel.setText(suspensionFringe.getMaximum() != null ? suspensionFringe.getMaximum().toString() : "");
		minLabel.setText(suspensionFringe.getMinimum() != null ? suspensionFringe.getMinimum().toString() : "");
		if (suspensionFringe.getMaximum() != null && suspensionFringe.getMinimum() != null) {
			Integer signum = suspensionFringe.getSignum();
			limLabel.setText((signum != null) ? ((signum.intValue() > 0) ? LOW_LABEL : HIGH_LABEL) : LOW_LABEL);
		}
		else {
			limLabel.setText("");
		}
	}

	/**
	 * @return the frontWingLabelMax
	 */
	public JLabel getFrontWingLabelMax() {
		return frontWingLabelMax;
	}

	/**
	 * @param frontWingLabelMax the frontWingLabelMax to set
	 */
	public void setFrontWingLabelMax(JLabel frontWingLabelMax) {
		this.frontWingLabelMax = frontWingLabelMax;
	}

	/**
	 * @return the rearWingLabelMax
	 */
	public JLabel getRearWingLabelMax() {
		return rearWingLabelMax;
	}

	/**
	 * @param rearWingLabelMax the rearWingLabelMax to set
	 */
	public void setRearWingLabelMax(JLabel rearWingLabelMax) {
		this.rearWingLabelMax = rearWingLabelMax;
	}

	/**
	 * @return the engineLabelMax
	 */
	public JLabel getEngineLabelMax() {
		return engineLabelMax;
	}

	/**
	 * @param engineLabelMax the engineLabelMax to set
	 */
	public void setEngineLabelMax(JLabel engineLabelMax) {
		this.engineLabelMax = engineLabelMax;
	}

	/**
	 * @return the brakesLabelMax
	 */
	public JLabel getBrakesLabelMax() {
		return brakesLabelMax;
	}

	/**
	 * @param brakesLabelMax the brakesLabelMax to set
	 */
	public void setBrakesLabelMax(JLabel brakesLabelMax) {
		this.brakesLabelMax = brakesLabelMax;
	}

	/**
	 * @return the gearboxLabelMax
	 */
	public JLabel getGearboxLabelMax() {
		return gearboxLabelMax;
	}

	/**
	 * @param gearboxLabelMax the gearboxLabelMax to set
	 */
	public void setGearboxLabelMax(JLabel gearboxLabelMax) {
		this.gearboxLabelMax = gearboxLabelMax;
	}

	/**
	 * @return the suspensionLabelMax
	 */
	public JLabel getSuspensionLabelMax() {
		return suspensionLabelMax;
	}

	/**
	 * @param suspensionLabelMax the suspensionLabelMax to set
	 */
	public void setSuspensionLabelMax(JLabel suspensionLabelMax) {
		this.suspensionLabelMax = suspensionLabelMax;
	}

	/**
	 * @return the frontWingLabelMin
	 */
	public JLabel getFrontWingLabelMin() {
		return frontWingLabelMin;
	}

	/**
	 * @param frontWingLabelMin the frontWingLabelMin to set
	 */
	public void setFrontWingLabelMin(JLabel frontWingLabelMin) {
		this.frontWingLabelMin = frontWingLabelMin;
	}

	/**
	 * @return the rearWingLabelMin
	 */
	public JLabel getRearWingLabelMin() {
		return rearWingLabelMin;
	}

	/**
	 * @param rearWingLabelMin the rearWingLabelMin to set
	 */
	public void setRearWingLabelMin(JLabel rearWingLabelMin) {
		this.rearWingLabelMin = rearWingLabelMin;
	}

	/**
	 * @return the engineLabelMin
	 */
	public JLabel getEngineLabelMin() {
		return engineLabelMin;
	}

	/**
	 * @param engineLabelMin the engineLabelMin to set
	 */
	public void setEngineLabelMin(JLabel engineLabelMin) {
		this.engineLabelMin = engineLabelMin;
	}

	/**
	 * @return the brakesLabelMin
	 */
	public JLabel getBrakesLabelMin() {
		return brakesLabelMin;
	}

	/**
	 * @param brakesLabelMin the brakesLabelMin to set
	 */
	public void setBrakesLabelMin(JLabel brakesLabelMin) {
		this.brakesLabelMin = brakesLabelMin;
	}

	/**
	 * @return the gearboxLabelMin
	 */
	public JLabel getGearboxLabelMin() {
		return gearboxLabelMin;
	}

	/**
	 * @param gearboxLabelMin the gearboxLabelMin to set
	 */
	public void setGearboxLabelMin(JLabel gearboxLabelMin) {
		this.gearboxLabelMin = gearboxLabelMin;
	}

	/**
	 * @return the suspensionLabelMin
	 */
	public JLabel getSuspensionLabelMin() {
		return suspensionLabelMin;
	}

	/**
	 * @param suspensionLabelMin the suspensionLabelMin to set
	 */
	public void setSuspensionLabelMin(JLabel suspensionLabelMin) {
		this.suspensionLabelMin = suspensionLabelMin;
	}

	/**
	 * @return the frontWingLabelLim
	 */
	public JLabel getFrontWingLabelLim() {
		return frontWingLabelLim;
	}

	/**
	 * @param frontWingLabelLim the frontWingLabelLim to set
	 */
	public void setFrontWingLabelLim(JLabel frontWingLabelLim) {
		this.frontWingLabelLim = frontWingLabelLim;
	}

	/**
	 * @return the rearWingLabelLim
	 */
	public JLabel getRearWingLabelLim() {
		return rearWingLabelLim;
	}

	/**
	 * @param rearWingLabelLim the rearWingLabelLim to set
	 */
	public void setRearWingLabelLim(JLabel rearWingLabelLim) {
		this.rearWingLabelLim = rearWingLabelLim;
	}

	/**
	 * @return the engineLabelLim
	 */
	public JLabel getEngineLabelLim() {
		return engineLabelLim;
	}

	/**
	 * @param engineLabelLim the engineLabelLim to set
	 */
	public void setEngineLabelLim(JLabel engineLabelLim) {
		this.engineLabelLim = engineLabelLim;
	}

	/**
	 * @return the brakesLabelLim
	 */
	public JLabel getBrakesLabelLim() {
		return brakesLabelLim;
	}

	/**
	 * @param brakesLabelLim the brakesLabelLim to set
	 */
	public void setBrakesLabelLim(JLabel brakesLabelLim) {
		this.brakesLabelLim = brakesLabelLim;
	}

	/**
	 * @return the gearboxLabelLim
	 */
	public JLabel getGearboxLabelLim() {
		return gearboxLabelLim;
	}

	/**
	 * @param gearboxLabelLim the gearboxLabelLim to set
	 */
	public void setGearboxLabelLim(JLabel gearboxLabelLim) {
		this.gearboxLabelLim = gearboxLabelLim;
	}

	/**
	 * @return the suspensionLabelLim
	 */
	public JLabel getSuspensionLabelLim() {
		return suspensionLabelLim;
	}

	/**
	 * @param suspensionLabelLim the suspensionLabelLim to set
	 */
	public void setSuspensionLabelLim(JLabel suspensionLabelLim) {
		this.suspensionLabelLim = suspensionLabelLim;
	}


}
