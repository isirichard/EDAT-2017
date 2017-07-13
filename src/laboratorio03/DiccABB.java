package laboratorio03;

public class DiccABB {
	protected Nodo raiz;
	public DiccABB(){
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
		return (String )(r == null ? null : r.info);
	}
	public boolean cambiar(Comparable x, Object y){
		Nodo r = referencia(x,raiz);
		if( r == null ) return false;
		r.info = y;
		return true;
	}

	///////////////////////////////////////////////////////////////////////////
	/*
	 * Operación agregar
			Alternativa 1: dos recorridos del ABB
	 */

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

	/**Alternativa 2: un sólo recorrido (no recursivo) del ABB
	 */
	public boolean agregar2(Comparable x, Object y)
			throws DiccLleno
	{
		Nodo q = new Nodo(x,y,null,null);
		if( raiz==null ){
			raiz=q;
			return true;
		}
		Nodo r=raiz;
		while(true){
			int c = x.compareTo(r.id);
			if(c==0) return false; //ya existe
			if(c<0)
				if(r.izq==null){
					r.izq=q; break;
				}else
					r=r.izq;
			else
				if(r.der==null){
					r.der=q; break;
				}else
					r=r.der;
		}
		return true;
	}
	//////////////////////////////////////////////////////////////
	//Operación Borrar
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
			r.id=r.izq.id; r.info=r.izq.info; r.izq=r.izq.izq;
		}else{
			Nodo q = r.izq;
			while(q.der.der != null) q=q.der;
			r.id=q.der.id; r.info=q.der.info; q.der=q.der.izq;
		}
		return r;
	}
	//:::::::::::::::Por derecha::::::::::::///////////////////////////////////////
	public boolean borrarD(Comparable x){
		Nodo r = referencia(x, raiz);
		if( r == null ) return false;
		raiz = borrarD(x,raiz);
		return true;
	}
	//borrar Nodo con id x (entregar ref a ABB sin x)
	protected Nodo borrarD(Comparable x, Nodo r){
		if( r == null ) return null;
		int c = x.compareTo(r.id);
		if( c==0 ) return borrarD(r);
		if( c<0 )
			r.izq = borrarD(x,r.izq);
		else
			r.der = borrarD(x,r.der);
		return r;
	}
	//borrar Nodo de referencia r (entregar ref a ABB sin x)
	protected Nodo borrarD(Nodo r){
		if(r.izq==null) return r.der; //Caso 1:solo arbol der.
		if(r.der==null) return r.izq; //Caso 2:solo arbol izq.
		//Caso 3: reemplazar por mayor de arbol derecho
		if( r.der.izq == null ){
			r.id=r.der.id; r.info=r.der.info; r.der=r.der.der;
		}else{
			Nodo q = r.der;
			while(q.izq.izq != null) q=q.izq;
			r.id=q.izq.id; r.info=q.izq.info; q.izq=q.izq.der;
		}
		return r;
	}
	
	
	
	//Solución 2: un recorrido (no recursivo)
	public boolean borrar2(Comparable x){
		if( raiz==null )return false;
		if( raiz.id.equals(x) ){
			raiz = borrar(raiz); return true;
		}
		Nodo r=raiz;
		while(true){
			int c = x.compareTo(r.id);
			if(c<0){
				if(r.izq==null) return false;
				if(r.izq.id.equals(x)){
					r.izq = borrar(r.izq); break;
				}else
					r = r.izq;
			}else{
				if(r.der==null) return false;
				if(r.der.id.equals(x)){
					r.der = borrar(r.der); break;
				}else
					r = r.der;
			}
		}
		return true;
	}
	//Versión alternativa
	public boolean borrar3(Comparable x){
		if( raiz==null ) return false;
		if( x.equals(raiz.id) ){
			raiz = borrar(raiz); return true;
		}
		int c=0; 
		int cAnt=0;
		
		Nodo r=raiz; 
		Nodo rAnt=r;
		while(r!=null && (c=x.compareTo(r.id))!=0){
			rAnt=r; cAnt=c;
			r = c<0 ? r.izq: r.der;
		}
		if( r==null ) return false;
		if( cAnt<0 )
			rAnt.izq = borrar(r);
		else
			rAnt.der = borrar(r);
		return true;
	}

}