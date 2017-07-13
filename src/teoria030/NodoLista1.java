package teoria030;

public class NodoLista1 {
	Object element;
	NodoLista1 siguiente;
	
	NodoLista1(){
		element=null;
		siguiente=null;
	}
	NodoLista1(Object o){
		element=o;
	}
	NodoLista1(Object o, NodoLista1 n){
		element=0;
		siguiente=n;
	}
}
