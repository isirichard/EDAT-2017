package laboratorio03;

public class A01_ABB {
	public static void main(String[] args) throws DiccLleno {
		DiccABB arbol = new DiccABB();
		arbol.agregar(1, "primero");
		arbol.agregar(2, "segundo");
		arbol.agregar(-5, "tecero");
		
		System.out.println(arbol.buscar(1));
		System.out.println(arbol.buscar(2));
		System.out.println(arbol.buscar(-5));
		
		Comparable x;
		x=1;
	
		System.out.println(x.compareTo(5));
	}
}
