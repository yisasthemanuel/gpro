package org.jlobato.gpro.services.raceanalysis;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.jlobato.gpro.dao.mybatis.facade.FachadaRaceData;
import org.jlobato.gpro.sheetparser.GPRORaceSheetParser;
import org.jlobato.gpro.sheetparser.GPRORaceSheetParserFactory;
import org.jlobato.gpro.sheetparser.RaceDataSheetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 
 * @author JLOBATO
 *
 */
@Component
public class SingleRaceImporter {
	
	/**
	 * 
	 */
	@Autowired
	FachadaRaceData managerRacedata;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext contexto = null;
		try {
			//Entorno desarrollo
			System.setProperty("entorno", "I");
			
			//Cargamos el contexto spring (el mismo contexto que la aplicación web)
			contexto = new FileSystemXmlApplicationContext("D:/desarrollo/gprodata-maven/gprdata/src/main/webapp/WEB-INF/spring-applicationContext.xml");
			System.out.println("Contexto cargado: " + contexto.getDisplayName());
			
			//Creamos nuestro objeto importador
			SingleRaceImporter importer = contexto.getBean(SingleRaceImporter.class);

			//Obtenemos el fichero excel para importar
			String baseDirectory = "D:/desarrollo/gits/gprsheetparser/gprsheetparser/src/test/resources";
			String file = "A1-Ring_S24.xlsx";
			FileInputStream fis = new FileInputStream(new File(baseDirectory, file));
			
			//Importamos
			try {
				importer.importSingleRace("Carrera de prueba", "JESUS", fis);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			//Obtenemos el fichero excel para importar
			file = "Ahvenisto_S49.xlsx";
			fis = new FileInputStream(new File(baseDirectory, file));
			
			//Importamos
			try {
				importer.importSingleRace("Carrera de prueba 2", "JESUS", fis);
			}catch(Exception e) {
				e.printStackTrace();				
			}
			
			//Obtenemos el fichero excel para importar
			file = "Austin_S49.xlsx";
			fis = new FileInputStream(new File(baseDirectory, file));
			
			//Importamos
			try {
				importer.importSingleRace("Carrera de prueba 3", "JESUS", fis);
			}catch(Exception e) {
				e.printStackTrace();				
			}
			
			//Obtenemos el fichero excel para importar
			file = "Brands_Hatch_S49.xlsx";
			fis = new FileInputStream(new File(baseDirectory, file));
			
			//Importamos
			try {
				importer.importSingleRace("Carrera de prueba 4", "JESUS", fis);
			}catch(Exception e) {
				e.printStackTrace();				
			}
			
			//Obtenemos el fichero excel para importar
			file = "Irungattukottai_S49.xlsx";
			fis = new FileInputStream(new File(baseDirectory, file));
			
			//Importamos
			try {
				importer.importSingleRace("Carrera de prueba 5", "JESUS", fis);
			}catch(Exception e) {
				e.printStackTrace();				
			}
			
			//Obtenemos el fichero excel para importar
			file = "Poznan_S23.xlsx";
			fis = new FileInputStream(new File(baseDirectory, file));
			
			//Importamos
			try {
				importer.importSingleRace("Carrera de prueba 6", "JESUS", fis);
			}catch(Exception e) {
				e.printStackTrace();				
			}
		} catch(Throwable t) {
			t.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
	
	/**
	 * 
	 */
	public SingleRaceImporter() {
	}
	
	/**
	 * 
	 * @param managerTrack
	 */
	@SuppressWarnings("unused")
	private void setManagerRacedata(FachadaRaceData managerRacedata) {
		this.managerRacedata = managerRacedata;
	}
	
	/**
	 * 
	 * @return
	 */
	private FachadaRaceData getManagerRacedata() {
		return this.managerRacedata;
	}

	/**
	 * 
	 * @param raceDescription
	 * @param codManager
	 * @param is
	 * @throws Exception 
	 */
	public void importSingleRace(String raceDescription, String codManager, InputStream is) throws Exception {
		//Parseamos la hoja con el analisis de la carrera
		GPRORaceSheetParser parser = GPRORaceSheetParserFactory.create(is);	
		RaceDataSheetModel model = parser.readRaceDataSheet();
		importSingleRace(raceDescription, codManager, model);
			
	}
	
	public void importSingleRace(String raceDescription, String codManager, RaceDataSheetModel model) throws Exception {
		getManagerRacedata().importRace(raceDescription, codManager, model);
	}

	
}
