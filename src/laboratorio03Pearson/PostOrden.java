package laboratorio03Pearson;

public class PostOrden {
	public static void main(String[] args) {
		ArbolB prueba = new ArbolB();
		prueba.postOrden();

		System.out.println();
		prueba.inOrden();

		System.out.println();
		prueba.preOrden();
		System.out.println();
		prueba.hojas();
		prueba.altura();
		System.out.println(prueba.buscar("A"));
	}
}
