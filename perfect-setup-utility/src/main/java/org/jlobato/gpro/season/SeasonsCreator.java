package org.jlobato.gpro.season;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SeasonsCreator {

	private static ObjectOutputStream oos;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Season> seasons = new ArrayList<Season>();
		for (int i = 1; i <= 50; i++) {
			Season current = new SeasonImpl("S" + i, i);
			seasons.add(current);
		}
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("seasons.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(seasons);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try { fos.close(); } catch(Exception c) {}
			}
		}

	}

}
