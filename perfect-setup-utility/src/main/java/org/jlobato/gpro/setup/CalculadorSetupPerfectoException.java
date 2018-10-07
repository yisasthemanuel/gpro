package org.jlobato.gpro.setup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CalculadorSetupPerfectoException extends Exception {

	private List<String> errorList;

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = -3387953839809486143L;

	/**
	 *
	 */
	public CalculadorSetupPerfectoException() {
		this(new ArrayList<String>());
	}

	/**
	 *
	 * @param errorList
	 */
	public CalculadorSetupPerfectoException(List<String> errorList) {
		super();
		this.errorList = errorList;
	}

	/**
	 *
	 * @return
	 */
	public List<String> getErrorList() {
		return errorList;
	}

	/**
	 * @return
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		String result = "Excepción durante el cálculo del setup perfecto";
		if (errorList.size() > 0) {
			result = "";
			Iterator<String> iterator = errorList.iterator();
			while (iterator.hasNext()) {
				result += iterator.next() + System.getProperty("line.separator");
			}
		}
		return result;
	}
}
