package presentacion02A;
/*
 * 10. Programa que elimine repetidos de lista de enteros.
 */
public class A10_AppElimRep {
	public static void main(String[] args) {
		//new, vacia, buscar, insertar, eliminar
		try{
			Lista lst=new Lista();		
			//generar N enteros al azar
			final int N=azar(1,100);
			//final int N=5;
			for(int i=0;i<N;++i){
				lst.insertar(new Integer(azar(-N,N)), i);
			}
			//eliminar repetidos
			sinRepetidos(lst);
			//mostrar lista sin repetidos
			Integer aux;
			for(int i=0; (aux=(Integer)lst.buscar(i))!=null;++i)
				System.out.println(aux.intValue());
		}catch(ListaLlena e){
			System.out.println("capacidad de lista excedida");
		}
	}
	//generar al azar N° entre x e y
	static public int azar(int x, int y){
		return x+(int)(Math.random()*(y-x+1));
	}
	/**
	 * Utilizando el método de la actividad 9 podemos eliminar
	 * repetidos de una lista para nuestras aplicaciones si queremos
	 * datos y objetos unicos.
	 */
	static public void sinRepetidos(Lista x)
			throws ListaLlena{
			Object aux;
			for(int i=0; (aux=x.buscar(i))!=null; ++i){
				while( x.buscar(aux) >= 0 )
					x.eliminar(aux);
				x.insertar(aux,i);
			}
	}
}