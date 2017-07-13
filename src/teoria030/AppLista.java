package teoria030;

public class AppLista {
	public static void main(String[] args) {
		Lista nuevo=new Lista();
		/**
		 * para hacer una aplicación de este tda lista.
		 * al momento de crear un objeto lista, nosotros lo creamos con
		 * cabecera. Ahora para ingresar debemos darle el primer iterador
		 * (ventana)del nodo cabeza. Luego es ya sólo buscar el nodo para darle
		 * el lugar correcto a insertar.
		 */
		nuevo.insertar("primero", new IteradorLista(nuevo.cabecera));
		nuevo.insertar("segundo", nuevo.buscar("primero"));
		nuevo.insertar("tercero", nuevo.buscar("tercero"));
		nuevo.insertar("cuarto", nuevo.buscar("tercero"));
		nuevo.insertar("quinto", nuevo.buscar("cuarto"));
		nuevo.insertar("sexto", nuevo.buscar("primero"));
		/**
		 * El iterador es como una ventana podemos ubicarla deacuerdo al elemento
		 * del nodo. Si el interador no se encuentra hace un recorrido y el iterador
		 * se vuelve nulo en consecuencia no se inserta el nodo.
		 * Para mas información ver los métodos de insertar y buscar en la clase
		 * Lista
		 */
		recorrido(nuevo.cabecera);
		
		
	}
	public static void recorrido(NodoLista lista){
		NodoLista aux=lista.siguiente;
		while(aux!=null){
			System.out.println(aux.elemento);
			aux=aux.siguiente;
		}
	}
}