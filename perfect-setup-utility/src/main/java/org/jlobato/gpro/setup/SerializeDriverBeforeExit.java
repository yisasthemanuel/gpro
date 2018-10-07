package org.jlobato.gpro.setup;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.jlobato.gpro.driver.DriverUI;
import org.jlobato.gpro.forecast.RaceForecastUI;
import org.jlobato.gpro.techdirector.TechnicalDirectorUI;
import org.jlobato.gpro.user.UsuarioUI;

/**
 *
 * @author JLOBATO
 *
 */
public class SerializeDriverBeforeExit extends WindowAdapter {

	/**
	 *
	 */
	private DriverUI driverUI;
	/**
	 *
	 */
	private PracticeSessionUI practiceSessionUI;
	/**
	 *
	 */
	private TechnicalDirectorUI techDirectorUI;

	/**
	 * 
	 */
	private RaceForecastUI forecastUI;
	
	private UsuarioUI userUI;

	
	/**
	 *
	 * @param panel
	 * @param practiceSessionUI
	 * @param techDirectorUI
	 */
	public SerializeDriverBeforeExit(DriverUI panel, PracticeSessionUI practiceSessionUI, TechnicalDirectorUI techDirectorUI, RaceForecastUI forecastUI, UsuarioUI userUI) {
		this.driverUI = panel;
		this.practiceSessionUI = practiceSessionUI;
		this.techDirectorUI = techDirectorUI;
		this.forecastUI = forecastUI;
		this.userUI = userUI;
	}

	/**
	 *
	 * @param evt
	 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
	 */
	public void windowClosing(WindowEvent evt) {
		//TODO Refactorizar el método que serializa el piloto, director técnico y la práctica
		if (driverUI != null && driverUI.getDriver() != null) {
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream("driver.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(driverUI.getDriver());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fos != null) {
					try { fos.close(); } catch(Exception c) {}
				}
			}
		}

		if (practiceSessionUI != null && practiceSessionUI.getModel() != null) {
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream("practice.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(practiceSessionUI.getModel());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fos != null) {
					try { fos.close(); } catch(Exception c) {}
				}
			}
		}

		if (techDirectorUI != null && techDirectorUI.getModel() != null) {
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream("techdirector.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(techDirectorUI.getModel());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fos != null) {
					try { fos.close(); } catch(Exception c) {}
				}
			}
		}

		if (forecastUI != null && forecastUI.getModel() != null) {
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream("forecast.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(forecastUI.getModel());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fos != null) {
					try { fos.close(); } catch(Exception c) {}
				}
			}
		}
		
		if (userUI != null && userUI.getModel() != null) {
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream("usuario.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(userUI.getModel());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fos != null) {
					try { fos.close(); } catch(Exception c) {}
				}
			}
		}

		System.exit(0);
	}
}
