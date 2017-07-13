package laboratorio02;
/*
 * 9. Método que elimine todos los repetidos de una lista
 */
public class A09_EliminarRep {
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
