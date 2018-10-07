package org.jlobato.gpro.setup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jlobato.gpro.driver.IDriver;
import org.jlobato.gpro.driver.SetupRangeCalculatorFactory;
import org.jlobato.gpro.driver.SetupRangeCalculatorStrategy;
import org.jlobato.gpro.techdirector.ITechnicalDirector;

public class CalculadorSetupPerfectoRacing4Spain implements CalculadorSetupPerfecto {

	/**
	 *
	 * @param practiceLap
	 * @param driver
	 * @param techDirector
	 * @return
	 * @see org.jlobato.gpro.setup.CalculadorSetupPerfecto#getNextCarSetup(org.jlobato.gpro.setup.PracticeLap, org.jlobato.gpro.driver.IDriver, org.jlobato.gpro.techdirector.ITechnicalDirector)
	 */
	public CarSetup getNextCarSetup(PracticeLap practiceLap, IDriver driver, ITechnicalDirector techDirector) {

		//Rangos para cada parte del coche en función del TD
		//Cuando el TD es nulo, debería coincidir con el driverRange
		SetupRangeCalculatorStrategy calculator = SetupRangeCalculatorFactory.getInstance().create();
		//Primero, obtenemos el rango del piloto
		//JMPL 12/12/2010. Para el cálculo del limite de rango, no influye el TD. Sólo influye a nivel de cálculo
		//del setup perfecto. Se pone todo
		int driverRange = calculator.calculateDriverSetupRange(driver);

		int wingsRange = calculator.calculateDriverSetupRange(driver);
		int engineRange = calculator.calculateDriverSetupRange(driver);
		int brakesRange = calculator.calculateDriverSetupRange(driver);
		int gearboxRange = calculator.calculateDriverSetupRange(driver);
		int suspensionRange = calculator.calculateDriverSetupRange(driver);


		//Wings. Obtenemos el comentario para wings
		int wingsDriverChange = 0;
		int wingsAplicableChange = 0;
		DriverComment wingsDriverComment = (DriverComment)practiceLap.getComms().get(CarSetup.FRONTWING_SETUP);
		switch (wingsDriverComment.getCommentGrade()) {
		case DriverComment.MINOR_COMMENT_GRADE:
			// El cambio es menor, aplicamos la mitad del cambio anterior, si lo
			// hay y no es mayor que el rango del piloto, y en otro caso el rango del piloto
			Integer lastChange = practiceLap.getLastChange(CarSetup.FRONTWING_SETUP);
			wingsAplicableChange = (lastChange != null && lastChange.intValue() <= driverRange) ? ((int) Math.round(lastChange.intValue() / 2.0))
					: wingsRange;
//					: driverRange;
			// Aplicamos el signo del cambio: positivo o negativo
			wingsDriverChange = Math.abs(wingsAplicableChange)
					* wingsDriverComment.getCommentSignum();
			break;
		case DriverComment.SATISFIED_COMMENT_GRADE:
			// El piloto está contento, aplicamos la mitad del cambio anterior,
			// si lo hay, y sino lo hay, el rango del piloto
			Integer lastChangeSatisfied = practiceLap.getLastChange(CarSetup.FRONTWING_SETUP);
			wingsAplicableChange = (lastChangeSatisfied != null) ? ((int) Math.round(lastChangeSatisfied.intValue() / 2.0))
					: wingsRange;
//					: driverRange;
			// Aplicamos el signo del cambio: cambiamos siempre la tendencia de la vuelta anterior si existe
			// y sentido negativo sino existe
			int commentSignum = -1;
			if (lastChangeSatisfied != null) {
				DriverComment lastComment = practiceLap.getLastComment(CarSetup.FRONTWING_SETUP);
				if (lastComment != null) {
					boolean lastCommentSatisfied = lastComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE;
					commentSignum = (lastChangeSatisfied.intValue() > 0) ? (lastCommentSatisfied ? 1 : -1) : (lastCommentSatisfied ? -1 : 1);
				}
			}
			wingsDriverChange = Math.abs(wingsAplicableChange) * commentSignum;
			break;
		case DriverComment.MEDIUM_COMMENT_GRADE:
			// El cambio es medio, aplicamos 100 de cambio
			wingsAplicableChange = 100;
			// Aplicamos el signo del cambio: positivo o negativo
			wingsDriverChange = wingsAplicableChange
					* wingsDriverComment.getCommentSignum();
			break;
		case DriverComment.MAYOR_COMMENT_GRADE:
			// El cambio es medio, aplicamos 200 de cambio
			wingsAplicableChange = 200;
			// Aplicamos el signo del cambio: positivo o negativo
			wingsDriverChange = wingsAplicableChange
					* wingsDriverComment.getCommentSignum();
			break;
		default:
			throw new IllegalStateException(
					"FW: El comentario del piloto no es ninguno de los permitidos => "
							+ wingsDriverComment.getCommentGrade());
		}

		//Engine. Obtenemos el comentario para engine
		int engineDriverChange = 0;
		int engineAplicableChange = 0;
		DriverComment engineDriverComment = (DriverComment)practiceLap.getComms().get(CarSetup.ENGINE_SETUP);
		switch (engineDriverComment.getCommentGrade()) {
		case DriverComment.MINOR_COMMENT_GRADE:
			// El cambio es menor, aplicamos la mitad del cambio anterior, si lo
			// hay, y sino lo hay, el rango del piloto
			Integer lastChange = practiceLap.getLastChange(CarSetup.ENGINE_SETUP);
			engineAplicableChange = (lastChange != null && lastChange.intValue() <= driverRange) ? ((int) Math.round(lastChange.intValue() / 2.0))
					: engineRange;
//					: driverRange;
			// Aplicamos el signo del cambio: positivo o negativo
			engineDriverChange = Math.abs(engineAplicableChange)
					* engineDriverComment.getCommentSignum();
			break;
		case DriverComment.SATISFIED_COMMENT_GRADE:
			// El piloto está contento, aplicamos la mitad del cambio anterior,
			// si lo hay, y sino lo hay, el rango del piloto
			Integer lastChangeSatisfied = practiceLap.getLastChange(CarSetup.ENGINE_SETUP);
			engineAplicableChange = (lastChangeSatisfied != null) ? ((int) Math.round(lastChangeSatisfied.intValue() / 2.0))
					: engineRange;
//					: driverRange;
			// Aplicamos el signo del cambio: cambiamos siempre la tendencia de la vuelta anterior si existe
			// y sentido negativo sino existe
			int commentSignum = -1;
			if (lastChangeSatisfied != null) {
				DriverComment lastComment = practiceLap.getLastComment(CarSetup.ENGINE_SETUP);
				if (lastComment != null) {
					boolean lastCommentSatisfied = lastComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE;
					commentSignum = (lastChangeSatisfied.intValue() > 0) ? (lastCommentSatisfied ? 1 : -1) : (lastCommentSatisfied ? -1 : 1);
				}
			}
			engineDriverChange = Math.abs(engineAplicableChange) * commentSignum;
			break;
		case DriverComment.MEDIUM_COMMENT_GRADE:
			// El cambio es medio, aplicamos 100 de cambio
			engineAplicableChange = 100;
			// Aplicamos el signo del cambio: positivo o negativo
			engineDriverChange = engineAplicableChange
					* engineDriverComment.getCommentSignum();
			break;
		case DriverComment.MAYOR_COMMENT_GRADE:
			// El cambio es medio, aplicamos 200 de cambio
			engineAplicableChange = 200;
			// Aplicamos el signo del cambio: positivo o negativo
			engineDriverChange = engineAplicableChange
					* engineDriverComment.getCommentSignum();
			break;
		default:
			throw new IllegalStateException(
					"EN: El comentario del piloto no es ninguno de los permitidos => "
							+ engineDriverComment.getCommentGrade());
		}

		//Brakes. Obtenemos el comentario para brakes
		int brakesDriverChange = 0;
		int brakesAplicableChange = 0;
		DriverComment brakesDriverComment = (DriverComment)practiceLap.getComms().get(CarSetup.BRAKES_SETUP);
		switch (brakesDriverComment.getCommentGrade()) {
		case DriverComment.MINOR_COMMENT_GRADE:
			// El cambio es menor, aplicamos la mitad del cambio anterior, si lo
			// hay, y sino lo hay, el rango del piloto
			Integer lastChange = practiceLap.getLastChange(CarSetup.BRAKES_SETUP);
			brakesAplicableChange = (lastChange != null && lastChange.intValue() <= driverRange) ? ((int) Math.round(lastChange.intValue() / 2.0))
					: brakesRange;
//					: driverRange;
			// Aplicamos el signo del cambio: positivo o negativo
			brakesDriverChange = Math.abs(brakesAplicableChange)
					* brakesDriverComment.getCommentSignum();
			break;
		case DriverComment.SATISFIED_COMMENT_GRADE:
			// El piloto está contento, aplicamos la mitad del cambio anterior,
			// si lo hay, y sino lo hay, el rango del piloto
			Integer lastChangeSatisfied = practiceLap.getLastChange(CarSetup.BRAKES_SETUP);
			brakesAplicableChange = (lastChangeSatisfied != null) ? ((int) Math.round(lastChangeSatisfied.intValue() / 2.0))
					: brakesRange;
//					: driverRange;
			// Aplicamos el signo del cambio: cambiamos siempre la tendencia de la vuelta anterior si existe
			// y sentido negativo sino existe
			int commentSignum = -1;
			if (lastChangeSatisfied != null) {
				DriverComment lastComment = practiceLap.getLastComment(CarSetup.BRAKES_SETUP);
				//Si no hay comentario anterior, el signo siempre será negativo
				if (lastComment != null) {
					boolean lastCommentSatisfied = lastComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE;
					commentSignum = (lastChangeSatisfied.intValue() > 0) ? (lastCommentSatisfied ? 1 : -1) : (lastCommentSatisfied ? -1 : 1);
				}
			}
			brakesDriverChange = Math.abs(brakesAplicableChange) * commentSignum;
			break;
		case DriverComment.MEDIUM_COMMENT_GRADE:
			// El cambio es medio, aplicamos 100 de cambio
			brakesAplicableChange = 100;
			// Aplicamos el signo del cambio: positivo o negativo
			brakesDriverChange = brakesAplicableChange
					* brakesDriverComment.getCommentSignum();
			break;
		case DriverComment.MAYOR_COMMENT_GRADE:
			// El cambio es medio, aplicamos 200 de cambio
			brakesAplicableChange = 200;
			// Aplicamos el signo del cambio: positivo o negativo
			brakesDriverChange = brakesAplicableChange
					* brakesDriverComment.getCommentSignum();
			break;
		default:
			throw new IllegalStateException(
					"BR: El comentario del piloto no es ninguno de los permitidos => "
							+ brakesDriverComment.getCommentGrade());
		}

		//Gearbox. Obtenemos el comentario para gearbox
		int gearboxDriverChange = 0;
		int gearboxAplicableChange = 0;
		DriverComment gearboxDriverComment = (DriverComment)practiceLap.getComms().get(CarSetup.GEARBOX_SETUP);
		switch (gearboxDriverComment.getCommentGrade()) {
		case DriverComment.MINOR_COMMENT_GRADE:
			// El cambio es menor, aplicamos la mitad del cambio anterior, si lo
			// hay, y sino lo hay, el rango del piloto
			Integer lastChange = practiceLap.getLastChange(CarSetup.GEARBOX_SETUP);
			gearboxAplicableChange = (lastChange != null && lastChange.intValue() <= driverRange) ? ((int) Math.round(lastChange.intValue() / 2.0))
					: gearboxRange;
//					: driverRange;
			// Aplicamos el signo del cambio: positivo o negativo
			gearboxDriverChange = Math.abs(gearboxAplicableChange)
					* gearboxDriverComment.getCommentSignum();
			break;
		case DriverComment.SATISFIED_COMMENT_GRADE:
			// El piloto está contento, aplicamos la mitad del cambio anterior,
			// si lo hay, y sino lo hay, el rango del piloto
			Integer lastChangeSatisfied = practiceLap.getLastChange(CarSetup.GEARBOX_SETUP);
			gearboxAplicableChange = (lastChangeSatisfied != null) ? ((int) Math.round(lastChangeSatisfied.intValue() / 2.0))
					: gearboxRange;
//					: driverRange;
			// Aplicamos el signo del cambio: cambiamos siempre la tendencia de la vuelta anterior si existe
			// y sentido negativo sino existe
			int commentSignum = -1;
			if (lastChangeSatisfied != null) {
				DriverComment lastComment = practiceLap.getLastComment(CarSetup.GEARBOX_SETUP);
				if (lastComment != null) {
					boolean lastCommentSatisfied = lastComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE;
					commentSignum = (lastChangeSatisfied.intValue() > 0) ? (lastCommentSatisfied ? 1 : -1) : (lastCommentSatisfied ? -1 : 1);
				}
			}
			gearboxDriverChange = Math.abs(gearboxAplicableChange) * commentSignum;
			break;
		case DriverComment.MEDIUM_COMMENT_GRADE:
			// El cambio es medio, aplicamos 100 de cambio
			gearboxAplicableChange = 100;
			// Aplicamos el signo del cambio: positivo o negativo
			gearboxDriverChange = gearboxAplicableChange
					* gearboxDriverComment.getCommentSignum();
			break;
		case DriverComment.MAYOR_COMMENT_GRADE:
			// El cambio es medio, aplicamos 200 de cambio
			gearboxAplicableChange = 200;
			// Aplicamos el signo del cambio: positivo o negativo
			gearboxDriverChange = gearboxAplicableChange
					* gearboxDriverComment.getCommentSignum();
			break;
		default:
			throw new IllegalStateException(
					"GE: El comentario del piloto no es ninguno de los permitidos => "
							+ gearboxDriverComment.getCommentGrade());
		}

		//Suspension. Obtenemos el comentario para suspension
		int suspensionDriverChange = 0;
		int suspensionAplicableChange = 0;
		DriverComment suspensionDriverComment = (DriverComment)practiceLap.getComms().get(CarSetup.SUSPENSION_SETUP);
		switch (suspensionDriverComment.getCommentGrade()) {
		case DriverComment.MINOR_COMMENT_GRADE:
			// El cambio es menor, aplicamos la mitad del cambio anterior, si lo
			// hay, y sino lo hay, el rango del piloto
			Integer lastChange = practiceLap.getLastChange(CarSetup.SUSPENSION_SETUP);
			suspensionAplicableChange = (lastChange != null && lastChange.intValue() <= driverRange) ? ((int) Math.round(lastChange.intValue() / 2.0))
					: suspensionRange;
//					: driverRange;
			// Aplicamos el signo del cambio: positivo o negativo
			suspensionDriverChange = Math.abs(suspensionAplicableChange)
					* suspensionDriverComment.getCommentSignum();
			break;
		case DriverComment.SATISFIED_COMMENT_GRADE:
			// El piloto está contento, aplicamos la mitad del cambio anterior,
			// si lo hay, y sino lo hay, el rango del piloto
			Integer lastChangeSatisfied = practiceLap.getLastChange(CarSetup.SUSPENSION_SETUP);
			suspensionAplicableChange = (lastChangeSatisfied != null) ? ((int) Math.round(lastChangeSatisfied.intValue() / 2.0))
					: suspensionRange;
//					: driverRange;
			// Aplicamos el signo del cambio: cambiamos siempre la tendencia de la vuelta anterior si existe
			// y sentido negativo sino existe
			int commentSignum = -1;
			if (lastChangeSatisfied != null) {
				DriverComment lastComment = practiceLap.getLastComment(CarSetup.SUSPENSION_SETUP);
				if (lastComment != null) {
					boolean lastCommentSatisfied = lastComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE;
					commentSignum = (lastChangeSatisfied.intValue() > 0) ? (lastCommentSatisfied ? 1 : -1) : (lastCommentSatisfied ? -1 : 1);
				}
			}
			suspensionDriverChange = Math.abs(suspensionAplicableChange) * commentSignum;
			break;
		case DriverComment.MEDIUM_COMMENT_GRADE:
			// El cambio es medio, aplicamos 100 de cambio
			suspensionAplicableChange = 100;
			// Aplicamos el signo del cambio: positivo o negativo
			suspensionDriverChange = suspensionAplicableChange
					* suspensionDriverComment.getCommentSignum();
			break;
		case DriverComment.MAYOR_COMMENT_GRADE:
			// El cambio es medio, aplicamos 200 de cambio
			suspensionAplicableChange = 200;
			// Aplicamos el signo del cambio: positivo o negativo
			suspensionDriverChange = suspensionAplicableChange
					* suspensionDriverComment.getCommentSignum();
			break;
		default:
			throw new IllegalStateException(
					"SU: El comentario del piloto no es ninguno de los permitidos => "
							+ suspensionDriverComment.getCommentGrade());
		}

		//Devolvemos el setup sugerido para la siguiente vuelta
		return new CarSetup(new Integer(practiceLap.getSetup().getFrontWing().intValue() + wingsDriverChange),
				new Integer(practiceLap.getSetup().getRearWing().intValue() + wingsDriverChange),
				new Integer(practiceLap.getSetup().getEngine().intValue() + engineDriverChange),
				new Integer(practiceLap.getSetup().getBrakes().intValue() + brakesDriverChange),
				new Integer(practiceLap.getSetup().getGearbox().intValue() + gearboxDriverChange),
				new Integer(practiceLap.getSetup().getSuspension().intValue() + suspensionDriverChange));
//		return CarSetup.ALL500_SETUP;
	}

