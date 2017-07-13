package presentacion03A;

import laboratorio03.QueueArr;
import laboratorio03.QueueEmpty;
import laboratorio03.QueueFull;

public class DiccionarioABB {

	protected Nodo raiz;
	public DiccionarioABB(){
		raiz = null;
	}
	protected Nodo referencia(Comparable x, Nodo r){
		if( r == null ) return null;
		int c = x.compareTo(r.id);
		if( c == 0 ) return r;
		return referencia(x, c<0 ? r.izq : r.der);
	}
	public String buscar(Comparable x){
		Nodo r = referencia(x,raiz);
		return (String)(r == null ? null : r.info);
	}
	public boolean cambiar(Comparable x, Object y){
		Nodo r = referencia(x,raiz);
		if( r == null ) return false;
		r.info = y;
		return true;
	}

	public boolean agregar(Comparable x,Object y)
			throws DiccLleno
	{
		if(referencia(x,raiz) != null) return false;
		raiz = agregar(x,y,raiz);
		return true;
	}
	//entrega ABB con nuevo nodo (eventualmente un nuevo ABB)
	protected Nodo agregar(Comparable x,Object y,Nodo r){
		if( r==null ) return new Nodo(x,y,null,null);
		if( x.compareTo(r.id) < 0 )
			r.izq = agregar(x, y, r.izq);
		else
			r.der = agregar(x, y, r.der);
		return r;
	}

	//borrar identificador x
	public boolean borrar(Comparable x){
		Nodo r = referencia(x, raiz);
		if( r == null ) return false;
		raiz = borrar(x,raiz);
		return true;
	}
	//borrar Nodo con id x (entregar ref a ABB sin x)
	protected Nodo borrar(Comparable x, Nodo r){
		if( r == null ) return null;
		int c = x.compareTo(r.id);
		if( c==0 ) return borrar(r);
		if( c<0 )
			r.izq = borrar(x,r.izq);
		else
			r.der = borrar(x,r.der);
		return r;
	}
	//borrar Nodo de referencia r (entregar ref a ABB sin x)
	protected Nodo borrar(Nodo r){
		if(r.izq==null) return r.der; //Caso 1:solo arbol der.
		if(r.der==null) return r.izq; //Caso 2:solo arbol izq.
		//Caso 3: reemplazar por mayor de arbol izquierdo
		if( r.izq.der == null ){
			r.id=r.izq.id; 
			r.info=r.izq.info; 
			r.izq=r.izq.izq;
		}else{
			Nodo q = r.izq;
			while(q.der.der != null) 
				q=q.der;
			r.id=q.der.id; 
			r.info=q.der.info; 
			q.der=q.der.izq;
		}
		return r;
	}
	

	private class Nodo{
		public Comparable id;
		public Object info;
		public Nodo izq, der;
		public Nodo(Comparable x,Object y,Nodo z,Nodo w){
			id=x; info=y; izq=z; der=w;
		}
	}
	
	void imprimir() throws QueueFull, QueueEmpty{
		System.out.println();
		Nodo aux=raiz;
		QueueArr cola=new QueueArr();
		cola.enque(aux);
		while(!cola.empty()){
			aux=(Nodo)cola.deque();
			
			System.out.print(aux.info);

			if(aux.izq!=null)
				cola.enque(aux.izq);
			if(aux.der!=null)
				cola.enque(aux.der);
		}

	}
}
