/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numeros_casiprimos;
    
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

    
/**
 *
 * @author Karen
 */
public class Numeros_casiPrimos {
    int[] inicial;
    int[] Final;
    int tamaño;
    int[] primos;
    int[] Noprimos;
    String[] archivo;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Numeros_casiPrimos obj=new Numeros_casiPrimos();
        obj.leerArchivo();
        obj.pasarNumeros();
        obj.VerificarPrimos();
    }
    
    public void leerArchivo(){
        try{
          FileInputStream Apertura=new FileInputStream("src\\casi.txt");
          DataInputStream Entrada= new DataInputStream(Apertura);
          BufferedReader Buffer=new BufferedReader(new InputStreamReader(Entrada));
          String Linea;
                    int Limite=0;
                    while((Linea =Buffer.readLine())!=null)   
                       Limite++;
          Entrada.close();
          archivo=new String[Limite];
          Limite=0;
          
           Apertura=new FileInputStream("src\\casi.txt");
           Entrada= new DataInputStream(Apertura);
           Buffer=new BufferedReader(new InputStreamReader(Entrada));
         
                    while((Linea =Buffer.readLine())!=null)   // lee cada linea de archivo
                       this.archivo[Limite++]=Linea; // cada linea la pasa a un string 
          Entrada.close();      
          
    }catch(Exception e){
            System.out.println("Ocurrio un error::"+e.getMessage());
    }
    }
    
    public void pasarNumeros(){
        
        int iter=0,iter2=0;
        tamaño=Integer.parseInt(this.archivo[iter]);
        String[] cad;
        this.inicial=new int[tamaño];
        this.Final=new int[tamaño];
        
        for(int i=1;i<=tamaño;i++){
             iter2=0;   
             cad=this.archivo[i].split("\\ ");
             this.inicial[iter]=Integer.parseInt(cad[iter2]);
             iter2++;
             this.Final[iter]=Integer.parseInt(cad[iter2]);
             iter++;
        }
    }
    
    public void VerificarPrimos(){
        
        for(int i=0;i<this.tamaño;i++){
           
           contarElementos(this.inicial[i],this.Final[i]);
           limites(this.inicial[i],this.Final[i]); 
           casiPrimo();
        }
    }
    
    public void contarElementos(int inicio,int fina){
        
        int recor=inicio;
        int P=0,primo=0,total=0;
        while(recor<=fina){
            
            for(int j=1;j<recor+1;j++){
                
                if(recor%j==0){
                    P++;
                }           
            }
            
            if(P!=2){
                
                if(recor>1)
                total++;
            }
            else 
                primo++;
            
            P=0;
            recor++;
        }
       
        this.primos=new int[primo];
        this.Noprimos=new int[total];
    }
    
    public void limites(int inicio,int fina){
    
        int recorrido=inicio,iteracion=0,iterNP=0;
        int P=0;
        while(recorrido<=fina){
            
            for(int j=1;j<recorrido+1;j++){
                
                if(recorrido%j==0){
                    P++;
                }
            }
            if(P==2){
                this.primos[iteracion]=recorrido;
                iteracion++;
            } 
            P=0;
            if(recorrido>2 && recorrido%2==0){
                   this.Noprimos[iterNP]=recorrido;
                   iterNP++;
            }
             
            else if(recorrido>3 && recorrido%3==0){
                this.Noprimos[iterNP]=recorrido;
                iterNP++;
            }
            recorrido++;
        }
    }
    
    public void casiPrimo(){
        
        int cont,cont2=0;
        for(int i=0;i<this.Noprimos.length;i++){
            
            cont=0;
            for(int j=0;j<this.primos.length;j++){
                
              if(Noprimos[i]%primos[j]==0){
                  cont++;
              }
            }
            if(cont==1){
                //System.out.println("Casi Primo: "+Noprimos[i]);
                cont2++;
            }
        }
        System.out.println("Total casi primo: "+cont2);
        
    }
}
