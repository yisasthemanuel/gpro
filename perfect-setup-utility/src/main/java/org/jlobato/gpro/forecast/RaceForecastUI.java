package org.jlobato.gpro.forecast;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author jlobato
 *
 */
public class RaceForecastUI extends JPanel {

	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = 115157178255760924L;
	private IRaceForecast model;

	private ForecastUI q1UI;
	private ForecastUI q2UI;
	private ArrayList<IntervalForecastUI> raceForecastsUI;
	private JButton grabButton;
	private JLabel estimatedRaceTempLabel;
	
	/**
	 * 
	 */
	private RaceForecastSupport support = new RaceForecastSupport(this);

	/**
	 * 
	 */
	public static final String GRAB_WEATHER_COMMAND = "GRAB-WEATHER";

	/**
	 *
	 */
	public RaceForecastUI() {
		setLayout(new BorderLayout());
		//Botón GRAB
		//TODO SOLO DEBE ESTAR HABILITADO SI HAY DATOS DE CONEXION DEL USUARIO
		grabButton = new JButton("Grab weather");
		grabButton.setActionCommand(GRAB_WEATHER_COMMAND);
		add(grabButton, BorderLayout.NORTH);
		raceForecastsUI = new ArrayList<IntervalForecastUI>();

		//Panel de clima de carrera
		JPanel forecastPanel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 1, 1);

		JPanel q1Panel = new JPanel(new BorderLayout());
		q1Panel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Q1"));
		forecastPanel.add(q1Panel, constraints);
		q1Panel.add(q1UI = new ForecastUI());

		JPanel q2Panel = new JPanel(new BorderLayout());
		q2Panel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Q2"));
		constraints.gridx = 1;
		forecastPanel.add(q2Panel, constraints);
		q2Panel.add(q2UI = new ForecastUI());

