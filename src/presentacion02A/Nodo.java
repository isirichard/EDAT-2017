package presentacion02A;

public class Nodo {
	public Object valor;
	public Nodo sgte;
	public Nodo(Object x, Nodo y){
		valor=x;
		sgte=y;
	}
}
