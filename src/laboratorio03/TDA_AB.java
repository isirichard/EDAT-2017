package laboratorio03;

public class TDA_AB {
	NodoAB raiz = new NodoAB("A", //valor
			new NodoAB("B",new NodoAB("D",null,null),new NodoAB("E",null,null)),
			new NodoAB("C",new NodoAB("F",null,null),new NodoAB("G",null,null))
			);

	int hojas(NodoAB r){
		if( r==null) return 0;
		if( r.izq==null && r.der==null ) return 1;
		return hojas(r.izq) + hojas(r.der);
	}
	int altura(NodoAB r){
		return r==null ? -1: 1+Math.max(altura(r.izq),altura(r.der));
	}
	NodoAB buscar(String x, NodoAB r){
		if( r==null || r.valor.equals(x) ) return r;
		NodoAB aux = buscar(x,r.izq);
		return aux!=null? aux: buscar(x,r.der);
	}
	void inOrden(NodoAB r){ //arbol izquierdo, raíz, arbol derecho
		if( r== null ) return;
		inOrden(r.izq); System.out.print(r.valor); inOrden(r.der);
	}
	void preOrden(NodoAB r){ //raiz, arbol izquierdo, arbol derecho
		if( r== null ) return;
		System.out.print(r.valor); preOrden(r.izq); preOrden(r.der);
	}
	void postOrden(NodoAB r){ //arbol izquierdo, arbol derecho, raíz
		if( r== null ) return;
		postOrden(r.izq);postOrden(r.der); System.out.print(r.valor);
	}
	//Propuesto. Reescribir a) usando concurrencia b) sin recursión
}
