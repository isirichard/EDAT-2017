package presentacion03E;


import laboratorio03.QueueArr;
import laboratorio03.QueueEmpty;
import laboratorio03.QueueFull;

import teoria04.PilaLista;

public class ArbolAVL {
	 Nodo raiz = new Nodo(10, //valor
			new Nodo(5,new Nodo(1,null,null),new Nodo(7,null,null)),
			new Nodo(15,new Nodo(12,null,null),new Nodo(13,null,null))
			);
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
/*
 * INSERCIÓN
 */
	//Rotacion Simple
	void insertar(Comparable x,Nodo raiz){

	}

	void eliminar(Comparable x,Nodo raiz){
		
	}
	Nodo conHijoDerecho(Nodo X){
		Nodo aux = X.der;
		X.der = aux.izq;
		aux.izq = X;
		return aux;
	}
	Nodo conHijoIzquierdo(Nodo X){
		Nodo aux = X.izq;
		X.izq = aux.der;
		aux.der = X;
		return aux;
	}
	//Rotación Doble
	Nodo dobleConHijoDerecho(Nodo X){
		X.der = conHijoIzquierdo( X.der );
		return conHijoDerecho( X );
	}
	Nodo dobleConHijoIzquierdo(Nodo X){
		X.izq = conHijoDerecho( X.izq ); //rot.entre hijo y nieto
		return conHijoIzquierdo( X ); //rot.entre X y nuevo hijo
	}
	
	private class Nodo {
		public int valor;
		public Nodo izq, der;
		public int c;
		public int h;
		public Nodo(int x,Nodo y,Nodo z){
			valor=x;
			izq=y;
			der=z;
			c=0;
			h=0;
		}
	}
	void actualizar(){
		Nodo raiz = new Nodo(10, //valor
				new Nodo(5,new Nodo(1,null,null),new Nodo(7,null,null)),
				new Nodo(15,new Nodo(12,null,null),new Nodo(13,null,null))
				);
	}
}
