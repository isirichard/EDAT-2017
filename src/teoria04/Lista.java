package teoria04;
class Lista
{
	NodoLista cabecera;

	Lista()
	{
		this.cabecera=new NodoLista(null);
	}

	boolean estaVacia()
	{
		if (this.cabecera.siguiente==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	IteradorLista buscar(Object o)
	{
		NodoLista nodo=this.cabecera.siguiente;
		while (nodo!=null && !nodo.elemento.equals(o))
		{
			nodo=nodo.siguiente;
		}
		return new IteradorLista(nodo);
	}

	void insertar(Object o, IteradorLista it)
	{
		if (it!=null && it.actual!=null)
		{
			it.actual.siguiente=new NodoLista(o, it.actual.siguiente);
		}
	}

	void eliminar(Object o)
	{
		IteradorLista it=encontrarPrevio(o);
		if (it.actual.siguiente!=null)
		{
			it.actual.siguiente=it.actual.siguiente.siguiente;
		}
	}

	IteradorLista encontrarPrevio(Object o)
	{
		NodoLista nodo=this.cabecera;
		while (nodo.siguiente!=null && !nodo.siguiente.elemento.equals(o))
		{
			nodo=nodo.siguiente;
		}
		return new IteradorLista(nodo);
	}
	
	public void recorrido(NodoLista lista){
		NodoLista aux=lista.siguiente;
		while(aux!=null){
			System.out.println(aux.elemento);
			aux=aux.siguiente;
		}
	}
	public void insertar(Object o){
		NodoLista nuevo=new NodoLista(o);
		cabecera.siguiente=nuevo;
	}
	
}
