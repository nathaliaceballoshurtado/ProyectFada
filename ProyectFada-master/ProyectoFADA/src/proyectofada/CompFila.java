/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofada;

import java.util.Vector;

/**
 *
 * @author Nathalia
 */
public class CompFila {
    private Vector<Integer> cfilas = new Vector<Integer>();
    private Vector<Integer> columnas = new Vector<Integer>();
    
    public Vector<Integer> representCsr(int nofilas, int nocolumnas,int[][] matrix){
        
        Vector<Integer> valores = new Vector<Integer>();
        int contadorValores =0;
        cfilas.add(0);
        for(int i=0;i<nofilas;i++){
             for(int j=0;j<nocolumnas;j++){
                if(matrix[i][j]!=0){
                    valores.add(matrix[i][j]);
                    columnas.add(j);
                    contadorValores++;
                }
                }
             cfilas.add(i+1, contadorValores);
        }
        
        return valores;
    }
    
    public Vector<Integer> getFilas(){
        return cfilas;
    }
    
    public Vector<Integer> getColumnas(){
        return columnas;
    }   
    
    public int[][] obtenerMatriz(Vector<Integer> val,int[][] matriz){
      for(int i=0;i<cfilas.size()-1;i++){
       for(int j=cfilas.get(i);j<cfilas.get(i+1)-cfilas.get(i);i++){
            matriz[j][columnas.get(j)] = val.get(0);
        }
      }
        return matriz;
    }
    
    public int[][] matrizTraspuesta(Vector<Integer> valo,  int[][] matrix){
      for(int i=0;i<cfilas.size()-1;i++){
       for(int j=cfilas.get(i);j<cfilas.get(i+1)-cfilas.get(i);i++){
            matrix[columnas.get(j)][j] = valo.get(0);
        }
      }
        return matrix;
    }
    
    //Completar método
    public Vector<Integer> modificarRepresentacion(int ir, int jr,Vector<Integer> valores, int valor){
         int filai = cfilas.get(ir);
         int filanexti = cfilas.get(ir+1);
         
         for(int k=filai;k<filanexti; k++){
             if(columnas.get(k)==jr){
                 valores.insertElementAt(valor, k);;
             }
         }
       return valores;  
    }
    
     public int obtenerElemento(int i, int j, Vector<Integer> val){
         int filai = cfilas.get(i);
         int filanexti = cfilas.get(i+1);
         int valor=0;
         
         for(int k=filai;k<filanexti; k++){
             if(columnas.get(k)==j){
                 valor=val.get(k);
             }
         }
       return valor;          
     }
     
     
    //Método erroneo ni puta de que esta pasando AIUDA
     public int[] obtenerFila(int fila, Vector<Integer> val, int filalen){
       int[] valores = new int[filalen];
       int filai = cfilas.get(fila);
       int filanexti = cfilas.get(fila+1);
       System.out.println(filai);
       
        for(int i=filai;i<filanexti;i++){
            System.out.println(columnas.get(i) + "i " + i);
             valores[columnas.get(i)] = val.get(i);
            }
       
       return valores;
   }
    
}
