package laboratorio02_D;

public class NodoDE {
	public Object id, info;
	public NodoDE sgte, ant;
	public NodoDE(Object x, Object y, NodoDE z, NodoDE w){
	id=x; info=y; sgte=z; ant=w;
	}
}
