package presentacion01A;

final public class CEnteroImpl implements IComparable {
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
	public int Compare(IComparable b) {
		return valor-((CEnteroImpl)b).valor;
	}
}
