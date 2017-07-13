package presentacion03A;
/*
 * Árbol expresión
AB con números (operandos) en las hojas y operadores en los nodos internos. Ejemplo. árbol
para la expresión 3*4 – 6/2
 */

import laboratorio03.QueueArr;
import laboratorio03.QueueEmpty;
import laboratorio03.QueueFull;
import teoria04.PilaLista;

public class AE {
	int evaluar(Nodo r){
		if(r==null) return 0;
		if(r.izq==null && r.der==null)
			return Integer.parseInt(""+r.valor);
		int a=evaluar(r.izq), b=evaluar(r.der), c=0;
		switch((""+(r.valor)).charAt(0)){
		case '+': c=a+b; break;
		case '-': c=a-b; break;
		case '*': c=a*b; break;
		case '/': c=a/b; break;
		}
		return c;
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
	Nodo expresion(String exp){
		/////////expresion///////////////
		
		PilaLista operando=new PilaLista();
		PilaLista operador=new PilaLista();
		for(int i=0;i<exp.length();i++){
			if(exp.charAt(i)<'9'&&exp.charAt(i)>'0')
				operando.apilar(new Nodo(exp.charAt(i),null,null));
			else if(operador.estaVacia())
				operador.apilar(new Nodo(exp.charAt(i),null,null));
			else if(jerarquia(exp.charAt(i),((char)((Nodo)operador.tope()).valor))<1){
				((Nodo)(operador.tope())).der=(Nodo)operando.desapilar();
				((Nodo)(operador.tope())).izq=(Nodo)operando.desapilar();
				operando.apilar(operador.desapilar());
				operador.apilar(new Nodo(exp.charAt(i),null,null));
			}
			else 
				operador.apilar(new Nodo(exp.charAt(i),null,null));
		}
		while(!operador.estaVacia()){
			((Nodo)(operador.tope())).der=(Nodo)operando.desapilar();
			((Nodo)(operador.tope())).izq=(Nodo)operando.desapilar();
			operando.apilar(operador.desapilar());
		}
		if(!operando.estaVacia())
			return (Nodo)(operando.desapilar());
		return null;
		//////////////////////////////////
		
	}
	int jerarquia(char c1, char c2){
		if((c1=='+'||c1=='-')&&(c2=='+'||c2=='-')||
		   (c1=='*'||c1=='/')&&(c2=='*'||c2=='/'))
			return -1;
		if((c1=='+'||c1=='-')&&(c2=='*'||c2=='/'))
			return -1;
		if((c1=='*'||c1=='/')&&(c2=='+'||c2=='-'))
			return 1;
		return -1;
	}
}
