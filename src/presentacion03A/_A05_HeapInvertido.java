package presentacion03A;

import laboratorio03.QueueEmpty;
import laboratorio03.QueueFull;

/*
 * Heap invertido
AB con menor en la raíz
 */
public class _A05_HeapInvertido {
//Operaciones propuestas: extraerMenor(raiz) y agregar(x,raiz)
	public static void main(String[] args) throws QueueFull, QueueEmpty {
		NodoH raiz = new NodoH(1, //valor
				new NodoH(2,new NodoH(4,null,null),new NodoH(5,null,null)),
				new NodoH(3,new NodoH(6,null,null),new NodoH(7,null,null))
				);
		
		HI prueba = new HI();
		prueba.extraerMenor(raiz);
		
		prueba.imprimirAnc(raiz);
		prueba.agregar(1, raiz);
		//prueba.agregar(8, raiz);
		prueba.imprimirAnc(raiz);
		
	}
}
