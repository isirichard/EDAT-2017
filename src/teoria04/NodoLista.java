package teoria04;

class NodoLista
{
	Object elemento;
	NodoLista siguiente;

	NodoLista(Object o)
	{
		this.elemento=o;
		this.siguiente=null;
	}

	NodoLista(Object o, NodoLista n)
	{
		this.elemento=o;
		this.siguiente=n;
	}
}
