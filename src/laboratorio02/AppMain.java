package laboratorio02;

public class AppMain {
	public static void main(String[] args) {
		try{
			Lista L=new Lista();		
		//generar N enteros al azar
			final int N=azar(1,100);
			for(int i=0;i<N;++i){
				L.insertar(new Integer(azar(-N,N)), i);
			}
			//eliminar repetidos
			sinRepetidos(L);
			//mostrar lista sin repetidos
			Integer aux;
			for(int i=0; (aux=(Integer)L.buscar(i))!=null;++i)
				System.out.println(aux.intValue());
		}catch(ListaLlena e){
			System.out.println("capacidad de lista excedida");
		}
	}
	//generar al azar N° entre x e y
	static public int azar(int x, int y){
		return x+(int)(Math.random()*(y-x+1));
	}
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
