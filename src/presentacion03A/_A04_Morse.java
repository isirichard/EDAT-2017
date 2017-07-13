package presentacion03A;

import laboratorio03.QueueEmpty;
import laboratorio03.QueueFull;

public class _A04_Morse {
	public static void main(String[] args) throws QueueFull, QueueEmpty {
		
		NodoM raiz = new NodoM(" ","", //valor
				new NodoM("E",".",new NodoM("I","..",null,null),new NodoM("A",".-",null,null)),
				new NodoM("T","-",new NodoM("N","-.",null,null),new NodoM("M","--",null,null))
				);
		
		
		Morse prueba = new Morse();
		System.out.println("buscando T: "+prueba.codigo('T', raiz));
		System.out.println("buscando .-: "+prueba.letra(".-", raiz));
		
		
		System.out.println("///////////////////////");
		System.out.println("buscando Z: "+prueba.codigo('Z', raiz));
		System.out.println("agregando: Z .--");prueba.agregar('Z',".--", raiz);
		
		System.out.println("///////////////////////");
		System.out.println("buscando Z: "+prueba.codigo('Z', raiz));
		System.out.println("buscando .--: "+prueba.letra(".--", raiz));
		
		
	}	
}
