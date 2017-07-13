package laboratorio02_DC;

public class NodoABBP {
	public Comparable id;
	public Object info;
	public NodoABBP izq, der;
	public NodoABBP(Comparable x,Object y,NodoABBP z,NodoABBP w){
	id=x; info=y; izq=z; der=w;
	}
	}
