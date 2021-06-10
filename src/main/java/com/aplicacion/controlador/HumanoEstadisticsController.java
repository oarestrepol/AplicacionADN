package com.aplicacion.controlador;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacion.modelo.HumanoEstadisticasModel;
import com.aplicacion.servicio.HumanoServices;

@RestController
@RequestMapping("/stats")
public class HumanoEstadisticsController {
	
	@Autowired
	HumanoServices humanoServices;
	
	@GetMapping
	public HumanoEstadisticasModel calculoEstadisticas(){
		return humanoServices.calculoEstadisticas();
	}

}
