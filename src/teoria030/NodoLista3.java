package teoria030;

public class NodoLista3 {
	Object element;
	NodoLista3 siguiente;
	
	NodoLista3(){
		element=null;
		siguiente=null;
	}
	NodoLista3(Object o){
		element=o;
	}
	NodoLista3(Object o, NodoLista3 n){
		element=0;
		siguiente=n;
	}
}
