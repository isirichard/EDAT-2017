package laboratorio05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//Problema. Buscar todas las líneas de un archivo que comiencen con un String
public class _A031_probString {
	public static void main(String[] args) throws IOException {
		BufferedReader a=new BufferedReader(new FileReader("texto.txt"));
		String linea;
		while((linea=buscar("hola",a))!=null)
			System.out.println(linea);
		a.close();
	}
	static public String buscar(String x,BufferedReader y) throws IOException{
		String linea;
		while((linea=y.readLine())!=null)
			if( linea.indexOf(x)==0) return linea;
		return null;
	}
}
