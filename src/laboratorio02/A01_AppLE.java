package laboratorio02;
/*
 * TDA Lista: lista/secuencia de valores: v0,v1,...,vn-1
 * 1. Implementación con lista enlazada
 */
public class A01_AppLE {

	public static void main(String[] args) throws ListaLlena {
		Lista lst = new Lista();
		System.out.println("probando lista enlazada: ");
		/**
		 * para insertar necesitamos el elemento de nuestro nodo nuevo
		 * y la ubicación en nuestra lista.
		 * La lista es sin nodo cabecera. this.cabecera=new NodoLista(null);
		 */
		lst.insertar("primero", 2);
		lst.insertar("segundo", 1);
		lst.insertar("tercero", 2);
		lst.insertar("cuarto", 3);
		
		imprimir(lst);
		
		lst.eliminar("tercero");
		
	}
	static void imprimir(Lista lst){
		Nodo aux=lst.primero;
		while(aux!=null){
			System.out.println(aux.valor);
			aux=aux.sgte;
		}
	}
	
}
