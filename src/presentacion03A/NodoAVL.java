package presentacion03A;

public class NodoAVL {
	public Comparable id;
	public Object info;
	int c;
	int h;
	int t;
	public NodoAVL izq, der, anc;
	public NodoAVL(){}
	public NodoAVL(Comparable id,Object info,NodoAVL y,NodoAVL z){
		this.id=id;
		this.info=info;
		izq=y;
		der=z;
	}
}
