package com.aplicacion.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Omar
 * Esta clase representa una entidad de la tabla Humano 
 */
@Entity
@Table(name = "Humano")
public class HumanoModel {
	
	//Llave primaria 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	//Cadena adn
	private String cadenaAdn;
	
	//Es mutante o no
	private Integer esMutante;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCadenaAdn() {
		return cadenaAdn;
	}
	public void setCadenaAdn(String cadenaAdn) {
		this.cadenaAdn = cadenaAdn;
	}
	public Integer getEsMutante() {
		return esMutante;
	}
	public void setEsMutante(Integer esMutante) {
		this.esMutante = esMutante;
	}

	
}
