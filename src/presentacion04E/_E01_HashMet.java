package presentacion04E;
/**
 *1. Implemente Hashing con todas sus operaciones (constructor, agregar, eliminar, buscar, recorrer,
visualizar arreglo) en un arreglo y usando el método que consideres más óptimo para manejar información.
 */
public class _E01_HashMet {
	public static void main(String[] args) throws DiccLleno {
		Hashing prueba=new Hashing();
		for (int i = 0; i < 500; i++) {
			prueba.agregar(i, i);
		}
		System.out.println(prueba);
		System.out.println(prueba.buscar(50));
		
	}
}
