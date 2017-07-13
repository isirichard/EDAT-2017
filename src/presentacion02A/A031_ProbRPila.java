package presentacion02A;
/*
 * Problema. Leer las líneas de un archivo y escribirlas al revés (1º la última, 2º la penúltima, ..., última la 1ª).
 * Indicación. Use el TDA (tipo de dato abstracto) Stack (Pila) que es un contenedor que opera con el
principio LIFO (Last In First Out), es decir, el último elemento que ingresa es el primero que sale.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class A031_ProbRPila {
	public static void main(String[] args) throws IOException {
		BufferedReader A= new BufferedReader(new FileReader("archivo.txt"));
		StackArr s= new StackArr();
		//leer líneas y guardalas en un stack
		String linea;
		while((linea=A.readLine())!=null ){
			s.push(linea);
			//System.out.println(linea);
		}
		//sacar y escribir líneas de Stack
		while(!s.empty())
			System.out.println(s.pop());
		 
	}	
	//new,push, pop, reset, empty, full
}
