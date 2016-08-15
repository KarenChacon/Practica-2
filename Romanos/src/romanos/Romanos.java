/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package romanos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *{
 * 
 * @author Karen
 */
public class Romanos {

    String vector[];
    int VectorEnteros[];
    String Romano[];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Romanos obj=new Romanos();
        obj.leerArchivo();
        obj.PasarArchivos();
        obj.TransformarRomano();
        obj.imprimir();
        obj.ImprimirSalida();
    }
    
    public void leerArchivo() {
        try{
          FileInputStream Apertura=new FileInputStream("src\\romanos.txt");
          DataInputStream Entrada= new DataInputStream(Apertura);
          BufferedReader Buffer=new BufferedReader(new InputStreamReader(Entrada));
          String Linea;
                    int Limite=0;
                    while((Linea =Buffer.readLine())!=null)   
                       Limite++;
          Entrada.close();
          this.vector=new String[Limite];
          this.VectorEnteros=new int[Limite];
          Limite=0;
          
           Apertura=new FileInputStream("src\\romanos.txt");
           Entrada= new DataInputStream(Apertura);
           Buffer=new BufferedReader(new InputStreamReader(Entrada));
         
                    while((Linea =Buffer.readLine())!=null)   // lee cada linea de archivo
                       this.vector[Limite++]=Linea; // cada linea la pasa a un string 
          Entrada.close();      
          
    }catch(Exception e){
            System.out.println("Ocurrio un error::"+e.getMessage());
    }
    }
    
    public void PasarArchivos(){
        
        this.Romano=new String[this.VectorEnteros.length]; // memoria al que guarda la conversion de romano
        for(int i=0;i<this.VectorEnteros.length;i++){
            
            this.VectorEnteros[i]=Integer.parseInt(vector[i]); // pasa a un vector tipo int
        }    
        
        for(int i=0;i<this.VectorEnteros.length;i++){
        
            this.Romano[i]=""; // inicializo en vacio
        }
    }
    
    public void TransformarRomano(){
        
        for (int i = 0; i < this.VectorEnteros.length; i++) {
                while(this.VectorEnteros[i]>0){                    
                   
                   if(this.VectorEnteros[i]>=1000){ // empiezo verificando si es mayor que 1000
                        this.VectorEnteros[i]-=1000; // asi sucesivamente
                        Romano[i]=Romano[i]+"M";
                    }
                   else if(this.VectorEnteros[i]>=900){
                            this.VectorEnteros[i]-=900;
                            Romano[i]=Romano[i]+"CM";
                        }
                   else if(this.VectorEnteros[i]>=500 && this.VectorEnteros[i]<900){
                            this.VectorEnteros[i]-=500;
                            Romano[i]=Romano[i]+"D";
                        }
                   else if(this.VectorEnteros[i]>=400){
                            this.VectorEnteros[i]-=400;
                            Romano[i]=Romano[i]+"CD";
                        }
                   else if(this.VectorEnteros[i]>=100 && this.VectorEnteros[i]<400){
                            this.VectorEnteros[i]-=100;
                            Romano[i]=Romano[i]+"C";
                   }
                   else if(this.VectorEnteros[i]>=90){
                            this.VectorEnteros[i]-=90;
                            Romano[i]=Romano[i]+"XC";
                        }
                   else if(this.VectorEnteros[i]>=50 && this.VectorEnteros[i]<90){
                            this.VectorEnteros[i]-=50;
                            Romano[i]=Romano[i]+"L";
                   }
                   else if(this.VectorEnteros[i]>=40){
                            this.VectorEnteros[i]-=40;
                            Romano[i]=Romano[i]+"XL";
                        }
                   else if(this.VectorEnteros[i]>=10 && this.VectorEnteros[i]<40){
                            this.VectorEnteros[i]-=10;
                            Romano[i]=Romano[i]+"X";
                   }
                   else if(this.VectorEnteros[i]>=9){
                            this.VectorEnteros[i]-=9;
                            Romano[i]=Romano[i]+"IX";
                        }
                   else if(this.VectorEnteros[i]>=5 && this.VectorEnteros[i]<9){
                            Romano[i]=Romano[i]+"V";
                            this.VectorEnteros[i]-=5;
                        }
                   else if(this.VectorEnteros[i]>=4){
                            this.VectorEnteros[i]-=4;
                            Romano[i]=Romano[i]+"IV";
                        }
                   else if(this.VectorEnteros[i]>=1 && this.VectorEnteros[i]<4){  
                            Romano[i]=Romano[i]+"I";
                            this.VectorEnteros[i]-=1;
                       } 
             }
        }
    }
    
    public void imprimir(){
        
        for(int i=0;i<this.VectorEnteros.length;i++){
        
            System.out.println(vector[i]+" "+Romano[i]);
        }
    }
    
    public void ImprimirSalida(){
     
        File Apertura=new File("src\\salidaromanos");
        try{

        FileWriter Archivo = new FileWriter(Apertura);
        BufferedWriter Buffer = new BufferedWriter(Archivo);
        PrintWriter Escritor = new PrintWriter(Buffer);  

            for (int i = 0; i < this.VectorEnteros.length; i++) 
                    Escritor.write(this.vector[i]+" "+Romano[i]+"\r\n");
                
                
        Escritor.close();
        Buffer.close();
        }catch(Exception e){
            System.out.println("Hubo un error::"+e.getMessage());
        }
    }
}