		JPanel racePanel = new JPanel(new GridLayout(2, 2));
		racePanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "RACE"));
		IntervalForecastUI intervalForecastUI = null;
		racePanel.add(intervalForecastUI = new IntervalForecastUI(new TitledBorder(new LineBorder(Color.BLACK), "Start - 0:30h")));
		this.raceForecastsUI.add(intervalForecastUI);
		racePanel.add(intervalForecastUI = new IntervalForecastUI(new TitledBorder(new LineBorder(Color.BLACK), "0:30h - 1:00h")));
		this.raceForecastsUI.add(intervalForecastUI);
		racePanel.add(intervalForecastUI = new IntervalForecastUI(new TitledBorder(new LineBorder(Color.BLACK), "1:00h - 1:30h")));
		this.raceForecastsUI.add(intervalForecastUI);
		racePanel.add(intervalForecastUI = new IntervalForecastUI(new TitledBorder(new LineBorder(Color.BLACK), "1:30h - 2:00h")));
		this.raceForecastsUI.add(intervalForecastUI);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.gridwidth = 2;
		forecastPanel.add(racePanel, constraints);

		add(forecastPanel, BorderLayout.CENTER);
		
		//Temperatura estimada de carrera
		JPanel estimatedRaceTempPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		estimatedRaceTempPanel.add(new JLabel("Estimated Race Temperature:"));
		estimatedRaceTempPanel.add(estimatedRaceTempLabel = new JLabel("--"));
		estimatedRaceTempLabel.setForeground(Color.RED);
		//estimatedRaceTempLabel.setFont(estimatedRaceTempLabel.getFont().deriveFont(Font.ITALIC));
		estimatedRaceTempPanel.add(new JLabel(" ºC"));
		add(estimatedRaceTempPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * 
	 * @return
	 */
	JLabel getEstimatedRaceTempLabel() {
		return this.estimatedRaceTempLabel;
	}

	/**
	 *
	 * @param model
	 */
	public void setModel(IRaceForecast model) {
		clear();
		this.model = model;
		support.fireRaceForecastChanged(this.model);
	}

	/**
	 *
	 */
	private void clear() {
		this.q1UI.clear();
		this.q2UI.clear();
		Iterator<IntervalForecastUI> forecastUIs = this.raceForecastsUI.iterator();
		while(forecastUIs.hasNext()) {
			IntervalForecastUI forecastUI = forecastUIs.next();
			forecastUI.clear();
		}
	}



	@Override
	/**
	 *
	 */
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		this.q1UI.setEnabled(enabled);
		this.q2UI.setEnabled(enabled);
		Iterator<IntervalForecastUI> forecastUIs = this.raceForecastsUI.iterator();
		while(forecastUIs.hasNext()) {
			IntervalForecastUI forecastUI = forecastUIs.next();
			forecastUI.setEnabled(enabled);
		}
	}

	/**
	 *
	 * @return
	 */
	public IRaceForecast getModel() {
		return this.model;
	}

	/**
	 * @return the grabButton
	 */
	public JButton getGrabButton() {
		return grabButton;
	}
	
	/**
	 *
	 * @param listener
	 */
	public void addRaceForecastListener(RaceForecastListener listener) {
		support.addRaceForecastListener(listener);
	}

	/**
	 *
	 * @param listener
	 */
	public void removePracticeSessionListener(RaceForecastListener listener) {
		support.removeRaceForecastListener(listener);
	}



	/**
	 *
	 * @author jlobato
	 *
	 */
	public static class ForecastUI extends JPanel {
		/**
		 *
		 */
		private static final long serialVersionUID = -4925913190031128855L;
		private IForecast model;
		private JTextField temperatureField;
		private JTextField humidityField;
		private JComboBox weatherCombo;

		/**
		 *
		 */
		public ForecastUI() {
			super(new GridBagLayout());
			GridBagConstraints constraints = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 1, 1);
			JLabel tempLabel = new JLabel("Temp: ");
			add(tempLabel, constraints);
			this.temperatureField = new JTextField(4);
			constraints.gridx = 1;
			add(this.temperatureField, constraints);
			JLabel degreesLabel = new JLabel(" ºC");
			constraints.gridx = 2;
			constraints.weightx = 1;
			add(degreesLabel, constraints);

			constraints.gridy = 1;
			constraints.gridx = 0;
			constraints.weightx = 0;
			JLabel humiLabel = new JLabel("Humedad: ");
			add(humiLabel, constraints);
			this.humidityField = new JTextField(4);
			constraints.gridx = 1;
			add(this.humidityField, constraints);
			JLabel percertLabel = new JLabel(" %");
			constraints.gridx = 2;
			add(percertLabel, constraints);

			constraints.gridy = 2;
			constraints.gridx = 0;
			JLabel climLabel = new JLabel("Clima: ");
			add(climLabel, constraints);
			//constraints.gridwidth = GridBagConstraints.REMAINDER;
			this.weatherCombo = new JComboBox(new Object[] {" ", "Seco", "Lluvia"});
			constraints.gridx = 1;
			add(this.weatherCombo, constraints);
		}

		/**
		 *
		 * @param forecast
		 */
		public void setModel(IForecast forecast) {
			clear();
			this.model = forecast;
			if (this.model != null) {
				//TODO Hacerlo a través de un evento
				getTemperatureField().setText(String.valueOf(this.model.getTemperature()));
				getHumidityField().setText(String.valueOf(this.model.getHumidity()));
				getWeatherCombo().setSelectedItem((this.model.getWeather() == IRaceForecast.WET_WEATHER) ? "Lluvia" : "Seco");
			}
		}

		/**
		 *
		 */
		public void clear() {
			getTemperatureField().setText("");
			getHumidityField().setText("");
			getWeatherCombo().setSelectedItem(" ");
		}

		/**
		 *
		 * @return
		 */
		public JComboBox getWeatherCombo() {
			return this.weatherCombo;
		}

		/**
		 *
		 * @return
		 */
		public JTextField  getHumidityField() {
			return this.humidityField;
		}

		/**
		 *
		 * @return
		 */
		public JTextField getTemperatureField() {
			return this.temperatureField;
		}

		/**
		 *
		 * @return
		 */
		public IForecast getModel() {
			return this.model;
		}

		@Override
		/**
		 *
		 */
		public void setEnabled(boolean enabled) {
			super.setEnabled(enabled);
			getTemperatureField().setEnabled(enabled);
			getHumidityField().setEnabled(enabled);
			getWeatherCombo().setEnabled(enabled);
		}


	}

	/**
	 *
	 * @author jlobato
	 *
	 */
	public static class IntervalForecastUI extends JPanel {
		/**
		 *
		 */
		private static final long serialVersionUID = -4726957109963347614L;
		private IIntervalForecast model;
		private JTextField startTemperatureField;
		private JTextField endTemperatureField;
		private JTextField startHumidityField;
		private JTextField endHumidityField;
		private JTextField startWeatherField;
		private JTextField endWeatherField;

		/**
		 *
		 */
		public IntervalForecastUI() {
			super(new GridBagLayout());
			GridBagConstraints constraints = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 1, 1);
			JLabel tempLabel = new JLabel("Temp: ");
			add(tempLabel, constraints);
			this.startTemperatureField = new JTextField(4);
			constraints.gridx = 1;
			add(this.startTemperatureField, constraints);
			JLabel degreesLabel = new JLabel("ºC - ");
			constraints.gridx = 2;
			add(degreesLabel, constraints);
			this.endTemperatureField = new JTextField(4);
			constraints.gridx = 3;
			add(this.endTemperatureField, constraints);
			JLabel degrees2Label = new JLabel("ºC");
			constraints.gridx = 4;
			constraints.weightx = 1;
			add(degrees2Label, constraints);


			constraints.gridy = 1;
			constraints.gridx = 0;
			constraints.weightx = 0;
			JLabel humiLabel = new JLabel("Humedad: ");
			add(humiLabel, constraints);
			this.startHumidityField = new JTextField(4);
			constraints.gridx = 1;
			add(this.startHumidityField, constraints);
			JLabel percentLabel = new JLabel("% - ");
			constraints.gridx = 2;
			add(percentLabel, constraints);
			this.endHumidityField = new JTextField(4);
			constraints.gridx = 3;
			add(this.endHumidityField, constraints);
			JLabel percent2Label = new JLabel("%");
			constraints.gridx = 4;
			add(percent2Label, constraints);

			constraints.gridy = 2;
			constraints.gridx = 0;
			JLabel rainLabel = new JLabel("Lluvia: ");
			add(rainLabel, constraints);
			this.startWeatherField = new JTextField(4);
			constraints.gridx = 1;
			add(this.startWeatherField, constraints);
			JLabel probalLabel = new JLabel("% - ");
			constraints.gridx = 2;
			add(probalLabel, constraints);
			this.endWeatherField = new JTextField(4);
			constraints.gridx = 3;
			add(this.endWeatherField, constraints);
			JLabel probal2Label = new JLabel("%");
			constraints.gridx = 4;
			add(probal2Label, constraints);
		}

		/**
		 *
		 * @param titledBorder
		 */
		public IntervalForecastUI(TitledBorder titledBorder) {
			this();
			setBorder(titledBorder);
		}

		/**
		 *
		 * @param intervalForecast
		 */
		public void setModel(IIntervalForecast intervalForecast) {
			clear();
			this.model = intervalForecast;

			if (this.model != null) {
				//TODO Hacerlo con un evento
				getStartTemperatureField().setText(String.valueOf(this.model.getInitialForecast().getTemperature()));
				getEndTemperatureField().setText(String.valueOf(this.model.getFinalForecast().getTemperature()));

				getStartHumidityField().setText(String.valueOf(this.model.getInitialForecast().getHumidity()));
				getEndHumidityField().setText(String.valueOf(this.model.getFinalForecast().getHumidity()));

				getStartWeatherField().setText(String.valueOf(this.model.getInitialForecast().getWeather()));
				getEndWeatherField().setText(String.valueOf(this.model.getFinalForecast().getWeather()));
			}
		}

		/**
		 *
		 */
		private void clear() {
			getStartTemperatureField().setText("");
			getEndTemperatureField().setText("");

			getStartHumidityField().setText("");
			getEndHumidityField().setText("");

			getStartWeatherField().setText("");
			getEndWeatherField().setText("");
		}

		/**
		 *
		 * @return
		 */
		private JTextField getEndWeatherField() {
			return endWeatherField;
		}

		/**
		 *
		 * @return
		 */
		private JTextField getStartWeatherField() {
			return startWeatherField;
		}

		/**
		 *
		 * @return
		 */
		private JTextField getEndHumidityField() {
			return endHumidityField;
		}

		/**
		 *
		 * @return
		 */
		private JTextField getStartHumidityField() {
			return startHumidityField;
		}

		/**
		 *
		 * @return
		 */
		private JTextField getEndTemperatureField() {
			return endTemperatureField;
		}

		/**
		 *
		 * @return
		 */
		private JTextField getStartTemperatureField() {
			return startTemperatureField;
		}

		/**
		 *
		 * @return
		 */
		public IIntervalForecast getModel() {
			return this.model;
		}

		@Override
		/**
		 *
		 */
		public void setEnabled(boolean enabled) {
			super.setEnabled(enabled);
			getStartTemperatureField().setEnabled(enabled);
			getEndTemperatureField().setEnabled(enabled);

			getStartHumidityField().setEnabled(enabled);
			getEndHumidityField().setEnabled(enabled);

			getStartWeatherField().setEnabled(enabled);
			getEndWeatherField().setEnabled(enabled);
		}


	}

	/**
	 * @return the q1UI
	 */
	public ForecastUI getQ1UI() {
		return q1UI;
	}

	/**
	 * @return the q2UI
	 */
	public ForecastUI getQ2UI() {
		return q2UI;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<IntervalForecastUI> getRaceForecastsUI() {
		return raceForecastsUI;
	}

}
