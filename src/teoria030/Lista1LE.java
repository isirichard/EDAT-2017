package teoria030;

public class Lista1LE {
	NodoLista1 primero;
	Lista1LE(){
		primero=new NodoLista1();
	}
	public void insertar(NodoLista1 aux){
		NodoLista1 nuevo=new NodoLista1();
		nuevo.siguiente=aux.siguiente;
		aux.siguiente=nuevo;
	}
	public void recorrido(NodoLista1 lista){
		NodoLista1 aux=lista;
		while(aux!=null){
			System.out.println(aux.element);
			aux=aux.siguiente;
		}
	}
	public void invertir(NodoLista1 lista){
		NodoLista1 siguiente=lista;
		NodoLista1 anterior=null;
		while(lista!=null){
			siguiente=lista.siguiente;
			lista.siguiente=anterior;
			anterior=lista;
			lista=siguiente;
		}
	}
}
