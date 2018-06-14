package productores_consumidores2;

import javax.swing.JTextArea;

public class Consumidor extends Thread
{
    private Pila contenedor;
    private int idconsumidor;
    JTextArea consola;
 
    /**
     * Constructor de la clase
     * @param contenedor Contenedor común a los consumidores y el productor
     * @param idconsumidor Identificador del consumidor
     */
    public Consumidor(Pila contenedor, int idconsumidor, JTextArea consola) 
    {
    	this.consola = consola;
        this.contenedor = contenedor;
        this.idconsumidor = idconsumidor;
    }
 
    @Override
    /**
     * Implementación de la hebra
     */
    public void run() 
    {
        while(Boolean.TRUE)
        {
        	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	try {
				consola.append("El consumidor " + idconsumidor + " consume: " + contenedor.get() + "\n");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
}