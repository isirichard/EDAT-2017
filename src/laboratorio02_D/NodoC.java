package laboratorio02_D;

public class NodoC {
	public Comparable id;
	public Object info;
	public NodoC sgte, ant;
	public NodoC(Comparable x,Object y,NodoC z,NodoC w){
		id=x; info=y; sgte=z; ant=w;
	}
}
//Clases comparables predefinidas: String, Date , Integer, Double, ...
//Clases comparables definidas por el programador:
/*	
	class C implements Comparable{
	...
	public int compareTo(C x){ ... }
	...
*/