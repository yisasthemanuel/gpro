package org.jlobato.gpro.languages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @author JLOBATO
 *
 */
public class LanguageManager {

	/**
	 * Instancia única de esta clase. Patrón Singleton.
	 */
	private static LanguageManager instance;

	private Map<String, ILanguage> languages;

	private Map<ILanguage, Map<String, String>> bundles;
	
	private ILanguage defaultLanguage = ConstantesLanguages.ESPAÑOL;

	/**
	 * Constructor privado. Patrón Singleton.
	 */
	private LanguageManager(Map<String, ILanguage> languages, Map<ILanguage, Map<String, String>> bundles) {
		this.languages = languages;
		this.bundles = bundles;
	}

	/**
	 * Acceso a la instancia única de esta clase
	 * @return
	 */
	public static LanguageManager getInstance() {
		return instance;
	}

	/**
	 * Acceso a la instancia única con configuración previa
	 * @param languages Mapa con los lenguages gestionados por este manager
	 * @return
	 */
	public static LanguageManager getInstance(Map<String, ILanguage> languages, Map<ILanguage, Map<String, String>> bundles) {
		instance = new LanguageManager(languages, bundles);
		return instance;
	}

	/**
	 * Iterador con la lista de idiomas gestionado por este manager
	 * @return
	 */
	public Iterator<ILanguage> getLanguages() {
		return this.languages.values().iterator();
	}

	/**
	 * Se añade este idioma a la lista de idiomas gestionados por este manager
	 * @param language Nuevo idioma que se gestiona
	 */
	public void addLanguage(ILanguage language) {
		this.languages.put(language.getKey(), language);
	}

	/**
	 * Se elimina este idioma de la lista de idiomas gestionados por este manager
	 * @param language Idioma a eliminar
	 */
	public void removeLanguage(ILanguage language) {
		this.languages.remove(language.getKey());
	}

	/**
	 *
	 * @param language
	 * @param key
	 * @return
	 */
	public String getBundle(ILanguage language, String key) {
		String result = null;
		Map<String, String> languageBundles = (Map<String, String>)this.bundles.get(language);
		if (languageBundles != null) {
			result = (String)languageBundles.get(key);
		}
		return result;
	}
	
	/**
	 * 
	 * @param language
	 * @param bundles
	 */
	public void addBundles(ILanguage language, Map<String, String> bundles) {
		if (!isLanguageSupported(language)) {
			throw new IllegalArgumentException("Language '" + language.getKey() + "' not supported");
		}
		
		Map<String, String> languageBundles = (Map<String, String>)this.bundles.get(language);
		if (languageBundles == null) {
			languageBundles = new HashMap<String, String>();
			this.bundles.put(language, bundles);
		}
		else {
			languageBundles.putAll(bundles);
		}
	}
	
	/**
	 * 
	 * @param language
	 * @return
	 */
	public boolean isLanguageSupported(ILanguage language) {
		boolean result = false;
		
		Iterator<ILanguage> itLang = getLanguages();
		
		while(itLang.hasNext() && !result) {
			result = language.equals(itLang.next());
		}
		
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	public ILanguage getDefaultLanguage() {
		return defaultLanguage;
	}

}
