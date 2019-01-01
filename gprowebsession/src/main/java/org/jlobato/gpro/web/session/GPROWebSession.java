package org.jlobato.gpro.web.session;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.jlobato.gpro.utils.GPROUtils;
import org.jlobato.gpro.web.xbean.ManagerHistoryXBean;
import org.jlobato.gpro.web.xbean.ManagerHistoryXBeanBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import net.sourceforge.jwebunit.junit.WebTester;

/**
 * 
 * @author 
 *
 */
public class GPROWebSession {
	
	/**
	 * 
	 */
	private static final String MANAGER_HISTORY_DIV_NAME = "dvManHistory";

	/**
	 * 
	 */
	public static final String MANAGER_HISTORY_LINK_NAME = "lnkmanhistory";

	/**
	 * 
	 */
	public static final String MANAGER_PAGE_PATTERN = "https://www.gpro.net/gb/ManagerProfile.asp?IDM={0}";

	/**
	 * 
	 */
	public static final String TABLE_HTML_TAG = "table";

	/**
	 * 
	 */
	private static final String SUBMIT_BUTTON_LABEL = "Submit2";

	/**
	 * 
	 */
	private static final String LOGIN_FIELD_NAME = "textLogin";

	/**
	 * 
	 */
	private static final String PASSWORD_FIELD_NAME = "textPassword";

	/**
	 * 
	 */
	private static final String NEW_STYLE_IMAGE_PRESENT = "/images/xdriver.gif";

	/**
	 * 
	 */
	private static final String NEW_STYLE_ALT_PRESENT = "";

	/**
	 * 
	 */
	private static final String HTML_TABLE_ROW_TAG = "tr";

	/**
	 * 
	 */
	private static final String HTML_TABLE_COLUMN_TAG = "td";

	/**
	 * 
	 */
	protected WebTester tester;
	
	/**
	 * 
	 */
	private boolean newStyle = false;
	
	/**
	 * 
	 */
	private String url;
	
	/**
	 * 
	 */
	private String username;
	
	/**
	 * 
	 */
	private String password;
	
	/**
	 * 
	 */
	private String idManager;

	/**
	 * 
	 */
	private boolean logged;
	
	/**
	 * 
	 * @param url
	 * @param username
	 * @param password
	 */
	public GPROWebSession(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
		this.tester = new WebTester();
	}
	
	
	/**
	 * 
	 */
	public void login() {
		//TODO Si falla al hacer login, devolvemos una sesión inválida
		if (isLogged()) {
			throw new IllegalStateException("You are already logged in");
		}
		tester.setScriptingEnabled(false);
		tester.beginAt(this.url);
		tester.assertButtonPresent(SUBMIT_BUTTON_LABEL);
		
		tester.setTextField(LOGIN_FIELD_NAME, this.username);
		tester.setTextField(PASSWORD_FIELD_NAME, this.password);
		
		tester.submit();
		
		//TODO meter el lenguaje
		//this.language = getLanguage(tester);
		
		//Aquí es donde va el tema de si el usuario utiliza o no el nuevo estilo de la web
		tester.assertImagePresentPartial(NEW_STYLE_IMAGE_PRESENT, NEW_STYLE_ALT_PRESENT);
		//Si la imagen está presente el usuario tiene configurado el estilo nuevo de web
		this.newStyle = true;
		
		//Obtenemos el id del manager para el que se abre la sesión
		Document doc = Jsoup.parse(this.tester.getPageSource());
		Elements links = doc.select("a[href]");
		boolean countryStats = false;
		for (Element link : links) {
			if (countryStats) {
				if (link.attr("href").contains("ManagerProfile")) {
					this.idManager = GPROUtils.getIDManagerFromLink(link.attr("href"));
					countryStats = false;
					break;
				}
			}
			if (link.attr("href").contains("Stats") && link.attr("href").contains("type")) countryStats = true;
        }
		
		this.logged = true;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isNewStyle() {
		return newStyle;
	}

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Si ya está la sesión creada o no
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
	public String getIdManager() {
		return idManager;
	}
	
	/**
	 * 
	 * @param idManager
	 */
	public List<ManagerHistoryXBean> getManagerHistory(String idManager) {
		//TODO - Esto hay que trasladarlo a un parser específico
		if (!isLogged()) {
			throw new IllegalStateException("You are not logged in while trying to get manager history for ID " + idManager);
		}
		
		List<ManagerHistoryXBean> result = new ArrayList<>();
		
		String managerHistoryPage = MessageFormat.format(MANAGER_PAGE_PATTERN, idManager);
		this.tester.gotoPage(managerHistoryPage);
		
		//Aseguramos que está el link
		this.tester.assertLinkPresent(MANAGER_HISTORY_LINK_NAME);
		//Si está el link entonces le damos al parseo de la tabla
		Document doc = Jsoup.parse(this.tester.getPageSource());
		Element divManHistory = doc.getElementById(MANAGER_HISTORY_DIV_NAME);
		Elements managerHistoryTables = divManHistory.getElementsByTag(TABLE_HTML_TAG);
		Element managerHistoryTable = managerHistoryTables.first();
		Elements rows = managerHistoryTable.getElementsByTag(HTML_TABLE_ROW_TAG);
		//La fila de los nombres de las columnas no nos interesa
		rows.remove(0);
		for (Element row : rows) {
			Elements datos = row.getElementsByTag(HTML_TABLE_COLUMN_TAG);
			//Season
			String season = datos.get(0).text();
			//Group
			String group = datos.get(1).getElementsByTag("a").first().text();
			//Tyres
			String tyres = datos.get(11).getElementsByTag("img").first().attr("src");
			//Position
			String position = datos.get(2).text();
			//Wins
			String wins = datos.get(3).text();			
			//Podiums
			String podiums = datos.get(4).text();			
			//Poles
			String poles = datos.get(5).text();
			//Fastest laps
			String fastestLaps = datos.get(6).text();
			//Points
			String points = datos.get(7).text();
			//Races
			String races = datos.get(8).text();
			//Cup
			String cup = datos.get(10).text();
			//Money
			String money = datos.get(12).text();
			
			result.add(ManagerHistoryXBeanBuilder.newManagerHistoryXBean()
					.withSeason(season)
					.withGroup(group)
					.withTyres(tyres)
					.withPosition(position)
					.withWins(wins)
					.withPodiums(podiums)
					.withPoles(poles)
					.withFastestLaps(fastestLaps)
					.withPoints(points)
					.withRaces(races)
					.withCup(cup)
					.withMoney(money).build());
		}
		return result;
		
	}
	
	/**
	 * 
	 */
	public void logout() {
		if (!isLogged()) {
			throw new IllegalStateException("You are not logged in while trying to log out");
		}
		
		this.tester.assertLinkPresentWithText("Logout");
		this.tester.clickLinkWithText("Logout");
	}

}
