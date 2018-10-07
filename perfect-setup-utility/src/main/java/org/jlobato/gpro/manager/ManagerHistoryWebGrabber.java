package org.jlobato.gpro.manager;

import org.jlobato.gpro.web.GPROWebGrabber;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ManagerHistoryWebGrabber extends GPROWebGrabber {
	public static final String HTML_TABLE_ROW_TAG = "tr";
	public static final String HTML_TABLE_COLUMN_TAG = "td";

	public ManagerHistoryWebGrabber(String url, String username, String password) {
		super(url, username, password);
	}

	public static void main(String[] args) {
		ManagerHistoryWebGrabber manager = new ManagerHistoryWebGrabber("https://www.gpro.net", "yisasthemanuel", "oxford");
		manager.login();
		
		System.out.println("New Style: " + manager.isNewStyle());
		System.out.println("Language used: " + manager.getLanguage());
		manager.doGrab();
	}

	@Override
	public void doGrab() {
		//Hacerlo bien
		this.tester.gotoPage("https://www.gpro.net/gb/ManagerProfile.asp?IDM=52243");
		//this.tester.dumpHtml();
		//Aseguramos que está el link
		this.tester.assertLinkPresent("lnkmanhistory");
		//Si está el link entonces le damos al parseo de la tabla
		Document doc = Jsoup.parse(this.tester.getPageSource());
		Element divManHistory = doc.getElementById("dvManHistory");
		Elements managerHistoryTables = divManHistory.getElementsByTag("table");
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
			
			System.out.println("Temporada: " + season + " - " + group + " - " + tyres);
		}
	}

}
