package presentacion03A;

import laboratorio03.QueueEmpty;
import laboratorio03.QueueFull;

/*
 * Arbol binario (AB)
Estructura de datos (recursiva) que está vacía (null) o contiene un nodo raíz con un valor y
referencias a dos árboles binarios (izquierdo y derecho)
 */
public class _A02_AB {
	public static void main(String[] args) throws QueueFull, QueueEmpty {
		Nodo raiz = new Nodo("A", //valor
				new Nodo("B",new Nodo("D",null,null),new Nodo("E",null,null)),
				new Nodo("C",new Nodo("F",null,new Nodo("T",null,new Nodo("U",null,null))),new Nodo("G",null,null))
				);


		AB prueba = new AB();
		System.out.println("hojas: "+prueba.hojas(raiz));
		System.out.println("altura: "+prueba.altura(raiz));
		System.out.println("Nodo buscado: "+prueba.buscar("F",raiz));
		System.out.print("inOrden: ");prueba.inOrden(raiz);
		//System.out.println();
		System.out.print("preOrden: ");prueba.preOrden(raiz);
		//System.out.println();
		System.out.print("postOrden: ");prueba.postOrden(raiz);
	}
}
/**
 * Algunas operaciones significado resultado
hojas(raiz) cantidad de nodos sin “hijos” 4
altura(raiz) largo máximo hasta hojas 2
buscar(x,raiz) referencia a nodo con valor x null o ref
inOrden(raiz) recorrido IRD(izq,raiz,der) DBEAFCG
preOrden(raiz) recorrido RID ABDECFG
postOrden(raiz) recorrido IDR DEBFGCA
 **/
