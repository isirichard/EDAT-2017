package presentacion02E;
/*
 * 5. Implementar la clase Queue con una lista enlazada circular (ultimo nodo apunta al primero).
 */
public class E05_QueueLEC {
	protected NodoQ primero;
	protected NodoQ ultimo;
	public E05_QueueLEC(){
		primero = ultimo = null;
	}
	//poner en cola
	public void enque(Object x) throws QueueFull{
		NodoQ r= new NodoQ(x,null);
		if(ultimo==null)
			primero=r;
		else
			ultimo.sgte=r;
		ultimo=r;
		//aqui hacemos el el ultimo luego de encolar apunte al primero
		r.sgte=primero;
	}
	//sacar de cola
	public Object deque()throws QueueEmpty{
		if(primero==null) 
			throw new QueueEmpty();
		if(primero==ultimo) 
			ultimo =null;
		Object aux=primero.valor;
		primero=primero.sgte;
		//nuevamente haciendo la referencia del siguiente del ultimo al primero
		ultimo.sgte=primero;
		return aux;
	}
	public boolean full(){
		return false;
	}
	public void reset(){
		primero=ultimo=null;
	}
	/*
	Class Nodo{
		public Object valor;
		public Nodo sgte;
		public Nodo(Object x, Nodo y){
			valor = x;
			sgte=y;
		}
	}
	*/
	
	static public void sinRepetidos(Lista x) throws ListaLlena{
		Object aux;
		for(int i=0;((aux=x.buscar(i))!=null);++i){
			while(x.buscar(aux)>=0)
				x.eliminar(aux);
			x.insertar(aux, i);
		}
	}
}
