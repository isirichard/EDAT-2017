package laboratorio02;
/*
 * Problema. Leer las líneas de un archivo y escribirlas al revés (1º la última, 2º la penúltima, ..., última la 1ª).
 * Indicación. Use el TDA (tipo de dato abstracto) Stack (Pila) que es un contenedor que opera con el
principio LIFO (Last In First Out), es decir, el último elemento que ingresa es el primero que sale.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class A031_ProbRPila {
	public static void main(String[] args) throws IOException {
		/*
		 * Usamos un reader para ingresar leer un archivo
		 * La Clase Buffered nos permite recorrer las cadenas.
		 */
		BufferedReader A= new BufferedReader(new FileReader("archivo.txt"));
		Stack s= new Stack();
		//leemos las lineas y guardamos en un stack pila
		String linea;
		while((linea=A.readLine())!=null ){
			s.push(linea);
			//System.out.println(linea);
		}
		//sacamos de la pila imprimimos en consola.
		while(!s.empty())
			System.out.println(s.pop());
		 
	}	
}
