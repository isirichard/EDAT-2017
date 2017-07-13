package presentacion03A;

import laboratorio03.DiccLleno;
import laboratorio03.Nodo;
import laboratorio03.QueueArr;
import laboratorio03.QueueEmpty;
import laboratorio03.QueueFull;

public class AVL {
	NodoAVL raiz=new NodoAVL();
	int tamano=0;
	public enum rotacion{
		SINROT,IZQ_SIMPLE,IZQ_DOBLE,DER_SIMPLE,DER_DOBLE;
	}
	rotacion rotar=rotacion.SINROT;

	void insertar(int x) throws DiccLleno, QueueFull, QueueEmpty{
		NodoAVL aux=agregar(x,x,raiz);
		if(aux==null)
			return;
		if(aux.anc!=null&&tamano>2){
			if(aux.anc.anc!=null){
				if(aux==aux.anc.izq){
					if(aux.anc==aux.anc.anc.izq)
						rotar=rotacion.DER_SIMPLE;
					else
						rotar=rotacion.IZQ_DOBLE;
				}
				if(aux==aux.anc.der){
					if(aux.anc==aux.anc.anc.der)
						rotar=rotacion.IZQ_SIMPLE;
					else
						rotar=rotacion.DER_DOBLE;
				}		
			}
		}
		while(aux!=null){
			if(desbalance(aux)==true){
				if(rotar==rotacion.IZQ_SIMPLE){
					aux=conHijoDerecho(aux);
				}
				if(rotar==rotacion.DER_SIMPLE)
					aux=conHijoIzquierdo(aux);
				if(rotar==rotacion.IZQ_DOBLE)
					aux=dobleConHijoDerecho(aux);			
				if(rotar==rotacion.DER_DOBLE)
					aux=dobleConHijoIzquierdo(aux);

			}
			
			if(aux.anc==null)raiz=aux;
			aux=aux.anc;
		}
		
	}
	public NodoAVL agregar(Comparable x, Object y, NodoAVL raiz)
			throws DiccLleno{
		tamano++;
		NodoAVL aux=raiz;
		NodoAVL padre=null;
		NodoAVL q = new NodoAVL(x,y,null,null);
		if(aux==null)
			return q;
		if( aux.info==null ){
			//raiz=q;
			aux.id=x;
			aux.info=y;
			aux.anc=padre;
			return aux;
		}
		NodoAVL r=raiz;
		while(true){
			padre=r;
			int c = x.compareTo(r.id);
			if(c==0) return null; //ya existe
			if(c<0)
				if(r.izq==null){
					r.izq=q; 
					q.anc=padre;
					return r.izq;		
				}else{
					r.izq.anc=padre;
					r=r.izq;
					
				}
			else
				if(r.der==null){
					r.der=q;
					q.anc=padre;
					return r.der;
				}else{
					r.der.anc=padre;
					r=r.der;
				}
		}
	}

	boolean desbalance(NodoAVL raiz) throws QueueFull, QueueEmpty{
		//System.out.println();
		//System.out.print("   numero desbalance "+Math.abs(altura(raiz.izq)-altura(raiz.der)));
		if(raiz.info==null)
			return false;
		if(Math.abs(altura(raiz.izq)-altura(raiz.der))>1){
			if(altura(raiz.der)-altura(raiz.izq)>1&&raiz.der!=null&&raiz.der.der!=null){
				rotar=rotacion.IZQ_SIMPLE;	
			}
			if(altura(raiz.der)-altura(raiz.izq)>1&&raiz.der!=null&&raiz.der.der==null){
				rotar=rotacion.IZQ_DOBLE;	
			}	
			if(altura(raiz.der)-altura(raiz.izq)<-1&&raiz.izq!=null&&raiz.izq.izq!=null){
				rotar=rotacion.DER_SIMPLE;
			}
			if(altura(raiz.der)-altura(raiz.izq)<-1&&raiz.izq!=null&&raiz.izq.izq==null){
				rotar=rotacion.DER_DOBLE;
			}
			
			//System.out.print(" altura izq "+altura(raiz.izq));
			//System.out.print(" altura der "+altura(raiz.der));
			//System.out.print(" altura der "+altura(raiz.der)+" info nodo derecha "+raiz.der.info+" nodo actual "+raiz.info);
			return true;	
		}	
		return false;
	}
	int altura(NodoAVL raiz) throws QueueFull, QueueEmpty{
		return raiz==null? 0: 1+Math.max(altura(raiz.izq),altura(raiz.der));
		/**
		int h=0;
		if(raiz==null)
			return 0;
		NodoAVL aux=raiz;
		QueueArr cola=new QueueArr();
		cola.enque(aux);
		while(!cola.empty()){
			aux=(NodoAVL)cola.deque();
			h+=1;

			if(aux.izq!=null)
				cola.enque(aux.izq);
			if(aux.der!=null)
				cola.enque(aux.der);
		}
		return h;
		*/
	}

