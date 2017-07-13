package teoria030;
class IteradorLista
{
	NodoLista actual;

	IteradorLista(NodoLista n)
	{
		this.actual=n;
	}

	boolean estaFuera()
	{
		if (actual==null)
			return true;
		else
			return false;
	}

	Object obtener()
	{
		return this.actual.elemento;
	}

	void avanzar()
	{
		if(!estaFuera())
		{
			this.actual=this.actual.siguiente;
		}
	}
}
