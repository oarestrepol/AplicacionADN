package com.aplicacion.servicio;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacion.modelo.HumanoEstadisticasModel;
import com.aplicacion.modelo.HumanoModel;
import com.aplicacion.repositorio.HumanoRepository;

@Service
public class HumanoServices {

	@Autowired
	HumanoRepository humanoRepository;
	
	public ArrayList<HumanoModel> obtenerHumanos(){
		return (ArrayList<HumanoModel>)humanoRepository.findAll();
		
	}
	
	public HumanoModel guardarHumano(HumanoModel humanoModel) {
		
		ArrayList<HumanoModel> humanos = obtenerHumanos();
		boolean existe = false;
		HumanoModel humanoAux = new HumanoModel();
		
		for(int i=0; i<humanos.size(); i++) {
			humanoAux = humanos.get(i);
			if(humanoModel.getCadenaAdn().equals(humanoAux.getCadenaAdn())) {
				  existe = true;
			  }
		}
		
		if( !existe ) {
			humanoAux = humanoRepository.save(humanoModel);
		}else {
			humanoAux = null;
		}
		
		return humanoAux;
	}
	
	public HumanoEstadisticasModel calculoEstadisticas() {
		
		double ratio = 0;
		HumanoEstadisticasModel estadisticas = new HumanoEstadisticasModel();
		
		ArrayList<HumanoModel> humanos = obtenerHumanos();
		ArrayList<HumanoModel> humanosMutantes = (ArrayList<HumanoModel>)humanoRepository.findByEsMutante(1) ;
		
		estadisticas.setCount_human_dna(humanos.size());
		estadisticas.setCount_mutant_dna(humanosMutantes.size());
		
		if( humanos.size() > 0) {
			ratio = Math.round(((double)humanosMutantes.size()/humanos.size()) * 100) / 100d;
			estadisticas.setRatio(ratio);
		}else {
			estadisticas.setRatio(0);
		}
		
		return estadisticas;
	}
	
}
