package laboratorio02;
/*
 * 3. TDA Diccionario
 */
import java.io.IOException;
/**TDA diccionario permite grabar palabra y significado (clave valor) para 
 * operaciones crud
 */
/*
 * Estructura de datos que permite la implementación eficiente de las operacioes
 * CRUD (Busqueda, inserción, eliminación.) Una de las implemetaciones que se está
 * usando es la diccionario con Lista enlazada.
 */
public class A03_TDADicc {
	public static void main(String[] args) throws IOException, DiccLleno {
		DiccionarioLE diccionario=new DiccionarioLE();
		diccionario.agregar("1", "soy el primero");
		diccionario.agregar("2", "soy el segundo");
		diccionario.agregar("3", "soy el tercero");
		
		System.out.println(diccionario.buscar("1"));
		diccionario.cambiar("3", "soy el ultimo");
		System.out.println(diccionario.buscar("3"));
	}
}
