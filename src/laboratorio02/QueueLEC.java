package laboratorio02;

public class QueueLEC {
	protected Nodo primero;
	protected Nodo ultimo;
	public QueueLEC(){
		primero = ultimo = null;
	}
	//poner en cola
	public void enque(Object x) throws QueueFull{
		Nodo r= new Nodo(x,null);
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
