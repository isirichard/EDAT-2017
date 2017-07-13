package presentacion02A;
/*
 * 6. Stack genérico con Excepciones
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A06_StackGE {
	public static void main(String[] args) throws StackEmpty, IOException {
		//pil.pop();
		//StackGE2<String> pil=new StackGE2<String>();
		/*
		try {
			pil.pop();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 */
		//StackGE pil= new StackGE();
		//Si hablamos de generico nos referimos al atributo Object para el elemento.
		StackGE s = new StackGE();
		//usamos un try por la excepcion de push si esta lleno
		//por la implementación de arreglo de objetos.
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String linea;
			while( (linea=in.readLine()) != null )
				s.push(linea);
		}catch(StackFull x){
			/*
			 * Tratamos las excepciones de la clase StackGE caso vacio y lleno con try
			 * para un manejo personalizada de errores.
			 */
			System.out.println("capacidad excedida");
		}
		//usamos un try por la excepción de pop sacar
		try{
			while(true)
				//System.out.println( (String)s.pop() );
				System.out.println( s.pop() );
		}catch(StackEmpty x){
			System.out.println("fin");
		}
		//new,  reset, empty, full, push, pop
	}

}
/*
 No se puede lograr eso en Java debido al type erasure (borrado de tipo). Tienes estas alternativas:

Pasar la clase de T como argumento en el constructor y crear el arreglo utilizando reflexión:

public Bolsa(Class<T> clazz, int capacidad) {
    array = (T[]) Array.newInstance(clazz, capacidad);
}
El código cliente llamaría al constructor de la siguiente manera:
Bolsa<String> bolsa = new Bolsa(String.class, 10);
Crear un arreglo de Object y hacer el casteo respectivo al momento de 
devolver elementos del arreglo (utilizada en la implementación de java.util.ArrayList):
public class Bolsa<T> {
    Object[] arreglo;

    public Bolsa(int capacidad) {
        arreglo = new Object[capacidad];
    }

    public T obtener(int indice) {
        //agrega validaciones correspondientes
        return (T) arreglo[indice];
    }
}
Utilizar un artificio basado en un arreglo de Object:
arreglo = (T[]) new Object[capacidad];
La primera es la más segura en tiempo de desarrollo y ejecución. La segunda y tercera tienen 
el artificio de trabajar con un arreglo de objetos y utilizar un casteo hacia abajo del tipo 
particular que será borrado en tiempo de ejecución, pero apoya durante el trabajo en tiempo 
de desarrollo. Además, en la segunda y tercera opción, debes tener cuidado al exponer el 
arreglo directamente a los clientes puesto que podrían malograr la información que se guarda en él.
 */
