package org.jlobato.gpro.setup;

import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jlobato.gpro.languages.ConstantesLanguages;
import org.jlobato.gpro.languages.ILanguage;
import org.jlobato.gpro.languages.LanguageManager;

/**
 *
 * @author JLOBATO
 *
 */
public class DriverCommentsParser {

	/**
	 *
	 * @param practiceLap
	 * @return
	 */
	public String getComments(PracticeLap practiceLap) {
		ILanguage userLanguage = SetupUtilityMediator.getInstance().getUsuario().getContextoUsuario().getLanguage();
		//String result = "I am satisfied with the setup of the car";
		String result = LanguageManager.getInstance().getBundle(userLanguage, ConstantesLanguages.SATISFIED_SETUP_KEY);
		HashMap<String, DriverComment> comments = practiceLap.getComms();
		boolean satisfied = true;
		String lineSeparator = System.getProperty("line.separator");
		StringBuffer commentsBuffer = new StringBuffer();
		//TODO Crear la entidad CarPart para el tipo de cosas: parte, descripción, etc. Como Enumerado
		//TODO Que dicha entidad devuelva una enumeración ordenada del orden de procesamiento de las partes
		//Wings
		DriverComment comment = (DriverComment)comments.get(CarSetup.FRONTWING_SETUP);
		if (comment.getCommentGrade() != DriverComment.SATISFIED_COMMENT_GRADE) {
			String carPartBundle = LanguageManager.getInstance().getBundle(userLanguage, CarSetup.FRONTWING_SETUP);
			commentsBuffer.append(carPartBundle + ": " + comment.getCommentDescription() + lineSeparator);
			satisfied = false;
		}

		//Engine
		comment = (DriverComment)comments.get(CarSetup.ENGINE_SETUP);
		if (comment.getCommentGrade() != DriverComment.SATISFIED_COMMENT_GRADE) {
			String carPartBundle = LanguageManager.getInstance().getBundle(userLanguage, CarSetup.ENGINE_SETUP);
			commentsBuffer.append(carPartBundle + ": " + comment.getCommentDescription() + lineSeparator);
			satisfied = false;
		}

		//Brakes
		comment = (DriverComment)comments.get(CarSetup.BRAKES_SETUP);
		if (comment.getCommentGrade() != DriverComment.SATISFIED_COMMENT_GRADE) {
			String carPartBundle = LanguageManager.getInstance().getBundle(userLanguage, CarSetup.BRAKES_SETUP);
			commentsBuffer.append(carPartBundle + ": " + comment.getCommentDescription() + lineSeparator);
			satisfied = false;
		}

		//Gearbox
		comment = (DriverComment)comments.get(CarSetup.GEARBOX_SETUP);
		if (comment.getCommentGrade() != DriverComment.SATISFIED_COMMENT_GRADE) {
			String carPartBundle = LanguageManager.getInstance().getBundle(userLanguage, CarSetup.GEARBOX_SETUP);
			commentsBuffer.append(carPartBundle + ": " + comment.getCommentDescription() + lineSeparator);
			satisfied = false;
		}

		//Suspension
		comment = (DriverComment)comments.get(CarSetup.SUSPENSION_SETUP);
		if (comment.getCommentGrade() != DriverComment.SATISFIED_COMMENT_GRADE) {
			String carPartBundle = LanguageManager.getInstance().getBundle(userLanguage, CarSetup.SUSPENSION_SETUP);
			commentsBuffer.append(carPartBundle + ": " + comment.getCommentDescription() + lineSeparator);
			satisfied = false;
		}
		if (!satisfied) {
			int from = commentsBuffer.lastIndexOf(lineSeparator);
			commentsBuffer.delete(from, commentsBuffer.length());
			result = commentsBuffer.toString();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	/**
	 *
	 */
	public HashMap<String, DriverComment> getComments(LineNumberReader reader) throws IOException {
		HashMap<String, DriverComment> result = (HashMap<String, DriverComment>) GPRODriverComment.ALL_SATISFIED_COMMENTS.clone();

		//Primero descomponemos la cadena en cada salto de línea que tenga
		String line = null;
		//Recorremos cada linea encontrada. Si no contiene los dos puntos, la ignoramos complentamente
		//Si contiene los dos puntos, descomponemos la cadena utilizando los dos puntos como separador
		while ((line = reader.readLine()) != null) {
			if (line.indexOf(":") != -1) {
				String[] comments = line.split(":");
				//Debe haber 2 cadenas justas. Si no es así, pasamos
				if (comments.length == 2) {
					//La primera cadena corresponde a la parte del coche afectada
					String carPartComment = comments[0].trim();
					//La segunda cadena corresponde al comentario del piloto
					String driverComment = comments[1].trim();
					//Obtenemos la lista de comentarios posibles para esa parte
					List<DriverComment> carPartCommsAvailable = (List)GPRODriverComment.CAR_PARTS_GROUP_COMMENTS.get(carPartComment);
					if (carPartCommsAvailable != null) {
						//Recoremos es lista buscando el comentario concreto
						boolean found = false;
						Iterator<DriverComment> iterator = carPartCommsAvailable.iterator();
						while (iterator.hasNext() && !found) {
							DriverComment current = iterator.next();
							//Si el comentario coincide, ya hemos dado con la tecla
							if (driverComment.equals(current.getCommentDescription())) {
								found = true;
								//Modificamos la lista para que incluya el comentario
								result.put(current.getCarPart(), current);
							}
						}
					}
				}
			}
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	/**
	 *
	 */
	public HashMap<String, DriverComment> getComments(String stringComments) {
		HashMap<String, DriverComment> result = (HashMap<String, DriverComment>)GPRODriverComment.ALL_SATISFIED_COMMENTS.clone();

		//Primero descomponemos la cadena en cada salto de línea que tenga
		String[] lines = stringComments.split(System.getProperty("line.separator"));
		//Recorremos cada linea encontrada. Si no contiene los dos puntos, la ignoramos complentamente
		//Si contiene los dos puntos, descomponemos la cadena utilizando los dos puntos como separador
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			if (line.indexOf(":") != -1) {
				String[] comments = line.split(":");
				//La primera cadena corresponde a la parte del coche afectada
				String carPartComment = comments[0].trim();
				//La segunda cadena corresponde al comentario del piloto
				String driverComment = comments[1].trim();
				//Obtenemos la lista de comentarios posibles para esa parte
				List<DriverComment> carPartCommsAvailable = (List)GPRODriverComment.CAR_PARTS_GROUP_COMMENTS.get(carPartComment);
				//Recoremos es lista buscando el comentario concreto
				boolean found = false;
				Iterator<DriverComment> iterator = carPartCommsAvailable.iterator();
				while (iterator.hasNext() && !found) {
					DriverComment current = iterator.next();
					//Si el comentario coincide, ya hemos dado con la tecla
					if (driverComment.equals(current.getCommentDescription())) {
						found = true;
						//Modificamos la lista para que incluya el comentario
						result.put(current.getCarPart(), current);
					}
				}
			}
		}

		return result;
	}
}
