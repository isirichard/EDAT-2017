package teoria030;

public class Lista5DEC {
	NodoLista5 cab;
	Lista5DEC(){
		cab=new NodoLista5(null);
		NodoLista5 lista=new NodoLista5();
		lista.anterior=cab;
		lista.siguiente=cab;
	}
}
