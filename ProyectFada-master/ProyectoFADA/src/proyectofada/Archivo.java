package proyectofada;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author invitado
 */
public class Archivo {
    int numeroDefilas =0;
    int numeroDecolumnas =0;
    
    public String leerArchivo(String archivo) throws FileNotFoundException, IOException
    {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        String camino = "";
        while((cadena = b.readLine())!=null) {
          camino = camino + cadena;

       }
        b.close();
        return camino;
    }
    
    
    public BufferedReader getBuffered(String link){

    FileReader lector  = null;
    BufferedReader br = null;
    try {
         File Arch=new File(link);
        if(!Arch.exists()){
           System.out.println("No existe el archivo");
        }else{
           lector = new FileReader(link);
           br = new BufferedReader(lector);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return br;
}
    
    public int [][]  readText()
    {
        try
        {
            //ruta de tu archivo
            String ruta = "src/proyectofada/Matriz/x.txt";
            BufferedReader br = getBuffered(ruta);
            //leemos la primera linea
            String linea =  br.readLine();
            //creamos la matriz vacia
            
            //contador
            int contador = 0;
            String[] values = linea.split(" ");
            numeroDefilas= Character.getNumericValue(values[0].charAt(0));
            linea = br.readLine();
            values = linea.split(" ");
            numeroDecolumnas = Character.getNumericValue(values[0].charAt(0));
            linea = br.readLine();
            
            
            System.out.println("numero de filas " + numeroDefilas + " numero de Columnas " + numeroDecolumnas);
            int[][] matriz = new int[numeroDefilas][numeroDecolumnas];
            
            while(linea != null)
            {
                values = linea.split(" ");
                
                
                //recorremos el arrar de string
                for (int i = 0; i<values.length; i++) {
                    //se obtiene el primer caracter de el arreglo de strings
                    matriz[contador][i] = Character.getNumericValue(values[i].charAt(0));
                   // System.out.println(Character.getNumericValue(values[i].charAt(0)));
                   
                }
                contador++;
                linea = br.readLine();
                
                
            }
            
            for(int i= 0 ; i <numeroDefilas; i++)
            {
                for(int j=0; j<numeroDecolumnas; j++ ) 
                {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
            return matriz;
        }
        catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }
        return null;
        
    
    }
    
    public int getFila(){
        return numeroDefilas;
    }
    
    public int getColumna(){
        return numeroDecolumnas;
    }
    
    
}