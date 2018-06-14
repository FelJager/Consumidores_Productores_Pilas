package productores_consumidores2;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Pila
{
	
    public char[] stck = new char[30];
    public char tos = 0;
    JTextField buffer;
 
    /**
     * Obtiene de forma concurrente o síncrona el elemento que hay en el contenedor
     * @return Contenido el contenedor
     */
    public synchronized char get() throws InterruptedException
    {
        while (tos == 0)
        {
        	try {
            JOptionPane.showMessageDialog(null, "El contenedor esta vacio, no puedo comer");
			Thread.sleep(10000);
        	}	catch (InterruptedException e)
        	{
        		// TODO Auto-generated catch block
				e.printStackTrace();
        	}
        }
        notify();
    
        --tos;
        String tmp = "";
        for(int i=0; i<tos;i++)
        {
        	tmp+=stck[i];
        }
        buffer.setText(tmp);
        
        return (char) stck[tos];
 
    }
 

    public synchronized void put(char c) 
    {
        while (tos == stck.length - 1) 
        {
            JOptionPane.showMessageDialog(null, "El contenedor esta lleno, ya no puedo ingresar ninguna letra");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        stck[tos++] = c;
        String tmp = "";
        for(int i=0; i<tos;i++)
        {
        	tmp+=stck[i];
        }
        buffer.setText(tmp);
        notify();
    }
    
    public Pila(JTextField textArea_1)
    {
    	this.buffer = textArea_1;
    }

	public class Stack {

        Stack(int size){
            stck = new char[size];
            tos = (char) -1;
        }
    }
    
}