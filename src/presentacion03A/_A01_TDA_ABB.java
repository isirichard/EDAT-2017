package presentacion03A;

import laboratorio03.QueueEmpty;
import laboratorio03.QueueFull;

public class _A01_TDA_ABB {
	/*
	 * TDA Diccionario: implementación con ABB
	 * 	(tiempo de todas las operaciones proporcional a altura del árbol)
		agregar, borrar, cambiar, buscar
	 */
	public static void main(String[] args) throws DiccLleno, QueueFull, QueueEmpty {
		DiccionarioABB prueba = new DiccionarioABB();
		/////AGREGAR//////
		prueba.agregar('E', "letra E ");
		prueba.agregar('C', "Letra C ");
		prueba.agregar('G', "Letra G ");
		prueba.agregar('B', "Letra B ");
		prueba.agregar('D', "Letra D ");
		prueba.agregar('H', "Letra F ");
		/////BUSCAR//////
		System.out.println(prueba.buscar('E'));
		System.out.println(prueba.buscar('H'));
		////CAMBIAR///////
		prueba.cambiar('H', "Letra H");
		System.out.println(prueba.buscar('H'));
		/////BORRAR//////
		prueba.borrar('E');
		System.out.println(prueba.buscar('E'));
		
		//prueba.imprimir();
	}
}
