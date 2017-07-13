package presentacion01E;

final public class CEnteroImpl implements Comparable {
	private int valor;
	public CEnteroImpl(int x){
		valor= x;
	}
	public String toString(){
		return Integer.toString(valor);
	}
	public int valorEntero(){
		return valor;
	}
	
	@Override
	public int Compare(Comparable b) {
		return valor-((CEnteroImpl)b).valor;
	}
}
