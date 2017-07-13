package presentacion02E;
/*
 * 4. Implementar la clase Queue sin usar variable n.
 */
public class E04_QueueLE {
	protected NodoQ primero;
	protected NodoQ ultimo;
	public E04_QueueLE(){
		primero = ultimo = null;
	}
	
	public void enque(Object x) throws QueueFull{
		NodoQ r= new NodoQ(x,null);
		if(ultimo==null)
			primero=r;
		else
			ultimo.sgte=r;
		ultimo=r;
	}
	public Object deque()throws QueueEmpty{
		if(primero==null) 
			throw new QueueEmpty();
		if(primero==ultimo) 
			ultimo =null;
		Object aux=primero.valor;
		primero=primero.sgte;
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
