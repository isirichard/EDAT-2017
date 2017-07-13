package laboratorio04;

public class _A06_Dicc {
	public static void main(String[] args) throws DiccLleno {
		DiccionarioEnc prueba=new DiccionarioEnc();
		prueba.agregar(0, 1);
		prueba.agregar(10, 2);
		prueba.agregar(100, 3);
		prueba.agregar(1000, 4);
		prueba.agregar(1, 5);
		System.out.println(prueba);
	}
}
