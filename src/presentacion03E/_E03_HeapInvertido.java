package presentacion03E;

import laboratorio03.QueueArr;
import laboratorio03.QueueEmpty;
import laboratorio03.QueueFull;


/**
 * 3. En un árbol Heap invertido, donde el menor está en la raiz y cada nodo tiene valores mayores como sus
hijos izquierdo y derecho. Implementar los métodos extraerMenor(raiz) y
agregar(x,raiz)
 */
public class _E03_HeapInvertido {
	Nodo raiz = new Nodo("A", //valor
			new Nodo("B",new Nodo("D",null,null),new Nodo("E",null,null)),
			new Nodo("C",new Nodo("F",null,null),new Nodo("G",null,null))
	);
	//Operaciones propuestas: extraerMenor(raiz) y agregar(x,raiz)
	void extraerMenorI(Nodo raiz){
		int m;
		int a[]=new int[10];
		int n=a.length;
		int t=0;
		int k=0;
		m=a[1]; // La variable m lleva el máximo
		a[1]=a[n--]; // Movemos el último a la raíz y achicamos el heap
		int j=1;
		while(2*j<n){ // mientras tenga algún hijo{
			k=2*j; // el hijo izquierdo
			if(k+1<=n && a[k+1]<a[k])
				k=k+1; // el hijo derecho es el mayor
				if(a[j]<a[k]) //si es menor
					break; // es mayor que ambos hijos
			t=a[j]; 
			a[j]=a[k];
			a[k]=t; 
			j=k; // lo intercambiamos con el mayor hijo
		}
	
	}
	void agregarI(int x, Nodo raiz){
		int a[]=new int[10];
		int n=a.length;
		a[++n]=x;
		int t=0;
		for(int j=n; j>1 && a[j]<a[j/2]; j/=2){ 
			// intercambiamos con el padre
			t=a[j];
			a[j]=a[j/2];
			a[j/2]=t;
		}
	}
	
	void agregarHI(String x) throws QueueFull, QueueEmpty{
		Nodo aux=raiz;
		QueueArr cola=new QueueArr();
		cola.enque(aux);
		while(!cola.empty()){
			aux=(Nodo)cola.deque();
			if(aux.izq!=null)
				cola.enque(aux.izq);
			if(aux.der!=null)
				cola.enque(aux.der);
		}
	}
}
