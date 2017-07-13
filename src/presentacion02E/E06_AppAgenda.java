package presentacion02E;
/*
 * 6. Escribir un programa que use la clase Diccionario (con la implementación que ud. desee) e implemente
la siguiente interfaz gráfica de usuario para manejar una agenda telefónica:
 */
//Esta en EDAT_Project el codigo swing debido a que no es soportado por EE
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class E06_AppAgenda {
	public static void main(String[] args) throws IOException {
		BufferedReader A= new BufferedReader(new FileReader("archivo.txt"));
		Stack s= new Stack();
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
}
