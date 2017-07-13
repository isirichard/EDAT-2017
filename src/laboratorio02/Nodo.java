package laboratorio02;

public class Nodo {
	public Object valor;
	public Nodo sgte;
	public Nodo(Object x, Nodo y){
		valor=x;
		sgte=y;
	}
}
