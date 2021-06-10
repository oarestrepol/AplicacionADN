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

@RestController
@RequestMapping("/mutant")
public class HumanoController {

	@Autowired
	HumanoServices humanoServices;
	
	@Autowired
	ICadenaAdn cadenaAdnOperation;
	
	@GetMapping
	public ArrayList<HumanoModel> obtenerHumanos(){
		return humanoServices.obtenerHumanos();
	}
	
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
