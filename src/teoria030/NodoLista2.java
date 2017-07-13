package teoria030;

public class NodoLista2 {
	Object element;
	NodoLista2 siguiente;
	NodoLista2 anterior;
	
	NodoLista2(){
		element=null;
		siguiente=null;
	}
	NodoLista2(Object o){
		element=o;
	}
	NodoLista2(Object o, NodoLista2 s,NodoLista2 a){
		element=0;
		siguiente=s;
		anterior=a;
	}
}
