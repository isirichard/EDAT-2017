package teoria04;

public class PilaLista {
	 private NodoLista lista;

	 public PilaLista()
	 {
		 lista=null;
	 }

	 public void apilar(Object x)
	 {
		 lista=new NodoLista(x, lista);
	 }

	 public Object desapilar() // si esta vacia se produce UNDERFLOW
 	{
		 if (!estaVacia())
		 {
			 Object x=lista.elemento;
			 lista=lista.siguiente;
			 return x;
		 }
		 return null;
	 }

	 public Object tope()
	 {
		 if (!estaVacia()) // si esta vacia es un error
		 {
			 Object x=lista.elemento;
			 return x;
		 }
		 return null;
	 }

	 public boolean estaVacia()
	 {
		 return lista==null;
	 }
}
