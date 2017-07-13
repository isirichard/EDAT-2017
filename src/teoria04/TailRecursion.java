package teoria04;

public class TailRecursion {
	public static void main(String[] args) {
		NodoA b;
		
	}
	void preordenTR2(NodoA nodo)
	{
		NodoA aux;
		PilaLista pila=new PilaLista(); // pila de nodos
		pila.apilar(nodo);
		while(!pila.estaVacia()) // mientras la pila no este vacia
		{
			aux=(NodoA)pila.desapilar();
			while (aux!=null)
			{
				System.out.print(aux.elemento);
				pila.apilar(aux.der);
				aux=aux.izq;
			}
		}
	}
	void preordenTR(NodoA nodo){
		NodoA aux;
		PilaLista pila=new PilaLista(); // pila de nodos
		pila.apilar(nodo);
		while(!pila.estaVacia()) // mientras la pila no este vacia
		{
			aux=(NodoA)pila.desapilar();
			if (aux!=null)
			{
				System.out.print(aux.elemento);
				// primero se apila el nodo derecho y luego el izquierdo
				// para mantener el orden correcto del recorrido
				// al desapilar los nodos
				pila.apilar(aux.der);
				pila.apilar(aux.izq);
			}
		}
	}

	void preordenR(NodoA nodo)
	{
		if (nodo!=null)
		{
			System.out.print(nodo.elemento);
			preordenR(nodo.izq);
			preordenR(nodo.der);
		}
	}
	void inordenR(NodoA nodo)
	{
		if (nodo!=null)
		{
			preordenR(nodo.izq);
			System.out.print(nodo.elemento);
			preordenR(nodo.der);		
		}
	}
	
	void imprimirR(int[] a, int j) // versión recursiva
	{
		if (j<a.length)
		{
			System.out.println(a[j]);
			imprimirR(a, j+1); // tail recursion
		}
	}
	
	void imprimirTR(int[] a, int j) // versión iterativa
	{
		while (j<a.length)
		{
			System.out.println(a[j]);
			j=j+1;
		}
	}
	
}
