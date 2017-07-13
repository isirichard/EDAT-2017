package presentacion02E;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class TADpila {
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
