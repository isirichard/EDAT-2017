package presentacion02E;

public class NodoQ {
	public Object valor;
	public NodoQ sgte;
	public NodoQ(Object x, NodoQ y){
		valor=x;
		sgte=y;
	}
}

