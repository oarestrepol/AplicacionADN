package com.aplicacion.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacion.modelo.CadenaADN;
import com.aplicacion.modelo.HumanoModel;
import com.aplicacion.operation.ICadenaAdn;
import com.aplicacion.servicio.HumanoServices;


/**
 * 
 * @author Omar
 * Esta clases es un servicio API Rest el cual via post recibe una cadena de adn, un
 * array String json, identifica si el adn es de un mutant y la almacena en la bd
 */

@RestController
@RequestMapping("/mutant")
public class HumanoController {

	//Instancia inyectada HumanoServices para realizar operaciones sobre la base de datos
	@Autowired
	HumanoServices humanoServices;
	
	//Instancia inyectada ICadenaAdn con la cual se realizan operaciones para identificar si  la cadena adn
	//es de un mutante o no
	@Autowired
	ICadenaAdn cadenaAdnOperation;
	
	//Metodo usado para obtener todos los humanos existentes de la base de datos via GET
	@GetMapping
	public ArrayList<HumanoModel> obtenerHumanos(){
		return humanoServices.obtenerHumanos();
	}
	
	//Metodo usado para almacenar una cadena adn en la base de datos, retorna salida si es mutante o si no es mutante
	// Toma la cadena adn de entrada en el request, un array de string json 
	@PostMapping
	public String guardarHumano(@RequestBody CadenaADN cadenaAdn) {
		HumanoModel humanoModel = new HumanoModel();
		String cadenaStr = "";
		String salida = "";
		String cadenaAdnArray[] = new String[cadenaAdn.getCadenaAdn().size()];
		cadenaAdn.getCadenaAdn().toArray(cadenaAdnArray);
		cadenaStr = cadenaAdnToString(cadenaAdnArray);
		humanoModel.setCadenaAdn(cadenaStr);
		
		if(cadenaAdnOperation.isMutant(cadenaAdnArray)) {
			humanoModel.setEsMutante(1);
			salida = " HTTP 200-OK";
		}else {
			humanoModel.setEsMutante(0);
			salida = "403-Forbidden";
		}
		
		humanoServices.guardarHumano(humanoModel);
		
		return salida;
	}
	
	//Este metodo retorna un string que corresponde a tomar un array de string y lo concatena con salto de linea
	public String cadenaAdnToString(String cadenaAdn[]) {
		String salida = "";
		if( cadenaAdn.length > 0) {
			for(int i=0; i<cadenaAdn.length; i++) {
				salida = salida + "\n" + cadenaAdn[i];
				
			}
		}
		return salida;
		
	}
}
