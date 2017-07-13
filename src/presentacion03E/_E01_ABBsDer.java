package presentacion03E;

import laboratorio03.Nodo;
/*
 * 1. Borrar elementos reemplazando por el menor de árbol derecho, en la implementación del TAD
 * Diccionario con ABBs.
 */

public class _E01_ABBsDer {
	protected Nodo raiz;
	protected Nodo referencia(Comparable x, Nodo r){
		if( r == null ) return null;
		int c = x.compareTo(r.id);
		if( c == 0 ) return r;
		return referencia(x, c<0 ? r.izq : r.der);
	}
	//:::::::::::::::BORRAR Por derecha in orden ::::::::::::///////////////////////////////////////
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
}
