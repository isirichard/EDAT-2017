package presentacion03A;

public class NodoH {
	public int valor;
	public String codigo;
	int c;
	int h;
	public NodoH izq, der, anc;
	public NodoH(int valor,NodoH y,NodoH z){
		this.valor=valor;
		izq=y;
		der=z;
	}
}
