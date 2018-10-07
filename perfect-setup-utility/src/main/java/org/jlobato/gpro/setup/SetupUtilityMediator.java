package org.jlobato.gpro.setup;

import org.jlobato.gpro.languages.ILanguage;
import org.jlobato.gpro.user.IUsuario;

public class SetupUtilityMediator {
	
	private static SetupUtilityMediator instance;
	private IUsuario usuario;

	private SetupUtilityMediator(IUsuario usuario) {
		this.usuario = usuario;
	}

	public IUsuario getUsuario() {
		return usuario;
	}
	
	public static SetupUtilityMediator getInstance() {
		return instance;
	}
	
	public static SetupUtilityMediator getInstance(IUsuario usuario) {
		instance = new SetupUtilityMediator(usuario);
		return instance;
	}
	
	public ILanguage getUserLanguage() {
		return getUsuario().getContextoUsuario().getLanguage();
	}

}
