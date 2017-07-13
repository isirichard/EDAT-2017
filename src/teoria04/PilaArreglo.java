package teoria04;

public class PilaArreglo {
	private Object[] arreglo;
	private int tope;
	private int MAX_ELEM=100; // maximo numero de elementos en la pila

	public PilaArreglo(){
		arreglo=new Object[MAX_ELEM];
		tope=-1; // inicialmente la pila esta vacía
	}
	/*
	public void apilar(Object x){
		if (tope+1<MAX_ELEM) // si esta llena se produce OVERFLOW{
			tope++;
		arreglo[tope]=x;
	}
	*/
	public void apilar(Object x)
	{
	 	if (tope+1<MAX_ELEM) // si esta llena se produce OVERFLOW
		 {
			 tope++;
			 arreglo[tope]=x;
		 }
		 else
		 {
			 MAX_ELEM=MAX_ELEM*2;
			 Object[] nuevo_arreglo=new Object[MAX_ELEM];
			 for (int i=0; i<arreglo.length; i++)
			 {
				 nuevo_arreglo[i]=arreglo[i];
			 }
			 tope++;
			 nuevo_arreglo[tope]=x;
			 arreglo=nuevo_arreglo;
		 }
	}
	public Object desapilar() {
		Object x=null;
		if (!estaVacia()) // si esta vacia se produce UNDERFLOW {
			x = arreglo[tope];
		tope--;
		return x;
	}


	public Object tope(){
		Object x=null;
		if (!estaVacia()) // si esta vacia es un error{
			x=arreglo[tope];
		return x;
	
	}

	public boolean estaVacia(){
		if (tope==-1){
			return true;
		}else {
			return false;
		}
	}
}



