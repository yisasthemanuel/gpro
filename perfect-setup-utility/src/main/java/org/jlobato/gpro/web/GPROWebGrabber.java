package org.jlobato.gpro.web;

import java.util.Iterator;

import org.jlobato.gpro.forecast.RaceForecastController;
import org.jlobato.gpro.forecast.RaceForecastWebGrabber;
import org.jlobato.gpro.languages.ConstantesLanguages;
import org.jlobato.gpro.languages.ILanguage;
import org.jlobato.gpro.languages.LanguageManager;
import org.jlobato.gpro.setup.GPRODriverComment;

import net.sourceforge.jwebunit.junit.WebTester;

public abstract class GPROWebGrabber {
	
	private static final String PASSWORD_FIELD_NAME = "textPassword";
	private static final String LOGIN_FIELD_NAME = "textLogin";
	private static final String SUBMIT_BUTTON_LABEL = "Submit2";
	private static final String TITLE_LABEL = "title";
	
	public static final String NEW_STYLE_ALT_PRESENT = "";
	public static final String NEW_STYLE_IMAGE_PRESENT = "/images/xdriver.gif";
	
	
	String url;
	String password;
	String username;
	boolean logged;
	ILanguage language;
	boolean newStyle;
	
	public WebTester tester;

	
	public GPROWebGrabber(String url, String username, String password) {
		this.password = password;
		this.url = url;
		this.username = username;
		this.tester = new WebTester();
		this.logged = false;
		this.newStyle = false;
		
		//Configuración de los idiomas disponibles
		LanguageManager.getInstance(ConstantesLanguages.AVAILABLE_LANGUAGES, GPRODriverComment.CAR_SETUP_PARTS_DESCRIPTIONS);
		LanguageManager.getInstance().addBundles(ConstantesLanguages.ESPAÑOL, RaceForecastWebGrabber.WEB_GRABBER_TOKENS_ES);
		LanguageManager.getInstance().addBundles(ConstantesLanguages.INGLES, RaceForecastWebGrabber.WEB_GRABBER_TOKENS_EN);
		LanguageManager.getInstance().addBundles(ConstantesLanguages.ESPAÑOL, RaceForecastController.RACE_FORECAST_TOKENS_ES);
		LanguageManager.getInstance().addBundles(ConstantesLanguages.INGLES, RaceForecastController.RACE_FORECAST_TOKENS_EN);
		
	}
	
	/**
	 * 
	 */
	public void login() {
		tester.setScriptingEnabled(false);
		tester.beginAt(this.url);
		tester.assertButtonPresent(SUBMIT_BUTTON_LABEL);
		
		tester.setTextField(LOGIN_FIELD_NAME, this.username);
		tester.setTextField(PASSWORD_FIELD_NAME, this.password);
		
		tester.submit();
		
		this.language = getLanguage(tester);
		
		//Aquí es donde va el tema de si el usuario utiliza o no el nuevo estilo de la web
		try {
			tester.assertImagePresentPartial(NEW_STYLE_IMAGE_PRESENT, NEW_STYLE_ALT_PRESENT);
			//Si la imagen está presente el usuario tiene configurado el estilo nuevo de web
			newStyle = true;
		} catch(Throwable e) {
			e.printStackTrace();
		}
		
		//tester.dumpHtml(System.out);
		
	}
	
	/**
	 * 
	 * @param tester
	 * @return
	 */
	private ILanguage getLanguage(WebTester tester) {
		ILanguage result = null;
		boolean found = false;

		Iterator<ILanguage> languages = LanguageManager.getInstance().getLanguages();

		while (languages.hasNext() && !found) {
			ILanguage language = languages.next();
			try {
				tester.assertLinkPresentWithExactText(language.getToken());
				result = language;
				found = true;
			}catch (Throwable t) {
				t.printStackTrace(System.out);
			}
		}
		System.out.println("LANGUAGE SELECCIONADO: " + result.getKey());
		return result;
	}
	
	
	public abstract void doGrab();

	public static void main(String[] args) {
	}

	/**
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isLogged() {
		return logged;
	}

	/**
	 * 
	 * @return
	 */
	public ILanguage getLanguage() {
		return language;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isNewStyle() {
		return newStyle;
	}

}
