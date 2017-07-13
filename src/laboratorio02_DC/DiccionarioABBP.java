package laboratorio02_DC;

public class DiccionarioABBP {
	protected NodoABBP raiz;
	public DiccionarioABBP(){raiz = null;}
	protected NodoABBP referencia(Comparable x, NodoABBP r){
		if( r == null ) return null;
		int c = x.compareTo(r.id);
		if( c == 0 ) return r;
		return referencia(x, c<0 ? r.izq : r.der);
	}
	//...
}
