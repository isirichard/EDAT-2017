package laboratorio03;

public class ArbolAVL {
/*
 * INSERCIÓN
 */
	//Rotacion Simple
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
}
