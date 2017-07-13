package presentacion02A;
/*
 * 2. TDA Lista: implementación con arreglo
 */
public class A02_AppLArr {
	public static void main(String[] args) throws ListaLlena {
		ListaArr lst=new ListaArr();
		/**
		 * el primer elemento siempre es cero este implementando en una lista
		 * o con un arreglo.
		 */
		lst.insertar("1", 0);
		lst.insertar("2", 1);
		lst.insertar("3", -5);
		//En el caso de arreglos igual funciona el entero para el TDA Lista
		imprimir(lst);
	}
	
	static void imprimir(ListaArr lst) throws ListaLlena{
		Object aux;
		for(int i=0; (aux=lst.buscar(i))!=null; ++i){
			System.out.println(lst.buscar(i));
		}
	}
	
	/**
	static void imprimir(ListaArr lst){
		for(int i=0;i<lst.n;i++){
			System.out.println(lst.valor[i]);
		}
	}
	**/
}
