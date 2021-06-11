package com.aplicacion.operation;

public interface ICadenaAdn {
	
	public static final int CANTIDAD = 4;
	public boolean validarArray(String array[]);
	public void verMatriz(String dna[]);
	public int validacionHorizontal(String dna[]);
	public int validacionVertical(String dna[]);
	public int validacionDiagonalS(String dna[]);
	public int validacionDiagonalD(String dna[]);
	boolean isMutant(String dna[]);
	

}
