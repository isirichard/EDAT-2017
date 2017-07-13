package presentacion03A;

import laboratorio03.QueueArr;
import laboratorio03.QueueEmpty;
import laboratorio03.QueueFull;

public class HI {
	int extraerMenor(NodoH raiz) throws QueueFull, QueueEmpty{
		NodoH nuevo=ultimo(raiz);
		int menor=raiz.valor;
		raiz.valor=nuevo.valor;
		suLugar(raiz);
		System.out.println();
		return menor;
	}

	NodoH ultimo(NodoH raiz) throws QueueFull, QueueEmpty{
		NodoH padre=null;
		NodoH aux=raiz;
		QueueArr cola=new QueueArr();
		cola.enque(aux);
		aux.anc=padre;
		while(!cola.empty()){
			aux=(NodoH)cola.deque();
			System.out.print(aux.valor);
			padre=aux;
			if(aux.izq!=null){
				aux.izq.anc=padre;
				cola.enque(aux.izq);
			}
			if(aux.der!=null){
				aux.der.anc=padre;
				cola.enque(aux.der);
			}
		}
		//System.out.println(aux.valor);
		//System.out.println(aux.anc.valor);
		NodoH t=aux;
		aux=aux.anc;
		if(aux.der==null){
			aux.izq=null;
			return t;
		}
		if(aux.izq==null){
			aux.der=null;
			return t;
		}
		if(aux.der.valor==t.valor){
			aux.der=null;
			return t;
		}
		else{
			aux.izq=null;
			return t;
		}

	}
	void suLugar(NodoH raiz){
		NodoH aux=raiz;
		int t=0;
		while(true){
			if(aux.izq==null&&aux.der==null)
				break;
			if(aux.izq==null&&aux.der.valor<aux.valor){
				t=aux.valor;
				aux.valor=aux.der.valor;
				aux.der.valor=t;
				aux=aux.der;
				continue;
			}
			if(aux.der==null&&aux.izq.valor<aux.valor){
				t=aux.valor;
				aux.valor=aux.izq.valor;
				aux.izq.valor=t;
				aux=aux.izq;
				continue;
			}
			if(aux.izq.valor<aux.der.valor){
				if(aux.izq.valor<aux.valor){
					t=aux.valor;
					aux.valor=aux.izq.valor;
					aux.izq.valor=t;
					aux=aux.izq;
					continue;
				}
			}
			if(aux.der.valor<aux.izq.valor){
				if(aux.der.valor<aux.valor){
					t=aux.valor;
					aux.valor=aux.der.valor;
					aux.der.valor=t;
					aux=aux.der;
					continue;
				}
			}		
		}
	}
	
	
	NodoH imprimirAnc(NodoH raiz) throws QueueFull, QueueEmpty{
		NodoH padre=null;
		NodoH aux=raiz;
		QueueArr cola=new QueueArr();
		cola.enque(aux);
		aux.anc=padre;
		while(!cola.empty()){
			aux=(NodoH)cola.deque();
			
			if(aux.anc==null){
				//System.out.println();
				System.out.print(aux.valor);

			}
			else{
				
				System.out.print(aux.valor);
			}
			
			padre=aux;
			if(aux.izq!=null){
				aux.izq.anc=padre;
				cola.enque(aux.izq);
			}
			if(aux.der!=null){
				aux.der.anc=padre;
				cola.enque(aux.der);
			}
		}
		System.out.println();
		return null;
	}

	void agregar(int x, NodoH raiz) throws QueueFull, QueueEmpty{
		//System.out.println();
		NodoH aux=espacio(x,raiz);
		suLugarAgregar(aux);
	}
	NodoH espacio(int x,NodoH raiz) throws QueueFull, QueueEmpty{
		NodoH padre=null;
		NodoH aux=raiz;
		QueueArr cola=new QueueArr();
		cola.enque(aux);
		aux.anc=padre;
		while(!cola.empty()){
			aux=(NodoH)cola.deque();
			//System.out.print(aux.valor);
			padre=aux;
			if(aux.izq==null){
				aux.izq=new NodoH(x,null,null);
				aux.izq.anc=padre;
				return aux.izq;
			}
			if(aux.der==null){
				aux.der=new NodoH(x,null,null);
				aux.der.anc=padre;
				return aux.der;
				
			}
			if(aux.izq!=null){
				aux.izq.anc=padre;
				cola.enque(aux.izq);
			}
			if(aux.der!=null){
				aux.der.anc=padre;
				cola.enque(aux.der);
			}
		}
		
		return null;
	}
	void suLugarAgregar(NodoH raiz){
		NodoH aux=raiz;
		int t=0;
		while(aux.anc!=null){
			if(aux.valor<aux.anc.valor){
				t=aux.anc.valor;
				aux.anc.valor=aux.valor;
				aux.valor=t;
				aux=aux.anc;
			}
			else
				return;
		}
	}



}
