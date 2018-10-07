package org.jlobato.gpro.setup;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

import org.jlobato.gpro.driver.IDriver;

public class PruebaSetup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("driver.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			final IDriver driver = (IDriver)ois.readObject();

			doTest(driver);

			//System.out.println("COMMENTS: " + parser.getComments(commentsExample));
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fis != null) try { fis.close(); } catch (Exception c) {}
		}
	}

	/**
	 * @param driver
	 */
	public static PracticeSession doTest(final IDriver driver) {
		//Ejemplo de setup
		PracticeSession testSession = new PracticeSession();
		CalculadorSetupPerfecto calculador = new CalculadorSetupPerfectoRacing4Spain();

		//Practice 1.
		DriverCommentsParser parser = new DriverCommentsParser();
		HashMap comments = new HashMap();
		/*comments.put(CarSetup.FRONTWING_SETUP, GPRODriverComment.MINOR_UP_FW_COMMENT);
		comments.put(CarSetup.ENGINE_SETUP, GPRODriverComment.MEDIUM_UP_EN_COMMENT);
		comments.put(CarSetup.BRAKES_SETUP, GPRODriverComment.MINOR_UP_BR_COMMENT);
		comments.put(CarSetup.GEARBOX_SETUP, GPRODriverComment.MINOR_DOWN_GE_COMMENT);
		comments.put(CarSetup.SUSPENSION_SETUP, GPRODriverComment.MINOR_UP_SU_COMMENT);*/
		String commentsExample = "Wings: The car could have a bit more speed in the straights" + System.getProperty("line.separator")
		+ "Engine: Try to favor a bit more the low revs" + System.getProperty("line.separator")
		+ "Gear: I am very often in the red. Put the gear ratio a bit higher" + System.getProperty("line.separator")
		+ "Suspension: The car is too rigid. Lower a bit the rigidity   " + System.getProperty("line.separator");
		comments = parser.getComments(commentsExample);

		PracticeLap practiceLap = new PracticeLap(testSession, new Integer(1), new LapTime("1:35.341", "0.130", "1:35:211"), new CarSetup(317, 317, 815, 511, 643, 769), comments);
		CarSetup nextSetup = calculador.getNextCarSetup(practiceLap, driver, null);
		System.out.println("Next setup: " + nextSetup);
		//Practice 2.
		comments = new HashMap();
		/*comments.put(CarSetup.FRONTWING_SETUP, GPRODriverComment.MINOR_UP_FW_COMMENT);
		comments.put(CarSetup.ENGINE_SETUP, GPRODriverComment.MINOR_UP_EN_COMMENT);
		comments.put(CarSetup.BRAKES_SETUP, GPRODriverComment.SATISFIED_BR_COMMENT);
		comments.put(CarSetup.GEARBOX_SETUP, GPRODriverComment.MINOR_DOWN_GE_COMMENT);
		comments.put(CarSetup.SUSPENSION_SETUP, GPRODriverComment.MINOR_UP_SU_COMMENT);*/
		commentsExample = "I am satisfied with the setup of the car" + System.getProperty("line.separator") + "   ";
		//266 266 764 460 694 718
		comments = parser.getComments(commentsExample);

		practiceLap = new PracticeLap(testSession, new Integer(2), new LapTime("1:34.426", "0.069", "1:34.357"), nextSetup, comments);
		nextSetup = calculador.getNextCarSetup(practiceLap, driver, null);
		System.out.println("Next setup: " + nextSetup);
		//Practice 3.
		comments = new HashMap();
		/*comments.put(CarSetup.FRONTWING_SETUP, GPRODriverComment.MINOR_UP_FW_COMMENT);
		comments.put(CarSetup.ENGINE_SETUP, GPRODriverComment.SATISFIED_EN_COMMENT);
		comments.put(CarSetup.BRAKES_SETUP, GPRODriverComment.MINOR_UP_BR_COMMENT);
		comments.put(CarSetup.GEARBOX_SETUP, GPRODriverComment.SATISFIED_GE_COMMENT);
		comments.put(CarSetup.SUSPENSION_SETUP, GPRODriverComment.SATISFIED_SU_COMMENT);*/
		commentsExample = "Gear: I am very often in the red. Put the gear ratio a bit higher" + System.getProperty("line.separator")
		+ "Suspension: The car is too rigid. Lower a bit the rigidity" + System.getProperty("line.separator");
		comments = parser.getComments(commentsExample);

		practiceLap = new PracticeLap(testSession, new Integer(3), new LapTime("1:34.870", "0.152", "1:34.718"), nextSetup, comments);
		nextSetup = calculador.getNextCarSetup(practiceLap, driver, null);
		System.out.println("Next setup: " + nextSetup);
		//Practice 4.
		comments = new HashMap();
		/*comments.put(CarSetup.FRONTWING_SETUP, GPRODriverComment.SATISFIED_FW_COMMENT);
		comments.put(CarSetup.ENGINE_SETUP, GPRODriverComment.MINOR_UP_EN_COMMENT);
		comments.put(CarSetup.BRAKES_SETUP, GPRODriverComment.SATISFIED_BR_COMMENT);
		comments.put(CarSetup.GEARBOX_SETUP, GPRODriverComment.SATISFIED_GE_COMMENT);
		comments.put(CarSetup.SUSPENSION_SETUP, GPRODriverComment.SATISFIED_SU_COMMENT);*/
		commentsExample = "Wings: The car could have a bit more speed in the straights" + System.getProperty("line.separator")
		+ "Gear: I am very often in the red. Put the gear ratio a bit higher" + System.getProperty("line.separator")
		+ "Suspension: The car is too rigid. Lower a bit the rigidity   " + System.getProperty("line.separator");
		comments = parser.getComments(commentsExample);

		practiceLap = new PracticeLap(testSession, new Integer(4), new LapTime("1:34.905", "0.175", "1:34.730"), nextSetup, comments);
		nextSetup = calculador.getNextCarSetup(practiceLap, driver, null);
		System.out.println("Next setup: " + nextSetup);
		//297 297 809 417 688 724

		comments = new HashMap();
		/*comments.put(CarSetup.FRONTWING_SETUP, GPRODriverComment.SATISFIED_FW_COMMENT);
		comments.put(CarSetup.ENGINE_SETUP, GPRODriverComment.MINOR_UP_EN_COMMENT);
		comments.put(CarSetup.BRAKES_SETUP, GPRODriverComment.SATISFIED_BR_COMMENT);
		comments.put(CarSetup.GEARBOX_SETUP, GPRODriverComment.SATISFIED_GE_COMMENT);
		comments.put(CarSetup.SUSPENSION_SETUP, GPRODriverComment.SATISFIED_SU_COMMENT);*/
		commentsExample = "Wings: The car could have a bit more speed in the straights" + System.getProperty("line.separator")
		+ "Engine: Try to favor a bit more the low revs" + System.getProperty("line.separator")
		+ "Suspension: The car is too rigid. Lower a bit the rigidity   " + System.getProperty("line.separator");
		comments = parser.getComments(commentsExample);

		practiceLap = new PracticeLap(testSession, new Integer(5), new LapTime("1:34.993", "0.181", "1:34.812"), nextSetup, comments);
		nextSetup = calculador.getNextCarSetup(practiceLap, driver, null);
		System.out.println("Next setup: " + nextSetup);

		comments = new HashMap();
		/*comments.put(CarSetup.FRONTWING_SETUP, GPRODriverComment.SATISFIED_FW_COMMENT);
		comments.put(CarSetup.ENGINE_SETUP, GPRODriverComment.MINOR_UP_EN_COMMENT);
		comments.put(CarSetup.BRAKES_SETUP, GPRODriverComment.SATISFIED_BR_COMMENT);
		comments.put(CarSetup.GEARBOX_SETUP, GPRODriverComment.SATISFIED_GE_COMMENT);
		comments.put(CarSetup.SUSPENSION_SETUP, GPRODriverComment.SATISFIED_SU_COMMENT);*/
		commentsExample = "Wings: The car could have a bit more speed in the straights" + System.getProperty("line.separator")
		+ "Engine: Try to favor a bit more the low revs" + System.getProperty("line.separator");
		comments = parser.getComments(commentsExample);

		practiceLap = new PracticeLap(testSession, new Integer(6), new LapTime("1:34.862", "0.078", "1:34.784"), nextSetup, comments);
		nextSetup = calculador.getNextCarSetup(practiceLap, driver, null);
		System.out.println("Next setup: " + nextSetup);

		comments = new HashMap();
		/*comments.put(CarSetup.FRONTWING_SETUP, GPRODriverComment.SATISFIED_FW_COMMENT);
		comments.put(CarSetup.ENGINE_SETUP, GPRODriverComment.MINOR_UP_EN_COMMENT);
		comments.put(CarSetup.BRAKES_SETUP, GPRODriverComment.SATISFIED_BR_COMMENT);
		comments.put(CarSetup.GEARBOX_SETUP, GPRODriverComment.SATISFIED_GE_COMMENT);
		comments.put(CarSetup.SUSPENSION_SETUP, GPRODriverComment.SATISFIED_SU_COMMENT);*/
		commentsExample = "Wings: The car could have a bit more speed in the straights" + System.getProperty("line.separator")
		+ "Gear: I am very often in the red. Put the gear ratio a bit higher" + System.getProperty("line.separator")
		+ "Brakes: I would like to have the balance a bit more to the front" + System.getProperty("line.separator")
		+ "Engine: Try to favor a bit more the low revs" + System.getProperty("line.separator");
		comments = parser.getComments(commentsExample);

		practiceLap = new PracticeLap(testSession, new Integer(6), new LapTime("1:34.862", "0.078", "1:34.784"), nextSetup, comments);
		nextSetup = calculador.getNextCarSetup(practiceLap, driver, null);
		System.out.println("Next setup: " + nextSetup);

		return testSession;
	}

}
