package com.aplicacion.modelo;

import java.util.List;

/**
 * 
 * @author Omar
 * Esta clase es un modelo que represena una cadena ADN esta clase es usada para mapear el objeto json
 *  que contiene un array de string json enviado en el body request del servicio
 */
public class CadenaADN {

	//Variable que contiene la cadena string adn
	private List<String> cadenaAdn;

	public List<String> getCadenaAdn() {
		return cadenaAdn;
	}

	public void setCadenaAdn(List<String> cadenaAdn) {
		this.cadenaAdn = cadenaAdn;
	}
	
	
}
