package teoria04;

public class ColaArreglo {
	private Object[] arreglo;
	private int primero, ultimo, numElem=0;
	private int MAX_ELEM=100; // maximo numero de elementos en la cola

	public ColaArreglo()
	{
		arreglo=new Object[MAX_ELEM];
		primero=0;
		ultimo=-1;
		numElem=0;
	}

	public void encolar(Object x)
	{
		if (numElem<=MAX_ELEM) // si esta llena se produce OVERFLOW
		{
			ultimo=(ultimo+1)%MAX_ELEM;
			arreglo[ultimo]=x;
			numElem++;
		}
	}

	public Object sacar()
	{
		if (!estaVacia()) // si esta vacia se produce UNDERFLOW
		{
			Object x=arreglo[primero];
			primero=(primero+1)%MAX_ELEM;
			numElem--;
			return x;
		}
		return null;
	}

	public boolean estaVacia()
	{
		return numElem==0;
	}
}

