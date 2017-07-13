package presentacion03E;


public class ABB {
	//a) Escriba un método recursivo que determine si un árbol es o no un árbol binario de búsqueda.
	boolean esABB(Nodo raiz){
		if(raiz==null)
			return true;
		if(raiz.izq!=null){
			if(raiz.valor.compareTo(raiz.izq.valor)<0)
				return false;
		}
		if(raiz.der!=null){
			if(raiz.valor.compareTo(raiz.der.valor)>0)
				return false;
		}
		return true&&esABB(raiz.izq)&&esABB(raiz.der);
	}
	/*
	 * b) Escriba un método (no recursivo) que entregue el valor del sucesor de un nodo, es decir, el menor
	 * descendiente del subárbol derecho.
	 */
	
	String sucesor(Nodo x){
		//Caso 3: reemplazar por mayor de arbol derecho
		if(x.der==null)
			return null;
		if( x.der!=null&&x.der.izq == null ){
			return (String)x.der.valor;
		}else{
			Nodo q = x.der;
			while(q.izq.izq != null) q=q.izq;
			return (String)x.izq.valor;
		}
	}
}
