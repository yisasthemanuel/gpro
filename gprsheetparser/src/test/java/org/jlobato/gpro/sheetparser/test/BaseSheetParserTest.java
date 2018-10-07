package org.jlobato.gpro.sheetparser.test;

import java.io.InputStream;

import org.jlobato.gpro.sheetparser.GPRORaceSheetParser;
import org.jlobato.gpro.sheetparser.GPRORaceSheetParserFactory;
import org.jlobato.gpro.sheetparser.RaceDataSheetModel;

/**
 * 
 * @author JLOBATO
 *
 */
public class BaseSheetParserTest {
	/**
	 * 
	 */
	InputStream sheetInputStream;
	
	/**
	 * 
	 */
	GPRORaceSheetParser parser;
	
	/**
	 * 
	 */
	RaceDataSheetModel model;
	
	/**
	 * 
	 * @param sheetPath
	 * @throws Exception
	 */
	void loadFromClassPath(String sheetPath) throws Exception {
		//Cargamos la hoja de cálculo
		sheetInputStream = getClass().getResourceAsStream(sheetPath);
		parser = GPRORaceSheetParserFactory.create(sheetInputStream, GPRORaceSheetParserFactory.EXCEL_PARSER);
		model = parser.readRaceDataSheet();
	}

}
