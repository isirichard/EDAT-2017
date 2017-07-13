package laboratorio02_DB;

public class Nodo {
	public Object id, info;
	public Nodo sgte;
	public Nodo(Object x,Object y,Nodo z){id=x; info=y; sgte=z;}
}
