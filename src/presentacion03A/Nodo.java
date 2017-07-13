package presentacion03A;

public class Nodo {
	public Object valor;
	public Nodo izq, der,anc;
	public int c;
	public int h;
	public Nodo(Object x,Nodo y,Nodo z){
		valor=x;
		izq=y;
		der=z;
		c=0;
		h=0;
	}
}
