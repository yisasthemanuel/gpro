package org.jlobato.gpro.setup;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class PracticeSessionUI extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = -8946108033248771682L;
	/**
	 *
	 */
	private GridBagConstraints constraints;

	/**
	 *
	 */
	private PracticeSession practiceSession;

	/**
	 *
	 */
	private HashMap<Integer, PracticeLapUI> practiceLapsUI;

	/**
	 *
	 */
	private JButton nextSetupButton;

	/**
	 *
	 */
	private JTextArea driverCommentsReceived;
	/**
	 *
	 */
	//private JButton perfectSetupButton;
	/**
	 *
	 */
	private JButton clearPracticeButton;

	/**
	 *
	 */
	private ButtonGroup commsButtonGroup;
	/**
	 *
	 */
	private PerfectSetupUI perfectSetupUI;
	
	/**
	 * 
	 */
	private PerfectSetupUI q2Setup;
	
	/**
	 * 
	 */
	private PerfectSetupUI raceSetup;

	/**
	 *
	 */
	private FringeSetupUI fringeSetupUI;

	/**
	 *
	 */
	public PracticeSessionUI() {
		super(new GridBagLayout());
		this.constraints = new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 1, 1);
		this.practiceLapsUI = new HashMap<Integer, PracticeLapUI>();
		createSetupHeader(this, this.constraints);
		this.commsButtonGroup = new ButtonGroup();
		int i = 1;
		for (; i <= PracticeSession.MAX_PRACTICE_RUNS; i++) {
			PracticeLapUI current;
			Integer currentRow = new Integer(i);
			this.practiceLapsUI.put(currentRow, current = createSetupPracticeLapUI(this, this.constraints, currentRow, currentRow.intValue() == 1));
			this.commsButtonGroup.add(current.getComms());
		}
		//Vista para el perfect setup
		perfectSetupUI = createPerfectSetupUI(this, this.constraints, ++i, "Perfect SETUP (Q1):");
		createFringeSetupUI(this, this.constraints, ++i);
		
		q2Setup = createPerfectSetupUI(this, this.constraints, ++i, "Perfect SETUP (Q2):");
		raceSetup = createPerfectSetupUI(this, this.constraints, ++i, "Perfect SETUP (RACE):");
		
		createAuxUI(this, this.constraints, ++i);
	}

	/**
	 * @param setupPanel
	 * @param constraints
	 */
	private void createSetupHeader(JPanel setupPanel,
			GridBagConstraints constraints) {
		JLabel labelLap = new JLabel("Lap");
		JLabel labelLapTime = new JLabel("Lap time");
		setupPanel.add(labelLap, constraints);
		constraints.gridx = 1;
		setupPanel.add(labelLapTime, constraints);

		JLabel labelDM = new JLabel("Driver mistake");
		constraints.gridx = 2;
		setupPanel.add(labelDM, constraints);

		JLabel labelNettime = new JLabel("Net time");
		constraints.gridx = 3;
		setupPanel.add(labelNettime, constraints);

		JLabel labelFW = new JLabel("FWing");
		constraints.gridx = 4;
		setupPanel.add(labelFW, constraints);

		JLabel labelRW = new JLabel("RWing");
		constraints.gridx = 5;
		setupPanel.add(labelRW, constraints);

		JLabel labelEngine = new JLabel("Engine");
		constraints.gridx = 6;
		setupPanel.add(labelEngine, constraints);

		JLabel labelBrakes = new JLabel("Brakes");
		constraints.gridx = 7;
		setupPanel.add(labelBrakes, constraints);

		JLabel labelGear = new JLabel("Gear");
		constraints.gridx = 8;
		setupPanel.add(labelGear, constraints);

		JLabel labelSuspension = new JLabel("Suspension");
		constraints.gridx = 9;
		setupPanel.add(labelSuspension, constraints);

		JLabel labelComms = new JLabel("Comms");
		constraints.gridx = 10;
		setupPanel.add(labelComms, constraints);
	}

	/**
	 *
	 * @param setupPanel
	 * @param constraints
	 * @param row
	 * @param visible
	 * @return
	 */
	private PracticeLapUI createSetupPracticeLapUI(JPanel setupPanel, GridBagConstraints constraints, Integer row, boolean visible) {
		return new PracticeLapUI(setupPanel, visible, row.intValue(), constraints);
	}

	/**
	 *
	 * @param setupPanel
	 * @param constraints
	 * @param row
	 */
	private PerfectSetupUI createPerfectSetupUI(JPanel setupPanel, GridBagConstraints constraints, int row, String label) {
		//Separador
		constraints.gridx = 0;
		constraints.gridy = constraints.gridy + 1;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		setupPanel.add(new JSeparator(SwingConstants.HORIZONTAL), constraints);

		return createSetupUI(setupPanel, true, row, constraints, label);
	}

	private void createFringeSetupUI(JPanel setupPanel, GridBagConstraints constraints, int row) {
		//Separador
		constraints.gridx = 0;
		constraints.gridy = constraints.gridy + 1;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		setupPanel.add(new JSeparator(SwingConstants.HORIZONTAL), constraints);

		createFringeSetupUI(setupPanel, true, row, constraints);
	}

	private void createFringeSetupUI(JPanel setupPanel, boolean visible, int row, GridBagConstraints constraints) {
		fringeSetupUI = new FringeSetupUI(setupPanel, visible, row, constraints);
	}


	private PerfectSetupUI createSetupUI(JPanel setupPanel, boolean visible, int row, GridBagConstraints constraints, String label) {
		//perfectSetupUI = new PerfectSetupUI(setupPanel, visible, row, constraints, label);
		return new PerfectSetupUI(setupPanel, visible, row, constraints, label);
	}

	/**
	 *
	 * @param setupPanel
	 * @param constraints
	 * @param row
	 */
	private void createAuxUI(JPanel setupPanel, GridBagConstraints constraints, int row) {
		//Separador
		constraints.gridx = 0;
		constraints.gridy = constraints.gridy + 1;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		setupPanel.add(new JSeparator(SwingConstants.HORIZONTAL), constraints);


		driverCommentsReceived = new JPopupTextArea();
		driverCommentsReceived.setPreferredSize(new Dimension(700, 180));
		constraints.gridy = constraints.gridy + 1;
		constraints.gridx = 0;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridheight = GridBagConstraints.RELATIVE;
		setupPanel.add(new JScrollPane(driverCommentsReceived), constraints);

		JPanel auxPanel = new JPanel();
		constraints.gridy = constraints.gridy + 1;
		constraints.gridx = 0;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.weighty = 0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridheight = 1;
		//setupPanel.add(nextSetupButton, constraints);
		setupPanel.add(auxPanel, constraints);

		nextSetupButton = new JButton("Next setup");
		nextSetupButton.setActionCommand("NEXT");
		//perfectSetupButton = new JButton("Perfect setup!");
		//perfectSetupButton.setActionCommand("PERFECT");
		clearPracticeButton = new JButton("Clear practice");
		clearPracticeButton.setActionCommand("CLEAR");

		auxPanel.add(nextSetupButton);
		//auxPanel.add(perfectSetupButton);
		auxPanel.add(clearPracticeButton);
	}

	/**
	 *
	 * @param practiceSession
	 */
	public void setModel(PracticeSession practiceSession) {
		this.practiceSession = practiceSession;

		//Primero habría que eliminar todos los listeners que hubiera

		//Pongo todos los practice lap ui a no visible excepto el primero
		Iterator<Entry<Integer, PracticeLapUI>> practiceLapsUIIterator = practiceLapsUI.entrySet().iterator();
		Integer uno = new Integer(1);
		PracticeLapUI ui = null;
		while(practiceLapsUIIterator.hasNext()) {
			Map.Entry entry = practiceLapsUIIterator.next();
			ui = (PracticeLapUI)entry.getValue();
			ui.clear();
			if (!entry.getKey().equals(uno)) {
				ui.setVisible(false);
			}
		}
		//Ahora recorro las practice lap del practice session
		Iterator<PracticeLap> practiceLaps = practiceSession.getPracticeLaps().iterator();
		PracticeLap lap = null;
		while(practiceLaps.hasNext()) {
			lap = practiceLaps.next();
			PracticeLapUI lapUI = practiceLapsUI.get(lap.getLapNumber());
			lapUI.setPracticeLap(lap);
		}
		//Ahora actualizo los perfect setups
		getPerfectSetupUI().setCarSetup(practiceSession.getPerfectSetup());
		getFringeSetupUI().setCarFringe(practiceSession.getCarFringe());
		getQ2SetupUI().setCarSetup(practiceSession.getQ2Setup());
		getRaceSetupUI().setCarSetup(practiceSession.getRaceSetup());

		//Vamos a la última practice lap ui y hacemos click en el botón
		ui = getPracticeLapUI(new Integer(practiceSession.getPracticeLaps().size()));
		if (ui == null) {
			ui = getPracticeLapUI(new Integer(1));
		}
		ui.getComms().doClick();

		//Se limpia el campo de introducción de comentarios
		this.driverCommentsReceived.setText("");
		this.nextSetupButton.setEnabled(false);
	}

	/**
	 *
	 * @return
	 */
	public PracticeSession getModel() {
		return this.practiceSession;
	}

	/**
	 * @return the nextSetupButton
	 */
	public JButton getNextSetupButton() {
		return nextSetupButton;
	}

	/**
	 * @return the driverCommentsReceived
	 */
	public JTextArea getDriverCommentsReceived() {
		return driverCommentsReceived;
	}

	public PracticeLapUI getPracticeLapUI(Integer lapNumber) {
		return practiceLapsUI.get(lapNumber);
	}

	/**
	 * @return the clearPracticeButton
	 */
	public JButton getClearPracticeButton() {
		return clearPracticeButton;
	}

	/**
	 *
	 * @return
	 */
	public ButtonGroup getCommsButtonGroup() {
		return commsButtonGroup;
	}

	/**
	 * @return the perfectSetupUI
	 */
	public PerfectSetupUI getPerfectSetupUI() {
		return perfectSetupUI;
	}

	/**
	 * @return the fringeSetupUI
	 */
	public FringeSetupUI getFringeSetupUI() {
		return fringeSetupUI;
	}
	
	/**
	 * 
	 * @return the q2 setup
	 */
	public PerfectSetupUI getQ2SetupUI() {
		return q2Setup;
	}
	
	/**
	 * 
	 * @return the race setup
	 */
	public PerfectSetupUI getRaceSetupUI() {
		return raceSetup;
	}

	/**
	 * @param fringeSetupUI the fringeSetupUI to set
	 */
	public void setFringeSetupUI(FringeSetupUI fringeSetupUI) {
		this.fringeSetupUI = fringeSetupUI;
	}
}
