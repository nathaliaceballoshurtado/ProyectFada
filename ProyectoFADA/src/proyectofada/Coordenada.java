/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofada;

import java.util.*;

/**
 *
 * @author Nathalia
 */
public class Coordenada {
    private Vector<Integer> filas = new Vector<Integer>();
    private Vector<Integer> columnas = new Vector<Integer>();
    
    //geters de Coordenada
     public Vector<Integer> getFilas(){
        return filas;
    }
    
    public Vector<Integer> getColumnas(){
        return columnas;
    }
    
    public Vector<Integer> representCoordenada(int fila, int columna,int[][] matrix){
        
        Vector<Integer> valores = new Vector<Integer>();
        
        int contadorValores =0;
        for(int i=0;i<fila;i++){
            for(int j=0;j<columna;j++){
                if(matrix[i][j]!=0){
                    valores.add(matrix[i][j]);
                    filas.add(i);
                    columnas.add(j);
                    contadorValores++;
                }
            }
        }
        
        return valores;
    }
    
    
    public int[][] obtenerMatriz(Vector<Integer> val, int contador,  int[][] matriz){
      
      if(contador!=filas.size()){
          matriz[filas.get(contador)][columnas.get(contador)]=val.get(contador);
          obtenerMatriz(val, contador+1, matriz);
      }    
        return matriz;
    }

    public Vector<Integer> transFila(){
        Vector<Integer> transpFilas =  columnas;
        return transpFilas;
    }
    
    public Vector<Integer> transColumn(){
        Vector<Integer> transpColumn =  filas;
        return transpColumn;
    }
    
    public int[][] matrizTraspuesta(Vector<Integer> valo, int cont,  int[][] matrix){
      
      if(cont!=-1){
          matrix[transFila().get(cont)][transColumn().get(cont)]=valo.get(cont);
          matrizTraspuesta(valo, cont-1, matrix);
      }    
        return matrix;
    }
    
    public Vector<Integer> modificarRepresentacion(int ir, int jr,Vector<Integer> valores, int valor){
        boolean entro = false;
        for(int i=0;i<filas.size();i++){
            if(filas.get(i)==ir&&columnas.get(i)==jr){
                    valores.insertElementAt(valor, i);
                    entro=true;
                }
        }
        if(entro==false){
                valores.add(valor);
                filas.add(ir);
                columnas.add(jr);
                } 
        return valores;
    }
    
   public int[] obtenerFila(int fila, Vector<Integer> val, int filalen){
       int[] valores = new int[filalen];
       
        for(int i=0;i<filas.size();i++){
            if(filas.get(i)==fila){
                valores[columnas.get(i)] = val.get(i);
            }
        }
       
       return valores;
   }
   
   public int[] obtenerColumna(int columna, Vector<Integer> valu, int columlen){
       int[] valores = new int[columlen];
       
        for(int i=0;i<columnas.size();i++){
            if(columnas.get(i)==columna){
                valores[filas.get(i)] = valu.get(i);
            }
        }
       
       return valores;
   }
   
   public int obtenerElemento(Vector<Integer> val, int i, int j){
       int valor = 0;
       
       for(int k=0;k<filas.size();k++){
           if((filas.get(k)==i)&&(columnas.get(k)==j)){
             valor=val.get(k);
           }
         }
       return valor;
   }
}