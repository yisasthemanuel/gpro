package org.jlobato.gpro.languages;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.swing.ImageIcon;

public class ConstantesLanguages {

	/**
	 * Constante para el inglés
	 */
	public final static ILanguage INGLES = new DefaultLanguage("inglés", "Home", "Inglés", Locale.ENGLISH, new ImageIcon(ConstantesLanguages.class.getResource("gb.gif")));

	/**
	 * Constante para el español
	 */
	public final static ILanguage ESPAÑOL = new DefaultLanguage("español", "Inicio", "Español", new Locale("es", "ES"), new ImageIcon(ConstantesLanguages.class.getResource("es.gif")));

	/**
	 * Mapa por defecto de los idiomas disponibles
	 */
	public final static Map<String, ILanguage> AVAILABLE_LANGUAGES = new HashMap<String, ILanguage>();

	/**
	 * Constante para referencia a la frase de que el piloto está satisfecho con el setup
	 */
	public final static String SATISFIED_SETUP_KEY = "driver.setup.satisfied";

	public final static String NO_PERFECT_SETUP_FOUND_KEY = "no.perfect.setup.found";

	public static final String PRACTICE_LAP_KEY = "practice.lap";

	public static final String COMMENTS_DRIVER_KEY = "comments.driver";

	/**
	 * Carga del mapa de idiomas disponibles
	 */
	static {
		AVAILABLE_LANGUAGES.put(INGLES.getKey(), INGLES);
		AVAILABLE_LANGUAGES.put(ESPAÑOL.getKey(), ESPAÑOL);
	}

}