	/**
	 *
	 * @param session
	 * @param driver
	 * @param techDirector
	 * @return
	 * @throws CalculadorSetupPerfectoException
	 */
	public CarSetup getPerfectSetup(PracticeSession session, IDriver driver, ITechnicalDirector techDirector) throws CalculadorSetupPerfectoException {
		CarSetup result = null;

		//Primero, obtenemos el rango del piloto
		//int driverRange = driver.getSetupRange();

		//Rangos para cada parte del coche en función del TD
		//Cuando el TD es nulo, debería coincidir con el driverRange
		SetupRangeCalculatorStrategy calculator = SetupRangeCalculatorFactory.getInstance().create();
		int wingsRange = calculator.calculateWingsSetupRange(driver, techDirector);
		int engineRange = calculator.calculateEngineSetupRange(driver, techDirector);
		int brakesRange = calculator.calculateBrakesSetupRange(driver, techDirector);
		int gearboxRange = calculator.calculateGearboxSetupRange(driver, techDirector);
		int suspensionRange = calculator.calculateSuspensionSetupRange(driver, techDirector);

		try {
			result = (CarSetup)CarSetup.ALL500_SETUP.clone();
		} catch (Exception e) {

		}

		Iterator<PracticeLap> iterator = session.getPracticeLaps().iterator();
		Integer goodWings = null;
		Integer badWings = null;
		int badWingsSignum = 0;

		Integer goodEngine = null;
		Integer badEngine = null;
		int badEngineSignum = 0;

		Integer goodBrakes = null;
		Integer badBrakes = null;
		int badBrakesSignum = 0;

		Integer goodGearbox = null;
		Integer badGearbox = null;
		int badGearboxSignum = 0;

		Integer goodSuspension = null;
		Integer badSuspension = null;
		int badSuspensionSignum = 0;


		while (iterator.hasNext()) {
			PracticeLap lap = iterator.next();
			//Si hay comentarios (no contamos la última vuelta para hacer el setup perfecto
			if (lap.getComms().size() != 0) {
				//Wings
				CarSetup currentSetup = lap.getSetup();
				Integer currentWings = currentSetup.getFrontWing();
				DriverComment currentWingsComment = (DriverComment)lap.getComms().get(CarSetup.FRONTWING_SETUP);
				if (currentWingsComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE) {
					goodWings = currentWings;
				}
				else {
					badWings = currentWings;
					badWingsSignum = currentWingsComment.getCommentSignum();
				}
				//Engine
				Integer currentEngine = currentSetup.getEngine();
				DriverComment currentEngineComment = (DriverComment)lap.getComms().get(CarSetup.ENGINE_SETUP);
				if (currentEngineComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE) {
					goodEngine = currentEngine;
				}
				else {
					badEngine = currentEngine;
					badEngineSignum = currentEngineComment.getCommentSignum();
				}
				//Brakes
				Integer currentBrakes = currentSetup.getBrakes();
				DriverComment currentBrakesComment = (DriverComment)lap.getComms().get(CarSetup.BRAKES_SETUP);
				if (currentBrakesComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE) {
					goodBrakes = currentBrakes;
				}
				else {
					badBrakes = currentBrakes;
					badBrakesSignum = currentBrakesComment.getCommentSignum();
				}
				//Gearbox
				Integer currentGearbox = currentSetup.getGearbox();
				DriverComment currentGearboxComment = (DriverComment)lap.getComms().get(CarSetup.GEARBOX_SETUP);
				if (currentGearboxComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE) {
					goodGearbox = currentGearbox;
				}
				else {
					badGearbox = currentGearbox;
					badGearboxSignum = currentGearboxComment.getCommentSignum();
				}
				//Suspension
				Integer currentSuspension = currentSetup.getSuspension();
				DriverComment currentSuspensionComment = (DriverComment)lap.getComms().get(CarSetup.SUSPENSION_SETUP);
				if (currentSuspensionComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE) {
					goodSuspension = currentSuspension;
				}
				else {
					badSuspension = currentSuspension;
					badSuspensionSignum = currentSuspensionComment.getCommentSignum();
				}
			}
		}

		//Control de rangos
		List<String> errorList = new ArrayList<String>();
		//Wings
		if (goodWings == null) {
			//Si no hemos encontrado un setup bueno de alerones
			errorList.add("Wings: No se ha encontrado un setup bueno para los alerones");
		}
		if (badWings == null) {
			//Si no hemos encontrado un setup malo de alerones
			errorList.add("Wings: No se ha encontrado un setup malo para los alerones");
		}

		//Engine
		if (goodEngine == null) {
			//Si no hemos encontrado un setup bueno de motor
			errorList.add("Engine: No se ha encontrado un setup bueno para el motor");
		}
		if (badEngine == null) {
			//Si no hemos encontrado un setup malo de alerones
			errorList.add("Engine: No se ha encontrado un setup malo para el motor");
		}

		//Brakes
		if (goodBrakes == null) {
			//Si no hemos encontrado un setup bueno de motor
			errorList.add("Brakes: No se ha encontrado un setup bueno para los frenos");
		}
		if (badBrakes == null) {
			//Si no hemos encontrado un setup malo de alerones
			errorList.add("Brakes: No se ha encontrado un setup malo para los frenos");
		}

		//Gearbox
		if (goodGearbox == null) {
			//Si no hemos encontrado un setup bueno de motor
			errorList.add("Gearbox: No se ha encontrado un setup bueno para la caja de cambios");
		}
		if (badGearbox == null) {
			//Si no hemos encontrado un setup malo de alerones
			errorList.add("Gearbox: No se ha encontrado un setup malo para la caja de cambios");
		}

		//Suspension
		if (goodSuspension == null) {
			//Si no hemos encontrado un setup bueno de motor
			errorList.add("Suspension: No se ha encontrado un setup bueno para la suspensión");
		}
		if (badSuspension == null) {
			//Si no hemos encontrado un setup malo de alerones
			errorList.add("Suspension: No se ha encontrado un setup malo para la suspensión");
		}

		//if (errorList.size() > 0) {
		//	throw new CalculadorSetupPerfectoException(errorList);
		//}

		Integer perfectSetupWings = null;
		if (goodWings != null && badWings != null) {
			int optWings = (int)Math.round(((goodWings.doubleValue() + badWings.doubleValue()) / 2.0) + (badWingsSignum) * wingsRange);
			perfectSetupWings = new Integer(optWings);
		}

		Integer perfectSetupEngine = null;
		if (goodEngine != null && badEngine != null) {
			int optEngine = (int)Math.round(((goodEngine.doubleValue() + badEngine.doubleValue()) / 2.0) + (badEngineSignum) * engineRange);
			perfectSetupEngine = new Integer(optEngine);
		}

		Integer perfectSetupBrakes = null;
		if (goodBrakes != null && badBrakes != null) {
			int optBrakes = (int)Math.round(((goodBrakes.doubleValue() + badBrakes.doubleValue()) / 2.0) + (badBrakesSignum) * brakesRange);
			perfectSetupBrakes = new Integer(optBrakes);
		}

		Integer perfectSetupGearbox = null;
		if (goodGearbox != null && badGearbox != null) {
			int optGearbox = (int)Math.round(((goodGearbox.doubleValue() + badGearbox.doubleValue()) / 2.0) + (badGearboxSignum) * gearboxRange);
			perfectSetupGearbox = new Integer(optGearbox);
		}

		Integer perfectSetupSuspension = null;
		if (goodSuspension != null && badSuspension != null) {
			int optSuspension = (int)Math.round(((goodSuspension.doubleValue() + badSuspension.doubleValue()) / 2.0) + (badSuspensionSignum) * suspensionRange);
			perfectSetupSuspension = new Integer(optSuspension);
		}

		result = new CarSetup(perfectSetupWings, perfectSetupWings, perfectSetupEngine, perfectSetupBrakes, perfectSetupGearbox, perfectSetupSuspension);

		return result;
	}

