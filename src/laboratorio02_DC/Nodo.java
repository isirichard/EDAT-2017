package laboratorio02_DC;

public class Nodo {
	public Comparable id;
	public Object info;
	public Nodo sgte, ant;
	public Nodo(Comparable x, Object y, Nodo z, Nodo w){
	id=x; info=y; sgte=z; ant=w;
	}
	}
