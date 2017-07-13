package laboratorio02;
/**
 * TDA Lista: lista/ secuencia de valores: v0,v1,...vn-1
 * @author Richard
 * 1. Implementación lista enlazada
 */
public class Lista {
	protected Nodo primero;
	/**
	 * Crear lista vacioa(sin valores)
	 */
	public Lista(){
		primero=null;
	}
	/**
	 * true si esta vacia(o false si no)
	 * @return booleano 
	 */
	public boolean vacia(){
		return primero==null;
	}
	/**
	 * indice de x, es decir primer i/vi=x(-1 si no esta)
	 * @param x primer posición de x con i
	 * @return int i
	 */
	public int buscar(Object x){
		int i=0;
		for(Nodo r=primero; r!=null; r=r.sgte){
			if(r.valor.equals(x))
				return i;
			i++;
		}
		return -1;
	}
	/**
	 * vi: valor de indice (null si i no existe)
	 * @param x indice a buscar
	 * @return valor a encontrar
	 */
	public Object buscar(int x){
		int i=0;
		for(Nodo r=primero; r!=null; r=r.sgte){
			if(i==x)
				return r.valor;
			i++;
		}
		return null;
	}
	/**
	 * v0,v1,...,vi-1,x,vi,...,vn-1
	 * si i=0 insertar al comienzo,
	 * si i=n añadir al final
	 * Nota. no se modifica si i<0 o i>n
	 * @param x
	 * @param y
	 * @throws ListaLlena
	 */
	public void insertar(Object x, int y) throws ListaLlena{
		try{
			//casos especiales
			if(y==0){
				primero=new Nodo(x,primero);
				return;
			}
			if(primero==null)return;
			//caso general
			Nodo r=primero;
			int i=0;
			while(i<y-1&&r.sgte!=null){
				++i;r=r.sgte;
			}
			if(i==y-1)
				r.sgte=new Nodo(x,r.sgte);
		}catch(OutOfMemoryError e){
			throw new ListaLlena("Error de insertar");
		}
	}
	/**
	 * eliminar 1ra aparicion de x
	 * @param x
	 */
	public void eliminar(Object x){
		//casos especiales
		if(primero==null) return;
		if(primero.valor.equals(x)){
			primero=primero.sgte;
			return;
		}
		//caso general
		Nodo r;
		for(r=primero;r.sgte!=null;r=r.sgte)
			if(r.sgte.valor.equals(x))
				break;
		if(r.sgte!=null)
			r.sgte=r.sgte.sgte;
	}
}
