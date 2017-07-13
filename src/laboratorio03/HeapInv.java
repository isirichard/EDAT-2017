package laboratorio03;

public class HeapInv {
	Nodo raiz = new Nodo("A", //valor
			new Nodo("B",new Nodo("D",null,null),new Nodo("E",null,null)),
			new Nodo("C",new Nodo("F",null,null),new Nodo("G",null,null))
	);
	public void insertar(int x){
		int a[]=new int[10];
		int n=a.length;
		a[++n]=x;
		int t=0;
		for(int j=n; j>1 && a[j]>a[j/2]; j/=2){ 
			// intercambiamos con el padre
			t=a[j];
			a[j]=a[j/2];
			a[j/2]=t;
		}
	}
	public void eliminar(int m){
		int a[]=new int[10];
		int n=a.length;
		int t=0;
		int k=0;
		m=a[1]; // La variable m lleva el máximo
		a[1]=a[n--]; // Movemos el último a la raíz y achicamos el heap
		int j=1;
		while(2*j<n){ // mientras tenga algún hijo{
			k=2*j; // el hijo izquierdo
			if(k+1<=n && a[k+1]>a[k])
				k=k+1; // el hijo derecho es el mayor
				if(a[j]>a[k])
					break; // es mayor que ambos hijos
			t=a[j]; 
			a[j]=a[k];
			a[k]=t; 
			j=k; // lo intercambiamos con el mayor hijo
		}
	}
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
	
	void niveles() throws QueueFull, QueueEmpty{
		Nodo aux=raiz;
		QueueArr cola=new QueueArr();
		cola.enque(aux);
		while(!cola.empty()){
			aux=(Nodo)cola.deque();
			System.out.print(aux.valor);
			
			if(aux.izq!=null)
				cola.enque(aux.izq);
			if(aux.der!=null)
				cola.enque(aux.der);
		}
		
	}
	private class Nodo {
		public String valor;
		public Nodo izq, der;
		public int c;
		public int h;
		public Nodo(String x,Nodo y,Nodo z){
			valor=x;
			izq=y;
			der=z;
			c=0;
			h=0;
		}
	}
	public static void main(String[] args) throws QueueFull, QueueEmpty {
		(new HeapInv()).niveles();
	}
	
}
