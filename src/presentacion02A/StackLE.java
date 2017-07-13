package presentacion02A;

public class StackLE {
	protected Nodo primero;
	public StackLE(){
		primero=null;
	}
	public void push(String x){
		primero=new Nodo(x,primero);	
	}
	public String pop(){
		String aux=(String)primero.valor;
		primero=primero.sgte;
		return aux;
	}
	public boolean empty(){
		return primero==null;
	}
	public boolean full(){
		return false;
	}
	public void reset(){
		primero=null;
	}
	/**
	 * Clase interna sólo de uso de la clase envolvedora
	 */
	private class Nodo{
		public String valor;
		public Nodo sgte;
		public Nodo (String x, Nodo y){
			valor=x;
			sgte=y;
		}
	}
	
}
