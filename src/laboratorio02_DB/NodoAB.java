package laboratorio02_DB;

public class NodoAB {
	public String id, info;
	public NodoAB izq, der;
	public NodoAB(String x, String y, NodoAB z, NodoAB w){
		id=x; info=y; izq=z; der=w;
	}
}
