package laboratorio02_DC;

public class ArbolABB {
	NodoAB raiz =
			new NodoAB("D", //valor
			new NodoAB("B", //arbol izquierdo
			new NodoAB("A",null,null),
			new NodoAB("C",null,null)),
			new NodoAB("F", //arbol derecho
			new NodoAB("E",null,null),
			new NodoAB("G",null,null))
			);
}
