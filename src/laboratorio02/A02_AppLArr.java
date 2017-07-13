package laboratorio02;
/*
 * 2. TDA Lista: implementación con arreglo
 */
/**
 * En este caso La lista implementada tiene un tamaña por la implementación usando
 * un arreglo de objetos para recorrer e imprimir sus elementos lo demuestran.
 */
public class A02_AppLArr {
	public static void main(String[] args) throws ListaLlena {
		ListaArr lst=new ListaArr();
		lst.insertar("1", 0);
		lst.insertar("2", 1);
		lst.insertar("3", -5);
		
		imprimir(lst);
	}
	static void imprimir(ListaArr lst){
		for(int i=0;i<lst.n;i++){
			System.out.println(lst.valor[i]);
		}
	}
}
