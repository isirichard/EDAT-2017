package presentacion03A;

import laboratorio03.NodoAB;
import laboratorio03.QueueArr;
import laboratorio03.QueueEmpty;
import laboratorio03.QueueFull;
import teoria04.PilaLista;

public class Morse {
	char letra(String x,NodoM r){
		if(x.equals("")){ 
			return r.valor.charAt(0);
		}
		return letra(x.substring(1), x.charAt(0)=='.'? r.izq: r.der);
	}

	String codigo(char c, NodoM raiz) throws QueueFull, QueueEmpty{
		limpiar(raiz);
		NodoM aux;
		PilaLista pila=new PilaLista(); // pila de nodos
		pila.apilar(raiz);
		aux=(NodoM)pila.desapilar();
		boolean nvacio=true;
		while(nvacio){
			if(c==aux.valor.charAt(0)){
				return aux.codigo;
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
			aux=(NodoM)pila.desapilar();
		}
		return null;
	}

	void agregar(char c, String codigo, NodoM raiz){
		NodoM aux=raiz;
		for(int i=0;i<codigo.length();i++){
			if(codigo.charAt(i)=='.'){
				
				if(aux.izq==null&&i==(codigo.length()-1))
					aux.izq=new NodoM(c+"",codigo,null,null);
				aux=aux.izq;
			}
			else{
				
				if(aux.der==null&&i==(codigo.length()-1))
					aux.der=new NodoM(c+"",codigo,null,null);
				aux=aux.der;
			}
		}
	}

	void limpiar(NodoM raiz) throws QueueFull, QueueEmpty{
		NodoM aux=raiz;
		QueueArr cola=new QueueArr();
		cola.enque(aux);
		while(!cola.empty()){
			aux=(NodoM)cola.deque();
			aux.c=0;
			aux.h=0;
			if(aux.izq!=null)
				cola.enque(aux.izq);
			if(aux.der!=null)
				cola.enque(aux.der);
		}

	}
}
