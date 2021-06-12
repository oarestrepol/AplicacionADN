package com.aplicacion.controlador;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacion.modelo.HumanoEstadisticasModel;
import com.aplicacion.servicio.HumanoServices;

/**
 * @author Omar
 * Esta clase  implementa un servicio API Rest el cual realiza el calculo de estadisticas tomando la informacion del base de datos
 */
@RestController
@RequestMapping("/stats")
public class HumanoEstadisticsController {
	
	// Instacia inyectada HumanoServices para acceder a la base de datos
	@Autowired
	HumanoServices humanoServices;
	
	//Metodo que accede a la base de datos y realiza calculos de estadisticas
	@GetMapping
	public HumanoEstadisticasModel calculoEstadisticas(){
		return humanoServices.calculoEstadisticas();
	}

}
