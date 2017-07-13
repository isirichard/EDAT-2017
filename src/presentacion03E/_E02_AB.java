package presentacion03E;
import teoria04.PilaLista;

/**
 * 2. En relación a los Arboles binarios, reescribir sus métodos: hojas(raiz), altura(raiz)
 * buscar(x,raiz), Inorden(raiz), Preorden(raiz) y PostOrden(raiz)
	a) usando concurrencia
	b) sin recursión
 */

public class _E02_AB {
	Nodo raiz = new Nodo("A", //valor
			new Nodo("B",new Nodo("D",null,null),new Nodo("E",null,null)),
			new Nodo("C",new Nodo("F",null,null),new Nodo("G",null,null))
			);
	void postOrdenR(Nodo r){ //arbol izquierdo, arbol derecho, raíz
		if( r== null ) return;
		postOrdenR(r.izq);
		postOrdenR(r.der); 
		System.out.print(r.valor);
	}
	Nodo buscar(String x){
		actualizar();
		Nodo aux;
		PilaLista pila=new PilaLista(); // pila de nodos
		pila.apilar(raiz);
		aux=(Nodo)pila.desapilar();
		boolean nvacio=true;
		while(nvacio){

			while(aux.c==0){
				if(x.equalsIgnoreCase(aux.valor)){
					System.out.println("si se encuentra "+aux.valor);
					nvacio=false;
					return aux;
				}
				
				aux.c++;
				if(aux.der!=null){
					pila.apilar(aux.der);
				}
				if(aux.izq!=null){
					pila.apilar(aux.izq);
				}
				if(aux.izq==null&&aux.der==null&&pila.estaVacia()){
					nvacio=false;
					break;
				}
				aux=(Nodo)pila.desapilar();
				
			}

		}
		return null;
	}
	void preOrden2()
	{
		Nodo aux;
		PilaLista pila=new PilaLista(); // pila de nodos
		pila.apilar(raiz);
		while(!pila.estaVacia()) // mientras la pila no este vacia
		{
			aux=(Nodo)pila.desapilar();
			if (aux!=null)
			{
				System.out.print(aux.valor);
				// primero se apila el nodo derecho y luego el izquierdo
				// para mantener el orden correcto del recorrido
				// al desapilar los nodos
				pila.apilar(aux.der);
				pila.apilar(aux.izq);
			}
		}
	}
	void altura(){
		actualizar();
		Nodo aux;
		PilaLista pila=new PilaLista(); // pila de nodos
		pila.apilar(raiz);
		aux=(Nodo)pila.desapilar();
		int altura=0;
		boolean nvacio=true;
		while(nvacio){
			while(aux.c==0){
				aux.c++;
				
				if(aux.der!=null){
					pila.apilar(aux.der);
					if(aux.der.h==0){
						aux.der.h=aux.h+1;
						if(aux.der.h>altura)
							altura=aux.der.h;
					}
				}
				if(aux.izq!=null){
					pila.apilar(aux.izq);
					if(aux.izq.h==0){
						aux.izq.h=aux.h+1;
						if(aux.izq.h>altura)
							altura=aux.izq.h;
					}
				}
				if(aux.izq==null&&aux.der==null&&pila.estaVacia()){
					nvacio=false;
					break;
				}
				aux=(Nodo)pila.desapilar();	
			}
		}
		System.out.println(altura);
	}
	void hojas(){
		actualizar();
		Nodo aux;
		PilaLista pila=new PilaLista(); // pila de nodos
		pila.apilar(raiz);
		aux=(Nodo)pila.desapilar();
		int hijos=0;
		boolean nvacio=true;
		while(nvacio){
			while(aux.c==0){
				aux.c++;
				if(aux.der!=null){
					pila.apilar(aux.der);
				}
				if(aux.izq!=null){
					pila.apilar(aux.izq);
				}
				if(aux.izq==null&&aux.der==null){
					hijos++;
				}
				if(aux.izq==null&&aux.der==null&&pila.estaVacia()){
					nvacio=false;
					break;
				}
				aux=(Nodo)pila.desapilar();	
			}
		}
		System.out.println(hijos);
	}
	void preOrden(){
		actualizar();
		Nodo aux;
		PilaLista pila=new PilaLista(); // pila de nodos
		pila.apilar(raiz);
		aux=(Nodo)pila.desapilar();
		boolean nvacio=true;
		while(nvacio){

			while(aux.c==0){
				System.out.print(aux.valor);
				
				aux.c++;
				if(aux.der!=null){
					pila.apilar(aux.der);
				}
				if(aux.izq!=null){
					pila.apilar(aux.izq);
				}
				if(aux.izq==null&&aux.der==null&&pila.estaVacia()){
					nvacio=false;
					break;
				}
				aux=(Nodo)pila.desapilar();
				
			}

		}
	} 
	void inOrden(){
		actualizar();
		Nodo aux;
		PilaLista pila=new PilaLista(); // pila de nodos
		pila.apilar(raiz);
		aux=(Nodo)pila.desapilar();
		boolean nvacio=true;
		while(nvacio){

			while(aux.c==0){
				if(aux.izq!=null){
					pila.apilar(aux);
					aux.c++;
					pila.apilar(aux.izq);
					aux=aux.izq;
				}else {
					pila.apilar(aux);
					aux.c++;
				}
				aux=(Nodo)pila.desapilar();
			}

			while(aux.c==1){
				System.out.print(aux.valor);
				if(pila.estaVacia()&&aux.der==null){
					nvacio=false;
					break;
				}
				if(aux.der!=null){
					pila.apilar(aux.der);
				}
				aux=(Nodo)pila.desapilar();
			}

		}
	} 
	void postOrden(){
		actualizar();
		Nodo aux;
		PilaLista pila=new PilaLista(); // pila de nodos
		pila.apilar(raiz);
		aux=(Nodo)pila.desapilar();
		boolean nvacio=true;
		while(nvacio){

			while(aux.c==0){
				if(aux.izq!=null){
					pila.apilar(aux);
					aux.c++;
					pila.apilar(aux.izq);
					aux=aux.izq;
				}else {
					pila.apilar(aux);
					aux.c++;
				}
				aux=(Nodo)pila.desapilar();
			}

			while(aux.c==1){
				if(aux.der!=null){
					pila.apilar(aux);
					aux.c++;
					pila.apilar(aux.der);
					aux=aux.der;
				}else{
					pila.apilar(aux);
					aux.c++;
				}
				aux=(Nodo)pila.desapilar();
			}
			while(aux.c==2){
				System.out.print(aux.valor);
				if(pila.estaVacia()){
					nvacio=false;
					break;
				}
				aux=(Nodo)pila.desapilar();
			}
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
	void actualizar(){
		raiz = new Nodo("A", //valor
				new Nodo("B",new Nodo("D",null,null),new Nodo("E",null,null)),
				new Nodo("C",new Nodo("F",null,null),new Nodo("G",null,null))
				);
	}
}
