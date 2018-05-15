/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fada;

import java.io.IOException;
import java.util.Vector;
import proyectofada.Archivo;
import proyectofada.CompFila;
import proyectofada.Coordenada;

/**
 *
 * @author invitado
 */
public class FADA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       
        //Guarda en una variable la matriz que trae de un archivo
        Archivo a = new Archivo();
        int[][] arrayCamino = a.readText();
        
        //Pasa la matriz dispersa al formato coordenada
        Coordenada c = new Coordenada();
        Vector<Integer> coordenadaArray = c.representCoordenada(a.getFila(), a.getColumna(), arrayCamino);
        
        //Imprime valores formato COO
         System.out.println("valores");
        for(int i=0; i<coordenadaArray.size();i++){
            
            System.out.print(coordenadaArray.get(i) + " ");
        }
        
        System.out.println("");
        System.out.println("filas");
        for(int i=0; i<coordenadaArray.size();i++){
            System.out.print(c.getFilas().get(i) + " ");
        }
        
        System.out.println("");
        System.out.println("columnas");
        for(int i=0; i<coordenadaArray.size();i++){
            System.out.print(c.getColumnas().get(i) + " ");
        }
        
        System.out.println("");
        System.out.println("obtener elemento");
        
        int valor = c.obtenerElemento(coordenadaArray, 4,5);
        System.out.print(valor);
        
         
        System.out.println("");
        System.out.println("valores de fila");
        
        int[] filaTotal = c.obtenerFila(4, coordenadaArray,a.getFila());
        for(int i=0; i<filaTotal.length;i++){
            System.out.print(filaTotal[i] + " ");
        }
        
        System.out.println("");
        System.out.println("valores de columna");
        
        int[] columnaTotal = c.obtenerColumna(5, coordenadaArray,a.getColumna());
        for(int i=0; i<columnaTotal.length;i++){
            System.out.println(columnaTotal[i]);
        }
        
        System.out.println("");
        System.out.println("Matriz original: ");
        
        //Llama al método que trae la matriz original de nuevo
        int[][] originalMatriz = new int[a.getFila()][a.getColumna()];
        originalMatriz = c.obtenerMatriz(coordenadaArray, 0, originalMatriz);
        
         for(int i= 0 ; i <a.getFila(); i++) {
                for(int j=0; j<a.getColumna(); j++ ){
                    
                    System.out.print(originalMatriz[i][j] + " ");
                }
                System.out.println();
            }
        
         System.out.println("Matriz traspuesta: ");
         
        int[][] matrizTranspuesta = new int[a.getColumna()][a.getFila()];
         matrizTranspuesta = c.matrizTraspuesta(coordenadaArray, coordenadaArray.size()-1, matrizTranspuesta);
        
         for(int i= 0 ; i <a.getColumna(); i++){
                for(int j=0; j<a.getFila(); j++ ){
                    System.out.print(matrizTranspuesta[i][j] + " ");
                }
                System.out.println();
            }
         
       System.out.println("Valores modificados");
       Vector<Integer> coordenadaArrayMod =  c.modificarRepresentacion(0,1,coordenadaArray,2);
       
        for(int i=0; i<coordenadaArrayMod.size();i++){
            
            System.out.print(coordenadaArrayMod.get(i) + " ");
        }
        
        System.out.println("");
        System.out.println("");
        
        
        CompFila cF = new CompFila();
        
        Vector<Integer> crsVector = cF.representCsr(a.getFila(), a.getColumna(), arrayCamino);
       
        System.out.println("Valores comprimida por fila");
        for(int i=0; i<crsVector.size();i++){
            System.out.print(crsVector.get(i) + " ");
        }
        
        System.out.println("");
        System.out.println("cfilas");
        for(int i=0; i<cF.getFilas().size();i++){
            System.out.print(cF.getFilas().get(i) + " ");
        }
        System.out.println("");
        System.out.println("columnas");
        for(int i=0; i<cF.getColumnas().size();i++){
            System.out.print(cF.getColumnas().get(i) + " ");
        }
        
        System.out.println("");
        System.out.println("obtener elemento");
        
        valor = cF.obtenerElemento(4, 5, crsVector);
        System.out.print(valor);
        
        System.out.println("");
        System.out.println("Valores modificados");
        
        
       Vector<Integer> crsVectorMod =  cF.modificarRepresentacion(0,1,coordenadaArray,2);
        for(int i=0; i<crsVectorMod.size();i++){
            
            System.out.print(crsVectorMod.get(i) + " ");
        }
        
        System.out.println("");
        
        
        System.out.println("");
        System.out.println("valores de fila");
        
        filaTotal = cF.obtenerFila(2, coordenadaArray,a.getFila());
        for(int i=0; i<filaTotal.length;i++){
            System.out.print(filaTotal[i] + " ");
        }
        
        System.out.println("");
        System.out.println("Matriz original: ");
        
        originalMatriz = cF.obtenerMatriz(coordenadaArray, originalMatriz);
        
         for(int i= 0 ; i <a.getFila(); i++){
                for(int j=0; j<a.getColumna(); j++ ){
                    System.out.print(originalMatriz[i][j] + " ");
                }
                System.out.println();
            }
         
         System.out.println("Matriz traspuesta: ");
      
         int[][] matrizTranspuestacF = new int[a.getColumna()][a.getFila()];
         matrizTranspuestacF = cF.matrizTraspuesta(coordenadaArray, matrizTranspuestacF);
        
         for(int i= 0 ; i <a.getColumna(); i++){
                for(int j=0; j<a.getFila(); j++ ){
                    System.out.print(matrizTranspuesta[i][j] + " ");
                }
                System.out.println();
            }
        
    }
    
}

