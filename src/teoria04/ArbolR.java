package teoria04;

public class ArbolR {
	void preorden(NodoA nodo)
	{
		 if (nodo!=null)
		 {
			 System.out.print(nodo.elemento);
			 preorden(nodo.izq);
			 preorden(nodo.der);
		 }
	}
}
