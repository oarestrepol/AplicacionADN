package com.aplicacion.modelo;

//Esta clase represnta un modelo de estadisticas

public class HumanoEstadisticasModel {
	
	// Esta variable almacena la cantidad de mutantes
	 private long count_mutant_dna;
	 
	 //Esta variable almacena la cantidad de cadenas adn
	 private long count_human_dna; 
	 
	 //Esta variable almacena el porcentaje entre mutante/total cadenas adn
	 private double ratio;
	 
	public long getCount_mutant_dna() {
		return count_mutant_dna;
	}
	public void setCount_mutant_dna(long count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}
	public long getCount_human_dna() {
		return count_human_dna;
	}
	public void setCount_human_dna(long count_human_dna) {
		this.count_human_dna = count_human_dna;
	}
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

}