	void eliminar(int x) throws QueueFull, QueueEmpty{
		NodoAVL aux =borrar(x);
		//System.out.println("holaaa "+aux);
		if(aux==null){
			return;
		}
		if(aux.anc!=null&&tamano>2){
			if(aux.anc.anc!=null){
				if(aux==aux.anc.izq){
					if(aux.anc==aux.anc.anc.izq)
						rotar=rotacion.DER_SIMPLE;
					else
						rotar=rotacion.IZQ_DOBLE;
				}
				if(aux==aux.anc.der){
					if(aux.anc==aux.anc.anc.der)
						rotar=rotacion.IZQ_SIMPLE;
					else
						rotar=rotacion.DER_DOBLE;
				}		
			}
		}
		
		//System.out.println("Hola");
		//System.out.println(aux.anc);
		while(aux!=null){
			if(desbalance(aux)==true){
				if(rotar==rotacion.IZQ_SIMPLE){
					aux=conHijoDerecho(aux);
				}
				if(rotar==rotacion.DER_SIMPLE)
					aux=conHijoIzquierdo(aux);
				if(rotar==rotacion.IZQ_DOBLE)
					aux=dobleConHijoDerecho(aux);			
				if(rotar==rotacion.DER_DOBLE)
					aux=dobleConHijoIzquierdo(aux);

			}
			if(aux.anc==null)raiz=aux;
			aux=aux.anc;
		}
	}
	
	
	//Solución 2: un recorrido (no recursivo)
		public NodoAVL borrar(Comparable x){
			tamano--;
			NodoAVL nodo;
			if( raiz==null )return null;
			if( raiz.id.equals(x) ){
				raiz = borrarD(raiz);
				nodo=raiz;
				
				return nodo;
				
			}
			NodoAVL r=raiz;
			
			while(true){
				int c = x.compareTo(r.id);
				if(c<0){
					if(r.izq==null) return null;
					if(r.izq.id.equals(x)){
						r.izq = borrarD(r.izq); 
						nodo=r.izq;
						if(nodo==null)
							nodo=r;
						break;
					}else{
						r.izq.anc=r;
						r = r.izq;
					}
				}else{
					if(r.der==null) return null;
					if(r.der.id.equals(x)){
						r.der = borrarD(r.der);
						nodo=r.der;
						if(nodo==null)
							nodo=r;
						break;
					}else{
						r.der.anc=r;
						r = r.der;
					}
				}
			}
			
			return nodo;
		}
	
	
	protected NodoAVL borrarD(NodoAVL r){
		NodoAVL nodo;
		//if(r.der==null&&r.izq==null&&r.anc!=null) return r.anc;
		if(r.izq==null) return r.der; //Caso 1:solo arbol der.
		if(r.der==null) return r.izq; //Caso 2:solo arbol izq.
		//System.out.println(r.der.izq);
		//Caso 3: reemplazar por mayor de arbol derecho
		if( r.der.izq == null ){
			r.id=r.der.id; 
			r.info=r.der.info;
			r.der=r.der.der;
			if(r.der==null)
				return r;
			r.der.anc=r;
			nodo=r.der;
			
		}else{
			NodoAVL q = r.der;
			r.der.anc=r;
			while(q.izq.izq != null){ 
				q.izq.anc=q;
				q=q.izq;
			}
			r.id=q.izq.id; 
			r.info=q.izq.info; 
			q.izq=q.izq.der;
			
			nodo=q.izq;
			if(nodo==null)
				nodo=q;
		}
		return nodo;
	}
	
	
	
	
	

	NodoAVL conHijoDerecho(NodoAVL X) throws QueueFull, QueueEmpty{
		//System.out.println();
		//System.out.println("entre");
		
		NodoAVL aux = X.der;
		X.der = aux.izq;
		aux.izq = X;
		
		aux.anc=X.anc;
		if(X.anc!=null){
			if(aux.anc.der.info==X.info){
				//System.out.println("Hijo izquierdo");
				X.anc.der=aux;
			}
			else
				X.anc.izq=aux;
			//System.out.print("/// info nodo hijo derecho padre: "+aux.anc.der.info);
			//System.out.print("/// info nodo : "+aux.info);
			
			//System.out.print("   info nodo padre: "+aux.anc.info);
		}
		//System.out.print("   info nodo actual: "+X.info);
		//System.out.print("   info nodo reemplazo: "+aux.info);
		
		return aux;
	}
	NodoAVL conHijoIzquierdo(NodoAVL X){
		NodoAVL aux = X.izq;
		X.izq = aux.der;
		aux.der = X;
		
		aux.anc=X.anc;
		
		if(X.anc!=null){
			if(aux.anc.der.info==X.info){
				//System.out.println("Hijo izquierdo");
				X.anc.der=aux;
			}
			else{
				X.anc.izq=aux;
				//System.out.println("Hijo izquierdo");
			}
		}
		return aux;
	}

	NodoAVL dobleConHijoDerecho(NodoAVL X) throws QueueFull, QueueEmpty{
		X.der = conHijoIzquierdo( X.der );
		return conHijoDerecho( X );
	}
	NodoAVL dobleConHijoIzquierdo(NodoAVL X) throws QueueFull, QueueEmpty{
		X.izq = conHijoDerecho( X.izq ); //rot.entre hijo y nieto
		return conHijoIzquierdo( X ); //rot.entre X y nuevo hijo
	}

	void imprimir() throws QueueFull, QueueEmpty{
		if(raiz==null){
			System.out.print("null");
			System.out.println();
			return;
		}
		
		NodoAVL aux=raiz;
		QueueArr cola=new QueueArr();
		cola.enque(aux);
		while(!cola.empty()){
			aux=(NodoAVL)cola.deque();
			System.out.print(aux.info);

			if(aux.izq!=null)
				cola.enque(aux.izq);
			if(aux.der!=null)
				cola.enque(aux.der);
		}
		System.out.println();
	}

}