	/**
	 *
	 */
	public CarFringe getCarFringe(PracticeSession session, IDriver driver, ITechnicalDirector techDirector) {
		CarFringe result = null;

		Iterator<PracticeLap> iterator = session.getPracticeLaps().iterator();
		Integer goodWings = null;
		Integer badWings = null;
		int badWingsSignum = -1;

		Integer goodEngine = null;
		Integer badEngine = null;
		int badEngineSignum = -1;

		Integer goodBrakes = null;
		Integer badBrakes = null;
		int badBrakesSignum = -1;

		Integer goodGearbox = null;
		Integer badGearbox = null;
		int badGearboxSignum = -1;

		Integer goodSuspension = null;
		Integer badSuspension = null;
		int badSuspensionSignum = -1;


		while (iterator.hasNext()) {
			PracticeLap lap = iterator.next();
			//Si hay comentarios (no contamos la última vuelta para hacer el setup perfecto
			if (lap.getComms().size() != 0) {
				//Wings
				CarSetup currentSetup = lap.getSetup();
				Integer currentWings = currentSetup.getFrontWing();
				DriverComment currentWingsComment = (DriverComment)lap.getComms().get(CarSetup.FRONTWING_SETUP);
				if (currentWingsComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE) {
					goodWings = currentWings;
				}
				else {
					badWings = currentWings;
					badWingsSignum = currentWingsComment.getCommentSignum();
				}
				//Engine
				Integer currentEngine = currentSetup.getEngine();
				DriverComment currentEngineComment = (DriverComment)lap.getComms().get(CarSetup.ENGINE_SETUP);
				if (currentEngineComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE) {
					goodEngine = currentEngine;
				}
				else {
					badEngine = currentEngine;
					badEngineSignum = currentEngineComment.getCommentSignum();
				}
				//Brakes
				Integer currentBrakes = currentSetup.getBrakes();
				DriverComment currentBrakesComment = (DriverComment)lap.getComms().get(CarSetup.BRAKES_SETUP);
				if (currentBrakesComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE) {
					goodBrakes = currentBrakes;
				}
				else {
					badBrakes = currentBrakes;
					badBrakesSignum = currentBrakesComment.getCommentSignum();
				}
				//Gearbox
				Integer currentGearbox = currentSetup.getGearbox();
				DriverComment currentGearboxComment = (DriverComment)lap.getComms().get(CarSetup.GEARBOX_SETUP);
				if (currentGearboxComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE) {
					goodGearbox = currentGearbox;
				}
				else {
					badGearbox = currentGearbox;
					badGearboxSignum = currentGearboxComment.getCommentSignum();
				}
				//Suspension
				Integer currentSuspension = currentSetup.getSuspension();
				DriverComment currentSuspensionComment = (DriverComment)lap.getComms().get(CarSetup.SUSPENSION_SETUP);
				if (currentSuspensionComment.getCommentGrade() == DriverComment.SATISFIED_COMMENT_GRADE) {
					goodSuspension = currentSuspension;
				}
				else {
					badSuspension = currentSuspension;
					badSuspensionSignum = currentSuspensionComment.getCommentSignum();
				}
			}
		}

		//Creamos los fringes
		//wings
		Fringe wingsFringe = createFringe(badWingsSignum, goodWings, badWings);
		//engine
		Fringe engineFringe = createFringe(badEngineSignum, goodEngine, badEngine);
		//brakes
		Fringe brakesFringe = createFringe(badBrakesSignum, goodBrakes, badBrakes);
		//brakes
		Fringe gearboxFringe = createFringe(badGearboxSignum, goodGearbox, badGearbox);
		//suspension
		Fringe suspensionFringe = createFringe(badSuspensionSignum, goodSuspension, badSuspension);

		result = new CarFringe(wingsFringe, engineFringe, brakesFringe, gearboxFringe, suspensionFringe);

		return result;
	}

	/**
	 *
	 * @param signum
	 * @param good
	 * @param bad
	 * @return
	 */
	private Fringe createFringe(int signum, Integer good, Integer bad) {
		Fringe result = (signum < 0) ? new Fringe(bad, good, signum) : new Fringe(good, bad, signum);
		return result;
	}

}
