package com.aplicacion.operation;

import org.springframework.stereotype.Component;

@Component
public class CadenaAdnImpl implements ICadenaAdn{

	public static int secuenciaCount = 0;
	
	@Override
	public boolean validarArray(String[] array) {
		boolean salida = true;

        if (array != null) {
            if (array.length >= 4) {
                for (int i = 0; i < array.length; i++) {
                    if (array[i].length() >= 4) {
                        if (array.length == array[i].length()) {
                            salida = true;
                        } else {
                            salida = false;
                        }
                    } else {
                        salida = false;
                    }

                    if (salida == false) {
                        break;
                    }
                }
            } else {
                salida = false;
            }
        } else {
            salida = false;
        }
        return salida;
	}

	@Override
	public void verMatriz(String[] dna) {
		// TODO Auto-generated method stub
		char dnaMatriz[][] = new char[dna.length][dna.length];

        for (int i = 0; i < dna.length; i++) {
            dnaMatriz[i] = dna[i].toCharArray();
        }

        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna[i].length(); j++) {
                System.out.print(dnaMatriz[i][j]);
            }
            System.out.print("\n");
        }
		
	}

	@Override
	public int validacionHorizontal(String[] dna) {
		char dnaMatriz[][] = new char[dna.length][dna.length];
        int tamano = dna.length;
        
        for (int i = 0; i < dna.length; i++) {
            dnaMatriz[i] = dna[i].toCharArray();
        }
        for (int j = 0; j < tamano; j++) {
            for (int i = 0; i < tamano; i++) {
                boolean validaElemento = false;
                
                for(int k= 0; k < CANTIDAD; k++){
                    if(( (i+(CANTIDAD-1)) < tamano )&& ( dnaMatriz[j][i] == dnaMatriz[j][i+k] )){
                        validaElemento = true;
                    }else{
                        validaElemento = false;
                        break;
                    }
                }
                
                if(validaElemento == true){
                    secuenciaCount++;
                }
            }
        }
        return secuenciaCount;
	}

	@Override
	public int validacionVertical(String[] dna) {
		char dnaMatriz[][] = new char[dna.length][dna.length];
        int tamano = dna.length;
        
        for (int i = 0; i < dna.length; i++) {
            dnaMatriz[i] = dna[i].toCharArray();
        }
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                boolean validaElemento = false;
                
                for(int k= 0; k < CANTIDAD; k++){
                    if(( (j+(CANTIDAD-1)) < tamano )&& ( dnaMatriz[j][i] == dnaMatriz[j+k][i] )){
                        validaElemento = true;
                    }else{
                        validaElemento = false;
                        break;
                    }
                }
                
                if(validaElemento == true){
                    secuenciaCount++;
                }
            }
        }
        return secuenciaCount;
	}

	@Override
	public int validacionDiagonalS(String[] dna) {
		char dnaMatriz[][] = new char[dna.length][dna.length];
        int tamano = dna.length;
        
        for (int i = 0; i < dna.length; i++) {
            dnaMatriz[i] = dna[i].toCharArray();
        } 
        //VALIDACION PARTE SUPREIOR MATRIZ
        for( int f=0 ; f < ( tamano - (CANTIDAD-1)); f++){
            for(int i=0; i< tamano; i++){
                boolean validaElemento = false;
                
                for(int k= 0; k < CANTIDAD; k++){
                    if(( (i+f+(CANTIDAD-1)) < tamano )&& ( dnaMatriz[i][i+f] == dnaMatriz[i+k][i+f+k] )){
                        validaElemento = true;
                    }else{
                        validaElemento = false;
                        break;
                    }
                }
                if(validaElemento == true){
                    secuenciaCount++;
                }
            }
        }
        
        //VALIDACION PARTE INFERIOR MATRIZ
        for( int f=1 ; f < ( tamano - (CANTIDAD-1)); f++){
            for(int i=0; i< tamano; i++){
                boolean validaElemento = false;
                
                for(int k= 0; k < CANTIDAD; k++){
                    if(( (i+f+(CANTIDAD-1)) < tamano )&& ( dnaMatriz[i+f][i] == dnaMatriz[i+k+f][i+k] )){
                        validaElemento = true;
                    }else{
                        validaElemento = false;
                        break;
                    }
                }
                if(validaElemento == true){
                    secuenciaCount++;
                }
            }
        }
        return secuenciaCount;
	}
	
	public int validacionDiagonalD(String dna[]) {
        char dnaMatriz[][] = new char[dna.length][dna.length];
        int tamano = dna.length;
        int secuenciaD = 0;
        
        for (int i = 0; i < tamano; i++) {
            dnaMatriz[i] = dna[i].toCharArray();
        } 
        
        //VALIDACION PARTE 1 MATRIZ DERECHA A IZQUIERDA SUPERIOR
        for(int f= (tamano-1); f >= 0; f--){
            for (int i = 0; i < tamano; i++) {
                boolean validaElemento = false;
                
                for (int k = 0; k < CANTIDAD; k++) {

                    if(( (i+k) < tamano ) && 
                          ((f-i-k) >= 0) &&
                         ( dnaMatriz[i][f-i] == dnaMatriz[i+k][f-i-k] )){
                        validaElemento = true;
                    }else{
                        validaElemento = false;
                        break;
                    }
                }
                if(validaElemento == true){
                    secuenciaCount++;
                    break;
                }
            }
        }   
        
        //VALIDACION PARTE 2 MATRIZ DERECHA A IZQUIERDA INFERIOR
        for(int i = 1; i < tamano; i++){
            for (int f= (tamano-1); f >= 0; f--) {
                boolean validaElemento = false;
                
                for (int k = 0; k < CANTIDAD; k++) {
                    if( (i+k+((tamano-1)-f)<tamano)&& 
                         ( dnaMatriz[i+(tamano-1)-f][f] == dnaMatriz[i+k+((tamano-1)-f)][f-k] )){
                        validaElemento = true;
                    }else{
                        validaElemento = false;
                        break;
                    }
                }
                if(validaElemento == true){
                    secuenciaCount++;
                    break;
                }
            }
        }   
        
        return secuenciaD;
     }
	
	public boolean isMutant(String dna[]){
		
		verMatriz(dna);
		
        if(validarArray(dna)){
            validacionHorizontal(dna);
            validacionVertical(dna);
            validacionDiagonalS(dna);   
        }

        if( secuenciaCount > 1 ){
        	secuenciaCount = 0;
            return true;
        }else{
        	secuenciaCount = 0;
            return false;
        }
        
    }

}
