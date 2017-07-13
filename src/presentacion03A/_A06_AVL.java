package presentacion03A;

import laboratorio03.DiccLleno;
import laboratorio03.QueueEmpty;
import laboratorio03.QueueFull;

public class _A06_AVL {
	public static void main(String[] args) throws DiccLleno, QueueFull, QueueEmpty {
		AVL prueba=new AVL();
		
		prueba.insertar(1);
		prueba.imprimir();
		prueba.insertar(2);
		prueba.imprimir();
		prueba.insertar(3);
		prueba.imprimir();
		prueba.insertar(4);
		prueba.imprimir();
		prueba.insertar(5);
		prueba.imprimir();
		prueba.insertar(6);
		prueba.imprimir();
		prueba.insertar(7);
		prueba.imprimir();
		
		prueba.insertar(0);
		prueba.imprimir();
		
		prueba.eliminar(4);
		prueba.imprimir();
		prueba.eliminar(5);
		prueba.imprimir();
		prueba.eliminar(0);
		prueba.imprimir();
		prueba.eliminar(1);
		prueba.imprimir();
		prueba.eliminar(6);
		prueba.imprimir();
		prueba.eliminar(2);
		prueba.imprimir();
		prueba.eliminar(3);
		prueba.imprimir();
		prueba.eliminar(7);
		prueba.imprimir();
		prueba.insertar(1);
		prueba.imprimir();
		prueba.insertar(2);
		prueba.imprimir();
		
	}
}
