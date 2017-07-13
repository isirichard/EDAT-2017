package laboratorio03;

public class Nodo {
	public Comparable id;
	public Object info;
	public Nodo izq, der;
	public Nodo(){};
	public Nodo(Comparable x,Object y,Nodo z,Nodo w){
		id=x; info=y; izq=z; der=w;
	}
}
