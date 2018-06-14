package productores_consumidores2;

import java.util.Random;

import javax.swing.JTextArea;

public class Productor extends Thread
{
    private Pila contenedor;
    private int idproductor;
    private int TIEMPOESPERA = 1000;
    private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Random random = new Random();
    private char c;
    JTextArea consola;
    
    public Productor(Pila contenedor, int idproductor, JTextArea consola) 
    {
    	this.consola = consola;
        this.contenedor = contenedor;
        this.idproductor = idproductor;
        new Random();
    }
 
    @Override

    public void run() 
    {
        while(Boolean.TRUE)
        { 
			c = alfabeto.charAt(random.nextInt(26));
			
            consola.append("El productor " + idproductor + " pone: " + c + "\n");
            contenedor.put(c);
            
            try
            {
                Thread.sleep(TIEMPOESPERA);
            } 
            catch (InterruptedException e) 
            { ;}
        }
    }

	
}