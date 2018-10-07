package org.jlobato.gpro.setup;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author JLOBATO
 *
 */
public class PracticeLapUI {
	/**
	 *
	 */
	private ArrayList<JComponent> components;

	private boolean visible;
	private JPanel setupPanel;
	private int row;
	private GridBagConstraints constraints;
	private PracticeLap practiceLap;

	private JTextField lapTime;
	private JTextField driverMistake;
	private JTextField netTime;
	private JTextField frontWing;
	private JTextField rearWing;
	private JTextField engine;
	private JTextField brakes;
	private JTextField gearbox;
	private JTextField suspension;
	private JLabel lapNumber;

	private JRadioButton comms;

	/**
	 *
	 * @param components
	 */
	public PracticeLapUI(JPanel setupPanel, boolean visible, int row, GridBagConstraints constraints) {
		this.setupPanel = setupPanel;
		this.visible = visible;
		this.row = row;
		this.constraints = constraints;

		buildUI(this.setupPanel, this.visible, this.row, this.constraints);
	}

	/**
	 * @param setupPanel
	 * @param visible
	 * @param row
	 * @param constraints
	 */
	private void buildUI(JPanel setupPanel, boolean visible, int row,
			GridBagConstraints constraints) {
		lapNumber = new JLabel("" + row);

		Dimension d25 = new Dimension(35, 20);
		Dimension d52 = new Dimension(62, 20);
		Dimension d35 = new Dimension(45, 20);

		int col = 0;

		lapTime = new JTextField();
		constraints.gridy = row;
		constraints.gridx = col++;
		setupPanel.add(lapNumber, constraints);

		constraints.gridx = col++;
		lapTime.setPreferredSize(d52);
		setupPanel.add(lapTime, constraints);

		driverMistake = new JTextField();
		constraints.gridx = col++;
		driverMistake.setPreferredSize(d35);
		setupPanel.add(driverMistake, constraints);

		netTime = new JTextField();
		constraints.gridx = col++;
		netTime.setPreferredSize(d52);
		setupPanel.add(netTime, constraints);

		frontWing = new JTextField();
		constraints.gridx = col++;
		frontWing.setPreferredSize(d25);
		setupPanel.add(frontWing, constraints);

		rearWing = new JTextField();
		constraints.gridx = col++;
		rearWing.setPreferredSize(d25);
		setupPanel.add(rearWing, constraints);

		engine = new JTextField();
		constraints.gridx = col++;
		engine.setPreferredSize(d25);
		setupPanel.add(engine, constraints);

		brakes = new JTextField();
		constraints.gridx = col++;
		brakes.setPreferredSize(d25);
		setupPanel.add(brakes, constraints);

		gearbox = new JTextField();
		constraints.gridx = col++;
		gearbox.setPreferredSize(d25);
		setupPanel.add(gearbox, constraints);

		suspension = new JTextField();
		constraints.gridx = col++;
		suspension.setPreferredSize(d25);
		setupPanel.add(suspension, constraints);

		comms = new JRadioButton();
		comms.setActionCommand("COMMS_" + row);
		constraints.gridx = col++;
		setupPanel.add(comms, constraints);

		brakes.setVisible(visible);
		driverMistake.setVisible(visible);
		engine.setVisible(visible);
		frontWing.setVisible(visible);
		gearbox.setVisible(visible);
		lapNumber.setVisible(visible);
		lapTime.setVisible(visible);
		netTime.setVisible(visible);
		rearWing.setVisible(visible);
		suspension.setVisible(visible);
		comms.setVisible(visible);

		this.components = new ArrayList<JComponent>(10);
		components.add(brakes);
		components.add(driverMistake);
		components.add(engine);
		components.add(frontWing);
		components.add(gearbox);
		components.add(lapNumber);
		components.add(lapTime);
		components.add(netTime);
		components.add(rearWing);
		components.add(suspension);
		components.add(comms);
	}

	/**
	 *
	 * @param visible
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
		Iterator<JComponent> iComponents = this.components.iterator();
		while (iComponents.hasNext()) {
			JComponent theComponent = (JComponent)iComponents.next();
			theComponent.setVisible(visible);
		}
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	public void setPracticeLap(PracticeLap practiceLap) {
		this.practiceLap = practiceLap;

		//Cambiamos los textos a los valores del practice lap
		getLapTime().setText(practiceLap.getLapTime().getLapTime());
		getDriverMistake().setText(practiceLap.getLapTime().getDriverMistake());
		getNetTime().setText(practiceLap.getLapTime().getNetTime());

		getFrontWing().setText(practiceLap.getSetup().getFrontWing().toString());
		getRearWing().setText(practiceLap.getSetup().getRearWing().toString());
		getEngine().setText(practiceLap.getSetup().getEngine().toString());
		getBrakes().setText(practiceLap.getSetup().getBrakes().toString());
		getGearbox().setText(practiceLap.getSetup().getGearbox().toString());
		getSuspension().setText(practiceLap.getSetup().getSuspension().toString());

		//Ponemos todos los componentes a visible
		setVisible(true);
	}

	public PracticeLap getPracticeLap() {
		return this.practiceLap;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the components
	 */
	public ArrayList<JComponent> getComponents() {
		return components;
	}

	/**
	 * @return the setupPanel
	 */
	public JPanel getSetupPanel() {
		return setupPanel;
	}

	/**
	 * @return the constraints
	 */
	public GridBagConstraints getConstraints() {
		return constraints;
	}

	/**
	 * @return the lapTime
	 */
	public JTextField getLapTime() {
		return lapTime;
	}

	/**
	 * @return the driverMistake
	 */
	public JTextField getDriverMistake() {
		return driverMistake;
	}

	/**
	 * @return the netTime
	 */
	public JTextField getNetTime() {
		return netTime;
	}

	/**
	 * @return the frontWing
	 */
	public JTextField getFrontWing() {
		return frontWing;
	}

	/**
	 * @return the rearWing
	 */
	public JTextField getRearWing() {
		return rearWing;
	}

	/**
	 * @return the engine
	 */
	public JTextField getEngine() {
		return engine;
	}

	/**
	 * @return the brakes
	 */
	public JTextField getBrakes() {
		return brakes;
	}

	/**
	 * @return the gearbox
	 */
	public JTextField getGearbox() {
		return gearbox;
	}

	/**
	 * @return the suspension
	 */
	public JTextField getSuspension() {
		return suspension;
	}

	/**
	 * @return the comms
	 */
	public JRadioButton getComms() {
		return comms;
	}

	/**
	 * @return the lapNumber
	 */
	public JLabel getLapNumber() {
		return lapNumber;
	}

	/**
	 *
	 */
	public void clear() {
		getLapTime().setText("");
		getDriverMistake().setText("");
		getNetTime().setText("");
		getBrakes().setText("");
		getFrontWing().setText("");
		getRearWing().setText("");
		getEngine().setText("");
		getGearbox().setText("");
		getSuspension().setText("");
	}

}
