package presentacion03A;

import laboratorio03.QueueArr;
import laboratorio03.QueueEmpty;
import laboratorio03.QueueFull;
import teoria04.PilaLista;

public class AB {
	int hojas(Nodo raiz){
		Nodo aux;
		PilaLista pila=new PilaLista(); // pila de nodos
		pila.apilar(raiz);
		aux=(Nodo)pila.desapilar();
		int hijos=0;
		boolean nvacio=true;
		while(nvacio){
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
		return hijos;
	}
	int altura(Nodo raiz) throws QueueFull, QueueEmpty{
		limpiar(raiz);
		Nodo aux;
		PilaLista pila=new PilaLista(); // pila de nodos
		pila.apilar(raiz);
		aux=(Nodo)pila.desapilar();
		int altura=0;
		boolean nvacio=true;
		while(nvacio){
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
		return altura;
	}


	Nodo buscar(String x,Nodo raiz){
		Nodo aux;
		PilaLista pila=new PilaLista(); // pila de nodos
		pila.apilar(raiz);
		aux=(Nodo)pila.desapilar();
		boolean nvacio=true;
		while(nvacio){


			if(x.equalsIgnoreCase((String)aux.valor)){
				nvacio=false;
				return aux;
			}


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
		return null;
	}

	void inOrden(Nodo raiz) throws QueueFull, QueueEmpty{
		limpiar(raiz);
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
		System.out.println();
	} 

	void preOrden(Nodo raiz) throws QueueFull, QueueEmpty{
		limpiar(raiz);
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
		System.out.println();
	} 

	void postOrden(Nodo raiz) throws QueueFull, QueueEmpty{
		limpiar(raiz);
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
		System.out.println();
	} 
	
	void limpiar(Nodo raiz) throws QueueFull, QueueEmpty{
		Nodo aux=raiz;
		QueueArr cola=new QueueArr();
		cola.enque(aux);
		while(!cola.empty()){
			aux=(Nodo)cola.deque();
			aux.c=0;
			aux.h=0;
			if(aux.izq!=null)
				cola.enque(aux.izq);
			if(aux.der!=null)
				cola.enque(aux.der);
		}
		
	}
}
