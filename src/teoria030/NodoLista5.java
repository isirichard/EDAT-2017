package teoria030;

public class NodoLista5 {
	Object element;
	NodoLista5 siguiente;
	NodoLista5 anterior;
	
	NodoLista5(){
		element=null;
		siguiente=null;
	}
	NodoLista5(Object o){
		element=o;
	}
	NodoLista5(Object o, NodoLista5 s,NodoLista5 a){
		element=0;
		siguiente=s;
		anterior=a;
	}
}
