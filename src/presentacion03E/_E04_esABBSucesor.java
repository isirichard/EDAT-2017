package presentacion03E;
/**
 * 4. Para los siguientes problemas considere las declaraciones:
class Nodo{
public Comparable valor;
public Nodo izq, der;
public Nodo(Comparable x, Nodo y, Nodo z){ valor=x; izq=y; der=z;
}
}
Nodo raiz = null;
Ejemplo: raiz=new Nodo(“C”,
new Nodo(“B”,null,null),
new Nodo(“D”,null, new Nodo(“F”,null,null))
);
a) Escriba un método recursivo que determine si un árbol es o no un árbol binario de búsqueda.
Encabezamiento: boolean esABB(Nodo x)
Ejemplo: esABB(raiz) = true
b) Escriba un método (no recursivo) que entregue el valor del sucesor de un nodo, es decir, el menor
descendiente del subárbol derecho.
Encabezamiento: String sucesor(Nodo x)
Ejemplo: sucesor(raiz) = “D”
 */
public class _E04_esABBSucesor {
	public static void main(String[] args) {
		Nodo raiz = new Nodo("C",
				new Nodo("B",null,null),
				new Nodo("D",null, new Nodo("F",null,null))
				);
		ABB prueba = new ABB();
		//System.out.println(raiz.valor.compareTo(raiz.izq.valor));
		System.out.println(prueba.esABB(raiz));
		System.out.println(prueba.sucesor(raiz.der.der));
	}
}



