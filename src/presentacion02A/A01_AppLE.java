package presentacion02A;
/*
 * TDA Lista: lista/secuencia de valores: v0,v1,...,vn-1
 * 1. Implementación con lista enlazada
 */
public class A01_AppLE {
	//static Nodo prueba = new Nodo("Ejemplo de Nodo",null);
	//static Lista lst= new Lista();
	public static void main(String[] args) throws ListaLlena {
		//System.out.println("probando clase Nodo: "+prueba.valor);
		System.out.println("probando lista enlazada: ");
		Lista lst= new Lista();
		/**
		 * Al implementarlo con listas sin cabecera se necesita siempre que al ingresar
		 * haya un orden comenzando con el 0 para luego colocarlo antes o despues del 0
		 */
		lst.insertar("primero", 0);
		lst.insertar("segundo", 1);
		lst.insertar("tercero", 2);
		lst.insertar("cuarto", 3);
		/*
		 * utiliza un entero para buscar, insertar y eliminar
		 * new Lista(), vacia, buscar, insertar, eliminar.
		 */
		
		imprimir(lst);
		/**
		lst.insertar("cuarto", 3);
		
		lst.eliminar("tercero");
		**/
		
	}
		
	
	static void imprimir(Lista lst) throws ListaLlena{
		Object aux;
		for(int i=0; (aux=lst.buscar(i))!=null; ++i){
			System.out.println(lst.buscar(i));
		}
	}	
}
	/*
	static void imprimir(Lista lst){
		Nodo aux=lst.primero;
		while(aux!=null){
			System.out.println(aux.valor);
			aux=aux.sgte;
		}
	}
	*/
	

