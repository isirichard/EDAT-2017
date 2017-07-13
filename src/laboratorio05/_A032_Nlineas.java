package laboratorio05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Problema. Ordenar un archivo (suponiendo que sólo N líneas caben en memoria)
	Solución 1. Dividir el arreglo en pedazos de N líneas, ordenarlos y grabarlos en archivos
	auxiliares. Finalmente realizar un merge de los archivos ordenados.
 *
 */
public class _A032_Nlineas {
	//crear k archivos ordenados
	public static void main(String[] args) {
		int n=10;
		int N=11;
		int k = (int)((double)n/N+0.9); //n: Nº de líneas del archivo
		PrintWriter[]A = new PrintWriter[k];//arreglo archivos
		for(int i=0; i<k; ++i){
			//A[i] = new PrintWriter(new FileWriter("A"+(i+1)+".txt"));
			//...
			A[i].println();
			//...
			A[i].close();
		}

		//merge de archivos ordenados
		//leer primera línea de todos los archivos
		String[]linea = new String[k];
		BufferedReader[]B =new BufferedReader[k];//arreglo archivos
		for(int i=0; i<k; ++i){
			/*
			B[i]=new Buffered(new FileReader("A"+(i+1)+".txt"));
			linea[i]= B[i].readLine(); //leer primera línea
			*/
		}
		//repetir hasta que se acaben todos los archivos
		//seleccionar la menor línea y grabarla en archivo de salida
		//...
		//Suposición. Se puede crear un arreglo de k archivos
	}
}
