package presentacion03A;

public class NodoM {
	public String valor;
	public String codigo;
	int c;
	int h;
	public NodoM izq, der;
	public NodoM(String valor,String codigo,NodoM y,NodoM z){
		this.valor=valor;
		this.codigo=codigo;
		izq=y;
		der=z;
	}
}
