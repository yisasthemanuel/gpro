package org.jlobato.gpro.setup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jlobato.gpro.languages.ConstantesLanguages;
import org.jlobato.gpro.languages.ILanguage;

/**
 *
 * @author JLOBATO
 *
 */
public class GPRODriverComment implements DriverComment {

	private String carPart;
	private String commentDescription;
	private int commentGrade;
	private int commentSign;

	/**
	 * WINGS COMMENTS ENGLISH
	 */
	public static final GPRODriverComment SATISFIED_FW_COMMENT = new GPRODriverComment(CarSetup.FRONTWING_SETUP, "Satisfied", DriverComment.SATISFIED_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_DOWN_FW_COMMENT = new GPRODriverComment(CarSetup.FRONTWING_SETUP, "I am really missing a lot of speed in straights", DriverComment.MAYOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MEDIUM_DOWN_FW_COMMENT = new GPRODriverComment(CarSetup.FRONTWING_SETUP, "The car is lacking some speed in the straights", DriverComment.MEDIUM_COMMENT_GRADE, -1);
	public static final GPRODriverComment MINOR_DOWN_FW_COMMENT = new GPRODriverComment(CarSetup.FRONTWING_SETUP, "The car could have a bit more speed in the straights", DriverComment.MINOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_UP_FW_COMMENT = new GPRODriverComment(CarSetup.FRONTWING_SETUP, "I cannot drive the car, there's no grip on it", DriverComment.MAYOR_COMMENT_GRADE, 1);
	public static final GPRODriverComment MEDIUM_UP_FW_COMMENT = new GPRODriverComment(CarSetup.FRONTWING_SETUP, "The car is very unstable in many corners", DriverComment.MEDIUM_COMMENT_GRADE, 1);
	public static final GPRODriverComment MINOR_UP_FW_COMMENT = new GPRODriverComment(CarSetup.FRONTWING_SETUP, "I am missing a bit of grip in the curves", DriverComment.MINOR_COMMENT_GRADE, 1);

	public static final GPRODriverComment SATISFIED_RW_COMMENT = new GPRODriverComment(CarSetup.REARWING_SETUP, "Satisfied", DriverComment.SATISFIED_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_DOWN_RW_COMMENT = new GPRODriverComment(CarSetup.REARWING_SETUP, "I am really missing a lot of speed in straights", DriverComment.MAYOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MEDIUM_DOWN_RW_COMMENT = new GPRODriverComment(CarSetup.REARWING_SETUP, "The car is lacking some speed in the straights", DriverComment.MEDIUM_COMMENT_GRADE, -1);
	public static final GPRODriverComment MINOR_DOWN_RW_COMMENT = new GPRODriverComment(CarSetup.REARWING_SETUP, "The car could have a bit more speed in the straights", DriverComment.MINOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_UP_RW_COMMENT = new GPRODriverComment(CarSetup.REARWING_SETUP, "I cannot drive the car, there's no grip on it", DriverComment.MAYOR_COMMENT_GRADE, 1);
	public static final GPRODriverComment MEDIUM_UP_RW_COMMENT = new GPRODriverComment(CarSetup.REARWING_SETUP, "The car is very unstable in many corners", DriverComment.MEDIUM_COMMENT_GRADE, 1);
	public static final GPRODriverComment MINOR_UP_RW_COMMENT = new GPRODriverComment(CarSetup.REARWING_SETUP, "I am missing a bit of grip in the curves", DriverComment.MINOR_COMMENT_GRADE, 1);

	/**
	 * WINGS COMMENTS SPANISH
	 */
	public static final GPRODriverComment SATISFIED_FW_COMMENT_ES = new GPRODriverComment(CarSetup.FRONTWING_SETUP, "Perfecto", DriverComment.SATISFIED_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_DOWN_FW_COMMENT_ES = new GPRODriverComment(CarSetup.FRONTWING_SETUP, "Realmente est� faltando mucha velocidad en las rectas", DriverComment.MAYOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MEDIUM_DOWN_FW_COMMENT_ES = new GPRODriverComment(CarSetup.FRONTWING_SETUP, "Al coche le est� faltando algo de velocidad en las rectas", DriverComment.MEDIUM_COMMENT_GRADE, -1);
	public static final GPRODriverComment MINOR_DOWN_FW_COMMENT_ES = new GPRODriverComment(CarSetup.FRONTWING_SETUP, "El coche podr�a tener un poco de mayor velocidad en las rectas", DriverComment.MINOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_UP_FW_COMMENT_ES = new GPRODriverComment(CarSetup.FRONTWING_SETUP, "No puedo conducir el coche, no hay control en �l", DriverComment.MAYOR_COMMENT_GRADE, 1);
	public static final GPRODriverComment MEDIUM_UP_FW_COMMENT_ES = new GPRODriverComment(CarSetup.FRONTWING_SETUP, "El coche es muy inestable en muchas curvas", DriverComment.MEDIUM_COMMENT_GRADE, 1);
	public static final GPRODriverComment MINOR_UP_FW_COMMENT_ES = new GPRODriverComment(CarSetup.FRONTWING_SETUP, "Est� faltando un poco de agarre en las curvas", DriverComment.MINOR_COMMENT_GRADE, 1);

	public static final GPRODriverComment SATISFIED_RW_COMMENT_ES = new GPRODriverComment(CarSetup.REARWING_SETUP, "Perfecto", DriverComment.SATISFIED_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_DOWN_RW_COMMENT_ES = new GPRODriverComment(CarSetup.REARWING_SETUP, "Realmente est� faltando mucha velocidad en las rectas", DriverComment.MAYOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MEDIUM_DOWN_RW_COMMENT_ES = new GPRODriverComment(CarSetup.REARWING_SETUP, "Al coche le est� faltando algo de velocidad en las rectas", DriverComment.MEDIUM_COMMENT_GRADE, -1);
	public static final GPRODriverComment MINOR_DOWN_RW_COMMENT_ES = new GPRODriverComment(CarSetup.REARWING_SETUP, "El coche podr�a tener un poco de mayor velocidad en las rectas", DriverComment.MINOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_UP_RW_COMMENT_ES = new GPRODriverComment(CarSetup.REARWING_SETUP, "No puedo conducir el coche, no hay control en �l", DriverComment.MAYOR_COMMENT_GRADE, 1);
	public static final GPRODriverComment MEDIUM_UP_RW_COMMENT_ES = new GPRODriverComment(CarSetup.REARWING_SETUP, "El coche es muy inestable en muchas curvas", DriverComment.MEDIUM_COMMENT_GRADE, 1);
	public static final GPRODriverComment MINOR_UP_RW_COMMENT_ES = new GPRODriverComment(CarSetup.REARWING_SETUP, "Est� faltando un poco de agarre en las curvas", DriverComment.MINOR_COMMENT_GRADE, 1);
	public static final ArrayList<GPRODriverComment> WINGS_COMMENTS = new ArrayList<GPRODriverComment>(12);

	/**
	 * ENGINE COMMENTS ENGLISH
	 */
	public static final GPRODriverComment SATISFIED_EN_COMMENT = new GPRODriverComment(CarSetup.ENGINE_SETUP, "Satisfied", DriverComment.SATISFIED_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_DOWN_EN_COMMENT = new GPRODriverComment(CarSetup.ENGINE_SETUP, "No, no, no!!! Favor a lot more the low revs!", DriverComment.MAYOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MEDIUM_DOWN_EN_COMMENT = new GPRODriverComment(CarSetup.ENGINE_SETUP, "The engine revs are too high", DriverComment.MEDIUM_COMMENT_GRADE, -1);
	public static final GPRODriverComment MINOR_DOWN_EN_COMMENT = new GPRODriverComment(CarSetup.ENGINE_SETUP, "Try to favor a bit more the low revs", DriverComment.MINOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_UP_EN_COMMENT = new GPRODriverComment(CarSetup.ENGINE_SETUP, "You should try to favor a lot more the high revs", DriverComment.MAYOR_COMMENT_GRADE, 1);
	public static final GPRODriverComment MEDIUM_UP_EN_COMMENT = new GPRODriverComment(CarSetup.ENGINE_SETUP, "The engine power on the straights is not sufficient", DriverComment.MEDIUM_COMMENT_GRADE, 1);
	public static final GPRODriverComment MINOR_UP_EN_COMMENT = new GPRODriverComment(CarSetup.ENGINE_SETUP, "I feel that I do not have enough engine power in the straights", DriverComment.MINOR_COMMENT_GRADE, 1);

	/**
	 * ENGINE COMMENTS SPANISH
	 */
	public static final GPRODriverComment SATISFIED_EN_COMMENT_ES = new GPRODriverComment(CarSetup.ENGINE_SETUP, "Perfecto", DriverComment.SATISFIED_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_DOWN_EN_COMMENT_ES = new GPRODriverComment(CarSetup.ENGINE_SETUP, "No, no, no! A favor de una mucho m�s baja las revoluciones!", DriverComment.MAYOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MEDIUM_DOWN_EN_COMMENT_ES = new GPRODriverComment(CarSetup.ENGINE_SETUP, "Las revoluciones del motor son muy altas", DriverComment.MEDIUM_COMMENT_GRADE, -1);
	public static final GPRODriverComment MINOR_DOWN_EN_COMMENT_ES = new GPRODriverComment(CarSetup.ENGINE_SETUP, "Intenta favorecer un poco m�s las revoluciones bajas", DriverComment.MINOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_UP_EN_COMMENT_ES = new GPRODriverComment(CarSetup.ENGINE_SETUP, "Debes de favorecer mucho m�s las altas revoluciones", DriverComment.MAYOR_COMMENT_GRADE, 1);
	public static final GPRODriverComment MEDIUM_UP_EN_COMMENT_ES = new GPRODriverComment(CarSetup.ENGINE_SETUP, "La potencia del motor en las rectas no es suficiente", DriverComment.MEDIUM_COMMENT_GRADE, 1);
	public static final GPRODriverComment MINOR_UP_EN_COMMENT_ES = new GPRODriverComment(CarSetup.ENGINE_SETUP, "Pienso que no tengo suficiente potencia del motor en las rectas", DriverComment.MINOR_COMMENT_GRADE, 1);
	public static final ArrayList<GPRODriverComment> ENGINE_COMMENTS = new ArrayList<GPRODriverComment>(12);

	/**
	 * BRAKES COMMENTS ENGLISH
	 */
	public static final GPRODriverComment SATISFIED_BR_COMMENT = new GPRODriverComment(CarSetup.BRAKES_SETUP, "Satisfied", DriverComment.SATISFIED_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_DOWN_BR_COMMENT = new GPRODriverComment(CarSetup.BRAKES_SETUP, "Please, move the balance a lot more to the back", DriverComment.MAYOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MEDIUM_DOWN_BR_COMMENT = new GPRODriverComment(CarSetup.BRAKES_SETUP, "I think the brakes effectiveness could be higher if we move the balance to the back", DriverComment.MEDIUM_COMMENT_GRADE, -1);
	public static final GPRODriverComment MINOR_DOWN_BR_COMMENT = new GPRODriverComment(CarSetup.BRAKES_SETUP, "Put the balance a bit more to the back", DriverComment.MINOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_UP_BR_COMMENT = new GPRODriverComment(CarSetup.BRAKES_SETUP, "I would feel a lot more comfortable to move the balance to the front", DriverComment.MAYOR_COMMENT_GRADE, 1);
	public static final GPRODriverComment MEDIUM_UP_BR_COMMENT = new GPRODriverComment(CarSetup.BRAKES_SETUP, "I think the brakes effectiveness could be higher if we move the balance to the front", DriverComment.MEDIUM_COMMENT_GRADE, 1);
	public static final GPRODriverComment MINOR_UP_BR_COMMENT = new GPRODriverComment(CarSetup.BRAKES_SETUP, "I would like to have the balance a bit more to the front", DriverComment.MINOR_COMMENT_GRADE, 1);

	/**
	 * BRAKES COMMENTS SPANISH
	 */
	public static final GPRODriverComment SATISFIED_BR_COMMENT_ES = new GPRODriverComment(CarSetup.BRAKES_SETUP, "Perfecto", DriverComment.SATISFIED_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_DOWN_BR_COMMENT_ES = new GPRODriverComment(CarSetup.BRAKES_SETUP, "Por favor, mueve el balance mucho m�s hacia atras", DriverComment.MAYOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MEDIUM_DOWN_BR_COMMENT_ES = new GPRODriverComment(CarSetup.BRAKES_SETUP, "Creo que la efectividad de los frenos podr�a ser mejor si movemos el balance hacia atras", DriverComment.MEDIUM_COMMENT_GRADE, -1);
	public static final GPRODriverComment MINOR_DOWN_BR_COMMENT_ES = new GPRODriverComment(CarSetup.BRAKES_SETUP, "Pon el balance un poco m�s hacia atras", DriverComment.MINOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_UP_BR_COMMENT_ES = new GPRODriverComment(CarSetup.BRAKES_SETUP, "Me sentir�a mucho m�s c�modo para mover la balanza hacia el frente", DriverComment.MAYOR_COMMENT_GRADE, 1);
	public static final GPRODriverComment MEDIUM_UP_BR_COMMENT_ES = new GPRODriverComment(CarSetup.BRAKES_SETUP, "Creo que la efectividad de los frenos podr�a ser mejor si movemos el balance hacia adelante", DriverComment.MEDIUM_COMMENT_GRADE, 1);
	public static final GPRODriverComment MINOR_UP_BR_COMMENT_ES = new GPRODriverComment(CarSetup.BRAKES_SETUP, "Deseo tener el balance un poco m�s hacia adelante", DriverComment.MINOR_COMMENT_GRADE, 1);
	public static final ArrayList<GPRODriverComment> BRAKES_COMMENTS = new ArrayList<GPRODriverComment>(12);

	/**
	 * GEARBOX COMMENTS ENGLISH
	 */
	public static final GPRODriverComment SATISFIED_GE_COMMENT = new GPRODriverComment(CarSetup.GEARBOX_SETUP, "Satisfied", DriverComment.SATISFIED_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_DOWN_GE_COMMENT = new GPRODriverComment(CarSetup.GEARBOX_SETUP, "Please, put a lot lower ratio between gears", DriverComment.MAYOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MEDIUM_DOWN_GE_COMMENT = new GPRODriverComment(CarSetup.GEARBOX_SETUP, "The gear ratio is too high", DriverComment.MEDIUM_COMMENT_GRADE, -1);
	public static final GPRODriverComment MINOR_DOWN_GE_COMMENT = new GPRODriverComment(CarSetup.GEARBOX_SETUP, "I cannot take advantage of the power of the engine. Put the gear ratio a bit lower", DriverComment.MINOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_UP_GE_COMMENT = new GPRODriverComment(CarSetup.GEARBOX_SETUP, "It feels like the engine is going to explode. Put a lot higher ratio between gears", DriverComment.MAYOR_COMMENT_GRADE, 1);
	public static final GPRODriverComment MEDIUM_UP_GE_COMMENT = new GPRODriverComment(CarSetup.GEARBOX_SETUP, "The gear ratio is too low", DriverComment.MEDIUM_COMMENT_GRADE, 1);
	public static final GPRODriverComment MINOR_UP_GE_COMMENT = new GPRODriverComment(CarSetup.GEARBOX_SETUP, "I am very often in the red. Put the gear ratio a bit higher", DriverComment.MINOR_COMMENT_GRADE, 1);

	/**
	 * GEARBOX COMMENTS SPANISH
	 */
	public static final GPRODriverComment SATISFIED_GE_COMMENT_ES = new GPRODriverComment(CarSetup.GEARBOX_SETUP, "Perfecto", DriverComment.SATISFIED_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_DOWN_GE_COMMENT_ES = new GPRODriverComment(CarSetup.GEARBOX_SETUP, "Por favor, disminuye la diferencia entre cambios", DriverComment.MAYOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MEDIUM_DOWN_GE_COMMENT_ES = new GPRODriverComment(CarSetup.GEARBOX_SETUP, "La diferencia de cambios es muy alta", DriverComment.MEDIUM_COMMENT_GRADE, -1);
	public static final GPRODriverComment MINOR_DOWN_GE_COMMENT_ES = new GPRODriverComment(CarSetup.GEARBOX_SETUP, "No puedo tomar ventaja de la potencia del motor. Pon la diferencia de cambios un poco m�s baja", DriverComment.MINOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_UP_GE_COMMENT_ES = new GPRODriverComment(CarSetup.GEARBOX_SETUP, "Parece como que el motor fuera a explotar. Pon una mayor diferencia de cambios", DriverComment.MAYOR_COMMENT_GRADE, 1);
	public static final GPRODriverComment MEDIUM_UP_GE_COMMENT_ES = new GPRODriverComment(CarSetup.GEARBOX_SETUP, "La diferencia de cambios es muy baja", DriverComment.MEDIUM_COMMENT_GRADE, 1);
	public static final GPRODriverComment MINOR_UP_GE_COMMENT_ES = new GPRODriverComment(CarSetup.GEARBOX_SETUP, "Estoy muy frecuentemente sobre lo rojo. Pon la diferencia de cambios un poco m�s alta", DriverComment.MINOR_COMMENT_GRADE, 1);
	public static final ArrayList<GPRODriverComment> GEARBOX_COMMENTS = new ArrayList<GPRODriverComment>(12);

	/**
	 * SUSPENSION COMMENTS ENGLISH
	 */
	public static final GPRODriverComment SATISFIED_SU_COMMENT = new GPRODriverComment(CarSetup.SUSPENSION_SETUP, "Satisfied", DriverComment.SATISFIED_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_DOWN_SU_COMMENT = new GPRODriverComment(CarSetup.SUSPENSION_SETUP, "The car is far too rigid. Lower a lot the rigidity", DriverComment.MAYOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MEDIUM_DOWN_SU_COMMENT = new GPRODriverComment(CarSetup.SUSPENSION_SETUP, "The suspension rigidity is too high", DriverComment.MEDIUM_COMMENT_GRADE, -1);
	public static final GPRODriverComment MINOR_DOWN_SU_COMMENT = new GPRODriverComment(CarSetup.SUSPENSION_SETUP, "The car is too rigid. Lower a bit the rigidity", DriverComment.MINOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_UP_SU_COMMENT = new GPRODriverComment(CarSetup.SUSPENSION_SETUP, "The suspension rigidity should be a lot higher", DriverComment.MAYOR_COMMENT_GRADE, 1);
	public static final GPRODriverComment MEDIUM_UP_SU_COMMENT = new GPRODriverComment(CarSetup.SUSPENSION_SETUP, "The suspension rigidity is too low", DriverComment.MEDIUM_COMMENT_GRADE, 1);
	public static final GPRODriverComment MINOR_UP_SU_COMMENT = new GPRODriverComment(CarSetup.SUSPENSION_SETUP, "I think with a bit more rigid suspension I will be able to go faster", DriverComment.MINOR_COMMENT_GRADE, 1);

	/**
	 * SUSPENSION COMMENTS SPANISH
	 */
	public static final GPRODriverComment SATISFIED_SU_COMMENT_ES = new GPRODriverComment(CarSetup.SUSPENSION_SETUP, "Perfecto", DriverComment.SATISFIED_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_DOWN_SU_COMMENT_ES = new GPRODriverComment(CarSetup.SUSPENSION_SETUP, "El coche est� muy r�gido. Baja mucho la rigidez", DriverComment.MAYOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MEDIUM_DOWN_SU_COMMENT_ES = new GPRODriverComment(CarSetup.SUSPENSION_SETUP, "La rigidez de la suspensi�n es muy alta", DriverComment.MEDIUM_COMMENT_GRADE, -1);
	public static final GPRODriverComment MINOR_DOWN_SU_COMMENT_ES = new GPRODriverComment(CarSetup.SUSPENSION_SETUP, "El coche est� muy r�gido. Baja un poco la rigidez", DriverComment.MINOR_COMMENT_GRADE, -1);
	public static final GPRODriverComment MAYOR_UP_SU_COMMENT_ES = new GPRODriverComment(CarSetup.SUSPENSION_SETUP, "La rigidez de la suspensi�n deber�a ser mucho m�s alta", DriverComment.MAYOR_COMMENT_GRADE, 1);
	public static final GPRODriverComment MEDIUM_UP_SU_COMMENT_ES = new GPRODriverComment(CarSetup.SUSPENSION_SETUP, "La rigidez de la suspensi�n es muy baja", DriverComment.MEDIUM_COMMENT_GRADE, 1);
	public static final GPRODriverComment MINOR_UP_SU_COMMENT_ES = new GPRODriverComment(CarSetup.SUSPENSION_SETUP, "Creo que con una suspensi�n m�s r�gida ser�a capaz de ir m�s r�pido", DriverComment.MINOR_COMMENT_GRADE, 1);
	public static final ArrayList<GPRODriverComment> SUSPENSION_COMMENTS = new ArrayList<GPRODriverComment>(12);

	/**
	 * ALL SATISFIED COMMENTS MAP
	 */
	public static final HashMap<String, DriverComment> ALL_SATISFIED_COMMENTS = new HashMap<String, DriverComment>();

	/**
	 * CAR PARTS GROUP COMMENTS MAP
	 */

	public static final HashMap<String, ArrayList<GPRODriverComment>> CAR_PARTS_GROUP_COMMENTS = new HashMap<String, ArrayList<GPRODriverComment>>();

	public static final HashMap<String, String> CAR_SETUP_PARTS_DESCRIPTIONS_EN = new HashMap<String, String>();
	public static final HashMap<String, String> CAR_SETUP_PARTS_DESCRIPTIONS_ES = new HashMap<String, String>();
	public static final Map<ILanguage, Map<String, String>> CAR_SETUP_PARTS_DESCRIPTIONS = new HashMap<ILanguage, Map<String, String>>();

	static {
		ALL_SATISFIED_COMMENTS.put(CarSetup.FRONTWING_SETUP, SATISFIED_FW_COMMENT);
		ALL_SATISFIED_COMMENTS.put(CarSetup.REARWING_SETUP, SATISFIED_RW_COMMENT);
		ALL_SATISFIED_COMMENTS.put(CarSetup.ENGINE_SETUP, SATISFIED_EN_COMMENT);
		ALL_SATISFIED_COMMENTS.put(CarSetup.BRAKES_SETUP, SATISFIED_BR_COMMENT);
		ALL_SATISFIED_COMMENTS.put(CarSetup.GEARBOX_SETUP, SATISFIED_GE_COMMENT);
		ALL_SATISFIED_COMMENTS.put(CarSetup.SUSPENSION_SETUP, SATISFIED_SU_COMMENT);

		//WINGS COMMENTS ENGLISH
		WINGS_COMMENTS.add(MINOR_DOWN_FW_COMMENT);
		WINGS_COMMENTS.add(MINOR_UP_FW_COMMENT);
		WINGS_COMMENTS.add(MEDIUM_DOWN_FW_COMMENT);
		WINGS_COMMENTS.add(MEDIUM_UP_FW_COMMENT);
		WINGS_COMMENTS.add(MAYOR_DOWN_FW_COMMENT);
		WINGS_COMMENTS.add(MAYOR_UP_FW_COMMENT);
		//WINGS COMMENTS SPANISH
		WINGS_COMMENTS.add(MINOR_DOWN_FW_COMMENT_ES);
		WINGS_COMMENTS.add(MINOR_UP_FW_COMMENT_ES);
		WINGS_COMMENTS.add(MEDIUM_DOWN_FW_COMMENT_ES);
		WINGS_COMMENTS.add(MEDIUM_UP_FW_COMMENT_ES);
		WINGS_COMMENTS.add(MAYOR_DOWN_FW_COMMENT_ES);
		WINGS_COMMENTS.add(MAYOR_UP_FW_COMMENT_ES);

		//ENGINE COMMENTS ENGLISH
		ENGINE_COMMENTS.add(MINOR_DOWN_EN_COMMENT);
		ENGINE_COMMENTS.add(MINOR_UP_EN_COMMENT);
		ENGINE_COMMENTS.add(MEDIUM_DOWN_EN_COMMENT);
		ENGINE_COMMENTS.add(MEDIUM_UP_EN_COMMENT);
		ENGINE_COMMENTS.add(MAYOR_DOWN_EN_COMMENT);
		ENGINE_COMMENTS.add(MAYOR_UP_EN_COMMENT);
		//ENGINE COMMENTS SPANISH
		ENGINE_COMMENTS.add(MINOR_DOWN_EN_COMMENT_ES);
		ENGINE_COMMENTS.add(MINOR_UP_EN_COMMENT_ES);
		ENGINE_COMMENTS.add(MEDIUM_DOWN_EN_COMMENT_ES);
		ENGINE_COMMENTS.add(MEDIUM_UP_EN_COMMENT_ES);
		ENGINE_COMMENTS.add(MAYOR_DOWN_EN_COMMENT_ES);
		ENGINE_COMMENTS.add(MAYOR_UP_EN_COMMENT_ES);

		//BRAKES COMMENTS ENGLISH
		BRAKES_COMMENTS.add(MINOR_DOWN_BR_COMMENT);
		BRAKES_COMMENTS.add(MINOR_UP_BR_COMMENT);
		BRAKES_COMMENTS.add(MEDIUM_DOWN_BR_COMMENT);
		BRAKES_COMMENTS.add(MEDIUM_UP_BR_COMMENT);
		BRAKES_COMMENTS.add(MAYOR_DOWN_BR_COMMENT);
		BRAKES_COMMENTS.add(MAYOR_UP_BR_COMMENT);
		//BRAKES COMMENTS SPANISH
		BRAKES_COMMENTS.add(MINOR_DOWN_BR_COMMENT_ES);
		BRAKES_COMMENTS.add(MINOR_UP_BR_COMMENT_ES);
		BRAKES_COMMENTS.add(MEDIUM_DOWN_BR_COMMENT_ES);
		BRAKES_COMMENTS.add(MEDIUM_UP_BR_COMMENT_ES);
		BRAKES_COMMENTS.add(MAYOR_DOWN_BR_COMMENT_ES);
		BRAKES_COMMENTS.add(MAYOR_UP_BR_COMMENT_ES);

		//GEARBOX COMMENTS ENGLISH
		GEARBOX_COMMENTS.add(MINOR_DOWN_GE_COMMENT);
		GEARBOX_COMMENTS.add(MINOR_UP_GE_COMMENT);
		GEARBOX_COMMENTS.add(MEDIUM_DOWN_GE_COMMENT);
		GEARBOX_COMMENTS.add(MEDIUM_UP_GE_COMMENT);
		GEARBOX_COMMENTS.add(MAYOR_DOWN_GE_COMMENT);
		GEARBOX_COMMENTS.add(MAYOR_UP_GE_COMMENT);
		//GEARBOX COMMENTS SPANISH
		GEARBOX_COMMENTS.add(MINOR_DOWN_GE_COMMENT_ES);
		GEARBOX_COMMENTS.add(MINOR_UP_GE_COMMENT_ES);
		GEARBOX_COMMENTS.add(MEDIUM_DOWN_GE_COMMENT_ES);
		GEARBOX_COMMENTS.add(MEDIUM_UP_GE_COMMENT_ES);
		GEARBOX_COMMENTS.add(MAYOR_DOWN_GE_COMMENT_ES);
		GEARBOX_COMMENTS.add(MAYOR_UP_GE_COMMENT_ES);

		//SUSPENSION COMMENTS ENGLISH
		SUSPENSION_COMMENTS.add(MINOR_DOWN_SU_COMMENT);
		SUSPENSION_COMMENTS.add(MINOR_UP_SU_COMMENT);
		SUSPENSION_COMMENTS.add(MEDIUM_DOWN_SU_COMMENT);
		SUSPENSION_COMMENTS.add(MEDIUM_UP_SU_COMMENT);
		SUSPENSION_COMMENTS.add(MAYOR_DOWN_SU_COMMENT);
		SUSPENSION_COMMENTS.add(MAYOR_UP_SU_COMMENT);
		//SUSPENSION COMMENTS SPANISH
		SUSPENSION_COMMENTS.add(MINOR_DOWN_SU_COMMENT_ES);
		SUSPENSION_COMMENTS.add(MINOR_UP_SU_COMMENT_ES);
		SUSPENSION_COMMENTS.add(MEDIUM_DOWN_SU_COMMENT_ES);
		SUSPENSION_COMMENTS.add(MEDIUM_UP_SU_COMMENT_ES);
		SUSPENSION_COMMENTS.add(MAYOR_DOWN_SU_COMMENT_ES);
		SUSPENSION_COMMENTS.add(MAYOR_UP_SU_COMMENT_ES);

		//CAR PARTS GROUP COMMENTS MAP ENGLISH
		CAR_PARTS_GROUP_COMMENTS.put("Wings", WINGS_COMMENTS);
		CAR_PARTS_GROUP_COMMENTS.put("Engine", ENGINE_COMMENTS);
		CAR_PARTS_GROUP_COMMENTS.put("Brakes", BRAKES_COMMENTS);
		CAR_PARTS_GROUP_COMMENTS.put("Gear", GEARBOX_COMMENTS);
		CAR_PARTS_GROUP_COMMENTS.put("Suspension", SUSPENSION_COMMENTS);
		//CAR PARTS GROUP COMMENTS MAP SPANISH
		CAR_PARTS_GROUP_COMMENTS.put("Alerones", WINGS_COMMENTS);
		CAR_PARTS_GROUP_COMMENTS.put("Motor", ENGINE_COMMENTS);
		CAR_PARTS_GROUP_COMMENTS.put("Frenos", BRAKES_COMMENTS);
		CAR_PARTS_GROUP_COMMENTS.put("Caja", GEARBOX_COMMENTS);
		CAR_PARTS_GROUP_COMMENTS.put("Suspensi�n", SUSPENSION_COMMENTS);

		CAR_SETUP_PARTS_DESCRIPTIONS_EN.put(CarSetup.FRONTWING_SETUP, "Wings");
		CAR_SETUP_PARTS_DESCRIPTIONS_EN.put(CarSetup.ENGINE_SETUP, "Engine");
		CAR_SETUP_PARTS_DESCRIPTIONS_EN.put(CarSetup.BRAKES_SETUP, "Brakes");
		CAR_SETUP_PARTS_DESCRIPTIONS_EN.put(CarSetup.GEARBOX_SETUP, "Gear");
		CAR_SETUP_PARTS_DESCRIPTIONS_EN.put(CarSetup.SUSPENSION_SETUP, "Suspension");
		CAR_SETUP_PARTS_DESCRIPTIONS_EN.put(ConstantesLanguages.SATISFIED_SETUP_KEY, "I am satisfied with the setup of the car");
		CAR_SETUP_PARTS_DESCRIPTIONS_EN.put(ConstantesLanguages.NO_PERFECT_SETUP_FOUND_KEY, "No perfect setup found!");
		CAR_SETUP_PARTS_DESCRIPTIONS_EN.put(ConstantesLanguages.PRACTICE_LAP_KEY, "Practice lap");
		CAR_SETUP_PARTS_DESCRIPTIONS_EN.put(ConstantesLanguages.COMMENTS_DRIVER_KEY, "comments from your driver");


		CAR_SETUP_PARTS_DESCRIPTIONS_ES.put(CarSetup.FRONTWING_SETUP, "Alerones");
		CAR_SETUP_PARTS_DESCRIPTIONS_ES.put(CarSetup.ENGINE_SETUP, "Motor");
		CAR_SETUP_PARTS_DESCRIPTIONS_ES.put(CarSetup.BRAKES_SETUP, "Frenos");
		CAR_SETUP_PARTS_DESCRIPTIONS_ES.put(CarSetup.GEARBOX_SETUP, "Caja");
		CAR_SETUP_PARTS_DESCRIPTIONS_ES.put(CarSetup.SUSPENSION_SETUP, "Suspensi�n");
		CAR_SETUP_PARTS_DESCRIPTIONS_ES.put(ConstantesLanguages.SATISFIED_SETUP_KEY, "Estoy satisfecho con la configuraci�n del coche");
		CAR_SETUP_PARTS_DESCRIPTIONS_ES.put(ConstantesLanguages.NO_PERFECT_SETUP_FOUND_KEY, "�No hay un setup perfecto!");
		CAR_SETUP_PARTS_DESCRIPTIONS_ES.put(ConstantesLanguages.PRACTICE_LAP_KEY, "Vuelta");
		CAR_SETUP_PARTS_DESCRIPTIONS_ES.put(ConstantesLanguages.COMMENTS_DRIVER_KEY, "comentarios de tu piloto");

		CAR_SETUP_PARTS_DESCRIPTIONS.put(ConstantesLanguages.INGLES, CAR_SETUP_PARTS_DESCRIPTIONS_EN);
		CAR_SETUP_PARTS_DESCRIPTIONS.put(ConstantesLanguages.ESPAÑOL, CAR_SETUP_PARTS_DESCRIPTIONS_ES);

	}


	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = -7399411191190597454L;

	public GPRODriverComment(String carPart, String commentDescription, int commentGrade, int commentSign) {
		this.carPart = carPart;
		this.commentDescription = commentDescription;
		this.commentGrade = commentGrade;
		this.commentSign = commentSign;
	}

	/**
	 * @return the carPart
	 */
	public String getCarPart() {
		return carPart;
	}

	/**
	 * @return the commentDescription
	 */
	public String getCommentDescription() {
		return commentDescription;
	}

	/**
	 * @return the commentGrade
	 */
	public int getCommentGrade() {
		return commentGrade;
	}

	/**
	 * @return the commentSign
	 */
	public int getCommentSignum() {
		return commentSign;
	}

	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.getCarPart() + ": " + this.getCommentDescription();
	}

}
