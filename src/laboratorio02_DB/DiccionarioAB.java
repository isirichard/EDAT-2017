package laboratorio02_DB;

public class DiccionarioAB {
	protected NodoAB raiz;
	public DiccionarioAB(){ raiz = null; }
	public String buscar(String x){ //tpo: O(log2(n))
		NodoAB r = referencia(x,raiz);
		return r == null ? null : r.info;
	}
	public boolean cambiar(String x, String y){ //tpo: O(log2(n))
		NodoAB r = referencia(x,raiz);
		if( r == null ) return false;
		r.info = y;
		return true;
	}
	public boolean agregar(String x, String y){ //tpo: O(log2(n))
		if(referencia(x,raiz) != null) 
			return false;
		raiz = agregar(x,y,raiz);
		return true;
	}
	public boolean borrar(String x){ //tpo: O(log2(n))
		NodoAB r = referencia(x, raiz);
		if( r == null ) return false;
		raiz = borrar(x,raiz);
		return true;
	}
	protected NodoAB referencia(String x, NodoAB r){
		if( r == null ) return null;
		int c = x.compareTo(r.id);
		if( c == 0 ) return r;
		return referencia(x, c<0 ? r.izq : r.der);
	}
	protected NodoAB agregar(String x,String y,NodoAB r){//árbol con (x,y)
		if( r==null ) return new NodoAB(x,y,null,null);
		if( x.compareTo(r.id) < 0 )
			r.izq = agregar(x, y, r.izq);
		else
			r.der = agregar(x, y, r.der);
		return r;
	}
	protected NodoAB borrar(String x, NodoAB r){//árbol sin x
		if( r == null ) return null;
		int c = x.compareTo(r.id);
		if( c==0 ) return borrar(r);
		if( c<0 ) r.izq=borrar(x,r.izq); else r.der=borrar(x,r.der);
		return r;
	}
	protected NodoAB borrar(NodoAB r){//nodo sin x
		if(r.izq == null) return r.der; //Caso 1:solo subarbol der.
		if(r.der == null) return r.izq; //Caso 2:solo subarbol izq.
		//Caso 3: reemplazar por antecesor (mayor de arbol izquierdo)
		if( r.izq.der == null ){
			r.id=r.izq.id; r.info=r.izq.info; r.izq=r.izq.izq;
		}else{
			NodoAB q = r.izq;
			while(q.der.der != null) q=q.der;
			r.id=q.der.id; r.info=q.der.info; q.der=q.der.izq;
		}
		return r;	
	}
}
